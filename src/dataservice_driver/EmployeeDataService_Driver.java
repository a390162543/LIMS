package dataservice_driver;

import java.rmi.RemoteException;
import java.util.Date;

import po.EmployeePO;
import systemenum.Position;
import systemenum.Sex;
import dataservice.EmployeeDataService;

public class EmployeeDataService_Driver {
	public void drive(EmployeeDataService employeedataservice){
		EmployeePO po = new EmployeePO(new Long("025001001"), "李华",
				"南京市栖霞区中转中心", Position.COURIER, new Long("18355555555"),
				new Date(), new Long("350232230230230230"), Sex.FAMALE);
		
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
