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

/**
 * 登录的辅助类，负责记录当前用户信息和提供相应业务逻辑服务
 * @author 刘航伸
 *@version 1.6
 */
public class LoginController {
 
	/**
	 *{@code LoginController}的逻辑层引用 
	 */
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
		 if(vo == null){
			 return false;
		 }
		else{
			employeeVO = employeeblService.find(id);
			List<OrganizationVO> vos = organizationblService.getOrganizationVO();
			if(!vos.isEmpty()){
				for(OrganizationVO vo1 : vos){					 				
					if(vo1.getName().equals(employeeVO.getOrganization())){
						organizationVO = vo1;
						break;
					}
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
