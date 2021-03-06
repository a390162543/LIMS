package vo;


/**
 * 该VO包含的库存的各个属性，用于传递库存信息
 * @author lc
 * @version 1.4
 *
 */
public class StorageVO {
	
	private int allCapacity;	
	private int nowCapacity;
	private double alarm;
	
	public StorageVO(int allCapacity, int nowCapacity, double alarm) {
		super();
		this.allCapacity = allCapacity;
		this.nowCapacity = nowCapacity;
		this.alarm = alarm;
	}

	public int getAllCapacity() {
		return allCapacity;
	}

	public void setAllCapacity(int allCapacity) {
		this.allCapacity = allCapacity;
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
