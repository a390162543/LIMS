package businesslogic.checkbl.orderinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class OrderTime implements CheckInfo{

	private String day;
	
	public OrderTime(String day) {
		// TODO Auto-generated constructor stub
		this.day = day;
	}

	@Override
	public CheckResultMessage check() {
		// TODO Auto-generated method stub
		int i_day = 0;
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		try {
			i_day = Integer.parseInt(day);
		} catch (Exception e) {
			// TODO: handle exception
			checkResultMessage.addInfo(CheckResult.FALSE, "天数应该为正整数");
			return checkResultMessage;
		}
		if (i_day<=0) {
			checkResultMessage.addInfo(CheckResult.FALSE, "天数应该大于0");
			return checkResultMessage;
		}
		if (i_day>15) {
			checkResultMessage.addInfo(CheckResult.WARNING, "快递天数过长，请确认");
		}
		return checkResultMessage;
	}
}
