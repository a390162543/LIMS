package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.RevenuePO;

public interface RevenueDataService {
    
    public boolean insert(RevenuePO po) throws RemoteException;
    
    public boolean delete(RevenuePO po) throws RemoteException;
    
    public boolean update(RevenuePO po) throws RemoteException;
    
    public RevenuePO find(long id) throws RemoteException;
    
    public List<RevenuePO> finds(String field, Object value) throws RemoteException;
    
    public List<RevenuePO> getAll() throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 

}
