package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.OrderPO;


/**
 * OrderDataService的职责是负责将Order业务逻辑层涉及的对保存的数据的修改、访问的操作交给
 * 后台的数据层处理
 * 
 * @author lc
 * @version 1.1
 *
 */
public interface OrderDataService extends DataIdentifiable,Remote{
	
	/**
	 * 创建一个OrderPO
	 * 
	 * @param po {@code OrderPO}
	 * @throws RemoteException
	 */
	public void insert(OrderPO po) throws RemoteException;
    
	/**
	 * 更新一个OrderPO
	 * 
	 * @param po {@code OrderPO}
	 * @throws RemoteException
	 */
    public void update(OrderPO po) throws RemoteException;
    
    /**
     * 根据订单的ID查找相应的OrderPO
     * 
     * @param id {@code String}
     * @return 成功则返回一个{@code OrderPO}，失败则返回null
     * @throws RemoteException
     */
    public OrderPO find(String id) throws RemoteException;
    
    /**
     * 根据要求查找符合条件的OrderPO
     * 
     * @param field {@code String}
     * @param value {@code Object}
     * @return 成功则返回一个{@code List<OrderPO>}，失败返回{@code null}
     * @throws RemoteException
     */
    public List<OrderPO> finds(String field, Object value) throws RemoteException;
    
    /**
     * 获取所有的OrderPO
     * @return 成功则返回{@code List<OrderPO>}，失败则返回{@code null}
     * @throws RemoteException
     */
    public List<OrderPO> getAll() throws RemoteException;
    
    /**
     * 初始化RMI
     * 
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * OrderDataService结束使用
     * 
     * @throws RemoteException
     */
    public void finish() throws RemoteException; 
}
