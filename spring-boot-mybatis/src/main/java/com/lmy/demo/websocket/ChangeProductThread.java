package com.lmy.demo.websocket;

public class ChangeProductThread extends Thread {

	private boolean ifWatched = true;

	@Override
	public void run() {
		System.out.println("开始报价");
		while (ifWatched) {
			try {
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
