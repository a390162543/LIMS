package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import po.LogPO;
/**
 * {@code LogDataService}是主要操作记录的数据层服务，提供主要操作记录的{@code insert}，
 * {@code finds}等方法
 * @author 刘德宽
 * @version 1.2
 */
public interface LogDataService  extends Remote{
	/**
	 * 在数据层插入一个{@code LogPO}
	 * @param po {@code LogPO}
	 * @throws RemoteException
	 */
	public void insert(LogPO po) throws RemoteException;
	
	/**
	 * 根据变量名和变量值获取响应的{@code LogPO}
     * @param field {@code LogPO}对应的变量名
     * @param value {@code LogPO}对应的变量值
	 * @return {@code LogPO}的列表，如果没有账户信息或获取失败，则返回空列表
	 * @throws RemoteException
	 */
	public List<LogPO> finds(String field, Object value) throws RemoteException;
	
	/**
	 * 日志记录数据层的初始化
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
    
	/**
	 * 日志记录数据层的结束
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
