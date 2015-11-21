package dataservice_driver;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import dataservice.PaymentDataService;
import po.PaymentPO;
import systemenum.Entry;



public class PaymentDataService_Driver {

	public void drive(PaymentDataService paymentDataService){
		PaymentPO po=new PaymentPO("0002116"
				+ "0112000001",new Date() , 30.00, "zhang", "1000000000000000000","1000000000000000000", Entry.AWARDS, "yes");
		try {
			paymentDataService.init();
			paymentDataService.insert(po);
			paymentDataService.update(po);
			PaymentPO poFound =paymentDataService.find("00021160112000001");
	        if(poFound != null)
	            System.out.println("find succeed!");
	       
	        List<PaymentPO> pos = paymentDataService.finds("id", new Long("00021160112000001"));
	        System.out.println("get "+pos.size()+" PaymentPO!");
	
	        paymentDataService.finish();
	    } catch (RemoteException e) {
	        e.printStackTrace();
	    }
	}
}
