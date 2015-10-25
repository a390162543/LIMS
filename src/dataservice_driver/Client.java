package dataservice_driver;

import data.ConstantData;
import dataservice.ConstantDataService;
import dataservice.EmployeeDataService;
import dataservice.OrganizationDataService;
import dataservice.PayDataService;
import dataservice.TransferDataService;
import dataservice.UserDataService;
import dataservice_stub.ConstantDataService_Stub;
import dataservice_stub.EmployeeDataService_Stub;
import dataservice_stub.OrganizationDataService_Stub;
import dataservice_stub.PayDataService_Stub;
import dataservice_stub.TransferDataService_Stub;
import dataservice_stub.UserDataService_Stub;

public class Client {
	public static void main(String[] args){
 		ConstantDataService constantdataservice= new ConstantDataService_Stub();
 		ConstantDataService_Driver constantdatadriver = new ConstantDataService_Driver();
 		constantdatadriver.drive(constantdataservice);
		
 		EmployeeDataService employeedataservice= new EmployeeDataService_Stub();
 		EmployeeDataService_Driver employeedatadriver = new EmployeeDataService_Driver();
 		employeedatadriver.drive(employeedataservice);
		
 		OrganizationDataService organizationdataservice = new OrganizationDataService_Stub();
 		OrganizationDataService_Driver organizationdataservicedriver =
 				new OrganizationDataService_Driver();
 	organizationdataservicedriver.drive(organizationdataservice);
		
 	 PayDataService paydataservice = new PayDataService_Stub();
 		 PayDataservice_Driver paydataservicedriver = new PayDataservice_Driver();
 		 paydataservicedriver.drive(paydataservice);
		 
 	TransferDataService transferdataservice = new TransferDataService_Stub();
 		TransferDataService_Driver transferdataservicedriver = new TransferDataService_Driver();
  		transferdataservicedriver.drive(transferdataservice);
		
		UserDataService userdataservice = new UserDataService_Stub();
		UserDataService_Driver userdataservicedriver =  new UserDataService_Driver();
		userdataservicedriver.drive(userdataservice);
		
		
	}
}
