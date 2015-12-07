package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.OrganizationPO;

/**
* {@code OrganizationDataService}是员工的数据层服务
* @author 刘航伸
* @version 1.2
*/
public interface OrganizationDataService extends DataIdentifiable,Remote{
	/**
	 * 在数据区插入一个{@code OrganizationPO}对象
	 * @param po
	 * @throws RemoteException
	 */	
	 public void insert(OrganizationPO po) throws RemoteException;

	 /**
	  * 在数据区删除一个{@code EmployeePO}对象
	  * @param po
	  * @throws RemoteException
	  */	 
	 public void delete(OrganizationPO po) throws RemoteException;

	 /**
	  * 更新数据区一个{@code OrganizationPO}对象
	  * @param po
	  * @throws RemoteException
	  */	 
	 public void update(OrganizationPO po) throws RemoteException;
	 
	 /**
	  * 根据{@code OrganizationPO}唯一标识{@code id}查找一个{@code OrganizationPO}对象
	  * @param id， 机构id
	  * @return {@code OrganizationPO}对象
	  * @throws RemoteException
	  */		    
	 public OrganizationPO find(String id) throws RemoteException;
	  
	 /**
	  * 根据{@code OrganizationPO}的信息{@code field}以及信息的具体内容{@code value}获取{@code OrganizationPO}列表
	  * @param field
	  * @param value
	  * @return {@code OrganizationPO}列表
	  * @throws RemoteException
	  */	 
	 public List<OrganizationPO> finds(String field, Object value) throws RemoteException;
	
	 /**
	  * 获取所有{@code OrganizationPO}列表
	  * @return {@code List<OrganizationPO>}
	  * @throws RemoteException
	  */		 
	 public List<OrganizationPO> getAll() throws RemoteException;
	  
	 public void finish() throws RemoteException; 

	 /**
	  * 初始化数据层服务
	  * @throws RemoteException
	  */
	 public void init() throws RemoteException ;
	 
	 /**
	  * 根据{@code OrganizationPO}唯一标识{@code  name}查找一个{@code OrganizationPO}对象的 id
	  * @param name， 机构名称
	  * @return {@code id}
	  * @throws RemoteException
	  */	    
	 public String getId(String name) throws RemoteException;

}
