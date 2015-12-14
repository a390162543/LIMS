package businesslogicservice;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;

import vo.PaymentVO;
import vo.RevenueVO;

/**
 * {@code  StatisticsblService}提供给界面层查看统计报表的业务逻辑服务
 * @author 刘德宽
 * @version 1.4
 */
public interface StatisticsblService {

    /**
     * 根据起始日期获取所有的付款单信息
     * @param  begindate  {@code Date} 
     * @param  enddate {@code Date}
     * @return {@code PaymentVO}的列表，如果没有付款单信息或获取失败，则返回空列表
     */
	public List<PaymentVO>  queryPaymentVO(Date begindate, Date enddate);
	
    /**
     * 根据起始日期获取所有的收款单信息
     * @param  begindate  {@code Date} 
     * @param  enddate {@code Date}
     * @return {@code RevenueVO}的列表，如果没有收款单信息或获取失败，则返回空列表
     */
	public List<RevenueVO>  queryRevenueVO(Date begindate, Date enddate);
	
    /**
     * 生成收款单和付款单信息到Excel
     * @return 成功修改则返回{@code true}，否则返回{@code false}
     */
	public boolean gainExcel(JTable table1, JTable table2 ,File file );
	
    /**
     * 根据收款单列表获取总收入
     * @param  revenuelist  {@code List<RevenueVO>}
     * @return {@code double}
     */
	public double getTotalIncome(List< RevenueVO>  revenuelist);
	
    /**
     * 根据付款单列表获取总支出
     * @param  paymentlist  {@code List<PaymentVO>}
     * @return {@code double}
     */
	public double getTotalExpenditure (List< PaymentVO>  paymentlist);
	
    /**
     * 根据付款单和收款单列表获取总利润
     * @param  paymentlist  {@code List<PaymentVO>}
     * @param  revenuelist  {@code List<RevenueVO>}
     * @return {@code double}
     */
	public double getTotalProfit(List< RevenueVO>  revenuelist   ,  List< PaymentVO>  paymentlist);
}
