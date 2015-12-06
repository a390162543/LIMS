package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import businesslogicservice.Identifiable;
import po.StoreinPO;

public interface StoreinDataService extends DataIdentifiable,Remote{
	
	public void insert(StoreinPO po) throws RemoteException;
    
    public void update(StoreinPO po) throws RemoteException;
    
    public StoreinPO find(String id) throws RemoteException;
    
    public List<StoreinPO> finds(String field, Object value) throws RemoteException;
    
    public List<StoreinPO> getAll() throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 
    
  
}
