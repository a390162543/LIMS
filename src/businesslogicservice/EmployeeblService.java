package businesslogicservice;

import java.util.List;
import vo.EmployeeVO;

/**
 * {@code ArrivalblService}�ṩ�������Ա�������ҵ���߼�����
 * @author ������
 * @version 1.4
 */
public interface EmployeeblService extends Identifiable{
	 /**
     * ��������¼Ա����Ϣ
     * 
     * @param vo ����㴫������{@code EmployeeVO}
     * @return  �ɹ���������{@code true}�����򷵻�{@code false}
     */
	public boolean createEmployeePO(EmployeeVO vo);
	 
	/**
     * ɾ��Ա����Ϣ
     * 
     * @param vo ����㴫������{@code EmployeeVO}
     * @return  �ɹ�ɾ������{@code true}�����򷵻�{@code false}
     */
	public boolean deleteEmployeePO (EmployeeVO vo);
	
	 /**
     * �޸�Ա����Ϣ
     * 
     * @param vo ����㴫������{@code EmployeeVO}
     * @return  �ɹ��޸ķ���{@code true}�����򷵻�{@code false}
     */
	public boolean modifyEmployeePO (EmployeeVO vo);
	
	/**
	 * ��ȡ����Ա����Ϣ
	 * 
	 * @return ����һ��{@code List<EmployeeVO>}���������ѯʧ�ܻ򲻴��ڣ��򷵻�{@code null}
	 */
	public List<EmployeeVO> getEmployeeVO();
	
	/**
     * ����{@code id}��ȡһ��{@code EmployeeVO}����
     * 
     * @param id {@code EmployeeVO}��{@code id}��ʶ
     * @return ����һ��{@code EmployeeVO}���������ѯʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     */
	public EmployeeVO find(String id);
	
	/**
     * ���� �������ƻ�ȡ�û�������˾����Ϣ
     * 
     * @param  organization String �ͣ����洫���Ļ�������
     * @return ����һ��{@code List<EmployeeVO>}���������ѯʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     */
	public List<EmployeeVO> getDriverVO(String organiztion);
	
	/**
     * ���ݻ������ƻ�ȡ����Id
     * 
     * @param id {@code OrganizationVO}��{@code id}��ʶ
     * @return ���ػ���id�������ѯʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     */
	public String getOrganizationId(String name);
	
	 
		
 
}
