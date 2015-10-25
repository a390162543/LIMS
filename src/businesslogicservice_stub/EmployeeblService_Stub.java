package businesslogicservice_stub;

import java.util.ArrayList;
import java.util.List;

import po.PayPO;
import systemenum.Position;
import vo.EmployeeVO;
import businesslogicservice.EmployeeblService;

public class EmployeeblService_Stub implements EmployeeblService{
	 long id;
	 String name;
	  String organization;
	  Position position;
	  PayPO pay;
	  
	  public EmployeeblService_Stub(long i, String n, String o, Position p ){
			id= i;
			name = n;
			organization = o;
			position =p;
			 
		}
	public boolean creatEmloyeePO(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteEmloyeePO(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean modifyEmloyeePO(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<EmployeeVO> getEmployeePO() {
		// TODO Auto-generated method stub
		List<EmployeeVO> employeeVO = new ArrayList<EmployeeVO>();
		employeeVO.add(new EmployeeVO(id,name,organization,position ));
		return employeeVO;
	}

	 
	public List<EmployeeVO> getSamePositionEmp(EmployeeVO vo) {
		// TODO Auto-generated method stub
		List<EmployeeVO> employeeVO = new ArrayList<EmployeeVO>();
		employeeVO.add(new EmployeeVO(id,name,organization,position ));
		return employeeVO;
	}

}
