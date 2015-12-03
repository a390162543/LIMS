package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import data.IdData;

public interface DataIdentifiable extends Remote{
    
    default IdDataService getIdDataService() throws RemoteException {
        return new IdData(this);
    };
    
    public boolean isAvailable(String id) throws RemoteException;
    
}
