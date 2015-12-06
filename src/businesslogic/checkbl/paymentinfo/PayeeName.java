package businesslogic.checkbl.paymentinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class PayeeName implements CheckInfo{

	private String payeeName;
	
	public PayeeName(String payeeName){
		this.payeeName = payeeName;
	}
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(!payeeName.matches("[\\u4e00-\\u9fa5]")){
			checkResultMessage.addInfo(CheckResult.FALSE, "收款人姓名应由中英文组成");
			return checkResultMessage;
		}
			
		return checkResultMessage;
	}

}
