package businesslogic.checkbl.paymentinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
/**
 * {@code CheckInfo}��ʵ���࣬Ϊ������ṩ�տ��˻���ŵļ�����
 * @author ���¿�
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
			checkResultMessage.addInfo(CheckResult.FALSE, "�տ��˻���ų���ӦΪ19λ����");
			return checkResultMessage;
		}
			
		return checkResultMessage;
	}

}
