package po;

import java.util.Date;

public class LogPO {
	
	private String operation;
	private Date date;

	public LogPO(String operation,Date date){
		this.operation=operation;
		this.date=date;
	
	}
	
	public String getOpration(){
		return operation;
	}
	
	public Date getDate(){
		return date;
	}

}
