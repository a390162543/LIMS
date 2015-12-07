package vo;

import po.PayPO;

/**
 * {@code PayPO}是员工业务逻辑层与界面层管理工资时之间传递的对象，
 * 记录了工资的所有信息
 * @author 刘航伸
 * @see po.EmployeePO
 */
public class PayVO {
	private double basePay;
	private double payByCount;
	private int count;
	private double salesCommission;
 
	private double rate;
	
	public PayVO(double basePay, double payByCount, int count, 
			double salesCommission , double rate){
		this.basePay = basePay;
		this.payByCount = payByCount;
		this.count = count;
		this.salesCommission = salesCommission;		 
		this.rate = rate;
	}
	
	public PayPO getPayPO(){
		return new PayPO(basePay, payByCount, count, salesCommission, rate);
	}
	
	public String getPayString(){
		String payStr = "";
		if(basePay == 0)
			payStr = payByCount + " /次";
		else{
			if(rate == 0)
				payStr = "月薪: " + basePay;
				
			else
				payStr = "基础工资: " + basePay + "\n" + "提成率： " + salesCommission;
		}
		return payStr;
	}

	public double getBasePay() {
		return basePay;
	}

	public void setBasePay(double basePay) {
		this.basePay = basePay;
	}

	public double getPayByCount() {
		return payByCount;
	}

	public void setPayByCount(double payByCount) {
		this.payByCount = payByCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count ) {
		this.count = count;
	}

	public double getSalesCommission() {
		return salesCommission;
	}

	public void setSalesCommission(double salesCommission) {
		this.salesCommission = salesCommission;
	}

	 

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
}
