package dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.OrganizationPO;

public interface OrganizationDataService {
	 public void insert(OrganizationPO po) throws RemoteException;
	    
	    public void delete(OrganizationPO po) throws RemoteException;
	    
	    public void update(OrganizationPO po) throws RemoteException;
	    
	    public OrganizationPO find(long id) throws RemoteException;
	    
	    public List<OrganizationPO> finds(String field, Object value) throws RemoteException;
	    
	    public List<OrganizationPO> getAll() throws RemoteException;
	    
	    public void finish() throws RemoteException; 

}
