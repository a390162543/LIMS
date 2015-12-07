package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.AccountPO;

/**
 * {@code AccountDataService}是账户的数据层服务，提供账户的{@code insert}，{@code update},
 * {@code delete}，{@code find}，{@code getAll}等方法
 * @author 刘德宽
 * @version 1.2
 */
public interface AccountDataService extends Remote{

	/**
	 * 在数据层插入一个{@code AccountPO}
	 * @param po {@code AccountPO}
	 * @throws RemoteException
	 */
	public void insert(AccountPO po) throws RemoteException;

	/**
	 * 在数据层删除一个{@code AccountPO}
	 * @param po {@code AccountPO}
	 * @throws RemoteException
	 */
	public void delete(AccountPO po) throws RemoteException;
	
	/**
	 * 在数据层更新一个{@code AccountPO}
	 * @param po {@code AccountPO}
	 * @throws RemoteException
	 */
	public void update(AccountPO po) throws RemoteException;
	
	/**
	 * 根据id获取相应的{@code AccountPO}
	 * @param id {@code String} 
	 * @return {@code AccountPO}
	 * @throws RemoteException
	 */
	public AccountPO find(String id) throws RemoteException;
	
	/**
	 * 获取所有的{@code AccountPO}
	 * @return {@code AccountPO}的列表，如果没有账户信息或获取失败，则返回空列表
	 * @throws RemoteException
	 */
	public List<AccountPO> getAll() throws RemoteException;
	
	/**
	 * 账户数据层的初始化
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
    
	/**
	 * 账户数据层的结束
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
	
}
