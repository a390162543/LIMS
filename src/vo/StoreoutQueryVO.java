package vo;

import java.util.List;



/**
 * ��ȡ���ⵥ�ϻ���Ķ�����
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
