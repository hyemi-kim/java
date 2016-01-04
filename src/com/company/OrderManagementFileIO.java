package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyemi on 2016. 1. 3..
 */

public class OrderManagementFileIO {

	public String fileName;

	public void setFileName(String string){
		this.fileName = string + ".txt";
	}

	public List<OrderInformation> findOrderInformationByOrderID(int orderID){
		List<OrderInformation> orderInformationList = new ArrayList<OrderInformation>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			String string;
			while((string = bufferedReader.readLine()) != null){
				OrderInformation orderInformation = OrderInformation.toOrderInformation(string);
				if(orderInformation.getOrderId() == orderID){
					orderInformationList.add(OrderInformation.toOrderInformation(string));
				}
			}
			bufferedReader.close();
		}
		catch(IOException exception){
			System.err.println(exception);
		}
		return orderInformationList;
	}

	public void writeNewOrderInformation(OrderInformation orderInformation) {
		try{
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,true));
			String orderInformationString = OrderInformation.toString(orderInformation);
			bufferedWriter.write(orderInformationString,0,orderInformationString.length());
			bufferedWriter.newLine();
			bufferedWriter.close();
		}
		catch(IOException exception){
			System.err.println(exception);
		}
	}

	public void updateOrderInformation(String old,String update){
		File inputFile = new File(fileName);
		File outputFile = new File(fileName + ".temp");
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		boolean result = false;
		try{
			fileInputStream = new FileInputStream(inputFile);
			fileOutputStream = new FileOutputStream(outputFile);
			bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
			String line;
			while((line = bufferedReader.readLine()) != null){
				if(line.equals(old)){
					bufferedWriter.write(update);
				}
				else {
					bufferedWriter.write(line);
				}
				bufferedWriter.flush();
				bufferedWriter.newLine();
			}
			result = true;
			bufferedWriter.close();
		}
		catch(IOException exception){
			System.err.println(exception);
		}
		if(result){
			inputFile.delete();
			outputFile.renameTo(new File(fileName));
		}
	}


}
