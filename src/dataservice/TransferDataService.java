package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.TransferPO;

public interface TransferDataService extends DataIdentifiable, Remote{
	 public void insert(TransferPO po) throws RemoteException;
	    
	 public void delete(TransferPO po) throws RemoteException;
	    
	 public void update(TransferPO po) throws RemoteException;
	    
	 public TransferPO find(String id) throws RemoteException;
	    
	 public List<TransferPO> finds(String field, Object value) throws RemoteException;
	    
	 public List<TransferPO> getAll() throws RemoteException;
	    
	 public void init() throws RemoteException ;
	 	   
	 public void finish() throws RemoteException; 

}
