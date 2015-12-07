package businesslogicservice;

import vo.OrderCreateVO;
import vo.OrderQueryVO;
import vo.OrderSignVO;



/**
 * OrderblService��ְ���Ǹ��𽫺Ͷ�����صĲ�����������������������ǩ�ա�����������ѯ���淢��������
 * ת������̨�߼�����
 * @author lc
 * @version 1.2
 *
 */


public interface OrderblService extends Identifiable {
	
	
	/**
	 * ��֤���������Ƿ�ɹ�
	 * 
	 * @param vo {@code OrderCreateVO}
	 * @return �ɹ�����{@code true}��ʧ�ܷ���{@code false}
	 * 
	 */
	public boolean createOrderPO(OrderCreateVO vo);
	
	
	/**
	 * ��֤����ǩ���Ƿ�ɹ�
	 * 
	 * @param vo {@code OrderSignVO}
	 * @return �ɹ�����{@code true}��ʧ�ܷ���{@code false}
	 * 
	 */
	public boolean signOrder(OrderSignVO vo);
	
	
	/**
	 * �ܾ����޸ĵ����Ƿ�ɹ�
	 * 
	 * @param vo {@code OrderCreateVO}
	 * @return �ɹ�����{@code true}��ʧ�ܷ���{@code false}
	 *
	 */
	public boolean modifyOrder(OrderCreateVO vo);
	
	
	/**
	 *������ѯʱ������ӦOrderQueryVO��������ʾ��Ϣ
	 * 
	 * @param orderId {@code String}
	 * @return ����һ�� {@code OrderQueryVO}
	 * 
	 */
	public OrderQueryVO returnOrderQueryVO(String orderId);
	
	
	/**
	 * ������۸�����Ҫ����Ϣ�ӽ��洫���߼���������ܷ���
	 * 
	 * @param vo {@code OrderCreateVO}
	 * @return ����һ��{@code double}
	 * 
	 */
	public double getTotal(OrderCreateVO vo);
	
	
	/**
	 * ����������ʱ������Ҫ����Ϣ�ӽ��洫���߼��������Ԥ���ʹ�ʱ��
	 * 
	 * @param senderAddress {@code String}
	 * @param receiverAddress {@code String}
	 * @return ����һ��{@code double}
	 * 
	 */
	public int getEximatedTime(String senderAddress, String receiverAddress);
	
	/**
	 * �ܾ�������������ִ�ж���������
	 * 
	 * @param vo {@code OrderCreateVO}
	 * @return �ɹ�����{@code true}��ʧ�ܷ���{@code false}
	 * 
	 */
	public boolean execute(OrderCreateVO vo);
	
}
