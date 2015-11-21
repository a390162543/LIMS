package businesslogicservice;

import java.util.List;

import po.EmployeePO;
import systemenum.Position;
import vo.EmployeeVO;

public interface EmployeeblService {
	public boolean creatEmployeePO(EmployeeVO vo);
	
	public boolean deleteEmployeePO (EmployeeVO vo);
	
	public boolean modifyEmployeePO (EmployeeVO vo);
	
	public List<EmployeeVO> getEmployeeVO();
	
	 public EmployeeVO find(String id);
	
	public List<EmployeeVO> getDriverVO(String organiztion);
	
	 
}
