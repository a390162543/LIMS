package businesslogicservice;

import java.util.List;

import vo.OrganizationVO;

/**
 * {@code OrganizationbiSerevice}�ṩ���������������ҵ���߼�����
 * @author ������
 * @version 1.4
 */
public interface OrganizationblService extends OrganizationIdentifiable{
	 /**
     * ��������¼������Ϣ
     * 
     * @param vo ����㴫������{@code OrganizationVO}
     * @return  �ɹ���������{@code true}�����򷵻�{@code false}
     */
	public boolean createOrganizationPO(OrganizationVO vo); 
	
	/**
     * ɾ��������Ϣ
     * 
     * @param vo ����㴫������{@code OrganizationVO}
     * @return  �ɹ�ɾ������{@code true}�����򷵻�{@code false}
     */
	public boolean deleteOrganizationPO (OrganizationVO vo);
	
	 /**
     * �޸Ļ�����Ϣ
     * 
     * @param vo ����㴫������{@code OrganizationVO}
     * @return  �ɹ��޸ķ���{@code true}�����򷵻�{@code false}
     */
	public boolean modifyOrganizationPO(OrganizationVO vo);
	
	/**
	 * ��ȡ���л�����Ϣ
	 * 
	 * @return����һ��{@code List<OrganizationVO>}���������ѯʧ�ܻ򲻴��ڣ��򷵻�{@code null}
	 */
	public List<OrganizationVO>  getOrganizationVO();
	
	/**
	 * ��ȡ���л�������
	 * 
	 * @return ����һ��{@code List<String>}���������ѯʧ�ܻ򲻴��ڣ��򷵻�{@code null}
	 */
	public List<String> getAllOrganizationName();
	
	/**
     * ����{@code name}��ȡһ��{@code id}����
     * 
     * @param name {@code OrganizationVO}��{@code name}��ʶ
     * @return ����һ��{@code id}���������ѯʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     */
	public String getId(String name);
	
	/**
     * ����{@code name}��ȡһ��{@code id}����
     * 
     * @param name {@code CityVO}��{@code name}��ʶ
     * @return ����һ��{@code id}���������ѯʧ�ܻ򲻴��ڣ��򷵻�{@code null}
     */
	public String getCityId(String name);
	
	/**
	 * ��ȡ���г�������
	 * 
	 * @return ����һ��{@code List<String>}���������ѯʧ�ܻ򲻴��ڣ��򷵻�{@code null}
	 */
	public List<String> getAllCityName();
}
