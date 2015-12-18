package businesslogic.checkbl.paymentinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
/**
 * {@code CheckInfo}��ʵ���࣬Ϊ������ṩ������ļ�����
 * @author ���¿�
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
			checkResultMessage.addInfo(CheckResult.FALSE, "������Ӧ����������С��");
			return checkResultMessage;
		}
			
		return checkResultMessage;
	}

}
