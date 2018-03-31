package com.lmy.demo.websocketstomp.message;

/**
 * 服务端向浏览器发送的消息
 */
public class SendMessage {

	private String responseMessage;

	public SendMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

}