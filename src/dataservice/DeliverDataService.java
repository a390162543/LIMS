package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.DeliverPO;

public interface DeliverDataService extends Remote{
    
    public void insert(DeliverPO po) throws RemoteException;
    
    public void update(DeliverPO po) throws RemoteException;
    
    public DeliverPO find(String id) throws RemoteException;
       
    public List<DeliverPO> finds(String field, Object value) throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException;
    

}
