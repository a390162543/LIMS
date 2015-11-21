package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import po.ConstantPO;

public interface ConstantDataService extends Remote{
	 public void insert(ConstantPO po) throws RemoteException;
	    
	 public void delete(ConstantPO po) throws RemoteException;
	    
	 public void update(ConstantPO po) throws RemoteException;	 
	    
	 public ConstantPO getConstantPO() throws RemoteException;
	        
	 public void finish() throws RemoteException; 
	 
	 public void init() throws RemoteException;

}
