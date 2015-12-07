package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import po.PaymentPO;
/**
 * {@code PaymentDataService}是付款单的数据层服务，提供付款单的{@code insert}，{@code update}，
 * {@code find},{@code finds}等方法
 * @author 刘德宽
 * @version 1.2
 */
public interface PaymentDataService extends DataIdentifiable, Remote{
	/**
	 * 在数据层插入一个{@code PaymentPO}
	 * @param po {@code PaymentPO}
	 * @throws RemoteException
	 */
	public void insert(PaymentPO po) throws RemoteException;
	
	/**
	 * 在数据层更新一个{@code PaymentPO}
	 * @param po {@code PaymentPO}
	 * @throws RemoteException
	 */
	public void update(PaymentPO po) throws RemoteException;
	
	/**
	 * 根据id获取相应的{@code PaymentPO}
	 * @param id {@code String} 
	 * @return {@code PaymentPO}
	 * @throws RemoteException
	 */
	public PaymentPO find(String id) throws RemoteException;
	
	/**
	 * 根据变量名和变量值获取响应的{@code PaymentPO}
     * @param field {@code PaymentPO}对应的变量名
     * @param value {@code PaymentPO}对应的变量值
	 * @return {@code PaymentPO}的列表，如果没有账户信息或获取失败，则返回空列表
	 * @throws RemoteException
	 */
	public List<PaymentPO> finds(String field, Object value) throws RemoteException;
	
	/**
	 * 付款单数据层的初始化
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
    
	/**
	 * 付款单户数据层的结束
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
