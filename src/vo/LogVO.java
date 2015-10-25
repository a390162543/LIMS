package vo;

import java.util.Date;

public class LogVO {

	private String operation;
	private Date date;

	public LogVO(String operation,Date date){
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
