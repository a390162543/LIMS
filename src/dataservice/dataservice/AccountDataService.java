package dataservice;

import java.rmi.RemoteException;
import java.util.List;
import java.util.ArrayList;

import po.AccountPO;

public interface AccountDataService {

	public void insert(AccountPO po) throws RemoteException;

	public void delete(AccountPO po) throws RemoteException;
	
	public void update(AccountPO po) throws RemoteException;
	
	public AccountPO find(long id) throws RemoteException;
	
	public List<AccountPO> getAll() throws RemoteException;
	
	public void init() throws RemoteException;
    
	public void finish() throws RemoteException;
	
}
