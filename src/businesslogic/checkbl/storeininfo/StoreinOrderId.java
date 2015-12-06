package businesslogic.checkbl.storeininfo;

import systemenum.CheckResult;
import systemenum.StorageState;
import vo.OrderQueryVO;
import vo.StoreinOrderVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.orderbl.Order;
import businesslogic.userbl.LoginController;


public class StoreinOrderId implements CheckInfo{

	private String orderId;
	
	public StoreinOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		Order order = new Order();
		OrderQueryVO orderQueryVO = order.returnOrderQueryVO(orderId);
		StoreinOrderVO storeinOrderVO = order.getStorageOrderVO(orderId);
		if (orderId.length() != 10) {
			checkResultMessage.addInfo(CheckResult.FALSE, "�����ų���ӦΪ10λ");
			return checkResultMessage;
		}
		if (orderId.length() == 10 && orderQueryVO == null) {
			checkResultMessage.addInfo(CheckResult.FALSE, "�ö��������ڣ���ȷ������");
			return checkResultMessage;
		}
		if (orderId.length() == 10 && orderQueryVO.getNowLocation() != LoginController.getOrganizationName()) {
			checkResultMessage.addInfo(CheckResult.FALSE, "�ö��������ڱ���ת����");
			return checkResultMessage;
		}
		if (orderId.length() == 10 && order.getStorageState(orderId) == StorageState.ISSTORING) {
			checkResultMessage.addInfo(CheckResult.FALSE, "�û����ѱ����");
			return checkResultMessage;
		}
		if (orderId.length() == 10 && storeinOrderVO.getAreaNum() >=0 && storeinOrderVO.getRowNum() >=0) {
			checkResultMessage.addInfo(CheckResult.FALSE, "�û����Ѿ����");
		}
		return checkResultMessage;
	}
	
	

}
