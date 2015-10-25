package businesslogicservice;

import java.util.List;

import po.EmployeePO;
import systemenum.Position;
import vo.EmployeeVO;

public interface EmployeeblService {
	public boolean creatEmloyeePO(EmployeeVO vo);
	
	public boolean deleteEmloyeePO (EmployeeVO vo);
	
	public boolean modifyEmloyeePO (EmployeeVO vo);
	
	public List< EmployeeVO > getEmployeePO();
	
	public List< EmployeeVO> getSamePositionEmp(EmployeeVO vo);
}
