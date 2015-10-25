package dataservice;

import java.rmi.RemoteException;

import po.StoragePO;

public interface StorageDataService {
	
    
    public void update(StoragePO po) throws RemoteException;
    
    public StoragePO find(long id) throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 
    
    

}
