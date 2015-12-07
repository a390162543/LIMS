package vo;

import po.ConstantPO;
 
/**
 * {@code ConstantPO}是价格业务逻辑层与界面层之间传递的对象，
 * 记录了价格的所有信息
 * @author 刘航伸
 */
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
