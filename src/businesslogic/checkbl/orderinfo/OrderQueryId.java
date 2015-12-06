package businesslogic.checkbl.orderinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.orderbl.Order;

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
			checkResultMessage.addInfo(CheckResult.FALSE, "�����ų���ӦΪ10λ");
			return checkResultMessage;
		}
		if (orderId.length() == 10 && order.returnOrderQueryVO(orderId) == null) {
			checkResultMessage.addInfo(CheckResult.FALSE, "�����ڸö�������ȷ������");
		}
		return checkResultMessage;
	}
	

}
