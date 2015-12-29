package businesslogic.checkbl.paymentinfo;

import systemenum.CheckResult;
import vo.AccountVO;
import businesslogic.accountbl.Account;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
/**
 * {@code CheckInfo}��ʵ���࣬Ϊ������ṩ������ļ�����
 * @author ���¿�
 *
 */
public class PaymentMoney implements CheckInfo{

	private String paymentMoney;
	private String accountId;
	
	public PaymentMoney(String paymentMoney ,String id){
		this.paymentMoney = paymentMoney;
		this.accountId = id;
	}
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();		
		Account account = new Account(); 
		 
		if(!paymentMoney.matches("^[0-9]+([.]{1}[0-9]+){0,1}$")){
			checkResultMessage.addInfo(CheckResult.FALSE, "������Ӧ����������С��");
			return checkResultMessage;
		}
		else {
			AccountVO accountVO = account.getAccountVOById(accountId);
			if(accountVO.getMoney()<Double.parseDouble(paymentMoney))
				checkResultMessage.addInfo(CheckResult.WARNING, "�˻�����");
			return checkResultMessage;
		}

	}

}
