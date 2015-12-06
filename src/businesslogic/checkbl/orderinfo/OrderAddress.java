package businesslogic.checkbl.orderinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class OrderAddress implements CheckInfo{
	
	private String address;

	public OrderAddress(String address) {
		this.address = address;
	}

	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if (address.indexOf("��")==-1) {
			checkResultMessage.addInfo(CheckResult.FALSE, "����ĵ�ַ��ʽ����");
		}	
		return checkResultMessage;
	}
	
	
	
	

}
