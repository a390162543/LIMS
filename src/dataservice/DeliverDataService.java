package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.DeliverPO;

public interface DeliverDataService {
    
    public boolean insert(DeliverPO po) throws RemoteException;
    
    public boolean delete(DeliverPO po) throws RemoteException;
    
    public boolean update(DeliverPO po) throws RemoteException;
    
    public DeliverPO find(long id) throws RemoteException;
    
    public List<DeliverPO> finds(String field, Object value) throws RemoteException;
    
    public List<DeliverPO> getAll() throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 

}
