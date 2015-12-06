package businesslogicservice;

import java.util.List;

import vo.TruckVO;

/**
 * {@code TruckblService}�ṩ������㳵�������ҵ���߼�����
 * @author ���滪
 * @version 1.3
 */
public interface TruckblService extends Identifiable {
    
    /**
     * ��������¼������Ϣ
     * @param vo ����㴫����{@code TruckVO}
     * @return �ɹ������򷵻�{@code true}�����򷵻�{@code false}
     */
    public boolean createTruckPO(TruckVO vo);
    
    /**
     * ɾ��������Ϣ
     * @param vo ����㴫����{@code TruckVO}
     * @return �ɹ�ɾ���򷵻�{@code true}�����򷵻�{@code false}
     */
    public boolean deleteTruckPO(TruckVO vo);
    
    /**
     * �޸ĳ�����Ϣ
     * @param vo ����㴫����{@code TruckVO}
     * @return �ɹ��޸��򷵻�{@code true}�����򷵻�{@code false}
     */
    public boolean modifyTruckPO(TruckVO vo);
    
    /**
     * ��ȡ���еĳ�����Ϣ
     * @return {@code TruckVO}���б����û�г�����Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
     */
    public List<TruckVO> getTruckVO();
    
    /**
     * ��ȡ������ĳ��Ӫҵ�������г�����Ϣ
     * @return {@code TruckVO}���б����û�г�����Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
     */
    public List<TruckVO> getTruckVO(String organization);
}
