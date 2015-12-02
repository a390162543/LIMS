package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CityPO;
 

public interface CityDataService extends Remote{
	 public void insert(CityPO po) throws RemoteException;
	    
	 public void delete(CityPO po) throws RemoteException;
	    
	 public void update(CityPO po) throws RemoteException;	 
	    
	 public CityPO find(String id) throws RemoteException;
	 
	 public List<CityPO> getAll()throws RemoteException;
	        
	 public void finish() throws RemoteException; 
	 
	 public void init() throws RemoteException;
	 
	 public CityPO findByName(String name) throws RemoteException;
}
