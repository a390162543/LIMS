package businesslogic.checkbl.storeininfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;


/**
 * 该类用于检查中转中心仓库管理人员在进行
 * 货物入库时输入的架号是否正确
 * @author lc
 * @version 1.1
 *
 */
public class FrameNum implements CheckInfo{

	private int frameNum;
	
	public FrameNum(int frameNum) {
		this.frameNum = frameNum;
	}
	
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if (frameNum<0 || frameNum>9) {
			checkResultMessage.addInfo(CheckResult.FALSE, "架号只能在0-9之间");
		}
		return checkResultMessage;
	}

}
