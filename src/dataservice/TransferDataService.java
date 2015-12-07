package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.TransferPO;

/**
* {@code TransferataService}��Ա�������ݲ����
* @author ������
* @version 1.2
*/
public interface TransferDataService extends DataIdentifiable, Remote{
	
	/**
	 * ������������һ��{@code TransferPO}����
	 * @param po
	 * @throws RemoteException
	 */
	 public void insert(TransferPO po) throws RemoteException;
	  
	/**
	 * ��������ɾ��һ��{@code TransferPO}����
	 * @param po
	 * @throws RemoteException
	 */
	 public void delete(TransferPO po) throws RemoteException;

	/**
	 * ����������һ��{@code TransferPO}����
	 * @param po
	 * @throws RemoteException
	 */
	 public void update(TransferPO po) throws RemoteException;

	 /**
	  * ����{@code OrganizationPO}Ψһ��ʶ{@code id}����һ��{@code OrganizationPO}����
	  * @param id�� ����id
	  * @return {@code OrganizationO}����
	  * @throws RemoteException
	  */
	 public TransferPO find(String id) throws RemoteException;

	 /**
	  * ����{@code TransferPO}����Ϣ{@code field}�Լ���Ϣ�ľ�������{@code value}��ȡ{@code OrganizationPO}�б�
	  * @param field
	  * @param value
	  * @return {@code OrganizationPO}�б�
	  * @throws RemoteException
	  */
	 public List<TransferPO> finds(String field, Object value) throws RemoteException;
	 
	 /**
	  * ��ȡ����{@code OrganizationPO}�б�
	  * @return {@code List<OrganizationPO>}
	  * @throws RemoteException
	  */	
	 public List<TransferPO> getAll() throws RemoteException;
	 
	 /**
	  * ��ʼ�����ݲ����
	  * @throws RemoteException
	  */
	 public void init() throws RemoteException ;
	 	   
	 public void finish() throws RemoteException; 

}
