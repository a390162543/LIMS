package businesslogicservice;

import java.util.List;
import vo.GoodsVO;
import vo.TransferVO;

/**
 * {@code TransferblService}�ṩ�������Ա�������ҵ���߼�����
 * @author ������
 * @version 1.4
 */ 
public interface TransferblService extends Identifiable{
	 /**
     * ��������¼��ת����Ϣ
     * 
     * @param vo ����㴫������{@code TransferVO}
     * @return  �ɹ���������{@code true}�����򷵻�{@code false}
     */
	public boolean createTransferPO(TransferVO vo);
	
	 /**
     * ����{@code location1}��{@code location2}��{@code way}��ȡ��Ӧ�˷�
     * 
     * @param location1, ����㴫������ �������� 
     * @param location2, ����㴫�����Ļ�������
     * @param way, ����㴫�����Ļ��˷�ʽ
     * @return ������Ӧ�˷�
     */
	public double getCost(String location1, String location2,String way);
	
	 /**
     * �޸���ת����Ϣ
     * 
     * @param vo ����㴫������{@code TransferVO}
     * @return  �ɹ��޸ķ���{@code true}�����򷵻�{@code false}
     */
	public boolean modifyTransferPO(TransferVO vo);
	
	 /**
     * ��ȡ������ת����Ϣ
     * 
     * @return  ����һ����������{@code TransferVO}��List
     */
	public List<TransferVO> getTransferVO();
	
	 /**
     * ��ת����ִ�з���
     * 
     * @param vo ����㴫������{@code TransferVO}
     * @return  �ɹ�ִ�з���{@code true}�����򷵻�{@code false}
     */
	public boolean execute(TransferVO vo);
	
	 /**
     * ����{@code id}��ȡһ��{@code GoodsVO}����
     * 
     *@param id {@code GoodsVO}��{@code id}��ʶ
     * @return ����һ��{@code GoodsVO}���������ѯʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     */
	public GoodsVO getGoodsVO(String id);
	
	/**
	 * ��ӻ���
	 * 
	 * @param vo ����㴫������{@code GoodsVO}
	 * @return �ɹ���ӷ���{@code true}, ���򷵻�{@code false}
	 */
	public boolean addGoods(GoodsVO vo);

	/**
	 * ɾ������
	 * 
	 * @param vo ����㴫������{@code GoodsVO}
	 * @return �ɹ�ɾ������{@code true}, ���򷵻�{@code false}
	 */
	public boolean deleteGoods(GoodsVO vo);
}
