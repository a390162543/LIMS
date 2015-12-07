package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.DeliverPO;

/**
 * {@code DeliverDataService}是派件单的数据层服务，提供{@code DeliverPO}的{@code insert}，
 * {@code update}，{@code find}，{@code finds}等方法
 * @author 林祖华
 * @version 1.2
 */
public interface DeliverDataService extends DataIdentifiable,Remote{
    
    /**
     * 在数据层插入一个{@code DeliverPO}
     * @param po 需要插入的{@code DeliverPO}
     * @throws RemoteException
     */
    public void insert(DeliverPO po) throws RemoteException;
    
    /**
     * 在数据层更新一个{@code DeliverPO}
     * @param po 需要更新的{@code DeliverPO}
     * @throws RemoteException
     */
    public void update(DeliverPO po) throws RemoteException;
    
    /**
     * 用{@code id}标识在数据层查找一个{@code DeliverPO}
     * @param id 需要查找的{@code DeliverPO}对应的{@code id}标识
     * @return 返回查找到的{@code DeliverPO}，如果查找失败或不存在，则返回{@code null}
     * @throws RemoteException
     */
    public DeliverPO find(String id) throws RemoteException;
    
    /**
     * 用{@code field}和{@code value}在数据层查找{@code DeliverPO}的列表
     * @param field {@code DeliverPO}的变量名
     * @param value {@code DeliverPO}对应的变量值
     * @return 符合条件的{@code DeliverPO}的列表，如果查找失败或不存在，则返回一个空列表
     * @throws RemoteException
     */
    public List<DeliverPO> finds(String field, Object value) throws RemoteException;
    
    /**
     * 初始化{@code DeliverDataService}的数据层服务
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * 结束{@code DeliverDataService}的数据层服务
     * @throws RemoteException
     */
    public void finish() throws RemoteException;
    

}
