package businesslogicservice;

import java.util.Date;
import java.util.List;

import vo.RevenueVO;

/**
 * {@code  SettlementblService}�ṩ��������������ҵ���߼�����
 * @author ���¿�
 * @version 1.4
 */
public interface SettlementblService {
    /**
     * �������ں�Ӫҵ����ȡ���е��տ��Ϣ
     * @param  date  {@code Date}
     * @param  organization {@code String}
     * @return {@code RevenueVO}���б����û���տ��Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
     */
	public List<RevenueVO> queryRevenueVO (Date date ,String organization);
	
    /**
     * �����տ��˻�
     * @param vo {@code RevenueVO} 
     * @param accountId {@code String}
     * @return �ɹ��޸��򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean setAccountId(RevenueVO vo,String accountId);
	
    /**
     * ��ȡ���е��տ��Ϣ
     * @return {@code RevenueVO}���б����û���տ����Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
     */
	public List<RevenueVO> getUncommittedRevenueVO();
	
    /**
     * ��ȡ���е��˻������Ϣ
     * @return {@code String}�����飬���û���˻������Ϣ���ȡʧ�ܣ��򷵻ؿ�����
     */
	public String[] getAllAccountId();
}
