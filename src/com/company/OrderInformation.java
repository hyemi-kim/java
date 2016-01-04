package com.company;

import java.util.StringTokenizer;

/**
 * Created by hyemi on 2015. 12. 29..
 */
public class OrderInformation {
	private int orderId;
	private int productId;
	private boolean logiProcessed;

	public int getOrderId() { return orderId; }
	public int getProductId() { return productId; }
	public boolean getLogiProcessed() { return logiProcessed; }
	public void setOrderId(int orderId) { this.orderId = orderId; }
	public void setProductId(int productId) { this.productId = productId; }
	public void setLogiProcessed(boolean logiProcessed) { this.logiProcessed = logiProcessed; }

	public OrderInformation(int orderId,int productId){
		this.orderId = orderId;
		this.productId = productId;
		this.logiProcessed = false;
	}

	public void print(){
		System.out.println("주문 ID : " + this.orderId +
			"상품 ID : " + this.productId + " , " + "배송 처리 : "+ this.logiProcessed);
	}

	public static String toString(OrderInformation orderInformation){
		return orderInformation.orderId + "," + orderInformation.productId + "," + orderInformation.logiProcessed;
	}

	public static OrderInformation toOrderInformation(String string){
		StringTokenizer stringTokenizer = new StringTokenizer(string,",");
		int tempOrderId = Integer.parseInt(stringTokenizer.nextToken());
		int tempProductId = Integer.parseInt(stringTokenizer.nextToken());
		boolean tempLogiProcessed = Boolean.parseBoolean(stringTokenizer.nextToken());
		OrderInformation orderInformation = new OrderInformation(tempOrderId,tempProductId);
		orderInformation.setLogiProcessed(tempLogiProcessed);
		return orderInformation;
	}

}
