package dataservice_driver;

import java.rmi.RemoteException;

import po.PayPO;
import dataservice.PayDataService;

public class PayDataservice_Driver {
	public void drive(PayDataService paydataservice){
		PayPO po = new PayPO(2000, 1000, 50, 0);
		try {
			paydataservice.delete(po);
			paydataservice.finish();
			paydataservice.insert(po);
			paydataservice.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
