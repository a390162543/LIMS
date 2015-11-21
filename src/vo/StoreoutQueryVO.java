package vo;

import java.util.List;

public class StoreoutQueryVO {
	
	private List<String> orderId;

	public StoreoutQueryVO(List<String> orderId) {
		super();
		this.orderId = orderId;
	}

	public List<String> getOrderId() {
		return orderId;
	}
	
	

}
