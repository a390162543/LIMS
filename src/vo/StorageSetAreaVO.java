package vo;

public class StorageSetAreaVO {
	
	private int airCapacity;
	private int motorCapacity;
	private int carCapacity;
	private int trainCapacity;
	
	
	public StorageSetAreaVO(int airCapacity, int motorCapacity,
			int carCapacity, int trainCapacity) {
		super();
		this.airCapacity = airCapacity;
		this.motorCapacity = motorCapacity;
		this.carCapacity = carCapacity;
		this.trainCapacity = trainCapacity;
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
	
	

}
