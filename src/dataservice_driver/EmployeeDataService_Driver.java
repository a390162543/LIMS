package dataservice_driver;

import java.rmi.RemoteException;

import po.EmployeePO;
import systemenum.Position;
import dataservice.EmployeeDataService;

public class EmployeeDataService_Driver {
	public void drive(EmployeeDataService employeedataservice){
		EmployeePO po = new EmployeePO(new Long("025001001"), "李华",
				"南京市栖霞区中转中心", Position.COURIER);
		
		try {
			employeedataservice.delete(po);
			employeedataservice.find(new Long("025110"));
			employeedataservice.finds("Position", Position.DRVER);
			employeedataservice.getAll();
			employeedataservice.insert(po);
			employeedataservice.update(po);
			employeedataservice.finish();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
