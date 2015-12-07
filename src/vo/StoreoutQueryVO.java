package vo;

import java.util.List;



/**
 * 获取出库单上货物的订单号
 * @author lc
 * @version 1.3
 *
 */
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
