package vo;

import java.util.Date;

public class StoreoutCheckResultVO {

	
	private String orderId;
	private String destination;
	private Date date;
	
	
	
	public StoreoutCheckResultVO(String orderId,  String destination, Date date) {
		super();
		this.orderId = orderId;
		this.destination = destination;
		this.date = date;
	}

	public String getOrderId() {
		return orderId;
	}

	public Date getDate(){
		return date;
	}
	
	public String destination(){
		return destination;
	}
}
