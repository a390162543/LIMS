package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import po.StoragePO;
import dataservice.StorageDataService;



/**
 * 实现StorageDataService，提供对库存数据操作的方法
 * @author lc
 * @version 1.3
 *
 */
public class StorageData extends UnicastRemoteObject implements StorageDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3542084446894544512L;

	/**
	 * 
	 */
	

	protected StorageData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(StoragePO po) throws RemoteException {
		String fileName = po.getStorageId();
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		DataUtil.writeObject(po, path);		
	}

	@Override
	public StoragePO find(String id) throws RemoteException {
		String fileName = id;
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		File file = new File(path);
		if (file.exists()) {
			StoragePO po = (StoragePO) DataUtil.readObject(path);
			return po;
		}
		else {
			return null;
		}
		
	}

	@Override
	public void init() throws RemoteException {
		StorageDataService storageDataService = new StorageData();
		try {
			LocateRegistry.createRegistry(1099);
		} catch (Exception e) {			
		}
		try {
			Naming.rebind("rmi://localhost/"+storageDataService.getClass().getSimpleName(), storageDataService);
		} catch (MalformedURLException e) {
			
		}
		System.out.println("Server is on.");
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
