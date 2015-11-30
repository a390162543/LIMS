package po;

import java.io.Serializable;
import java.util.Date;

import systemenum.Position;
import vo.LogVO;

public class LogPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3659846227709114531L;
	private String operation;
	private String employeeId;
	private String employeeName;
	private Position employeePosition;
	private Date date;

	public LogPO(String operation,String employeeId, String employeeName, Position employeePosition,Date date){
		this.operation=operation;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePosition = employeePosition;
		this.date=date;
	}
	
	public String getOpration(){
		return operation;
	}
	
	public String getEmployeeId(){
		return employeeId;
	}
	
	public String getEmployeeName(){
		return employeeName;
	}
	
	public Position getEmployeePosition(){
		return employeePosition;
	}
	
	public Date getDate(){
		return date;
	}
	
	public LogVO getLogVO(){
		LogVO vo = new LogVO(operation ,employeeId ,employeeName ,employeePosition, date );
		return vo;
	}

}
