package io4;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputApp1 {

	public static void main(String[] args) throws Exception {
		
		String name = "Iphone 15 pro";
		String company = "apple";
		int price = 1500000;
		double discountRate = 0.05;
		boolean soldOut = false;
		
		DataOutputStream out = new DataOutputStream(new FileOutputStream("src/io4/item.sav"));
		
		out.writeUTF(name);
		out.writeUTF(company);
		out.writeInt(price);
		out.writeDouble(discountRate);
		out.writeBoolean(soldOut);
		
		out.close();
	}
}
