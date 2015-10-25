package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ConstantPO;

public interface ConstantDataService {
	 public void insert(ConstantPO po) throws RemoteException;
	    
	 public void delete(ConstantPO po) throws RemoteException;
	    
	 public void update(ConstantPO po) throws RemoteException;	 
	    
	 public ConstantPO getConstantPO() throws RemoteException;
	        
	 public void finish() throws RemoteException; 

}
