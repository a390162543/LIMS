package businesslogic.checkbl.paymentinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
/**
 * {@code CheckInfo}的实现类，为界面层提供付款金额的检查服务
 * @author 刘德宽
 *
 */
public class PaymentMoney implements CheckInfo{

	private String paymentMoney;
	
	public PaymentMoney(String paymentMoney){
		this.paymentMoney = paymentMoney;
	}
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(!paymentMoney.matches("^[0-9]+([.]{1}[0-9]+){0,1}$")){
			checkResultMessage.addInfo(CheckResult.FALSE, "付款金额应是整数或者小数");
			return checkResultMessage;
		}
			
		return checkResultMessage;
	}

}
