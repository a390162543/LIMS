package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.UserPO;

/**
* {@code UserDataService}��Ա�������ݲ����
* @author ������
* @version 1.2
*/
public interface UserDataService extends Remote{
	/**
	 * ������������һ��{@code UserPO}����
	 * @param po
	 * @throws RemoteException
	 */
	 public void insert(UserPO po) throws RemoteException;
	  
	 /**
	  * ��������ɾ��һ��{@code UserPO}����
	  * @param po
	  * @throws RemoteException
	  */
	 public void delete(String id) throws RemoteException;
	  
	 /**
	  * ����������һ��{@code UserPO}����
	  * @param po
	  * @throws RemoteException
	  */
	 public void update(UserPO po) throws RemoteException;
	 
	 /**
	  * ����{@code UserPO}Ψһ��ʶ{@code id}����һ��{@code UserPO}����
	  * @param id�� Ա��id
	  * @return {@code UserPO}����
	  * @throws RemoteException
	  */
	 public UserPO find(String id) throws RemoteException;
	   
	 /**
	  * ��ȡ����{@code UserPO}�б�
	  * @return {@code List<UserPO>}
	  * @throws RemoteException
	  */
	 public List<UserPO> getAll() throws RemoteException;
	 
	 /**
	  * ��ʼ�����ݲ����
	  * @throws RemoteException
	  */
	 public void init() throws RemoteException;
	    
	 public void finish() throws RemoteException; 

}
