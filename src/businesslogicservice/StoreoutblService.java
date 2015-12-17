package businesslogicservice;

import java.util.List;

import vo.StoreoutCreateVO;



/**
 * StoreoutblService��ְ���Ǹ��𽫺ͻ��������صĲ����������������ⵥ���޸ĳ��ⵥ�����ⵥ��ִ�С�
 * ��������п��λ��״̬�ı仯����ҵ���߼�����
 * 
 * @author lc
 * @version 1.2
 */
public interface StoreoutblService extends Identifiable{

	/**
	 * �������ⵥ
	 * 
	 * @param vo {@code StoreoutCreateVO}
	 * @return �ɹ�����{@code true}   ʧ�ܷ���{@code false}
	 */
	public boolean createStoreoutPO (StoreoutCreateVO vo);
	
	/**
	 * �޸ĳ��ⵥ
	 * 
	 * @param vo {@code StoreoutCreateVO}
	 * @return �ɹ�����{@code true},ʧ�ܷ���{@code false}
	 */
	public boolean modifyStoreout (StoreoutCreateVO vo);
	
	/**
	 * ���ⵥִ��
	 * 
	 * @param vo {@code StoreoutCreateVO}
	 * @return �ɹ�����{@code true},ʧ�ܷ���{@code false}
	 */
	public boolean execute (StoreoutCreateVO vo);
	
	/**
	 * ���ⵥȷ�����һ�����ʱ���ı���Ӧ�Ŀ���λ�õ�״̬,����λ�����óɿ���
	 * 
	 * @param orderId {@code String}
	 * @return �ɹ�����{@code true}, ʧ�ܷ���{@code false}
	 */
	public boolean changeLocationState (String orderId);

	/**
	 * ���ⵥ�ڴ���ʱȡ���󣬽�δ����Ļ����ڿ���λ�����óɲ�����
	 * 
	 * @param orderId {@code String}
	 * @return �ɹ�����{@code true}, ʧ�ܷ���{@code false}
	 */
	public boolean restoreLcationState (String orderId);
	
	public  List<String> getTransferVO (String transferId);
	
	public List<String> getLoadVO (String loadId);
}
