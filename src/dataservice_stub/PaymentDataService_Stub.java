package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.AccountPO;
import po.ApprovalPO;
import po.PaymentPO;
import dataservice.AccountDataService;
import dataservice.PaymentDataService;

public class PaymentDataService_Stub implements PaymentDataService{
	
	PaymentPO po;
	
	public PaymentDataService_Stub(PaymentPO po){
		this.po=po;
	}

	public void insert(PaymentPO po) throws RemoteException {
		System.out.println("Insert Succeed!\n");
	}

	public void update(PaymentPO po) throws RemoteException {
		System.out.println("Update Succeed!\n");
	}

	public PaymentPO find(long id) throws RemoteException {
		System.out.println("find Succeed!\n");
		return po;
	}

	public List<PaymentPO> finds(String field, Object value)
			throws RemoteException {
		System.out.println("finds Succeed!\n");
		List<PaymentPO> list=new ArrayList<PaymentPO>();
		list.add(po);
		return list;
	}

	public void init() throws RemoteException {
		System.out.println("Init Succeed!\n");
	}

	public void finish() throws RemoteException {
		System.out.println("Finished!\n");
	}
	

}
