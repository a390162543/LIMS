package businesslogic.statisticsbl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;

import vo.PaymentVO;
import vo.RevenueVO;
import businesslogic.ExcelExporter;
import businesslogic.paymentbl.Payment;
import businesslogic.revenuebl.Revenue;
import businesslogicservice.StatisticsblService;
/**
 * {@code Statistics}是统计报表的业务逻辑的实现类，提供所有有关统计报表的业务逻辑服务
 * @author 刘德宽
 * @version 1.6
 */
public class Statistics implements StatisticsblService {

	@Override
	public List<PaymentVO> queryPaymentVO(Date begindate, Date enddate) {  
		List<PaymentVO> vos = new ArrayList<PaymentVO>();
        Payment payment = new Payment();       
        vos = payment.queryPaymentVO(begindate, enddate);
        return vos ;
	}
	
	@Override
	public List<RevenueVO> queryRevenueVO(Date begindate, Date enddate) {
		List<RevenueVO> vos = new ArrayList<RevenueVO>();
		Revenue revenue = new Revenue();       
        vos = revenue.queryRevenueVO(begindate, enddate);
        return vos ;	
	}

	@Override
	public boolean gainExcel(JTable table1, JTable table2 ,File file ) {
		ExcelExporter excelExporter = new ExcelExporter();
		try {
			excelExporter.export(table1,table2,file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public double getTotalIncome(List<RevenueVO> revenuelist) {
		double totalIncome =0.0;
		for(RevenueVO vo: revenuelist)
			totalIncome += vo.getRevenue();
		return totalIncome;
	}

	@Override
	public double getTotalExpenditure(List<PaymentVO> paymentlist) {
		double totalExpenditure = 0.0;
		for(PaymentVO vo: paymentlist)
			totalExpenditure += vo.getMoney();
		return totalExpenditure;
	}

	@Override
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
