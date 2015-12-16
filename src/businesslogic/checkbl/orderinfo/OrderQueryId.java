package businesslogic.checkbl.orderinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.orderbl.Order;


/**
 * 该类用于检查用户在查询物流信息时输入的订单号是否正确
 * 
 * @author lc
 * @version 1.1
 *
 */
public class OrderQueryId implements CheckInfo {
	
	private String orderId;
	
	public OrderQueryId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		Order order = new Order();
		if (orderId.length() != 10) {
			checkResultMessage.addInfo(CheckResult.FALSE, "订单号长度应为10位");
			return checkResultMessage;
		}
		if (orderId.length() == 10 && order.returnOrderQueryVO(orderId) == null) {
			checkResultMessage.addInfo(CheckResult.FALSE, "不存在该订单，请确认输入");
		}
		return checkResultMessage;
	}
	

}
