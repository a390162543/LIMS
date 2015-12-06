package vo;

import java.util.Date;

import po.StoragePO;

public class StorageSetAreaVO {
	
	private String storageId;
	private int airCapacity;
	private int motorCapacity;
	private int carCapacity;
	private int trainCapacity;
	private double alarm;
	
	
	public StorageSetAreaVO(String storageId, int airCapacity, int motorCapacity,
			int carCapacity, int trainCapacity, double alarm) {
		super();
		this.storageId = storageId;
		this.airCapacity = airCapacity;
		this.motorCapacity = motorCapacity;
		this.carCapacity = carCapacity;
		this.trainCapacity = trainCapacity;
		this.alarm = alarm;
	}


	public String getStorageId() {
		return storageId;
	}
	
	public int getAirCapacity() {
		return airCapacity;
	}

	public int getMotorCapacity() {
		return motorCapacity;
	}

	public int getCarCapacity() {
		return carCapacity;
	}

	public int getTrainCapacity() {
		return trainCapacity;
	}
	
	public double getAlarm(){
		return alarm;
	}

	public StoragePO getInitialStoragePO(){
		return new StoragePO(airCapacity, motorCapacity, carCapacity, trainCapacity, 
				(airCapacity+motorCapacity+carCapacity+trainCapacity)*1000, 0, alarm, new Date(), storageId);
	}
}
