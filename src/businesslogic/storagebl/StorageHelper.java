package businesslogic.storagebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.omg.PortableServer.POA;

import po.StorageLocationPO;
import po.StoragePO;
import systemenum.StorageState;
import vo.StorageLocationVO;
import dataservice.StorageLocationDataService;



public class StorageHelper {
	
	public boolean initLocationInfo(String storageId, int airNum, int carNum, int trainNUm, int freeNum) {
		try {
			StorageLocationDataService storageLocationDataService = (StorageLocationDataService) Naming.lookup("rmi://localhost/LocationData");
			storageLocationDataService.initLocationInfo(storageId, airNum, carNum, trainNUm, freeNum);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean changeLocationState(StorageLocationVO vo) {
		StorageLocationPO po = vo.getStorageLocationPO();
		try {
			StorageLocationDataService storageLocationDataService = (StorageLocationDataService) Naming.lookup("rmi://localhost/LocationData");
			storageLocationDataService.update(po);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public StorageState getLocationState(StorageLocationVO vo) {
		StorageState state = null;
		try {
			StorageLocationDataService storageLocationDataService = (StorageLocationDataService) Naming.lookup("rmi://localhost/LocationData");
			state = storageLocationDataService.getLocationState(vo);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	
	public boolean changeLocationInfo(StoragePO orginalPO, StoragePO updatePO) {
		try {
			StorageLocationDataService storageLocationDataService = (StorageLocationDataService) Naming.lookup("rmi://localhost/LocationData");
			storageLocationDataService.changeLocationInfo(orginalPO, updatePO);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public int getMaxAir(String storageId) {
		int max = 0;
		try {
			StorageLocationDataService storageLocationDataService = (StorageLocationDataService) Naming.lookup("rmi://localhost/LocationData");
			max = storageLocationDataService.getMaxAir(storageId);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return max;
	}
	
	public int getMaxTrain(String storageId) {
		int max = 0;
		try {
			StorageLocationDataService storageLocationDataService = (StorageLocationDataService) Naming.lookup("rmi://localhost/LocationData");
			max = storageLocationDataService.getMaxTrain(storageId);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return max;
	}
	

	public int getMaxCar(String storageId) {
		int max = 0;
		try {
			StorageLocationDataService storageLocationDataService = (StorageLocationDataService) Naming.lookup("rmi://localhost/LocationData");
			max = storageLocationDataService.getMaxCar(storageId);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return max;
	}
	
	public int getMaxFree(String storageId) {
		int max = 0;
		try {
			StorageLocationDataService storageLocationDataService = (StorageLocationDataService) Naming.lookup("rmi://localhost/LocationData");
			max = storageLocationDataService.getMaxFree(storageId);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return max;
	}
}
