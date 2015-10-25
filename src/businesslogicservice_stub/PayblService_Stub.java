package businesslogicservice_stub;

import po.EmployeePO;
import businesslogicservice.PayblService;

public class PayblService_Stub implements PayblService{
	 double basePay;
	 double payByCount;
	 int count;
	 double salesCommission;
	 double monthPay;
	 
	 public PayblService_Stub(double b, double p, int c, double s ){
		 basePay = b;
		 payByCount = p;
		 count = c;
		 salesCommission = s;
		  
	 }
	@Override
	public boolean addPayByCount() {
		// TODO Auto-generated method stub
		count ++;
		return true;
	}
	@Override
	public double addSalesCommission(double account) {
		// TODO Auto-generated method stub
		return account * 0.1;
	}
	@Override
	public double getMonthlyPay(EmployeePO e) {
		// TODO Auto-generated method stub
		return monthPay;
	}
}
