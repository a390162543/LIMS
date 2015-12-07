package businesslogicservice;


import vo.StorageLocationVO;
import vo.StoreinCreateVO;



/**
 * StoreinblService��ְ���Ǹ��𽫺ͻ��������صĲ���������������ⵥ���޸���ⵥ����ⵥ��ִ�С�
 * �������п��λ��״̬�ı仯����ҵ���߼�����
 * 
 * @author lc
 * @version 1.3
 */
public interface StoreinblService extends Identifiable {
	
	/**
	 * ������ⵥ
	 * 
	 * @param vo {@code StoreinCreateVO}
	 * @return �ɹ�����{@code true}   ʧ�ܷ���{@code false}
	 */
	public boolean createStoreinPO (StoreinCreateVO vo);
	
	/**
	 * �޸���ⵥ
	 * 
	 * @param vo {@code StoreinCreateVO}
	 * @return �ɹ�����{@code true},ʧ�ܷ���{@code false}
	 */
	public boolean modifyStorein (StoreinCreateVO vo);
	
	/**
	 * ��ⵥִ��
	 * 
	 * @param vo {@code StoreinCreateVO}
	 * @return �ɹ�����{@code true},ʧ�ܷ���{@code false}
	 */
	public boolean execute (StoreinCreateVO vo);
	
	/**
	 * ��ⵥȷ�����һ�����ʱ���ı���Ӧ�Ŀ���λ�õ�״̬,��λ�ý������ٷ��û���
	 * 
	 * @param vo {@code StorageLocationVO}
	 * @return �ɹ�����{@code true}, ʧ�ܷ���{@code false}
	 */
	public boolean changeLocationState (StorageLocationVO vo);
	
	
	/**
	 * ��ⵥ�ڴ���ʱȡ���󣬽�ԭ����ռ�õĿ���е�λ������Ϊ����
	 * 
	 * @param vo {@code StorageLocationVO}
	 * @return �ɹ�����{@code true}, ʧ�ܷ���{@code false}
	 */
	public boolean restoreLocationState (StorageLocationVO vo);
	
	
}
