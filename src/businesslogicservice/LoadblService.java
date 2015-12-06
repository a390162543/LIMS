package businesslogicservice;


import vo.GoodsVO;
import vo.LoadVO;

/**
 * {@code LoadblService}�ṩ�������װ���������ҵ���߼�����
 * @author ���滪
 * @version 1.5
 */
public interface LoadblService extends Identifiable {
    
    /**
     * ��������¼װ������Ϣ
     * @param vo ����㴫������{@code LoadVO}
     * @return �ɹ���������{@code true}�����򷵻�{@code false}
     */
    public boolean createLoadPO(LoadVO vo);
    
    /**
     * �޸�װ������Ϣ
     * 
     * @param vo ����㴫������{@code LoadVO}
     * @return  �ɹ��޸ķ���{@code true}�����򷵻�{@code false}
     */
    public boolean modifyLoadPO(LoadVO vo);
    
    /**
     * ����{@code id}��ȡһ��{@code GoodsVO}����
     * @param id {@code GoodsVO}��{@code id}��ʶ
     * @return ����һ��{@code GoodsVO}���������ѯʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     */
    public GoodsVO getGoodsVO(String id);
    
    /**
     * ��װ���������б������һ��{@code GoodsVO}
     * @param vo ��Ҫ�����{@code GoodsVO}
     * @return �����ӳɹ��򷵻�{@code true}�����򷵻�{@code false}
     */
    public boolean addGoods(GoodsVO vo);
    
    /**
     * ��װ���������б���ɾ��һ��{@code GoodsVO}
     * @param vo ��Ҫɾ����{@code GoodsVO}
     * @return ���ɾ���ɹ��򷵻�{@code true}�����򷵻�{@code false}
     */
    public boolean deleteGoods(GoodsVO vo);
    
    /**
     * ��ȡװ����������ܼ�
     * @param location1 {@code LoadVO}�еĳ�����
     * @param location2 {@code LoadVO}�е�Ŀ�ĵ�
     * @return �����ܼ�
     */
    public double getCost(String location1, String location2);
    
    /**
     * ִ��װ������Ϣ
     * 
     * @param vo ����㴫������{@code LoadVO}
     * @return  �ɹ�ִ�з���{@code true}�����򷵻�{@code false}
     */
    public boolean execute(LoadVO vo);
    
}
