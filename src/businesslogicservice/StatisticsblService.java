package businesslogicservice;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;

import vo.PaymentVO;
import vo.RevenueVO;

/**
 * {@code  StatisticsblService}�ṩ�������鿴ͳ�Ʊ����ҵ���߼�����
 * @author ���¿�
 * @version 1.4
 */
public interface StatisticsblService {

    /**
     * ������ʼ���ڻ�ȡ���еĸ����Ϣ
     * @param  begindate  {@code Date} 
     * @param  enddate {@code Date}
     * @return {@code PaymentVO}���б����û�и����Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
     */
	public List<PaymentVO>  queryPaymentVO(Date begindate, Date enddate);
	
    /**
     * ������ʼ���ڻ�ȡ���е��տ��Ϣ
     * @param  begindate  {@code Date} 
     * @param  enddate {@code Date}
     * @return {@code RevenueVO}���б����û���տ��Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
     */
	public List<RevenueVO>  queryRevenueVO(Date begindate, Date enddate);
	
    /**
     * �����տ�͸����Ϣ��Excel
     * @return �ɹ��޸��򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean gainExcel(JTable table1, JTable table2 ,File file );
	
    /**
     * �����տ�б��ȡ������
     * @param  revenuelist  {@code List<RevenueVO>}
     * @return {@code double}
     */
	public double getTotalIncome(List< RevenueVO>  revenuelist);
	
    /**
     * ���ݸ���б��ȡ��֧��
     * @param  paymentlist  {@code List<PaymentVO>}
     * @return {@code double}
     */
	public double getTotalExpenditure (List< PaymentVO>  paymentlist);
	
    /**
     * ���ݸ�����տ�б��ȡ������
     * @param  paymentlist  {@code List<PaymentVO>}
     * @param  revenuelist  {@code List<RevenueVO>}
     * @return {@code double}
     */
	public double getTotalProfit(List< RevenueVO>  revenuelist   ,  List< PaymentVO>  paymentlist);
}
