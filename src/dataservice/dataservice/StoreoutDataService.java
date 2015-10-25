package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.StoreoutPO;

public interface StoreoutDataService {
	
	public void insert(StoreoutPO po) throws RemoteException;
    
    public void delete(StoreoutPO po) throws RemoteException;
    
    public void update(StoreoutPO po) throws RemoteException;
    
    public StoreoutPO find(long id) throws RemoteException;
    
    public List<StoreoutPO> finds(String field, Object value) throws RemoteException;
    
    public List<StoreoutPO> getAll() throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 
}
