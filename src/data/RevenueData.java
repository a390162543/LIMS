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

import po.RevenuePO;
import dataservice.RevenueDataService;

public class RevenueData extends UnicastRemoteObject implements RevenueDataService {

    /**
     * 
     */
    private static final long serialVersionUID = 1681492939084373146L;
    
    protected RevenueData() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void insert(RevenuePO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);
    }

    @Override
    public void update(RevenuePO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);
    }

    @Override
    public RevenuePO find(String id) throws RemoteException {
        String fileName = id;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        File file = new File(path);
        if(file.exists()){
            RevenuePO po = (RevenuePO) DataUtil.readObject(file.getAbsolutePath());
            return po;
        }else{
            return null;
        }
    }

    @Override
    public List<RevenuePO> finds(String field, Object value)
            throws RemoteException {
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
        List<RevenuePO> revenuePOs = new ArrayList<RevenuePO>();
        
        File[] files = DataUtil.getAll(path);
        for(File f : files){
            RevenuePO po = (RevenuePO)DataUtil.readObject(f.getAbsolutePath());
            switch (field) {
            case "documentState":
                if(po.getDocumentState().equals(value)){
                    revenuePOs.add(po);
                }
                break;
            case "organization":
                if(po.getOrganization().equals(value)){
                    revenuePOs.add(po);
                }
                break;
            case "date" :
	        	if(po.getRevenueDate().after((Date)value)||po.getRevenueDate().equals((Date)value))
	        		revenuePOs.add(po);
	        	break;
            default:
            }
        }
            
        return revenuePOs;
    }

    @Override
    public List<RevenuePO> getAll() throws RemoteException {
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
        List<RevenuePO> pos = new ArrayList<RevenuePO>();
        try{
            File[] files = DataUtil.getAll(path);
            for(File f : files){
                RevenuePO po = (RevenuePO) DataUtil.readObject(f.getAbsolutePath());
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
