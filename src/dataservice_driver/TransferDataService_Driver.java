package dataservice_driver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dataservice.TransferDataService;
import po.TransferPO;

public class TransferDataService_Driver {
	public void drive(TransferDataService transferdataservice){
		List<Long> l = new ArrayList<Long>();
		l.add(new Long("1088336612"));
		TransferPO po = new TransferPO(new Long("02501601120000001"), new Date(),
				new Long("10240010001"), "南京市栖霞区中转中心",
				"上海市浦东新区中转中心" ,
				new Long("1025"), "李华", l, 300.0);
		
		try {
			transferdataservice.delete(po);
			transferdataservice.find(new Long("02501601120000001"));
			transferdataservice.finds("日期", new Date());
			transferdataservice.getAll();
			transferdataservice.insert(po);
			transferdataservice.update(po);
			transferdataservice.finish();
			} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
