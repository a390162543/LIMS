package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.CityPO;
import dataservice.CityDataService;
 
 

public class CityData extends UnicastRemoteObject implements CityDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8423183515411226659L;

	protected CityData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	 

	@Override
	public void insert(CityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		 String fileName = po.getId();
	     String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
	     DataUtil.writeObject(po, path);
	}

	@Override
	public void delete(CityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		 String fileName = po.getId();
	     String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
	     new File(path).delete();
	}

	@Override
	public void update(CityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		 String fileName = po.getId();
	     String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
	     DataUtil.writeObject(po, path);
	}
 
	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		  CityDataService cds = new CityData();
	        try {
	            LocateRegistry.createRegistry(1099);
	        } catch (Exception e) {
	        }

	        try {
	            Naming.rebind("rmi://localhost/"+cds.getClass().getSimpleName(), cds);
	        } catch (MalformedURLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        System.out.println("Server is on.");
	}


	@Override
	public CityPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		String fileName = String.format("%03d", id);
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		CityPO po =(CityPO) DataUtil.readObject(path);
		return po;
	}


	@Override
	public List<CityPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		 String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
	      List<CityPO> pos = new ArrayList<CityPO>();
	        try{
	            File[] files = DataUtil.getAll(path);
	            for(File f : files){
	                CityPO po = (CityPO) DataUtil.readObject(f.getAbsolutePath());
	                pos.add(po);
	            }
	        }catch(NullPointerException e){
	            return pos;
	        }
	        return pos;
	}


	@Override
	public CityPO findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		List<CityPO> pos = getAll();
		for(CityPO po : pos){
			if(po.getName().equals(name))
				return po;
		}
		return null;
	}


	@Override
	public String getId(String name) throws RemoteException {
		// TODO Auto-generated method stub
		if(findByName(name) == null){
			return null;
		}
		else{
			String id = findByName(name).getId();
			return id;
		}
		
	}

}
