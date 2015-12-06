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
		if (address.indexOf("市")==-1) {
			checkResultMessage.addInfo(CheckResult.FALSE, "输入的地址格式有误");
		}	
		return checkResultMessage;
	}
	
	
	
	

}
