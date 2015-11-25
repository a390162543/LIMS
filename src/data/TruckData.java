package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.TruckPO;
import dataservice.TruckDataService;

public class TruckData extends UnicastRemoteObject implements TruckDataService {

    /**
     * 
     */
    private static final long serialVersionUID = 1681492939084373146L;

    protected TruckData() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void insert(TruckPO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);
    }

    @Override
    public void delete(TruckPO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        new File(path).delete();
    }

    @Override
    public void update(TruckPO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);
    }

    @Override
    public TruckPO find(String id) throws RemoteException {
        String fileName = id;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        File file = new File(path);
        if(file.exists()){
            TruckPO po = (TruckPO) DataUtil.readObject(file.getAbsolutePath());
            return po;
        }else{
            return null;
        }
    }

    @Override
    public List<TruckPO> finds(String field, Object value)
            throws RemoteException {
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
        List<TruckPO> truckPOs = new ArrayList<TruckPO>();
        
        File[] files = DataUtil.getAll(path);
        for(File f : files){
            TruckPO po = (TruckPO)DataUtil.readObject(f.getAbsolutePath());
            switch (field) {
            case "organization":
                if(po.getOrganization().equals(value)){
                    truckPOs.add(po);
                }
                break;
            default:
            }
        }
        return truckPOs;
    }

    @Override
    public List<TruckPO> getAll() throws RemoteException {
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
        List<TruckPO> pos = new ArrayList<TruckPO>();
        try{
            File[] files = DataUtil.getAll(path);
            for(File f : files){
                TruckPO po = (TruckPO) DataUtil.readObject(f.getAbsolutePath());
                pos.add(po);
            }
        }catch(NullPointerException e){
            return pos;
        }
        return pos;
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
