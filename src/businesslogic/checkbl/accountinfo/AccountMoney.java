package businesslogic.checkbl.accountinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
/**
 * {@code CheckInfo}的实现类，为界面层提供账户金额的检查服务
 * @author 刘德宽
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
			checkResultMessage.addInfo(CheckResult.FALSE, "账户金额应是整数或者小数");
			return checkResultMessage;

		}
		else	
			return checkResultMessage;
	}

}
