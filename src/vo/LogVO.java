package vo;

import java.util.Date;

import po.LogPO;
import systemenum.Position;
/**
 * {@code LogVO}����־��¼������ҵ���߼���֮�䴫�ݵ�ֵ����
 * ��¼��־��¼��������Ϣ
 * @author ���¿�
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
     * ��ȡһ��{@code LogVO}��Ӧ��{@code LogPO}����
     * @return {@code LogPO}����
     */
	public LogPO getLogPO(){
		LogPO po = new LogPO(operation ,employeeId ,employeeName ,employeePosition, date );
		return po;
	}
}
