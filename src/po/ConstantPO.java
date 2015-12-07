package po;

import java.io.Serializable;

import vo.ConstantVO;

/**
 * {@code ConstantPO}是价格业务逻辑层与数据层之间传递的持久化对象，
 * 记录了价格的所有信息
 * @author 刘航伸
 */
public class ConstantPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2490864291437683436L;
	private double price;
	 
	
	 
	
	public ConstantPO(double price) {
		super();
		this.price = price;
	}

	public ConstantVO getConstantVO(){
		return new ConstantVO(price);
	}
	
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	 
}
