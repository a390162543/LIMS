package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.UserPO;

public interface UserDataService {
	 public void insert(UserPO po) throws RemoteException;
	    
	    public void delete(UserPO po) throws RemoteException;
	    
	    public void update(UserPO po) throws RemoteException;
	    
	    public UserPO find(long id) throws RemoteException;
	    
	    public List<UserPO> finds(String field, Object value) throws RemoteException;
	    
	    public List<UserPO> getAll() throws RemoteException;
	    
	    public void init() throws RemoteException;
	    
	    public void finish() throws RemoteException; 

}
