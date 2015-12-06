package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.OrderPO;

public interface OrderDataService extends DataIdentifiable,Remote{
	
	public void insert(OrderPO po) throws RemoteException;
    	
    public void update(OrderPO po) throws RemoteException;
    
    public OrderPO find(String id) throws RemoteException;
    
    public List<OrderPO> finds(String field, Object value) throws RemoteException;
    
    public List<OrderPO> getAll() throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 
}
