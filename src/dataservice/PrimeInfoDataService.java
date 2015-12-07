package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.PrimeInfoPO;
/**
 * {@code PrimeInfoDataService}是期初建账的数据层服务，提供期初账单的{@code insert}
 * {@code getAll}等方法
 * @author 刘德宽
 * @version 1.2
 */
public interface PrimeInfoDataService extends Remote{
	/**
	 * 在数据层插入一个{@code PrimeInfoPO}
	 * @param po {@code PrimeInfoPO}
	 * @throws RemoteException
	 */
	public void insert(PrimeInfoPO po) throws RemoteException;
	
	/**
	 * 获取所有的{@code PrimeInfoPO}
	 * @return {@code PrimeInfoPO}的列表，如果没有账户信息或获取失败，则返回空列表
	 * @throws RemoteException
	 */
	public List<PrimeInfoPO> getAll() throws RemoteException;
	
	/**
	 * 期初账单数据层的初始化
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
    
	/**
	 * 期初账单数据层的结束
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
