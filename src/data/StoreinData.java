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

import po.StoreinPO;
import systemenum.DocumentState;
import dataservice.StoreinDataService;

public class StoreinData extends UnicastRemoteObject implements StoreinDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3640418178675991082L;


	/**
	 * 
	 */
	
	

	protected StoreinData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(StoreinPO po) throws RemoteException {
		String fileName = po.getStoreinId();
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		DataUtil.writeObject(po, path);
	}

	@Override
	public void update(StoreinPO po) throws RemoteException {
		String fileName = po.getStoreinId();
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		DataUtil.writeObject(po, path);	
	}

	@Override
	public StoreinPO find(String id) throws RemoteException {
		String fileName = id;
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		StoreinPO po = (StoreinPO) DataUtil.readObject(path);
		return po;
	}

	@Override
	public List<StoreinPO> finds(String field, Object value)
			throws RemoteException {
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
		List<StoreinPO> storeinPOs = new ArrayList<StoreinPO>();
		
		try{
			File[] files = DataUtil.getAll(path);
			for(File f : files){
				StoreinPO po = (StoreinPO)DataUtil.readObject(f.getAbsolutePath());
				switch (field) {
				case "id":
					
					break;
					
					
				case "date":
				{
					
					
					if (po.getInDate().compareTo((Date)value)>=0&&po.getDocumentState().equals(DocumentState.PASS)) {
						
						storeinPOs.add(po);
					}
				}
					break;
					
				case "destination":
					break;
					
				case "organization":
					if (po.getOrganization().equals((String)value)&&po.getDocumentState().equals(DocumentState.PASS)) {
						System.out.println(po.getDocumentState().toString());
						storeinPOs.add(po);
					}
					
					break;
					
				case "documentState":
					if (po.getDocumentState().equals((DocumentState)value)) {
						storeinPOs.add(po);
					}
				default:
					break;
				}
				
 		   	}
		}
		catch(NullPointerException e){
            return storeinPOs;
        }
		return storeinPOs;
	}

	@Override
	public List<StoreinPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		StoreinDataService storeinDataService = new StoreinData();
		try {
			LocateRegistry.createRegistry(1099);
		} catch (Exception e) {			
		}
		try {
			Naming.rebind("rmi://localhost/"+storeinDataService.getClass().getSimpleName(), storeinDataService);
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
