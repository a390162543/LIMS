package businesslogic.checkbl.orderinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;


/**
 * 该类用于用户在界面输入地址时检查是否符合格式
 * 
 * @author lc
 * @version 1.0
 *
 */
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
