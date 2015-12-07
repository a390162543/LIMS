package po;

import java.io.Serializable;

import vo.PayVO;
 
/**
 * {@code PayPO}��Ա��ҵ���߼��������ݲ������ʱ֮�䴫�ݵĳ־û�����
 * ��¼�˹��ʵ�������Ϣ
 * @author ������
 * @see vo.EmployeeVO
 */
public class PayPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3189394023247206404L;
	private double basePay;
	private double payByCount;
	private int count;
	private double salesCommission;
	private double rate;
	
	public PayPO(double basePay, double payByCount, int count, 
			double salesCommission,double rate ){
		this.basePay = basePay;
		this.payByCount = payByCount;
		this.count = count;
		this.salesCommission = salesCommission;
		this.rate = rate;
	}
	
	
	public String getPayString(){
		String payStr = "";
		if(basePay == 0)
			payStr = payByCount + " /��";
		else{
			if(rate == 0)
				payStr = "��������: " + basePay + "\n" + "����ʣ� " + salesCommission;
			else
				payStr = "��н: " + basePay;
		}
		return payStr;
	}
	
	public PayVO getPayVO() {
		return new PayVO(basePay, payByCount, count, salesCommission,  rate);
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
	public double getBasePay() {
		return basePay;
	}



	public void setBasePay(double basePay) {
		this.basePay = basePay;
	}



	public double getRate() {
		return rate;
	}



	public void setRate(double rate) {
		this.rate = rate;
	}



	public void setSalesCommission(double salesCommission) {
		this.salesCommission = salesCommission;
	}
	 
	

}
