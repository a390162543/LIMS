package dataservice_stub;

import java.rmi.RemoteException;

import po.StoragePO;
import dataservice.StorageDataService;

public class StorageDataService_Stub implements StorageDataService{

	int airCapacity;
	int motorCapacity;
	int carCapacity;
	int trainCapacity;
	int allCapacity;	
	int nowCapacity;
	double alarm;
	
	
	public StorageDataService_Stub(int airCapacity, int motorCapacity,
			int carCapacity, int trainCapacity, int allCapacity,
			int nowCapacity, double alarm) {
		super();
		this.airCapacity = airCapacity;
		this.motorCapacity = motorCapacity;
		this.carCapacity = carCapacity;
		this.trainCapacity = trainCapacity;
		this.allCapacity = allCapacity;
		this.nowCapacity = nowCapacity;
		this.alarm = alarm;
	}

	@Override
	public void update(StoragePO po) throws RemoteException {
		System.out.println("Update Succeed!\n");
	}

	@Override
	public StoragePO find(long id) throws RemoteException {
		StoragePO po = new StoragePO(airCapacity, motorCapacity, carCapacity, trainCapacity, allCapacity, nowCapacity,alarm);
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
