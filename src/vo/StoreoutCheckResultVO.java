package vo;

import java.util.Date;



/**
 * 用于显示在库存查看时出库货物的信息的VO
 * 
 * @author lc
 * @version 1.3
 *
 */
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
