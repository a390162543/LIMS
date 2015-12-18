package businesslogic.checkbl.paymentinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
/**
 * {@code CheckInfo}的实现类，为界面层提供收款账户编号的检查服务
 * @author 刘德宽
 *
 */
public class PayeeAccountId implements CheckInfo{

	private String payeeAccountId;
	
	public PayeeAccountId(String payeeAccountId){
		this.payeeAccountId = payeeAccountId;
	}
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(!payeeAccountId.matches("[0-9]{19}")){
			checkResultMessage.addInfo(CheckResult.FALSE, "收款账户编号长度应为19位数字");
			return checkResultMessage;
		}
			
		return checkResultMessage;
	}

}
