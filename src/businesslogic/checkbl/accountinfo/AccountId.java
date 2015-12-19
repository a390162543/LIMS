package businesslogic.checkbl.accountinfo;

import systemenum.CheckResult;
import businesslogic.accountbl.Account;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

/**
 * {@code CheckInfo}��ʵ���࣬Ϊ������ṩ�˻���ŵļ�����
 * @author ���¿�
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
			checkResultMessage.addInfo(CheckResult.FALSE, "�˻���ų���ӦΪ19λ����");
			return checkResultMessage;
		}
		else{
			Account account = new Account();
			String[] accountIds = account.getAllAccountId();
			for(String id : accountIds){
				if(id.equals(accountId))
					checkResultMessage.addInfo(CheckResult.FALSE, "�˻��Ѵ���");
			}
			return checkResultMessage;
		}
	}

}
