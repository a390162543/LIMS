package vo;

import po.ConstantPO;

public class ConstantVO {
	private double price;

	
	
	public ConstantVO(double price) {
		super();
		this.price = price;
	}
	public ConstantPO getConsstantPO(){
		return new ConstantPO(price);
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	 
	
}
