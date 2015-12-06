package businesslogic.checkbl.orderinfo;

import systemenum.CheckResult;
import vo.OrderQueryVO;
import vo.OrderSignVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.orderbl.Order;
import businesslogic.userbl.LoginController;

public class OrderSignId implements CheckInfo {

	private String orderId;
	
	public OrderSignId(String orderId) {
		this.orderId = orderId;
	}
	
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		Order order = new Order();
		OrderQueryVO orderQueryVO = order.returnOrderQueryVO(orderId);
		OrderSignVO orderSignVO = order.getOrderSignVO(orderId);

		if (orderId.length() != 10) {
			checkResultMessage.addInfo(CheckResult.FALSE, "�����ų���ӦΪ10λ");
			return checkResultMessage;
		}
		if (orderId.length() == 10 && orderSignVO == null) {
			checkResultMessage.addInfo(CheckResult.FALSE, "�����ڸö�������ȷ������");
			return checkResultMessage;
		}
		if (orderId.length() == 10 && orderSignVO.getSignName() != null ) {
			checkResultMessage.addInfo(CheckResult.FALSE, "�ö����ѱ�ǩ��");
			return checkResultMessage;
		}
		if (orderId.length() == 10 && orderQueryVO.getNowLocation() != LoginController.getOrganizationName()) {
			checkResultMessage.addInfo(CheckResult.FALSE, "�ö�����δ�ʹ����ǩ��");
			return checkResultMessage;
		}
		return checkResultMessage;
	}

}
