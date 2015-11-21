package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.LoadPO;

public interface LoadDataService extends Remote{
    
    public void insert(LoadPO po) throws RemoteException;
    
    public void update(LoadPO po) throws RemoteException;
    
    public LoadPO find(String id) throws RemoteException;
       
    public List<LoadPO> finds(String field, Object value) throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 
    
}
