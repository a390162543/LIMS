package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.PayPO;

public interface PayDataService {
	 public void insert(PayPO po) throws RemoteException;
	    
	    public void delete(PayPO po) throws RemoteException;
	    
	    public void update(PayPO po) throws RemoteException;
	    
	    public PayPO find(long id) throws RemoteException;
	    
	    public List<PayPO> finds(String field, Object value) throws RemoteException;
	    
	    public List<PayPO> getAll() throws RemoteException;
	    
	    public void init() throws RemoteException;
	    
	    public void finish() throws RemoteException; 

}
