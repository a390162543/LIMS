package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


import po.AccountPO;

import dataservice.AccountDataService;

public class AccountData extends UnicastRemoteObject implements AccountDataService {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 2474946814549106980L;

	protected AccountData() throws RemoteException {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	@Override
	public void insert(AccountPO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);		
	}

	@Override
	public void delete(AccountPO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        new File(path).delete();	
	}

	@Override
	public void update(AccountPO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);			
	}

	@Override
	public AccountPO find(String id) throws RemoteException {
		String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+id+".ser";
		File file = new File(path);
		return (AccountPO) DataUtil.readObject(file.getAbsolutePath());
	}

	@Override
	public List<AccountPO> getAll() throws RemoteException {
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
        List<AccountPO> pos = new ArrayList<AccountPO>();
        try{
            File[] files = DataUtil.getAll(path);
            for(File f : files){
            	AccountPO po = (AccountPO) DataUtil.readObject(f.getAbsolutePath());
                pos.add(po);
            }
        }catch(NullPointerException e){
            return pos;
        }
        return pos;
	}

	@Override
	public void init() throws RemoteException {
		AccountDataService ads = new AccountData();
        try {
            LocateRegistry.createRegistry(1099);
        } catch (Exception e) {
        }

        try {
            Naming.rebind("rmi://localhost/"+ads.getClass().getSimpleName(), ads);
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
