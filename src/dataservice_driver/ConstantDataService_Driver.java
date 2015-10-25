package dataservice_driver;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import po.ConstantPO;
import dataservice.ConstantDataService;

public class ConstantDataService_Driver {
	public void drive(ConstantDataService constantdataservice){
		Map<String,Double> map = new HashMap<String,Double>();
		map.put("南京-北京", 900.0);
		ConstantPO po = new ConstantPO();
		
		try {
			constantdataservice.delete(po);
			constantdataservice.getConstantPO();
			constantdataservice.insert(po);
			constantdataservice.update(po);
			constantdataservice.finish();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
