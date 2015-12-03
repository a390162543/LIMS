package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.DeliverPO;
import dataservice.DeliverDataService;

public class DeliverData extends UnicastRemoteObject implements DeliverDataService {  

    /**
     * 
     */
    private static final long serialVersionUID = 7611473460575504707L;

    protected DeliverData() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void insert(DeliverPO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);
    }

    @Override
    public void update(DeliverPO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);
    }

    @Override
    public DeliverPO find(String id) throws RemoteException {
        String fileName = id;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        File file = new File(path);
        if(file.exists()){
            DeliverPO po = (DeliverPO) DataUtil.readObject(file.getAbsolutePath());
            return po;
        }else{
            return null;
        }
    }

    @Override
    public List<DeliverPO> finds(String field, Object value)
            throws RemoteException {
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
        List<DeliverPO> deliverPOs = new ArrayList<DeliverPO>();
        
        File[] files = DataUtil.getAll(path);
        for(File f : files){
            DeliverPO po = (DeliverPO)DataUtil.readObject(f.getAbsolutePath());
            switch (field) {
            case "documentState":
                if(po.getDocumentState().equals(value)){
                    deliverPOs.add(po);
                }
                break;
            default:
            }
        }
            
        return deliverPOs;
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

    @Override
    public boolean isAvailable(String id) throws RemoteException {
        return find(id) == null;
    }
    
}
