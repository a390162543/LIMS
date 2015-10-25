package dataservice_stub;

import java.rmi.RemoteException;
 





import po.PayPO;
import dataservice.PayDataService;

public class PayDataService_Stub implements PayDataService{

	@Override
	public void insert(PayPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed");
	}

	@Override
	public void delete(PayPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Detele Succeed");
	}

	@Override
	public void update(PayPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed");
	}

	@Override
	 
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Succeed");
	}

}
