package com.lmy.demo.websocket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.FutureTask;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.lmy.demo.domain.Product;

@ServerEndpoint(value = "/websocket/{productId}")
@Component
public class WebSocketServer {
	// 静态变量，用来记录当前在线连接数，应该把它设计成线程安全的。
	private static int onlineCount = 0;
	private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

	private FutureTask<WebSocketServer> future;
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	private int productId;

	public int getProductId() {
		return productId;
	}

	@OnOpen
	public void onOpen(@PathParam("productId") String productId, Session session) {
		this.session = session;
		webSocketSet.add(this); // 加入set中
		this.productId=Integer.parseInt(productId);
		Product product = new Product();
		product.setId(Integer.parseInt(productId));
		future = new FutureTask<>(new ChangeProductCallable(this));
		new Thread(future).start();
		addOnlineCount(); // 在线数加1
		System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
		try {
			sendMessage("连接成功");
		} catch (IOException e) {
			System.out.println("websocket IO异常");
		}
	}

	@OnClose
	public void onClose() {
		webSocketSet.remove(this);
		subOnlineCount();
		future.cancel(true);
		System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("来自客户端的消息:" + message);
		for (WebSocketServer item : webSocketSet) {
			try {
				item.sendMessage("已收到客户端的信息");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("发生错误");
		error.printStackTrace();
	}

	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}

	/**
	 * 群发自定义消息
	 * */
	public static void sendInfo(String message) throws IOException {
		System.out.println(message);
		for (WebSocketServer item : webSocketSet) {
			try {
				item.sendMessage(message);
			} catch (IOException e) {
				continue;
			}
		}
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebSocketServer.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSocketServer.onlineCount--;
	}
}
