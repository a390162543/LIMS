package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.RevenuePO;

public interface RevenueDataService extends Remote{
    
    public void insert(RevenuePO po) throws RemoteException;
    
    public void update(RevenuePO po) throws RemoteException;
    
    public RevenuePO find(String id) throws RemoteException;
       
    public List<RevenuePO> finds(String field, Object value) throws RemoteException;
        
    public List<RevenuePO> getAll() throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 

}
