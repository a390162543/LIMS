package po;

import java.io.Serializable;
import java.util.Date;

import vo.StorageSetAreaVO;
import vo.StorageVO;


/**
 * ���������Ϣ
 * 
 * @author lc
 * @version 1.3
 *
 */
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
	
	
	//0����������1���������2������������3���������.
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

	/**
	 * ��ȡ��ǰ���������Ĵ�С
	 * 
	 * @return ����һ��{@code StorageSetAreaVO}
	 */
	public StorageSetAreaVO getStorageSetAreaVO(){
		return new StorageSetAreaVO(storageId, airCapacity, motorCapacity, carCapacity, trainCapacity, alarm);
	}

	/**
	 * ���¿��������Ĵ�С
	 * 
	 * @param vo {@code StorageSetAreaVO}
	 * @return StoragePO
	 */
	public StoragePO getUpdateStoragePO(StorageSetAreaVO vo){
		
		return new StoragePO(vo.getAirCapacity(), vo.getMotorCapacity(), vo.getCarCapacity(), vo.getTrainCapacity(),
				(vo.getAirCapacity()+vo.getMotorCapacity()+vo.getCarCapacity()+vo.getTrainCapacity())*1000, nowCapacity, alarm, checkDate, storageId);
	}
	
	/**
	 * ���ظÿ�����Ϣ
	 * 
	 * @return StorageVO
	 */
	public StorageVO getStorageVO() {
		return new StorageVO(allCapacity*1000, nowCapacity, alarm);
	}
	
}
