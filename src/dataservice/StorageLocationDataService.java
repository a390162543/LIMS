package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.StorageLocationPO;
import po.StoragePO;
import systemenum.StorageState;
import vo.StorageLocationVO;

public interface StorageLocationDataService extends Remote{

	public boolean update(StorageLocationPO po) throws RemoteException;
	
	public boolean initLocationInfo(String storageId, int airNum, int carNum, int trainNUm, int freeNum) throws RemoteException;
	
	public boolean changeLocationInfo(StoragePO orginalPO, StoragePO updatePO) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public void finish() throws RemoteException;

	public StorageState getLocationState(StorageLocationVO vo) throws RemoteException;
	
}
