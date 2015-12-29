package businesslogic.checkbl.accountinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
/**
 * {@code CheckInfo}��ʵ���࣬Ϊ������ṩ�˻����ļ�����
 * @author ���¿�
 *
 */
public class AccountMoney implements CheckInfo{

	private String accountMoney;
	
	public AccountMoney(String accountMoney){
		this.accountMoney = accountMoney;
	}
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(!accountMoney.matches("^[0-9]+([.]{1}[0-9]+){0,1}$")){
			checkResultMessage.addInfo(CheckResult.FALSE, "�˻����Ӧ����������С��");
			return checkResultMessage;

		}
		else	
			return checkResultMessage;
	}

}
