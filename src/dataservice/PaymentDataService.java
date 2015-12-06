package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import po.PaymentPO;

public interface PaymentDataService extends DataIdentifiable, Remote{
	
	public void insert(PaymentPO po) throws RemoteException;
	
	public void update(PaymentPO po) throws RemoteException;
	
	public PaymentPO find(String id) throws RemoteException;
	
	public List<PaymentPO> finds(String field, Object value) throws RemoteException;
	
	public void init() throws RemoteException;
    
	public void finish() throws RemoteException;
}
