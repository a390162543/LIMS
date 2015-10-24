package businesslogicservice;

import java.util.Date;
import java.util.List;

import vo.PaymentVO;
import vo.RevenueVO;

public interface StatisticsblService {

	public List<PaymentVO>  queryPaymentVO(Date begindate, Date enddate);
	public List<RevenueVO>  queryRevenueVO(Date begindate, Date enddate);
}
