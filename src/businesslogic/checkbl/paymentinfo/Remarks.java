package businesslogic.checkbl.paymentinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class Remarks implements CheckInfo{
	private String remarks;
	
	public Remarks(String remarks){
		this.remarks = remarks;
	}
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(!remarks.matches("([0-9a-zA-z ()]|[\\u4e00-\\u9fa5])+")){
			checkResultMessage.addInfo(CheckResult.FALSE, "��עӦ�����֣���Ӣ�ģ��ո���������");
			return checkResultMessage;
		}
		return checkResultMessage;
	}

}
