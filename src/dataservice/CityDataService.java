package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CityPO;
 
/**
 * {@code CityDataService}是城市的数据层服务
 * @author 刘航伸
 * @version 1.2
 */
public interface CityDataService extends Remote{
	/**
	 * 在数据区插入一个{@code CityPO}对象
	 * @param po
	 * @throws RemoteException
	 */
	 public void insert(CityPO po) throws RemoteException;
	 
	 /**
	  * 在数据区删除一个{@code CityPO}对象
	  * @param po
	  * @throws RemoteException
	  */
	 public void delete(CityPO po) throws RemoteException;
	 
	 /**
	  *  更新数据区一个{@code CityPO}对象
	  * @param po
	  * @throws RemoteException
	  */
	 public void update(CityPO po) throws RemoteException;	 
	 
	 /**
	  * 根据{@code CityPO}唯一标识{@code id}查找一个{@code CityPO}对象
	  * @param id， 城市id
	  * @return {@code CityPO}对象
	  * @throws RemoteException
	  */
	 public CityPO find(String id) throws RemoteException;
	 
	 /**
	  * 获取所有{@code CityPO}列表
	  * @return {@code List<CityPO>}
	  * @throws RemoteException
	  */
	 public List<CityPO> getAll()throws RemoteException;
	 
	 /**
	  *    
	  * @throws RemoteException
	  */
	 public void finish() throws RemoteException; 
	 
	 /**
	  * 初始化数据层服务
	  * @throws RemoteException
	  */
	 public void init() throws RemoteException;
	 
	 /**
	  * 通过{@code CityPO}唯一标识{@code name}查找{@code CityPO}对象
	  * @param name，城市名称
	  * @return 如果城市存在，返回{@code CityPO}对象,否则返回null
	  * @throws RemoteException
	  */
	 public CityPO findByName(String name) throws RemoteException;
	 
	 /**
	  * 通过{@code CityPO}唯一标识{@code name}获得其{@code id}
	  * @param name，城市名称
	  * @return 如果城市存在，返回{@code id},否则返回null
	  * @throws RemoteException
	  */
	 public String getId(String name) throws RemoteException;
}
