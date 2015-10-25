package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.StoreinPO;

public interface StoreinDataService {
	
	public void insert(StoreinPO po) throws RemoteException;
    
    public void update(StoreinPO po) throws RemoteException;
    
    public StoreinPO find(long id) throws RemoteException;
    
    public List<StoreinPO> finds(String field, Object value) throws RemoteException;
    
    public List<StoreinPO> getAll() throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 
    
  
}
