package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.OrganizationPO;

public interface OrganizationDataService extends DataIdentifiable,Remote{
	 public void insert(OrganizationPO po) throws RemoteException;
	    
	    public void delete(OrganizationPO po) throws RemoteException;
	    
	    public void update(OrganizationPO po) throws RemoteException;
	    
	    public OrganizationPO find(String id) throws RemoteException;
	    
	    public List<OrganizationPO> finds(String field, Object value) throws RemoteException;
	    
	    public List<OrganizationPO> getAll() throws RemoteException;
	    
	    public void finish() throws RemoteException; 
	    
	    public void init() throws RemoteException ;
	    
	    public String getId(String name) throws RemoteException;

}
