package businesslogicservice;

import java.util.List;

import vo.EmployeeVO;
import vo.OrderRevenueVO;
import vo.RevenueVO;

/**
 * {@code RevenueblService}�ṩ��������տ�����ҵ���߼�����
 * @author ���滪
 * @version 1.5
 */
public interface RevenueblService extends Identifiable {
    
    /**
     * ��������¼�տ��Ϣ
     * @param vo ����㴫������{@code RevenueVO}
     * @return �ɹ���������{@code true}�����򷵻�{@code false}
     */
    public boolean createRevenuePO(RevenueVO vo);
    
    /**
     * �޸��տ��Ϣ
     * 
     * @param vo ����㴫������{@code RevenueVO}
     * @return  �ɹ��޸ķ���{@code true}�����򷵻�{@code false}
     */
    public boolean modifyRevenuePO(RevenueVO vo);
    
    /**
     * ִ���տ��Ϣ
     * 
     * @param vo ����㴫������{@code RevenueVO}
     * @return  �ɹ�ִ�з���{@code true}�����򷵻�{@code false}
     */
    public boolean execute(RevenueVO vo);
    
    /**
     * ����{@code id}��ʶ��ȡһ��{@code OrderRevenueVO}
     * @param id ������{@code id}
     * @return  {@code OrderPO}��Ӧ��һ��{@code OrderRevenueVO}�������ѯʧ��
     * �򲻴��ڣ��򷵻�{@code null}
     */
    public OrderRevenueVO getOrderRevenueVO(String id);
    
    /**
     * �ڶ����б������һ��{@code OrderRevenueVO}
     * @param vo ��Ҫ�����{@code OrderRevenueVO}
     * @return �����ӳɹ��򷵻�{@code true}�����򷵻�{@code false}
     */
    public boolean add(OrderRevenueVO vo);
    
    /**
     * �ڶ����б���ɾ��һ��{@code OrderRevenueVO}
     * @param vo ��Ҫɾ����{@code OrderRevenueVO}
     * @return ���ɾ���ɹ��򷵻�{@code true}�����򷵻�{@code false}
     */
    public boolean delete(OrderRevenueVO vo);
    
    /**
     * ��ȡ�������ܼ�
     * @return �����ܼ�
     */
    public double getSum();
    
    /**
     * ��ȡ��Ӫҵ�������п��Ա
     * @return {@code EmployeeVO}���б���������ڱ�Ӫҵ�����Ա���򷵻�һ�����б�
     * @see businesslogic.userbl.LoginController
     */
    public List<EmployeeVO> getAllCouriers();
    
}
