package po;

import java.io.Serializable;
import java.util.Date;

import businesslogic.storagebl.StorageHelper;
import systemenum.StorageState;
import vo.StorageSetAreaVO;

public class StoragePO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1677320272855633799L;

	/**
	 * 
	 */
	

	private String storageId;
	
	private int airCapacity;
	private int motorCapacity;
	private int carCapacity;
	private int trainCapacity;
	private int allCapacity;	
	private int nowCapacity;
	private double alarm;
	private Date checkDate;
	
	private StorageHelper[][][][] storageHelper = new StorageHelper[4][50][100][100];
	
	
	//0代表航空区，1代表火车区，2代表汽车区，3代表机动区.
	public StoragePO(int airCapacity, int motorCapacity, int carCapacity,
			int trainCapacity, int allCapacity, int nowCapacity, double alarm,
			Date checkDate,String storageId) {
		super();
		this.airCapacity = airCapacity;
		this.motorCapacity = motorCapacity;
		this.carCapacity = carCapacity;
		this.trainCapacity = trainCapacity;
		this.allCapacity = allCapacity;
		this.nowCapacity = nowCapacity;
		this.alarm = alarm;
		this.checkDate = checkDate;
		this.storageId = storageId;
		
		for (int i = 0; i < airCapacity; i++) {
			for (int j = 0; j < 100; j++) {
				for (int j2 = 0; j2 < 100; j2++) {
					storageHelper[0][i][j][j2] = new StorageHelper();
					storageHelper[0][i][j][j2].setState(StorageState.ISAVAILABLE);
				}
			}
			
		}
		
		for (int i = 0; i < trainCapacity; i++) {
			for (int j = 0; j < storageHelper.length; j++) {
				for (int j2 = 0; j2 < storageHelper.length; j2++) {
					storageHelper[1][i][j][j2] = new StorageHelper();
					storageHelper[1][i][j][j2].setState(StorageState.ISAVAILABLE);
				}
			}
			
		}
		
		for (int i = 0; i < carCapacity; i++) {
			for (int j = 0; j < storageHelper.length; j++) {
				for (int j2 = 0; j2 < storageHelper.length; j2++) {
					storageHelper[2][i][j][j2] = new StorageHelper();
					storageHelper[2][i][j][j2].setState(StorageState.ISAVAILABLE);
				}
			}
			
		}
		
		for (int i = 0; i < motorCapacity; i++) {
			for (int j = 0; j < storageHelper.length; j++) {
				for (int j2 = 0; j2 < storageHelper.length; j2++) {
					storageHelper[3][i][j][j2] = new StorageHelper();
					storageHelper[3][i][j][j2].setState(StorageState.ISAVAILABLE);
				}
			}
			
		}
	}
	
	
	public int getAllCapacity() {
		return allCapacity;
	}
	public void setAllCapacity(int allCapacity) {
		this.allCapacity=allCapacity;
	}
	
	public int getAirCapacity() {
		return airCapacity;
	}
	public void setAirCapacity(int airCapacity) {
		this.airCapacity = airCapacity;
	}
	
	public int getMotorCapacity() {
		return motorCapacity;
	}
	public void setMotorCapacity(int motorCapacity) {
		this.motorCapacity = motorCapacity;
	}
	
	public int getCarCapacity() {
		return carCapacity;
	}
	public void setCarCapacity(int carCapacity) {
		this.carCapacity = carCapacity;
	}
	
	public int getTrainCapacity() {
		return trainCapacity;
	}
	public void setTrainCapacity(int trainCapacity) {
		this.trainCapacity = trainCapacity;
	}
	
	public int getNowCapacity() {
		return nowCapacity;
	}
	public void setNowCapacity(int nowCapacity) {
		this.nowCapacity = nowCapacity;
	}
	
	public double getAlarm() {
		return alarm;
	}
	public void setAlarm(double alarm) {
		this.alarm = alarm;
	}


	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	
	
	public String getStorageId(){
		return storageId;
	}

	public StorageSetAreaVO getStorageSetAreaVO(){
		return new StorageSetAreaVO(storageId, airCapacity, motorCapacity, carCapacity, trainCapacity, alarm);
	}

	public StoragePO getUpdateStoragePO(StorageSetAreaVO vo){
		setAirCapacity(vo.getAirCapacity());
		setMotorCapacity(vo.getMotorCapacity());
		setCarCapacity(vo.getCarCapacity());
		setTrainCapacity(vo.getTrainCapacity());
		setAlarm(vo.getAlarm());
		return this;
	}
	
	public StorageHelper[][][][] getStorageHelperData() {
		return storageHelper;
	}
}
