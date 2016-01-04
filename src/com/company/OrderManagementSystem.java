package com.company;

import com.company.queue.Queue;
import com.company.queue.QueueImpl;

import java.util.List;

/**
 * Created by hyemi on 2015. 12. 31..
 */
public class OrderManagementSystem {

	private Queue<OrderInformation> orderInformationQueue;
	private OrderManagementFileIO orderManagementFileIO;

	public OrderManagementSystem() {
		orderInformationQueue = new QueueImpl<OrderInformation>();
		orderManagementFileIO = new OrderManagementFileIO();
	}

	public void setFileName(String string){
		orderManagementFileIO.setFileName(string);
	}

	public void addOrder(int orderID,int productID) {
		OrderInformation orderInformation = new OrderInformation(orderID,productID);
		orderInformationQueue.enqueue(orderInformation);
	}

	public void processOrder() {
		if(orderInformationQueue.getSize() > 0){
			orderManagementFileIO.writeNewOrderInformation(orderInformationQueue.dequeue());
		}
	}

	public void printOrderInformationByOrderID(int orderID){
		List<OrderInformation> orderInformationList = orderManagementFileIO.findOrderInformationByOrderID(orderID);
		if(orderInformationList.size() == 0){
			System.out.println("해당 주문번호에 해당하는 주문정보가 없습니다.");
			return;
		}

		for(OrderInformation orderInformation : orderInformationList){
			orderInformation.print();
		}
	}

	public void listAllOrderInformationList(){
		for(OrderInformation orderInformation : orderInformationQueue.getAllElements()) {
			orderInformation.print();
		}
	}

	public void logisticsProcess(int orderID){
		for(OrderInformation orderInformation : orderManagementFileIO.findOrderInformationByOrderID(orderID)){
			String oldString = OrderInformation.toString(orderInformation);
			orderInformation.setLogiProcessed(true);
			orderManagementFileIO.updateOrderInformation(oldString,OrderInformation.toString(orderInformation));
		}
	}
}
