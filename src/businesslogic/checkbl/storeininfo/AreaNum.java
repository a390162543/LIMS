package businesslogic.checkbl.storeininfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;


/**
 * �������ڼ����ת���Ĳֿ������Ա�ڽ���
 * �������ʱ����������Ƿ���ȷ
 * @author lc
 * @version 1.1
 *
 */
public class AreaNum implements CheckInfo{

	private int araeNum;
	
	public AreaNum(int araeNum) {
		this.araeNum = araeNum;
	}
	
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if (araeNum<0 || araeNum>3) {
			checkResultMessage.addInfo(CheckResult.FALSE, "����ֻ����0-3֮��");
		}
		return checkResultMessage;
	}

}
