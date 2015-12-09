package vo;

import java.util.Date;

import po.LogPO;
import systemenum.Position;
/**
 * {@code LogVO}是日志记录界面与业务逻辑层之间传递的值对象，
 * 记录日志记录的所有信息
 * @author 刘德宽
 * @version 1.6
 */
public class LogVO {

	private String operation;
	private String employeeId;
	private String employeeName;
	private Position employeePosition;
	private Date date;

	public LogVO(String operation, String employeeId, String employeeName, Position employeePosition){
		this.operation=operation;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePosition = employeePosition;
		this.date = new Date() ;		
	}
	public LogVO(String operation, String employeeId, String employeeName, Position employeePosition,Date date){
		this.operation=operation;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePosition = employeePosition;
		this.date = date ;		
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
    /**
     * 获取一个{@code LogVO}对应的{@code LogPO}对象
     * @return {@code LogPO}对象
     */
	public LogPO getLogPO(){
		LogPO po = new LogPO(operation ,employeeId ,employeeName ,employeePosition, date );
		return po;
	}
}
