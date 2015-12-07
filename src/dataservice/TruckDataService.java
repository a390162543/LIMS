package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.TruckPO;

/**
 * {@code TruckDataService}是车辆信息的数据层服务，提供{@code TruckPO}的{@code insert}，
 * {@code update}，{@code find}，{@code finds}等方法
 * @author 林祖华
 * @version 1.2
 */
public interface TruckDataService extends DataIdentifiable,Remote{
    
    /**
     * 在数据层插入一个{@code TruckPO}
     * @param po 需要插入的{@code TruckPO}
     * @throws RemoteException
     */
    public void insert(TruckPO po) throws RemoteException;
    
    /**
     * 在数据层删除一个{@code TruckPO}
     * @param po 需要删除的{@code TruckPO}
     * @throws RemoteException
     */
    public void delete(TruckPO po) throws RemoteException;
    
    /**
     * 在数据层更新一个{@code TruckPO}
     * @param po 需要更新的{@code TruckPO}
     * @throws RemoteException
     */
    public void update(TruckPO po) throws RemoteException;
    
    /**
     * 用{@code id}标识在数据层查找一个{@code TruckPO}
     * @param id 需要查找的{@code TruckPO}对应的{@code id}标识
     * @return 返回查找到的{@code TruckPO}，如果查找失败或不存在，则返回{@code null}
     * @throws RemoteException
     */
    public TruckPO find(String id) throws RemoteException;

    /**
     * 用{@code field}和{@code value}在数据层查找{@code TruckPO}的列表
     * @param field {@code TruckPO}的变量名
     * @param value {@code TruckPO}对应的变量值
     * @return 符合条件的{@code TruckPO}的列表，如果查找失败或不存在，则返回一个空列表
     * @throws RemoteException
     */
    public List<TruckPO> finds(String field, Object value) throws RemoteException;

    /**
     * 获取数据层所有{@code TruckPO}的的列表
     * @return {@code TruckPO}的列表，如果查找失败或不存在，则返回一个空列表
     * @throws RemoteException
     */
    public List<TruckPO> getAll() throws RemoteException;
    
    /**
     * 初始化{@code TruckDataService}的数据层服务
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * 结束{@code TruckDataService}的数据层服务
     * @throws RemoteException
     */
    public void finish() throws RemoteException; 
    
}
