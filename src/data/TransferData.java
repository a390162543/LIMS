package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

 
import po.TransferPO;
 
import dataservice.TransferDataService;

public class TransferData extends UnicastRemoteObject implements TransferDataService{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1323252719430911624L;

	protected TransferData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String fileName = po.getId();
	     String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
	     DataUtil.writeObject(po, path);
	}

	@Override
	public void delete(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        new File(path).delete();
	}

	@Override
	public void update(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		 String fileName = po.getId();
	     String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
	     DataUtil.writeObject(po, path);
	}

	@Override
	public TransferPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		String fileName = id;
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
		TransferPO po = (TransferPO)DataUtil.readObject(path);
		return po;
	}

	@Override
	public List<TransferPO> finds(String field, Object value)throws RemoteException {
		// TODO Auto-generated method stub
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
        List<TransferPO> pos = new ArrayList<TransferPO>();
        try{
            File[] files = DataUtil.getAll(path);
            for(File f : files){
                TransferPO po = (TransferPO) DataUtil.readObject(f.getAbsolutePath());
                switch (field) {
                case "documentState": 
                	if(po.getDocumentState().equals(value))
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
	public List<TransferPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
        List<TransferPO> pos = new ArrayList<TransferPO>();
        try{
            File[] files = DataUtil.getAll(path);
            for(File f : files){
                TransferPO po = (TransferPO) DataUtil.readObject(f.getAbsolutePath());
                pos.add(po);
            }
        }catch(NullPointerException e){
            return pos;
        }
        return pos;
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		TransferDataService tds = new TransferData();
        try {
            LocateRegistry.createRegistry(1099);
        } catch (Exception e) {
        }

        try {
            Naming.rebind("rmi://localhost/"+tds.getClass().getSimpleName(),   tds);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Server is on.");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
