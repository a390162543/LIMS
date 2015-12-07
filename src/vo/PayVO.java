package vo;

import po.PayPO;

/**
 * {@code PayPO}��Ա��ҵ���߼��������������ʱ֮�䴫�ݵĶ���
 * ��¼�˹��ʵ�������Ϣ
 * @author ������
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
			payStr = payByCount + " /��";
		else{
			if(rate == 0)
				payStr = "��н: " + basePay;
				
			else
				payStr = "��������: " + basePay + "\n" + "����ʣ� " + salesCommission;
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
