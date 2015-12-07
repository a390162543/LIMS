package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.EmployeePO;

/**
* {@code EmployeeDataService}是员工的数据层服务
* @author 刘航伸
* @version 1.2
*/
public interface EmployeeDataService extends DataIdentifiable,Remote{
	/**
	 * 在数据区插入一个{@code EmployeePO}对象
	 * @param po
	 * @throws RemoteException
	 */
	 public void insert(EmployeePO po) throws RemoteException;
	 
	 /**
	  * 在数据区删除一个{@code EmployeePO}对象
	  * @param po
	  * @throws RemoteException
	  */
	 public void delete(EmployeePO po) throws RemoteException;
	  
	 /**
	  * 更新数据区一个{@code EmployeeO}对象
	  * @param po
	  * @throws RemoteException
	  */
	 public void update(EmployeePO po) throws RemoteException;
	 
	 /**
	  * 根据{@code EmployeePO}唯一标识{@code id}查找一个{@code EmployeePO}对象
	  * @param id， 员工id
	  * @return {@code EmployeePO}对象
	  * @throws RemoteException
	  */	    
	 public EmployeePO find(String id) throws RemoteException;
	 
	 /**
	  * 根据{@code EmployeePO}的信息{@code field}以及信息的具体内容{@code value}获取{@code EmployeePO}列表
	  * @param field
	  * @param value
	  * @return {@code EmployeePO}列表
	  * @throws RemoteException
	  */
	 public List<EmployeePO> finds(String field, Object value) throws RemoteException;
	 
	 /**
	  * 获取所有{@code EmployeePO}列表
	  * @return {@code List<EmployeePO>}
	  * @throws RemoteException
	  */	    
	 public List<EmployeePO> getAll() throws RemoteException;
	    
	 public void finish() throws RemoteException; 
	 
	 /**
	  * 初始化数据层服务
	  * @throws RemoteException
	  */
	 public void init() throws RemoteException;
	
	 
}
