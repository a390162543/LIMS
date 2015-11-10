package businesslogicservice_stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.AccountVO;
import vo.PaymentVO;
import vo.RevenueVO;
import businesslogicservice.StatisticsblService;

public class StatisticsblService_Stub implements StatisticsblService {
	PaymentVO pvo;
	RevenueVO rvo;
	
	public StatisticsblService_Stub(PaymentVO pvo , RevenueVO rvo){
		this.pvo=pvo;
		this.rvo=rvo;
	}
	public List<PaymentVO> queryPaymentVO(Date begindate, Date enddate) {
		List<PaymentVO> list=new ArrayList<PaymentVO>();
		list.add(pvo);
		return list;
	}

	public List<RevenueVO> queryRevenueVO(Date begindate, Date enddate) {
		List<RevenueVO> list=new ArrayList<RevenueVO>();
		list.add(rvo);
		return list;
	}

	public boolean gainExcel() {
		
		return true;
	}
	
	public double getTotalIncome(List<RevenueVO> revenuelist) {

		return 2.0;
	}

	public double getTotalExpenditure(List<PaymentVO> paymentlist) {
		return 2.0;
	}
	
	public double getTotalProfit(List<RevenueVO> revenuelist,
			List<PaymentVO> paymentlist) {
	
		return 2.0;
	}

}
