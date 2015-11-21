package businesslogic.statisticsbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;





import po.PaymentPO;
import po.RevenuePO;
import dataservice.PaymentDataService;
import dataservice.RevenueDataService;
import vo.PaymentVO;
import vo.RevenueVO;
import businesslogicservice.StatisticsblService;

public class Statistics implements StatisticsblService {

	public List<PaymentVO> queryPaymentVO(Date begindate, Date enddate) {
        List<PaymentVO> vos = new ArrayList<PaymentVO>();
        try {
        	PaymentDataService pds = (PaymentDataService) Naming.lookup("rmi://localhost/PaymentData");
            List<PaymentPO> pos = pds.finds("date", begindate);
            for(PaymentPO po : pos){
            	if(po.getDate().before(enddate)||po.getDate().equals(enddate))
            		vos.add(po.getPaymentVO());
            }
        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (RemoteException e) {

            e.printStackTrace();
        } catch (NotBoundException e) {
  
            e.printStackTrace();
        }
        return vos;
	}

	public List<RevenueVO> queryRevenueVO(Date begindate, Date enddate) {
//        List<RevenueVO> vos = new ArrayList<RevenueVO>();
//        try {
//        	RevenueDataService rds = (RevenueDataService) Naming.lookup("rmi://localhost/RevenueData");
//            List<RevenuePO> pos = rds.finds("date", begindate);
//            for(RevenuePO po : pos){
//            	if(po.getRevenueDate().before(enddate)||po.getRevenueDate().equals(enddate))
//            		vos.add(po.getRevenueVO());
//            }
//        } catch (MalformedURLException e) {
//
//            e.printStackTrace();
//        } catch (RemoteException e) {
//
//            e.printStackTrace();
//        } catch (NotBoundException e) {
//  
//            e.printStackTrace();
//        }
//        return vos;
		return null;
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
