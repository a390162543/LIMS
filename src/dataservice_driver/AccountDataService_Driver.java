package dataservice_driver;

import java.rmi.RemoteException;
import java.util.List;

import dataservice.AccountDataService;
import po.AccountPO;

public class AccountDataService_Driver {
	public void drive(AccountDataService accountDataService){
		AccountPO po=new AccountPO("2000000000000000000",  "1000000000000000000",50.00);
		try {
			accountDataService.init();
			accountDataService.insert(po);
			accountDataService.update(po);
			AccountPO poFound =accountDataService.find("100000000000000001");
	        if(poFound != null)
	            System.out.println("find succeed!");
	        accountDataService.delete(poFound);

	        List<AccountPO> allPO = accountDataService.getAll();
	        System.out.println("get "+allPO.size()+" AccountPO!");
	        accountDataService.finish();
	    } catch (RemoteException e) {
	        e.printStackTrace();
	    }
	}
}
