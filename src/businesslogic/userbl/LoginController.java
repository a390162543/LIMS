package businesslogic.userbl;

import java.util.List;


 



import businesslogic.employeebl.Employee;
import businesslogic.organizationbl.Organization;
import businesslogicservice.EmployeeblService;
import businesslogicservice.OrganizationblService;
import businesslogicservice.UserblService;
import systemenum.Position;
import vo.EmployeeVO;
import vo.OrganizationVO;
import vo.UserVO;

public class LoginController {
 
 
	private static EmployeeVO employeeVO;
	private static OrganizationVO organizationVO;
	private UserblService userblService;
	private EmployeeblService employeeblService;
	private OrganizationblService organizationblService;
	  
	
	
	public boolean checkUser(String id,String password){
		userblService = new User();
		employeeblService = new Employee();
		UserVO vo = userblService.find(id);
		organizationblService = new Organization();
		if(vo == null )
			return false;
		else{
			employeeVO = employeeblService.find(id);
			List<OrganizationVO> vos = organizationblService.getOrganizationVO();
			for(OrganizationVO vo1 : vos){
				if(vo1.getName().equals(employeeVO.getOrganization())){
					organizationVO = vo1;
					break;
				}
			}
			 
			return vo.getPassword().equals(password);
		}
		 
	}
	public static  Position getPosition(){
		return employeeVO.getPosition();
	}
	
	public static String getEmployeeName(){
		return employeeVO.getName();
	}
	
	public static String getEmployeeId(){
		return employeeVO.getId();
	}
	
	public static String getOrganizationName(){	 		
		return organizationVO.getName();
	}
	public static String getOrganizationId(){
		return organizationVO.getId();
	}
	 
}
