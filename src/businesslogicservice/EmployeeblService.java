package businesslogicservice;

import java.util.List;

import po.EmployeePO;
import systemenum.Position;
import vo.EmployeeVO;

public interface EmployeeblService {
	public EmployeeVO creatEmloyeePO(EmployeeVO vo);
	
	public boolean deleteEmloyeePO (EmployeeVO vo);
	
	public boolean modifyEmloyeePO (EmployeeVO vo);
	
	public boolean setFocusedEmployeePO(EmployeeVO vo);
	
	public List< EmployeeVO > getEmployeePO();
	
	public boolean isExist(EmployeeVO vo);
	
	public List< EmployeeVO> getSamePositionEmp(EmployeeVO vo);
}
