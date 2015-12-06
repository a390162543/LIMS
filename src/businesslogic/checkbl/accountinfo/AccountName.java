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
		if(!accountName.matches("([0-9a-zA-z ()]|[\\u4e00-\\u9fa5])+")){
			checkResultMessage.addInfo(CheckResult.FALSE, "账户名称应由数字，中英文，空格或括号组成");
			return checkResultMessage;
		}			
		return checkResultMessage;
	}

}
