package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.PrimeInfoPO;

public interface PrimeInfoDataService extends Remote{
	
	public void insert(PrimeInfoPO po) throws RemoteException;
	
	public List<PrimeInfoPO> getAll() throws RemoteException;
	
	public void init() throws RemoteException;
    
	public void finish() throws RemoteException;
}
