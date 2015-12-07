package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.TransferPO;

/**
* {@code TransferataService}是员工的数据层服务
* @author 刘航伸
* @version 1.2
*/
public interface TransferDataService extends DataIdentifiable, Remote{
	
	/**
	 * 在数据区插入一个{@code TransferPO}对象
	 * @param po
	 * @throws RemoteException
	 */
	 public void insert(TransferPO po) throws RemoteException;
	  
	/**
	 * 在数据区删除一个{@code TransferPO}对象
	 * @param po
	 * @throws RemoteException
	 */
	 public void delete(TransferPO po) throws RemoteException;

	/**
	 * 更新数据区一个{@code TransferPO}对象
	 * @param po
	 * @throws RemoteException
	 */
	 public void update(TransferPO po) throws RemoteException;

	 /**
	  * 根据{@code OrganizationPO}唯一标识{@code id}查找一个{@code OrganizationPO}对象
	  * @param id， 机构id
	  * @return {@code OrganizationO}对象
	  * @throws RemoteException
	  */
	 public TransferPO find(String id) throws RemoteException;

	 /**
	  * 根据{@code TransferPO}的信息{@code field}以及信息的具体内容{@code value}获取{@code OrganizationPO}列表
	  * @param field
	  * @param value
	  * @return {@code OrganizationPO}列表
	  * @throws RemoteException
	  */
	 public List<TransferPO> finds(String field, Object value) throws RemoteException;
	 
	 /**
	  * 获取所有{@code OrganizationPO}列表
	  * @return {@code List<OrganizationPO>}
	  * @throws RemoteException
	  */	
	 public List<TransferPO> getAll() throws RemoteException;
	 
	 /**
	  * 初始化数据层服务
	  * @throws RemoteException
	  */
	 public void init() throws RemoteException ;
	 	   
	 public void finish() throws RemoteException; 

}
