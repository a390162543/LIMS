package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.LoadPO;

/**
 * {@code LoadDataService}是装车单的数据层服务，提供{@code LoadPO}的{@code insert}，
 * {@code update}，{@code find}，{@code finds}等方法
 * @author 林祖华
 * @version 1.2
 */
public interface LoadDataService extends DataIdentifiable,Remote{
    
    /**
     * 在数据层插入一个{@code LoadPO}
     * @param po 需要插入的{@code LoadPO}
     * @throws RemoteException
     */
    public void insert(LoadPO po) throws RemoteException;
    
    /**
     * 在数据层更新一个{@code LoadPO}
     * @param po 需要更新的{@code LoadPO}
     * @throws RemoteException
     */
    public void update(LoadPO po) throws RemoteException;
    
    /**
     * 用{@code id}标识在数据层查找一个{@code LoadPO}
     * @param id 需要查找的{@code LoadPO}对应的{@code id}标识
     * @return 返回查找到的{@code LoadPO}，如果查找失败或不存在，则返回{@code null}
     * @throws RemoteException
     */
    public LoadPO find(String id) throws RemoteException;
    
    /**
     * 用{@code field}和{@code value}在数据层查找{@code LoadPO}的列表
     * @param field {@code LoadPO}的变量名
     * @param value {@code LoadPO}对应的变量值
     * @return 符合条件的{@code LoadPO}的列表，如果查找失败或不存在，则返回一个空列表
     * @throws RemoteException
     */
    public List<LoadPO> finds(String field, Object value) throws RemoteException;
    
    /**
     * 初始化{@code LoadDataService}的数据层服务
     * @throws RemoteException
     */
    public void init() throws RemoteException;
    
    /**
     * 结束{@code LoadDataService}的数据层服务
     * @throws RemoteException
     */
    public void finish() throws RemoteException; 
    
}
