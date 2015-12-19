package businesslogic.checkbl.accountinfo;

import systemenum.CheckResult;
import businesslogic.accountbl.Account;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

/**
 * {@code CheckInfo}的实现类，为界面层提供账户编号的检查服务
 * @author 刘德宽
 *
 */
public class AccountId implements CheckInfo{

	private String accountId;
	
	public AccountId(String accountId){
		this.accountId = accountId;
	}
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(!accountId.matches("[0-9]{19}")){
			checkResultMessage.addInfo(CheckResult.FALSE, "账户编号长度应为19位数字");
			return checkResultMessage;
		}
		else{
			Account account = new Account();
			String[] accountIds = account.getAllAccountId();
			for(String id : accountIds){
				if(id.equals(accountId))
					checkResultMessage.addInfo(CheckResult.FALSE, "账户已存在");
			}
			return checkResultMessage;
		}
	}

}
