package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.StoreoutPO;
import systemenum.DocumentState;
import dataservice.StoreoutDataService;

public class StoreoutData extends UnicastRemoteObject implements StoreoutDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9009029709572980993L;



	protected StoreoutData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insert(StoreoutPO po) throws RemoteException {
		String fileName = po.getStoreoutId();
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		DataUtil.writeObject(po, path);
		return true;
		}

	@Override
	public boolean update(StoreoutPO po) throws RemoteException {
		String fileName = po.getStoreoutId();
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		DataUtil.writeObject(po, path);
		return true;
	}

	@Override
	public StoreoutPO find(String id) throws RemoteException {
		String fileName = id;
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		StoreoutPO po = (StoreoutPO) DataUtil.readObject(path);
		return po;
	}

	@Override
	public List<StoreoutPO> finds(String field, Object value)
			throws RemoteException {
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
		List<StoreoutPO> storeoutPOs = new ArrayList<StoreoutPO>();
		
		try{
			File[] files = DataUtil.getAll(path);
			for(File f : files){
				StoreoutPO po = (StoreoutPO)DataUtil.readObject(f.getAbsolutePath());
				switch (field) {
				case "id":
					
					break;
					
				case "documentState":
					if (po.getDocumentState().equals((DocumentState)value)) {
						storeoutPOs.add(po);
					}
					break;
					
				case "date":
					if (po.getDate().compareTo((Date)value)>=0&&po.getDocumentState().equals(DocumentState.PASS)) {
						storeoutPOs.add(po);
					}
					break;
					
				case "destination":
					break;
					
				case "organization":
					if (po.getOrganization().equals((String)value)&&po.getDocumentState().equals(DocumentState.PASS)) {
						storeoutPOs.add(po);	
					}
					break;
					
				default:
					break;
				}
				
 		   	}
		}
		catch(NullPointerException e){
            return storeoutPOs;
        }
		return storeoutPOs;
	}

	@Override
	public List<StoreoutPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() throws RemoteException {
		StoreoutDataService storeoutDataService = new StoreoutData();
		try {
			LocateRegistry.createRegistry(1099);
		} catch (Exception e) {			
		}
		try {
			Naming.rebind("rmi://localhost/"+storeoutDataService.getClass().getSimpleName(), storeoutDataService);
		} catch (MalformedURLException e) {
			
		}
		System.out.println("Server is on.");
	}
		

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAvailable(String id) throws RemoteException {
		return find(id) == null;
	}

}
