package businesslogicservice_driver;

import java.util.Date;
import java.util.List;

import vo.PaymentVO;
import vo.RevenueVO;
import businesslogicservice.StatisticsblService;


public class StatisticsblService_Driver {

	public void drive(StatisticsblService statisticsblService){
		List<RevenueVO> vos1 = statisticsblService.queryRevenueVO(new Date(2015,9,1), new Date());
	    System.out.println("get "+vos1.size()+" RevenueVO!");

		List<PaymentVO> vos2 = statisticsblService.queryPaymentVO(new Date(2015,9,1), new Date());
	    System.out.println("get "+vos2.size()+" PaymentVO!");
	}
}
