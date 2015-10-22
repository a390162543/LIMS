package businesslogicservice;

import java.util.List;

import po.EmployeePO;
import systemenum.Position;

public interface EmployeeblService {
	public EmployeePO creatEmloyeePO(long id, String name, String organization,
			Position  position );
	
	public boolean deleteEmloyeePO ();
	
	public boolean modifyEmloyeePO (long id, String name, String organization,
			Position position);
	
	public boolean queryEmployeePO();
	
	public boolean setFocusedEmployeePO(int index);
	
	public List< EmployeePO > getEmployeePO();
	
	public boolean isExist(String name);
	
	public List< EmployeePO> getSamePositionEmp(Position postion);
}
