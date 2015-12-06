package businesslogic.checkbl.storageinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

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
