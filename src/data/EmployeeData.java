package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
 
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

 

import po.EmployeePO;
import dataservice.EmployeeDataService;
 

public class EmployeeData extends UnicastRemoteObject implements EmployeeDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7509178710283514242L;

	protected EmployeeData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(EmployeePO po) throws RemoteException {
		// TODO Auto-generated method stub
		 String fileName = po.getId();
	     String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
	     DataUtil.writeObject(po, path);
	}

	@Override
	public void delete(EmployeePO po) throws RemoteException {
		String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        new File(path).delete();
		
	}

	@Override
	public void update(EmployeePO po) throws RemoteException {
		// TODO Auto-generated method stub
		 String fileName = po.getId();
	     String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
	     DataUtil.writeObject(po, path);
	}

	@Override
	public EmployeePO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		String fileName = id;
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		File file = new File(path);
		if(file.exists()){
			EmployeePO po =(EmployeePO) DataUtil.readObject(path);
			return po;
		}
		else {
			return null;
		}
		
	}

	@Override
	public List<EmployeePO> finds(String field, Object value)throws RemoteException {
		// TODO Auto-generated method stub
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
	    List<EmployeePO> pos = new ArrayList<EmployeePO>();
	    try{
	    	File[] files = DataUtil.getAll(path);
	           for(File f : files){
	        	   EmployeePO po = (EmployeePO) DataUtil.readObject(f.getAbsolutePath());
	        	   switch(field){
	        	   case "organization":
	        		   if(po.getOrganization().equals(value))
	        			    pos.add(po);
	        		   break;
	        	  
	        	   }
	               
	            }
	        }catch(NullPointerException e){
	            return pos;
	        }
	        return pos;
	 
	}

	@Override
	public List<EmployeePO> getAll() throws RemoteException {
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
	    List<EmployeePO> pos = new ArrayList<EmployeePO>();
	    try{
	    	File[] files = DataUtil.getAll(path);
	           for(File f : files){
	        	   EmployeePO po = (EmployeePO) DataUtil.readObject(f.getAbsolutePath());
	                pos.add(po);
	            }
	        }catch(NullPointerException e){
	            return pos;
	        }
	        return pos;
	 
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		  
	        try {
	            LocateRegistry.createRegistry(1099);
	        } catch (Exception e) {
	        }

	        try {
	            Naming.rebind("rmi://localhost/"+this.getClass().getSimpleName(),  this);
	        } catch (MalformedURLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        System.out.println("Server is on.");
	}

	@Override
	public boolean isAvailable(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return find(id) == null;
	}

}
