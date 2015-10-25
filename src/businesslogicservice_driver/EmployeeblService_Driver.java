package businesslogicservice_driver;

 

import systemenum.Position;
import vo.EmployeeVO;
import businesslogicservice.EmployeeblService;

public class EmployeeblService_Driver {
	public void drive(EmployeeblService employeeblservice){		 
		EmployeeVO vo = new EmployeeVO(new Long("025001001"), "Ahri", 
				"南京市栖霞区中转中心",Position.MANAGER);
		
		employeeblservice.creatEmloyeePO(vo);
		employeeblservice.deleteEmloyeePO(vo);
		employeeblservice.getEmployeePO();
		employeeblservice.getSamePositionEmp(vo);
		employeeblservice.modifyEmloyeePO(vo);
		
	}
}
