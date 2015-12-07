package data;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.ArrivalPO;
import dataservice.ArrivalDataService;

/**
 * {@code ArrivalData}是到达单数据层服务的实现类
 * @author 林祖华
 * @version 1.4
 */
public class ArrivalData extends UnicastRemoteObject implements ArrivalDataService {

    /**
     * 
     */
    private static final long serialVersionUID = 9010705082165879966L;
    
    protected ArrivalData() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void insert(ArrivalPO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);
    }

    @Override
    public void update(ArrivalPO po) throws RemoteException {
        String fileName = po.getId();
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        DataUtil.writeObject(po, path);
    }

    @Override
    public ArrivalPO find(String id) throws RemoteException {
        String fileName = id;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/"+fileName+".ser";
        File file = new File(path);
        if(file.exists()){
            ArrivalPO po = (ArrivalPO) DataUtil.readObject(file.getAbsolutePath());
            return po;
        }else{
            return null;
        }
    }

    @Override
    public List<ArrivalPO> finds(String field, Object value)
            throws RemoteException {
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName();
        List<ArrivalPO> arrivalPOs = new ArrayList<ArrivalPO>();
        
        File[] files = DataUtil.getAll(path);
        if(files != null){
            for(File f : files){
                ArrivalPO po = (ArrivalPO)DataUtil.readObject(f.getAbsolutePath());
                switch (field) {
                case "documentState":
                    if(po.getDocumentState().equals(value)){
                        arrivalPOs.add(po);
                    }
                    break;
                default:
                }
            }
        }
        return arrivalPOs;
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
