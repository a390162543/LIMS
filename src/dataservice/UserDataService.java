package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.UserPO;

public interface UserDataService extends Remote{
	 public void insert(UserPO po) throws RemoteException;
	    
	    public void delete(UserPO po) throws RemoteException;
	    
	    public void update(UserPO po) throws RemoteException;
	    
	    public UserPO find(String id) throws RemoteException;
	    
	    public List<UserPO> getAll() throws RemoteException;
	    
	    public void init() throws RemoteException;
	    
	    public void finish() throws RemoteException; 

}
