package businesslogicservice;

import java.util.Date;
import java.util.List;

import vo.PaymentVO;
import vo.RevenueVO;

public interface StatisticsblService {

	public List<PaymentVO>  queryPaymentVO(Date begindate, Date enddate);
	
	public List<RevenueVO>  queryRevenueVO(Date begindate, Date enddate);
	
	public boolean gainExcel();
	
	public double getTotalIncome(List< RevenueVO>  revenuelist);
	
	public double getTotalExpenditure (List< PaymentVO>  paymentlist);
	
	public double getTotalProfit(List< RevenueVO>  revenuelist   ,  List< PaymentVO>  paymentlist);
}
