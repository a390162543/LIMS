package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IdDataService extends Remote{
    
    public String getArrivalId(String tag) throws RemoteException;
    
    public boolean updateArrivalId(String tag, String id) throws RemoteException;
    
    public String getDeliverId(String tag) throws RemoteException;
    
    public boolean updateDeliverId(String tag, String id) throws RemoteException;
    
    public String getLoadId(String tag) throws RemoteException;
    
    public boolean updateLoadId(String tag, String id) throws RemoteException;
    
    public String getRevenueId(String tag) throws RemoteException;
    
    public boolean updateRevenueId(String tag, String id) throws RemoteException;
    
    public String getTruckId(String tag) throws RemoteException;
    
    public boolean updateTruckId(String tag, String id) throws RemoteException;
    
    
    public void init() throws RemoteException;
    
    public void finish() throws RemoteException; 
    
}
