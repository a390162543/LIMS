package businesslogic.checkbl.storageinfo;


import java.util.Date;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class FromDate implements CheckInfo{

	private Date fromDate;
	private Date toDate;
	
	public FromDate(Date froDate, Date toDate){
		this.fromDate = froDate;
		this.toDate = toDate;
	}
	
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if (fromDate.getTime()-System.currentTimeMillis()>0) {
			checkResultMessage.addInfo(CheckResult.FALSE, "查询日期不能超过当前时间");
			return checkResultMessage;
		}
		if (fromDate.getTime()-toDate.getTime()>0) {
			checkResultMessage.addInfo(CheckResult.FALSE, "查询起始日期不能超过结束日期");
			return checkResultMessage;
		}
		
		if (System.currentTimeMillis()-(fromDate.getTime())>((long)1000*6*30*24*60*60)) {
			
			checkResultMessage.addInfo(CheckResult.WARNING, "选择的日期距离今天过远，请确认");
			return checkResultMessage;
		}
		
		return checkResultMessage;
	}

}
