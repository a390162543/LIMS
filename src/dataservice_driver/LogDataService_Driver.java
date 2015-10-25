package dataservice_driver;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.LogPO;
import dataservice.LogDataService;

public class LogDataService_Driver {

	public void drive(LogDataService logDataService){
		LogPO po=new LogPO("createOrderVO by wang",new Date());
		try {
			logDataService.init();

	        List<LogPO> pos = logDataService.finds("date", "createOrderVO by wang");
	        System.out.println("get "+pos.size()+" LogPO!");
	    
	        logDataService.finish();
		
		} catch (RemoteException e) {
	        e.printStackTrace();
	    }
	}
}
