package vo;

import systemenum.GoodsState;

public class OrderQueryVO {
	
	 private long id;
	 private GoodsState state;
	 private String deliverInfo;
	 private String nowLocation;
	 private String nextLocation;
	 
	 public OrderQueryVO(long id, GoodsState state, String deliverInfo,
			String nowLocation, String nextLocation) {
		super();
		this.id = id;
		this.state = state;
		this.deliverInfo = deliverInfo;
		this.nowLocation = nowLocation;
		this.nextLocation = nextLocation;
	}

	 
	public long getId() {
		return id;
	}

	public GoodsState getState() {
		return state;
	}

	public String getDeliverInfo() {
		return deliverInfo;
	}

	public String getNowLocation() {
		return nowLocation;
	}

	public String getNextLocation() {
		return nextLocation;
	}
	 
	 
	 

}
