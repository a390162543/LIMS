package businesslogicservice_driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import systemenum.DocumentState;
import systemenum.Position;
import systemenum.Power;
import businesslogicservice.ConstantblService;
import businesslogicservice.EmployeeblService;
import businesslogicservice.OrganizationblService;
import businesslogicservice.PayblService;
import businesslogicservice.TransferblService;
import businesslogicservice.UserblService;
import businesslogicservice_stub.ConstantblService_Stub;
import businesslogicservice_stub.EmployeeblService_Stub;
import businesslogicservice_stub.OrganizationblService_Stub;
import businesslogicservice_stub.PayblService_Stub;
import businesslogicservice_stub.TransferblService_Stub;
import businesslogicservice_stub.UserblService_Stub;

public class Client {
	public static void main(String[] args){
		ConstantblService constantblservice= new ConstantblService_Stub(23.1,2000.0);
 		ConstantblService_Driver constantbldriver = new ConstantblService_Driver();
 		constantbldriver.driver(constantblservice);
		
 		
 		EmployeeblService employeeblservice= 
 				new EmployeeblService_Stub(new Long("025001001"), "Ahri", 
 						"南京市栖霞区中转中心",Position.MANAGER);
 		EmployeeblService_Driver employeebldriver = new EmployeeblService_Driver();
 		employeebldriver.drive(employeeblservice);
		
 		
 		OrganizationblService organizationblservice = 
 				new OrganizationblService_Stub(new Long("025001"), 
 						"南京市栖霞区中转中心","南京");
 		OrganizationblService_Driver organizationblservicedriver =
 				new OrganizationblService_Driver();
 	organizationblservicedriver.drive(organizationblservice);
 	
 	
		
 	 PayblService payblservice = new PayblService_Stub(2000, 1000, 50, 0);
 		 PayblService_Driver payblservicedriver = new PayblService_Driver();
 		 payblservicedriver.drive(payblservice);
 		 
 		 
 		long l = new Long("1008356612");
		List<Long> ll = new ArrayList<Long>();
		ll.add(l);	 
		TransferblService transferblservice = 
 			new TransferblService_Stub(new Long("02501610120000001"), new Date(),
 					new Long("102111011"), "南京市栖霞区中转中心",  
 					"上海市浦东新区中转中心",  new Long("1024"), "Tom",
 					ll, 200,DocumentState.PENDING );
 		TransferblService_Driver transferblservicedriver = new TransferblService_Driver();
  		transferblservicedriver.drive(transferblservice);
		
  		
		UserblService userblservice = 
				new UserblService_Stub(new Long("0250001001"), "000000",Power.COURIER);;
		UserblService_Driver userblservicedriver =  new UserblService_Driver();
		userblservicedriver.drive(userblservice);
		 
	}
}
