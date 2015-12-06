package businesslogicservice;

import java.util.List;

import vo.DeliverVO;
import vo.EmployeeVO;
/**
 * {@code DeliverblService}�ṩ��������ɼ��������ҵ���߼�����
 * @author ���滪
 * @version 1.3
 */
public interface DeliverblService extends Identifiable {

    /**
     * ��������¼�ɼ�����Ϣ
     * 
     * @param vo ����㴫������{@code DeliverVO}
     * @return  �ɹ���������{@code true}�����򷵻�{@code false}
     */
    public boolean createDeliverPO(DeliverVO vo);
    
    /**
     * �޸��ɼ�����Ϣ
     * 
     * @param vo ����㴫������{@code DeliverVO}
     * @return  �ɹ��޸ķ���{@code true}�����򷵻�{@code false}
     */
    public boolean modifyDeliverPO(DeliverVO vo);
    
    /**
     * ִ���ɼ�����Ϣ
     * 
     * @param vo ����㴫������{@code DeliverVO}
     * @return  �ɹ�ִ�з���{@code true}�����򷵻�{@code false}
     */
    public boolean execute(DeliverVO vo);
    
    /**
     * ��ȡ��Ӫҵ�������п��Ա
     * @return {@code EmployeeVO}���б�û�п��Ա�򷵻ؿ��б�
     * @see businesslogic.userbl.LoginController
     */
    public List<EmployeeVO> getAllCouriers();
}
