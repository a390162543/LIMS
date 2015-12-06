package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;

/**
 * {@code ArrivalDataService}是到达单的数据层服务，提供到达单的{@code insert}，{@code update}，
 * {@code find}，{@code finds}等方法
 * @author 林祖华
 * @version 1.2
 */
public interface ArrivalDataService extends DataIdentifiable,Remote{
    
    public void insert(ArrivalPO po) throws RemoteException;
    
    public void update(ArrivalPO po) throws RemoteException;
    
    public ArrivalPO find(String id) throws RemoteException;
       
    public List<ArrivalPO> finds(String field, Object value) throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 
    
}
