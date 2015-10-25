package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.AccountPO;
import po.LogPO;

public interface LogDataService {
	
	public void insert(LogPO po) throws RemoteException;
	
	public List<LogPO> finds(String field, Object value) throws RemoteException;
	
	public void init() throws RemoteException;
    
	public void finish() throws RemoteException;
}
