package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.PayPO;

public interface PayDataService {
	    public void insert(PayPO po) throws RemoteException;
	    
	    public void delete(PayPO po) throws RemoteException;
	    
	    public void update(PayPO po) throws RemoteException;
	 
	    public void finish() throws RemoteException; 

}
