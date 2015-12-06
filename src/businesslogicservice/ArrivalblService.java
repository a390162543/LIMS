package businesslogicservice;

import vo.ArrivalVO;
import vo.LoadVO;
import vo.TransferVO;

/**
 * {@code ArrivalblService}�ṩ������㵽�ﵥ�����ҵ���߼�����
 * @author ���滪
 * @version 1.4
 */
public interface ArrivalblService extends Identifiable{
    
    /**
     * ��������¼���ﵥ��Ϣ
     * 
     * @param vo ����㴫������{@code ArrivalVO}
     * @return  �ɹ���������{@code true}�����򷵻�{@code false}
     */
    public boolean createArrivalPO(ArrivalVO vo);
    
    /**
     * �޸ĵ��ﵥ��Ϣ
     * 
     * @param vo ����㴫������{@code ArrivalVO}
     * @return  �ɹ��޸ķ���{@code true}�����򷵻�{@code false}
     */
    public boolean modifyArrivalPO(ArrivalVO vo);
    
    /**
     * ִ�е��ﵥ��Ϣ
     * 
     * @param vo ����㴫������{@code ArrivalVO}
     * @return  �ɹ�ִ�з���{@code true}�����򷵻�{@code false}
     */
    public boolean execute(ArrivalVO vo);
    
    /**
     * ����{@code id}��ȡһ��{@code LoadVO}����
     * 
     * @param id {@code LoadVO}��{@code id}��ʶ
     * @return ����һ��{@code LoadVO}���������ѯʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     */
    public LoadVO getLoadVO(String id);
    
    /**
     * ����{@code id}��ȡһ��{@code TransferVO}����
     * 
     * @param id {@code TransferVO}��{@code id}��ʶ
     * @return ����һ��{@code TransferVO}���������ѯʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     */
    public TransferVO getTransferVO(String id);
    
}
