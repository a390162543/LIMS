package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.StoragePO;



/**
 * StorageDataService的职责是负责将Storage业务逻辑层涉及的对保存的数据的修改、访问的操作交给
 * 后台的数据层处理
 * 
 * @author lc
 * @version 1.1
 *
 */
public interface StorageDataService extends Remote {
	
    
	/**
	 * 更新一个StoragePO
	 * 
	 * @param po {@code StoragePO}
	 * @throws RemoteException
	 */
    public void update(StoragePO po) throws RemoteException;
    
    /**
     * 根据ID查找相应的StoragePO
     * 
     * @param id {@code String}
     * @return 成功则返回一个{@code StoragePO}，失败则返回{@code null}
     * @throws RemoteException
     */
    public StoragePO find(String id) throws RemoteException;
    
    /**
     * 初始化RMI
     * 
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * 结束对你StorageDataService的使用
     * 
     * @throws RemoteException
     */
    public void finish() throws RemoteException; 
    
    

}
