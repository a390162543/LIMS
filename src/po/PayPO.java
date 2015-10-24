package po;

public class PayPO {
	private double basePay;
	private double payByCount;
	private int count;
	private double salesCommission;
	private double monthPay;
	
	public PayPO(double basePay, double payByCount, int count, 
			double salesCommission,double mothPay){
		this.basePay = basePay;
		this.payByCount = payByCount;
		this.count = count;
		this.salesCommission = salesCommission;
		this.monthPay = mothPay;
	}
	
	
	public double getBasepay() {
		return basePay;
	}
	public void setBasepay(double basepay) {
		this.basePay = basepay;
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
	public void setCount(int count) {
		this.count = count;
	}
	public double getSalesCommission() {
		return salesCommission;
	}
	public void setSalesCommission(double salesCommission) {
		this.salesCommission = salesCommission;
	}
	public double getMonthPay() {
		return monthPay;
	}
	public void setMonthPay(double monthPay) {
		this.monthPay = monthPay;
	}
	

}
