package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.EmployeePO;

public interface EmployeeDataService extends Remote{
	 public void insert(EmployeePO po) throws RemoteException;
	    
	 public void delete(EmployeePO po) throws RemoteException;
	    
	 public void update(EmployeePO po) throws RemoteException;
	    
	 public EmployeePO find(String id) throws RemoteException;
	    
	 public List<EmployeePO> finds(String field, Object value) throws RemoteException;
	    
	 public List<EmployeePO> getAll() throws RemoteException;
	    
	 public void finish() throws RemoteException; 
	 
	 public void init() throws RemoteException;
	
	 
}
