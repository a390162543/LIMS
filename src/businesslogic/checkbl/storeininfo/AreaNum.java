package businesslogic.checkbl.storeininfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;


/**
 * 该类用于检查中转中心仓库管理人员在进行
 * 货物入库时输入的区号是否正确
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
			checkResultMessage.addInfo(CheckResult.FALSE, "区号只能在0-3之间");
		}
		return checkResultMessage;
	}

}
