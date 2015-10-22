package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.LoadPO;

public interface LoadDataService {
    
    public void insert(LoadPO po) throws RemoteException;
    
    public void delete(LoadPO po) throws RemoteException;
    
    public void update(LoadPO po) throws RemoteException;
    
    public LoadPO find(long id) throws RemoteException;
    
    public List<LoadPO> finds(String field, Object value) throws RemoteException;
    
    public List<LoadPO> getAll() throws RemoteException;
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 

}
