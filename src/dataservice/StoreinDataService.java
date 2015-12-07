package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import po.StoreinPO;



/**
 * StoreinDataService的职责是将逻辑层关于入库单的操作传给数据层进行相应的处理
 * 
 * @author lc
 * @version 1.3
 *
 */
public interface StoreinDataService extends DataIdentifiable,Remote{
	
	/**
	 * 将一个新创建的StoreinPO写入数据层
	 * 
	 * @param po {@code StoreinPO}
	 * @return 成功则返回{@code true}，失败则返回{@code false}
	 * @throws RemoteException
	 */
	public boolean insert(StoreinPO po) throws RemoteException;
    
	/**
	 * 更新业务逻辑层操作的StoreinPO
	 * 
	 * @param po {@code StoreinPO}
	 * @return 成功则返回{@code true}，失败则返回{@code false}
	 * @throws RemoteException
	 * 
	 */
    public boolean  update(StoreinPO po) throws RemoteException;
    
    /**
     * 根据ID查找相应的入库单
     * 
     * @param id {@code String}
     * @return 成功则返回一个{@code StoreinPO},失败返回{@code null}
     * @throws RemoteException
     */
    public StoreinPO find(String id) throws RemoteException;
    
    /**
     * 根据条件查找入库单
     * 
     * @param field {@code String}
     * @param value {@code Object}
     * @return 成功则返回一个{@code List<StoreinPO>},失败返回{@code null}
     * @throws RemoteException
     */
    public List<StoreinPO> finds(String field, Object value) throws RemoteException;
    
    /**
     * 获取所有的入库单
     * 
     * @return 成功则返回一个{@code List<StoreinPO>},失败返回{@code null}
     * @throws RemoteException
     */
    public List<StoreinPO> getAll() throws RemoteException;
    
    /**
     * 初始化RMI
     * 
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * 结束StoreinDataService的使用
     * 
     * @throws RemoteException
     */
    public void finish() throws RemoteException; 
    
  
}
