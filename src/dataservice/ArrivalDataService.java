package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;

public interface ArrivalDataService {
    
    public void insert(ArrivalPO po) throws RemoteException;
    
    public void update(ArrivalPO po) throws RemoteException;
    
    public ArrivalPO find(long id) throws RemoteException;
       
    public List<ArrivalPO> finds(String field, Object value) throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 
    
}
