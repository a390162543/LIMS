package vo;

public class PayVO {
	private double basePay;
	private double payByCount;
	private int count;
	private double salesCommission;
	private double monthPay;
	
	public PayVO(double basePay, double payByCount, int count, 
			double salesCommission,double mothPay){
		this.basePay = basePay;
		this.payByCount = payByCount;
		this.count = count;
		this.salesCommission = salesCommission;
		this.monthPay = mothPay;
	}
}
