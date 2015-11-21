package dataservice_stub;

import java.rmi.RemoteException;
import java.util.Date;

import po.StoragePO;
import dataservice.StorageDataService;

public class StorageDataService_Stub implements StorageDataService{

	String storageId;
	int airCapacity;
	int motorCapacity;
	int carCapacity;
	int trainCapacity;
	int allCapacity;	
	int nowCapacity;
	double alarm;
	Date checkDate;
	
	
	public StorageDataService_Stub(String storageId,int airCapacity, int motorCapacity,
			int carCapacity, int trainCapacity, int allCapacity,
			int nowCapacity, double alarm,Date checkDate) {
		super();
		this.storageId = storageId;
		this.airCapacity = airCapacity;
		this.motorCapacity = motorCapacity;
		this.carCapacity = carCapacity;
		this.trainCapacity = trainCapacity;
		this.allCapacity = allCapacity;
		this.nowCapacity = nowCapacity;
		this.alarm = alarm;
		this.checkDate = checkDate;
	}

	@Override
	public void update(StoragePO po) throws RemoteException {
		System.out.println("Update Succeed!\n");
	}

	@Override
	public StoragePO find(String id) throws RemoteException {
		StoragePO po = new StoragePO(airCapacity, motorCapacity, carCapacity, 
				trainCapacity, allCapacity, nowCapacity,alarm,checkDate,storageId);
		return po;
	}

	@Override
	public void init() throws RemoteException {
		System.out.println("Init Succeed!\n");
	}

	@Override
	public void finish() throws RemoteException {
		System.out.println("Finish Succeed!\n");	
	}
	
	

}
