package businesslogicservice;
 
 
import vo.PayVO;
 

public interface PayblService {
	public int addPayByCount(PayVO vo);
	
	public double addSalesCommission(double account,PayVO vo);
	
	public double getMonthlyPay(PayVO vo);
	
	 
}
