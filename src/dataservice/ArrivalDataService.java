package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;

public interface ArrivalDataService {
    
    public boolean insert(ArrivalPO po) throws RemoteException;
    
    public boolean delete(ArrivalPO po) throws RemoteException;
    
    public boolean update(ArrivalPO po) throws RemoteException;
    
    public ArrivalPO find(long id) throws RemoteException;
    
    public List<ArrivalPO> finds(String field, Object value) throws RemoteException;
    
    public List<ArrivalPO> getAll() throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 

}
