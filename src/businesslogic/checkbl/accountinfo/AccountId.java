package businesslogic.checkbl.accountinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class AccountId implements CheckInfo{

	private String accountId;
	
	public AccountId(String accountId){
		this.accountId = accountId;
	}
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(accountId.length()!=19){
			checkResultMessage.addInfo(CheckResult.FALSE, "�˻���ų���ӦΪ19λ");
			return checkResultMessage;
		}
			
		return checkResultMessage;
	}

}
