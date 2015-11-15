package businesslogic_tester.orderbl;

import businesslogic.constantbl.Constant;

public class MockConstant extends Constant{
	
	double distance;
	double price;
	
	public MockConstant(double distance,double price){
		this.distance = distance;
		this.price = price;
	}
	
	public double getPrice(){
		return price;
	}

	public double getDiatance(String senderAddress ,String receiverAddress){	
		return distance;
	}
	
	
}
