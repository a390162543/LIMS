package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.TruckPO;

public interface TruckDataService extends DataIdentifiable,Remote{
    
    public void insert(TruckPO po) throws RemoteException;
    
    public void delete(TruckPO po) throws RemoteException;
    
    public void update(TruckPO po) throws RemoteException;
    
    public TruckPO find(String id) throws RemoteException;

    public List<TruckPO> finds(String field, Object value) throws RemoteException;

    public List<TruckPO> getAll() throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 
    
}
