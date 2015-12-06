package businesslogic.checkbl.storeininfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class AreaNum implements CheckInfo{

	private int araeNum;
	
	public AreaNum(int araeNum) {
		this.araeNum = araeNum;
	}
	
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if (araeNum<0 || araeNum>3) {
			checkResultMessage.addInfo(CheckResult.FALSE, "区号只能在0-3之间");
		}
		return checkResultMessage;
	}

}
