package vo;

public class OrderDeliverInfoVO {
	
	private String orderId;
	private String nowLocation;
	private String nextLocation;
	private String deliverInfo;
	

	public OrderDeliverInfoVO(String orderId, String nowLocation,
			String nextLocation, String deliverInfo) {
		super();
		this.orderId = orderId;
		this.nowLocation = nowLocation;
		this.nextLocation = nextLocation;
		this.deliverInfo = deliverInfo;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getNowLocation() {
		return nowLocation;
	}
	public void setNowLocation(String nowLocation) {
		this.nowLocation = nowLocation;
	}
	public String getNextLocation() {
		return nextLocation;
	}
	public void setNextLocation(String nextLocation) {
		this.nextLocation = nextLocation;
	}
	public String getDeliverInfo() {
		return deliverInfo;
	}
	public void setDeliverInfo(String deliverInfo) {
		this.deliverInfo = deliverInfo;
	}
	
	

}
