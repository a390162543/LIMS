package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.AccountPO;
import po.ApprovalPO;
import po.PaymentPO;

public interface PaymentDataService {
	
	public void insert(PaymentPO po) throws RemoteException;
	
	public void update(PaymentPO po) throws RemoteException;
	
	public PaymentPO find(long id) throws RemoteException;
	
	public List<PaymentPO> finds(String field, Object value) throws RemoteException;
	
	public void init() throws RemoteException;
    
	public void finish() throws RemoteException;
}
