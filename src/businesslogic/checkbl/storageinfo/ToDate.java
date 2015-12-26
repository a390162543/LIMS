package businesslogic.checkbl.storageinfo;

import java.util.Date;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class ToDate implements CheckInfo{

	private Date toDate;
	private Date fromDate;
	
	public ToDate(Date fromDate, Date toDate) {
		// TODO Auto-generated constructor stub
		this.toDate = toDate;
		this.fromDate = fromDate;
	}
	
	@Override
	public CheckResultMessage check() {
		// TODO Auto-generated method stub
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if (toDate.getTime()-System.currentTimeMillis()>0) {
			checkResultMessage.addInfo(CheckResult.FALSE, "查询日期不能超过当前时间");
			return checkResultMessage;
		}
		if (toDate.getTime()-fromDate.getTime()<0) {
			checkResultMessage.addInfo(CheckResult.FALSE, "查询起始日期不能超过结束日期");
			return checkResultMessage;
		}
		if ((System.currentTimeMillis()-(toDate.getTime())>((long)1000*3*30*24*60*60))) {
			
			checkResultMessage.addInfo(CheckResult.WARNING, "选择的日期距离今天过远，请确认");	
			return checkResultMessage;
		}		
		return checkResultMessage;
	}
	

}
