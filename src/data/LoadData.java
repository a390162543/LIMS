package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import po.LoadPO;
import dataservice.LoadDataService;

public class LoadData extends UnicastRemoteObject implements LoadDataService {
  
    /**
     * 
     */
    private static final long serialVersionUID = -7790239601843261444L;

    protected LoadData() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void insert(LoadPO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);
    }

    @Override
    public void update(LoadPO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);
    }

    @Override
    public LoadPO find(String id) throws RemoteException {
        String fileName = id;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        File file = new File(path);
        if(file.exists()){
            LoadPO po = (LoadPO) DataUtil.readObject(file.getAbsolutePath());
            return po;
        }else{
            return null;
        }
    }

    @Override
    public List<LoadPO> finds(String field, Object value)
            throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void init() throws RemoteException {
        try {
            LocateRegistry.createRegistry(1099);
        } catch (Exception e) {
        }

        try {
            Naming.rebind("rmi://localhost/"+this.getClass().getSimpleName(), this);
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
