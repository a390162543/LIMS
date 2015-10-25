package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ApprovalPO;

public interface ApprovalDataService {
	public void insert(ApprovalPO po) throws RemoteException;
	    
	public void delete(ApprovalPO po) throws RemoteException;
	    
	public void update(ApprovalPO po) throws RemoteException;
	    
	public ApprovalPO find(long id) throws RemoteException;
		    
	public List<ApprovalPO> finds(String field, Object value) throws RemoteException;
		    
	public List<ApprovalPO> getAll() throws RemoteException;
		    
	public void init() throws RemoteException;
		    
	public void finish() throws RemoteException; 

}
