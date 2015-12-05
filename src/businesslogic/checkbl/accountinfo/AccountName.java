package businesslogic.checkbl.accountinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class AccountName implements CheckInfo{
private String accountName;
	
	public AccountName(String accountName){
		this.accountName = accountName;
	}
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(accountName.matches("[0-9a-zA-z ()\\u4e00-\\u9fa5]+")){
			checkResultMessage.addInfo(CheckResult.FALSE, "账户编号长度应为19位");
			return checkResultMessage;
		}			
		return checkResultMessage;
	}

}
