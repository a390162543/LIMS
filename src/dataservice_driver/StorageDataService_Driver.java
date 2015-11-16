package dataservice_driver;

import java.rmi.RemoteException;
import java.util.Date;

import po.OrderPO;
import po.StoragePO;
import dataservice.StorageDataService;

public class StorageDataService_Driver {
	
	public void drive(StorageDataService storageDataService){
		
		StoragePO storagePO = new StoragePO(10, 50, 90, 50, 2000000, 1000000, 0.85, 
				new Date(2015, 10, 29, 13, 50),new Long("0011503480"));
		
		try {
			storageDataService.update(storagePO);
			System.out.println("Succeed£¡");
		} catch (RemoteException e) {
			System.out.println("false");
			e.printStackTrace();
		}
		
		try {
			long findId = new Long("0250");
			StoragePO StorageFindPO = storageDataService.find(findId);
			System.out.println("Succeed");
		} catch (RemoteException e) {
			System.out.println("false");
			e.printStackTrace();
		}
		
		try {
			storageDataService.init();
			System.out.println(true);
		} catch (RemoteException e) {
			System.out.println(false);
			e.printStackTrace();
		}
		
		try {
			storageDataService.finish();
			System.out.println(true);
		} catch (RemoteException e) {
			System.out.println(false);
			e.printStackTrace();
		}
		
	}

}
