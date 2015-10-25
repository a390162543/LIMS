package dataservice_driver;

import java.rmi.RemoteException;

import po.UserPO;
import systemenum.Power;
import dataservice.UserDataService;

public class UserDataService_Driver {
	public void drive(UserDataService userdataservice){
		UserPO po =  new UserPO(new Long("0250001001"), "000000");
		
		try {
			userdataservice.delete(po);
			userdataservice.find(new Long("0250001001"));
			userdataservice.init();
			userdataservice.getAll();
			userdataservice.insert(po);
			userdataservice.update(po);
			userdataservice.finish();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
