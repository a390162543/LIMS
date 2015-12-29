package businesslogicservice;


/**
 * {@code  PrimeInfoblService}�ṩ��������ڳ����˴����ҵ���߼�����
 * @author ���¿�
 * @version 1.4
 */
import java.util.List;

import vo.AccountVO;
import vo.CityVO;
import vo.EmployeeVO;
import vo.OrderCreateVO;
import vo.OrganizationVO;
import vo.PrimeInfoVO;
import vo.StoreinCreateVO;
import vo.TruckVO;

public interface PrimeInfoblService {
    /**
     * ��������¼�ڳ�������Ϣ
     * @return �ɹ������򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean createPrimeInfoPO ();
	
    /**
     * ��ȡ���е��˵���Ϣ
     * @return {@code PrimeInfoVO}���б����û���˻���Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
     */
	public List<PrimeInfoVO> QueryPrimeInfoVO();
	
    /**
     * ִ���ڳ�������Ϣ
     * @return  �ɹ�ִ�з���{@code true}�����򷵻�{@code false}
     */
	public boolean execute();
	
	 /**
     * ����˻���Ϣ
     * @param vo ����㴫����{@code AccountVO}
     * @return �ɹ�����򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean addAccountVO( AccountVO vo);
	
    /**
     * ɾ���˻���Ϣ
     * @param vo ����㴫����{@code AccountVO}
     * @return �ɹ�ɾ���򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean removeAccountVO( AccountVO vo);
	
    /**
     * �޸��˻���Ϣ
     * @param vo ����㴫����{@code AccountVO}
     * @return �ɹ��޸��򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean modifyAccountVO( AccountVO vo);
	
	 /**
     * ��ӳ�����Ϣ
     * @param vo ����㴫����{@code TruckVO}
     * @return �ɹ�����򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean addTruckVO( TruckVO vo);
	
    /**
     * ɾ��������Ϣ
     * @param vo ����㴫����{@code TruckVO}
     * @return �ɹ�ɾ���򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean removeTruckVO( TruckVO vo);
	
    /**
     * �޸ĳ�����Ϣ
     * @param vo ����㴫����{@code TruckVO}
     * @return �ɹ��޸��򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean modifyTruckVO( TruckVO vo);
	
	 /**
     * ��ӻ�����Ϣ
     * @param vo ����㴫����{@code OrganizationVO}
     * @return �ɹ�����򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean addOrganizationVO( OrganizationVO vo);
	
    /**
     * ɾ��������Ϣ
     * @param vo ����㴫����{@code OrganizationVO}
     * @return �ɹ�ɾ���򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean removeOrganizationVO( OrganizationVO vo);
	
    /**
     * �޸Ļ�����Ϣ
     * @param vo ����㴫����{@code OrganizationVO}
     * @return �ɹ��޸��򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean modifyOrganizationVO( OrganizationVO vo);
	
	 /**
     * ���Ա����Ϣ
     * @param vo ����㴫����{@code EmployeeVO}
     * @return �ɹ�����򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean addEmployeeVO( EmployeeVO vo);
	
    /**
     * ɾ��Ա����Ϣ
     * @param vo ����㴫����{@code EmployeeVO}
     * @return �ɹ�ɾ���򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean removeEmployeeVO( EmployeeVO vo);
	
    /**
     * �޸�Ա����Ϣ
     * @param vo ����㴫����{@code EmployeeVO}
     * @return �ɹ��޸��򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean modifyEmployeeVO( EmployeeVO vo);
	
	 /**
     * ��ӳ�����Ϣ
     * @param vo ����㴫����{@code CityVO}
     * @return �ɹ�����򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean addCityVO( CityVO vo);
	
    /**
     * ɾ��������Ϣ
     * @param vo ����㴫����{@code CityVO}
     * @return �ɹ�ɾ���򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean removeCityVO( CityVO vo);
	
    /**
     * �޸ĳ�����Ϣ
     * @param vo ����㴫����{@code CityVO}
     * @return �ɹ��޸��򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean modifyCityVO( CityVO vo);
	
	 /**
     * ��ӿ����Ϣ
     * @param vo ����㴫����{@code StoreinCreateVO}
     * @return �ɹ�����򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean addStoreinCheckResultVO( StoreinCreateVO vo);
	
    /**
     * ɾ�������Ϣ
     * @param vo ����㴫����{@code StoreinCreateVO}
     * @return �ɹ�ɾ���򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean removeStoreinCheckResultVO( StoreinCreateVO vo);
	
    /**
     * �޸Ŀ����Ϣ
     * @param vo ����㴫����{@code StoreinCreateVO}
     * @return �ɹ��޸��򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean modifyStoreinVO( StoreinCreateVO vo);
	
	 /**
     * ��Ӷ�����Ϣ
     * @param vo ����㴫����{@code OrderCreateVO}
     * @return �ɹ�����򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean addOrderCheckResultVO( OrderCreateVO vo);
	
    /**
     * ɾ��������Ϣ
     * @param vo ����㴫����{@code OrderCreateVO}
     * @return �ɹ�ɾ���򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean removeOrderCheckResultVO( OrderCreateVO vo);
	
    /**
     * �޸Ķ�����Ϣ
     * @param vo ����㴫����{@code OrderCreateVO}
     * @return �ɹ��޸��򷵻�{@code true}�����򷵻�{@code false}
     */
	public boolean modifyOrderVO( OrderCreateVO vo);

    /**
     * ��ȡ���л�������Ϣ
     * @return {@code String}�б����û�л�������Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
     */
	public List<String> getOrganizationName();

    /**
     * ͨ����������ȡ���������Ϣ
     * @param name ����㴫����{@code String}
     * @return {@code String}�����û�л��������Ϣ���ȡʧ�ܣ��򷵻ؿ��ַ���
     */
	public String getOrganizationId(String name);
    
	/**
     * ��ȡ���г���������Ϣ
     * @return {@code String}�б����û�г���������Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
     */
	public List<String> getCityName() ;
	
	/**
     * ͨ�����ƻ�ȡ���б����Ϣ
     * @return {@code String}�б����û�г��б����Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
     */
	public String getCityId(String name) ;
	
	/**
     * ��ȡ���ж��������Ϣ
     * @return {@code String}�б����û�ж��������Ϣ���ȡʧ�ܣ��򷵻ؿ��б�
     */
	public List<String> getOrderList();
}
