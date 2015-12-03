package dataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IdDataService extends Remote,Serializable{
    
    public String getId(String tag) throws RemoteException;
    
    public boolean updateId(String tag, String id) throws RemoteException;

}
