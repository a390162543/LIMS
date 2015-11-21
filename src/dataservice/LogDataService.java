package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import po.LogPO;

public interface LogDataService  extends Remote{
	
	public void insert(LogPO po) throws RemoteException;
	
	public List<LogPO> finds(String field, Object value) throws RemoteException;
	
	public void init() throws RemoteException;
    
	public void finish() throws RemoteException;
}
