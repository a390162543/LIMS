package businesslogic.checkbl.orderinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;


/**
 * �������ڼ����Ա����Ļ��������Ƿ���ȷ
 * @author lc
 * @version 1.1
 *
 */
public class OrderVolumn implements CheckInfo {

	private double volumn;
	
	public OrderVolumn(double volumn) {
		this.volumn = volumn;
	}
	
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if (volumn<=0) {
			checkResultMessage.addInfo(CheckResult.FALSE, "��������������0");
			return checkResultMessage;
		}
		if (volumn>=50) {
			checkResultMessage.addInfo(CheckResult.WARNING, "�������������ȷ��");
		}
		return checkResultMessage;
	}

}
