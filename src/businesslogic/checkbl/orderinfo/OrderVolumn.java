package businesslogic.checkbl.orderinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class OrderVolumn implements CheckInfo {

	private double volumn;
	
	public OrderVolumn(double volumn) {
		this.volumn = volumn;
	}
	
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if (volumn<=0) {
			checkResultMessage.addInfo(CheckResult.FALSE, "货物体积必须大于0");
			return checkResultMessage;
		}
		if (volumn>=50) {
			checkResultMessage.addInfo(CheckResult.WARNING, "货物体积过大，请确认");
		}
		return checkResultMessage;
	}

}
