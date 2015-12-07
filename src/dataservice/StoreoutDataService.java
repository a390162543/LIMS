package dataservice;

/**
 * StoreoutDataService的职责是将逻辑层关于出库单的操作传给数据层进行相应的处理
 * 
 * @author lc
 * @version 1.3
 *
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import po.StoreoutPO;

public interface StoreoutDataService extends DataIdentifiable,Remote {
	
	/**
	 * 将一个新创建的StoreoutPO写入数据层
	 * 
	 * @param po {@code StoreoutPO}
	 * @return 成功则返回{@code true}，失败则返回{@code false}
	 * @throws RemoteException
	 */
	public boolean insert(StoreoutPO po) throws RemoteException;
      
	/**
	 * 更新业务逻辑层操作的StoreoutPO
	 * 
	 * @param po {@code StoreoutPO}
	 * @return 成功则返回{@code true}，失败则返回{@code false}
	 * @throws RemoteException
	 */
    public boolean update(StoreoutPO po) throws RemoteException;
    
    /**
     * 根据ID查找相应的出库单
     * 
     * @param id {@code String}
     * @return 成功则返回一个{@code StoreoutPO},失败返回{@code null}
     * @throws RemoteException
     */
    public StoreoutPO find(String id) throws RemoteException;
    
    /**
     * 根据条件查找出库单
     * 
     * @param field {@code String}
     * @param value {@code Object}
     * @return 成功则返回一个{@code List<StoreoutPO>},失败返回{@code null}
     * @throws RemoteException
     */
    public List<StoreoutPO> finds(String field, Object value) throws RemoteException;
    
    /**
     * 获取所有的出库单
     * 
     * @return 成功则返回一个{@code List<StoreoutPO>},失败返回{@code null}
     * @throws RemoteException
     */
    public List<StoreoutPO> getAll() throws RemoteException;
    
    /**
     * 初始化RMI
     * 
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * 结束StoreoutDataService的使用
     * 
     * @throws RemoteException
     */
    public void finish() throws RemoteException; 
}
