package po;

import java.io.Serializable;
import java.util.Date;

import systemenum.Position;
import vo.LogVO;

/**
 * {@code LogPO}是日志记录业务逻辑层与数据层之间传递的持久化对象，
 * 记录了日志记录的所有信息
 * @author 刘德宽
 *
 */
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
	
    /**
     * 获取该{@code LogPO}对应的{@code LogVO}对象
     * @return {@code LogVO}对象
     */
	public LogVO getLogVO(){
		LogVO vo = new LogVO(operation ,employeeId ,employeeName ,employeePosition, date );
		return vo;
	}

}
