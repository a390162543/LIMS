package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.StoreoutPO;

public interface StoreoutDataService extends Remote {
	
	public void insert(StoreoutPO po) throws RemoteException;
       
    public void update(StoreoutPO po) throws RemoteException;
    
    public StoreoutPO find(String id) throws RemoteException;
    
    public List<StoreoutPO> finds(String field, Object value) throws RemoteException;
    
    public List<StoreoutPO> getAll() throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 
}
