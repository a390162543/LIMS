package businesslogicservice;

import java.util.List;
import vo.EmployeeVO;

public interface EmployeeblService extends Identifiable{
	public boolean creatEmployeePO(EmployeeVO vo);
	
	public boolean deleteEmployeePO (EmployeeVO vo);
	
	public boolean modifyEmployeePO (EmployeeVO vo);
	
	public List<EmployeeVO> getEmployeeVO();
	
	 public EmployeeVO find(String id);
	
	 
	
	 
}
