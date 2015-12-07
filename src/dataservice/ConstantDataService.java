package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import po.ConstantPO;

/**
 * {@code ConstantDataService}是价格的数据层服务
 * @author 刘航伸
 * @version 1.2
 */
public interface ConstantDataService extends Remote{
	/**
	 * 在数据区插入一个{@code ConstantO}对象
	 * @param po
	 * @throws RemoteException
	 */
	 public void insert(ConstantPO po) throws RemoteException;
	 
	 /**
	  * 在数据区删除一个{@code ConstantPO}对象
	  * @param po
	  * @throws RemoteException
	  */
	 public void delete(ConstantPO po) throws RemoteException;
	   
	 /**
	  *  更新数据区一个{@code ConstantPO}对象
	  * @param po
	  * @throws RemoteException
	  */
	 public void update(ConstantPO po) throws RemoteException;	 
	   
	 /**
	  * 获取{@code ConstantPO}对象
	  * @return {@code ConstantPO}对象
	  * @throws RemoteException
	  */
	 public ConstantPO getConstantPO() throws RemoteException;
	        
	 public void finish() throws RemoteException; 
	 
	 /**
	  * 初始化数据层服务
	  * @throws RemoteException
	  */
	 public void init() throws RemoteException;

}
