package vo;

import java.util.Date;



/**
 * ������ʾ�ڿ��鿴ʱ����������Ϣ��VO
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
