package com.yueting.api.service;

public class MockQueue {
	private String placeOrder;
	private String completeOrder;
	public String getPlaceOrder() {
		return placeOrder;
	}
	public void setPlaceOrder(String placeOrder) throws InterruptedException {
		
		new Thread(() -> {
			System.out.println("接收到下单请求："+placeOrder);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.placeOrder = placeOrder;
			System.out.println("下单请求完毕："+placeOrder);
		}).start();
		
	}
	public String getCompleteOrder() {
		return completeOrder;
	}
	public void setCompleteOrder(String completeOrder) {
		this.completeOrder = completeOrder;
	}
}
