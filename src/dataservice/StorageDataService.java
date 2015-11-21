package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.StoragePO;

public interface StorageDataService extends Remote {
	
    
    public void update(StoragePO po) throws RemoteException;
    
    public StoragePO find(String id) throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 
    
    

}
