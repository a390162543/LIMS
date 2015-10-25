package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.StoragePO;

public interface StorageDataService {
	
	public void insert(StoragePO po) throws RemoteException;
    
    public void delete(StoragePO po) throws RemoteException;
    
    public void update(StoragePO po) throws RemoteException;
    
    public StoragePO find(long id) throws RemoteException;
    
    public List<StoragePO> finds(String field, Object value) throws RemoteException;
    
    public List<StoragePO> getAll() throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 

}
