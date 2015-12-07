package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.OrganizationPO;

/**
* {@code OrganizationDataService}��Ա�������ݲ����
* @author ������
* @version 1.2
*/
public interface OrganizationDataService extends DataIdentifiable,Remote{
	/**
	 * ������������һ��{@code OrganizationPO}����
	 * @param po
	 * @throws RemoteException
	 */	
	 public void insert(OrganizationPO po) throws RemoteException;

	 /**
	  * ��������ɾ��һ��{@code EmployeePO}����
	  * @param po
	  * @throws RemoteException
	  */	 
	 public void delete(OrganizationPO po) throws RemoteException;

	 /**
	  * ����������һ��{@code OrganizationPO}����
	  * @param po
	  * @throws RemoteException
	  */	 
	 public void update(OrganizationPO po) throws RemoteException;
	 
	 /**
	  * ����{@code OrganizationPO}Ψһ��ʶ{@code id}����һ��{@code OrganizationPO}����
	  * @param id�� ����id
	  * @return {@code OrganizationPO}����
	  * @throws RemoteException
	  */		    
	 public OrganizationPO find(String id) throws RemoteException;
	  
	 /**
	  * ����{@code OrganizationPO}����Ϣ{@code field}�Լ���Ϣ�ľ�������{@code value}��ȡ{@code OrganizationPO}�б�
	  * @param field
	  * @param value
	  * @return {@code OrganizationPO}�б�
	  * @throws RemoteException
	  */	 
	 public List<OrganizationPO> finds(String field, Object value) throws RemoteException;
	
	 /**
	  * ��ȡ����{@code OrganizationPO}�б�
	  * @return {@code List<OrganizationPO>}
	  * @throws RemoteException
	  */		 
	 public List<OrganizationPO> getAll() throws RemoteException;
	  
	 public void finish() throws RemoteException; 

	 /**
	  * ��ʼ�����ݲ����
	  * @throws RemoteException
	  */
	 public void init() throws RemoteException ;
	 
	 /**
	  * ����{@code OrganizationPO}Ψһ��ʶ{@code  name}����һ��{@code OrganizationPO}����� id
	  * @param name�� ��������
	  * @return {@code id}
	  * @throws RemoteException
	  */	    
	 public String getId(String name) throws RemoteException;

}
