package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;

/**
 * {@code ArrivalDataService}是到达单的数据层服务，提供{@code ArrivalPO}的{@code insert}，
 * {@code update}，{@code find}，{@code finds}等方法
 * @author 林祖华
 * @version 1.2
 */
public interface ArrivalDataService extends DataIdentifiable,Remote{
    
    /**
     * 在数据层插入一个{@code ArrivalPO}
     * @param po 需要插入的{@code ArrivalPO}
     * @throws RemoteException
     */
    public void insert(ArrivalPO po) throws RemoteException;
    
    /**
     * 在数据层更新一个{@code ArrivalPO}
     * @param po 需要更新的{@code ArrivalPO}
     * @throws RemoteException
     */
    public void update(ArrivalPO po) throws RemoteException;
    
    /**
     * 用{@code id}标识在数据层查找一个{@code ArrivalPO}
     * @param id 需要查找的{@code ArrivalPO}对应的{@code id}标识
     * @return 返回查找到的{@code ArrivalPO}，如果查找失败或不存在，则返回{@code null}
     * @throws RemoteException
     */
    public ArrivalPO find(String id) throws RemoteException;
    
    /**
     * 用{@code field}和{@code value}在数据层查找{@code ArrivalPO}的列表
     * @param field {@code ArrivalPO}的变量名
     * @param value {@code ArrivalPO}对应的变量值
     * @return 符合条件的{@code ArrivalPO}的列表，如果查找失败或不存在，则返回一个空列表
     * @throws RemoteException
     */
    public List<ArrivalPO> finds(String field, Object value) throws RemoteException;
    

    /**
     * 初始化{@code ArrivalDataService}的数据层服务
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * 结束{@code ArrivalDataService}的数据层服务
     * @throws RemoteException
     */
    public void finish() throws RemoteException; 
    
}
