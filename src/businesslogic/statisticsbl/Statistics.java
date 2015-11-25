package businesslogic.statisticsbl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.PaymentVO;
import vo.RevenueVO;
import businesslogic.paymentbl.Payment;
import businesslogic.revenuebl.Revenue;
import businesslogicservice.StatisticsblService;

public class Statistics implements StatisticsblService {

	public List<PaymentVO> queryPaymentVO(Date begindate, Date enddate) {  
		List<PaymentVO> vos = new ArrayList<PaymentVO>();
        Payment payment = new Payment();       
        vos = payment.queryPaymentVO(begindate, enddate);
        return vos ;
	}

	public List<RevenueVO> queryRevenueVO(Date begindate, Date enddate) {
		List<RevenueVO> vos = new ArrayList<RevenueVO>();
		Revenue revenue = new Revenue();       
        vos = revenue.queryRevenueVO(begindate, enddate);
        return vos ;	
	}

	public boolean gainExcel() {

		return false;
	}

	public double getTotalIncome(List<RevenueVO> revenuelist) {
		double totalIncome =0.0;
		for(RevenueVO vo: revenuelist)
			totalIncome += vo.getRevenue();
		return totalIncome;
	}


	public double getTotalExpenditure(List<PaymentVO> paymentlist) {
		double totalExpenditure = 0.0;
		for(PaymentVO vo: paymentlist)
			totalExpenditure += vo.getMoney();
		return totalExpenditure;
	}


	public double getTotalProfit(List<RevenueVO> revenuelist,
			List<PaymentVO> paymentlist) {
		double totalIncome =0.0;
		for(RevenueVO vo: revenuelist)
			totalIncome += vo.getRevenue();
		double totalExpenditure = 0.0;
		for(PaymentVO vo: paymentlist)
			totalExpenditure += vo.getMoney();
		return totalIncome-totalExpenditure;
	}

}
