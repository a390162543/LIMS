package po;

import java.io.Serializable;
import java.util.Date;

import vo.LogVO;

public class LogPO implements Serializable{
	
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
	
	public LogVO getLogVO(){
		LogVO vo = new LogVO(operation , date );
		return vo;
	}

}
