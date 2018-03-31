package com.lmy.demo.websocket;

import java.util.concurrent.Callable;

import com.lmy.demo.domain.Product;
import com.lmy.demo.service.ProductService;

public class ChangeProductCallable implements Callable<WebSocketServer>{
	private WebSocketServer ws;

	public ChangeProductCallable(WebSocketServer ws) {
		this.ws = ws;
	}

	private ProductService productService = SpringBean.getBean(ProductService.class);

	@Override
	public WebSocketServer call() throws Exception {
		Product realProduct = productService.getProductById(this.ws.getProductId());
		while (this.ws.getSession().isOpen()) {
			float price = realProduct.getPrice();
			float nextPrice = (float) (price + Math.random());
			realProduct.setPrice(nextPrice);
			productService.doUpdateProduct(realProduct);
			Thread.sleep(1000);
			this.ws.sendMessage(nextPrice + "");
		}
		return ws;
	}

}
