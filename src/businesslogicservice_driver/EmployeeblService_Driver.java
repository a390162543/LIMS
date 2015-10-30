package businesslogicservice_driver;

 

import java.util.Date;

import systemenum.Position;
import systemenum.Sex;
import vo.EmployeeVO;
import businesslogicservice.EmployeeblService;

public class EmployeeblService_Driver {
	public void drive(EmployeeblService employeeblservice){		 
		EmployeeVO vo = new EmployeeVO(new Long("025001001"), "Ahri", 
				"南京市栖霞区中转中心",Position.MANAGER, new Long("18355555555"),
				new Date(), new Long("350232230230230230"), Sex.FAMALE);
		
		employeeblservice.creatEmloyeePO(vo);
		employeeblservice.deleteEmloyeePO(vo);
		employeeblservice.getEmployeePO();
		employeeblservice.getSamePositionEmp(vo);
		employeeblservice.modifyEmloyeePO(vo);
		
	}
}
