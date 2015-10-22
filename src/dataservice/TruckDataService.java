package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.TruckPO;

public interface TruckDataService {
    
    public boolean insert(TruckPO po) throws RemoteException;
    
    public boolean delete(TruckPO po) throws RemoteException;
    
    public boolean update(TruckPO po) throws RemoteException;
    
    public TruckPO find(long id) throws RemoteException;
    
    public List<TruckPO> finds(String field, Object value) throws RemoteException;
    
    public List<TruckPO> getAll() throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 

}
