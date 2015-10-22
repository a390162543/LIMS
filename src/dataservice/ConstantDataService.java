package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ConstantPO;

public interface ConstantDataService {
	 public void insert(ConstantPO po) throws RemoteException;
	    
	 public void delete(ConstantPO po) throws RemoteException;
	    
	 public void update(ConstantPO po) throws RemoteException;
	    
	 public ConstantPO find(long id) throws RemoteException;
	    
	 public List<ConstantPO> finds(String field, Object value) throws RemoteException;
	    
	 public List<ConstantPO> getAll() throws RemoteException;
	    
	 public void init() throws RemoteException;
	    
	 public void finish() throws RemoteException; 

}
