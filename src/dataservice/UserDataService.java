package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.UserPO;

/**
* {@code UserDataService}是员工的数据层服务
* @author 刘航伸
* @version 1.2
*/
public interface UserDataService extends Remote{
	/**
	 * 在数据区插入一个{@code UserPO}对象
	 * @param po
	 * @throws RemoteException
	 */
	 public void insert(UserPO po) throws RemoteException;
	  
	 /**
	  * 在数据区删除一个{@code UserPO}对象
	  * @param po
	  * @throws RemoteException
	  */
	 public void delete(String id) throws RemoteException;
	  
	 /**
	  * 更新数据区一个{@code UserPO}对象
	  * @param po
	  * @throws RemoteException
	  */
	 public void update(UserPO po) throws RemoteException;
	 
	 /**
	  * 根据{@code UserPO}唯一标识{@code id}查找一个{@code UserPO}对象
	  * @param id， 员工id
	  * @return {@code UserPO}对象
	  * @throws RemoteException
	  */
	 public UserPO find(String id) throws RemoteException;
	   
	 /**
	  * 获取所有{@code UserPO}列表
	  * @return {@code List<UserPO>}
	  * @throws RemoteException
	  */
	 public List<UserPO> getAll() throws RemoteException;
	 
	 /**
	  * 初始化数据层服务
	  * @throws RemoteException
	  */
	 public void init() throws RemoteException;
	    
	 public void finish() throws RemoteException; 

}
