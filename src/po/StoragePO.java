package po;

public class StoragePO {
	
	
	private int airCapacity;
	private int motorCapacity;
	private int carCapacity;
	private int trainCapacity;
	private int allCapacity;	
	private int nowCapacity;
	private double alarm;
	
	
	public StoragePO(int airCapacity, int motorCapacity, int carCapacity,
			int trainCapacity, int allCapacity, int nowCapacity, double alarm) {
		super();
		this.airCapacity = airCapacity;
		this.motorCapacity = motorCapacity;
		this.carCapacity = carCapacity;
		this.trainCapacity = trainCapacity;
		this.allCapacity = allCapacity;
		this.nowCapacity = nowCapacity;
		this.alarm = alarm;
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
	
	
	


}
