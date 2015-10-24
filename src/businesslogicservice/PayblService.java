package businesslogicservice;

import po.EmployeePO;
import po.PayPO;
import systemenum.Position;

public interface PayblService {
	public boolean addPayByCount();
	
	public double addSalesCommission(double account);
	
	public double getMonthlyPay(EmployeePO e);
	
	 
}
