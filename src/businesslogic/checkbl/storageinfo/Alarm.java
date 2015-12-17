package businesslogic.checkbl.storageinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;


/**
 * 该类用于检查中转中心仓库管理人员在进行
 * 库存分区调整时输入的库存警戒值的大小是否正确
 * @author lc
 *
 */
public class Alarm implements CheckInfo{
	
	private double alarm;
	
	public Alarm(double alarm) {
		this.alarm = alarm;
	}

	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if (alarm<=0 || alarm>1) {
			checkResultMessage.addInfo(CheckResult.FALSE, "警戒值应该大于0小于等于1");
		}
		return checkResultMessage;
	}

	
}
