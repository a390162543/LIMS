package businesslogicservice;

import vo.PaymentVO;

/**
 * {@code  PaymentblService}�ṩ������㸶������ҵ���߼�����
 * @author ���¿�
 * @version 1.4
 */
public interface PaymentblService extends Identifiable{

    /**
     * ��������¼�����Ϣ
     * @param vo ����㴫����{@code PaymentVO}
     * @return �ɹ������򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean createPaymentPO(PaymentVO vo);
	
    /**
     * �޸ĸ����Ϣ
     * @param vo ����㴫����{@code PaymentVO}
     * @return �ɹ��޸��򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean modifyPaymentPO(PaymentVO vo);
	
    /**
     * ִ�и����Ϣ
     * 
     * @param vo ����㴫������{@code PaymentVO}
     * @return  �ɹ�ִ�з���{@code true}�����򷵻�{@code false}
     */
	public boolean execute(PaymentVO vo);

}
