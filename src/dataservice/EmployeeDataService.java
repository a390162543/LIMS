package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.EmployeePO;

/**
* {@code EmployeeDataService}��Ա�������ݲ����
* @author ������
* @version 1.2
*/
public interface EmployeeDataService extends DataIdentifiable,Remote{
	/**
	 * ������������һ��{@code EmployeePO}����
	 * @param po
	 * @throws RemoteException
	 */
	 public void insert(EmployeePO po) throws RemoteException;
	 
	 /**
	  * ��������ɾ��һ��{@code EmployeePO}����
	  * @param po
	  * @throws RemoteException
	  */
	 public void delete(EmployeePO po) throws RemoteException;
	  
	 /**
	  * ����������һ��{@code EmployeeO}����
	  * @param po
	  * @throws RemoteException
	  */
	 public void update(EmployeePO po) throws RemoteException;
	 
	 /**
	  * ����{@code EmployeePO}Ψһ��ʶ{@code id}����һ��{@code EmployeePO}����
	  * @param id�� Ա��id
	  * @return {@code EmployeePO}����
	  * @throws RemoteException
	  */	    
	 public EmployeePO find(String id) throws RemoteException;
	 
	 /**
	  * ����{@code EmployeePO}����Ϣ{@code field}�Լ���Ϣ�ľ�������{@code value}��ȡ{@code EmployeePO}�б�
	  * @param field
	  * @param value
	  * @return {@code EmployeePO}�б�
	  * @throws RemoteException
	  */
	 public List<EmployeePO> finds(String field, Object value) throws RemoteException;
	 
	 /**
	  * ��ȡ����{@code EmployeePO}�б�
	  * @return {@code List<EmployeePO>}
	  * @throws RemoteException
	  */	    
	 public List<EmployeePO> getAll() throws RemoteException;
	    
	 public void finish() throws RemoteException; 
	 
	 /**
	  * ��ʼ�����ݲ����
	  * @throws RemoteException
	  */
	 public void init() throws RemoteException;
	
	 
}
