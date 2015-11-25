package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import dataservice.IdDataService;

public class IdData extends UnicastRemoteObject implements IdDataService{

    /**
     * 
     */
    private static final long serialVersionUID = -4036320556350764141L;

    protected IdData() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getArrivalId(String tag) throws RemoteException {
        String fileName = tag;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/ArrivalData/"+fileName+".ser";
        File file = new File(path);
        if(file.exists()){
            return read(path);
        }else{
            return "";
        }
    }

    @Override
    public boolean updateArrivalId(String tag, String id) throws RemoteException {
        String fileName = tag;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/ArrivalData/"+fileName+".ser";
        write(path, id);
        return true;
    }
    
    @Override
    public String getDeliverId(String tag) throws RemoteException {
        String fileName = tag;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/DeliverData/"+fileName+".ser";
        File file = new File(path);
        if(file.exists()){
            return read(path);
        }else{
            return "";
        }
    }

    @Override
    public boolean updateDeliverId(String tag, String id){
        String fileName = tag;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/DeliverData/"+fileName+".ser";
        write(path, id);
        return true;
    }

    @Override
    public String getLoadId(String tag) throws RemoteException {
        String fileName = tag;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/LoadData/"+fileName+".ser";
        File file = new File(path);
        if(file.exists()){
            return read(path);
        }else{
            return "";
        }
    }

    @Override
    public boolean updateLoadId(String tag, String id) throws RemoteException {
        String fileName = tag;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/LoadData/"+fileName+".ser";
        write(path, id);
        return true;
    }

    @Override
    public String getRevenueId(String tag) throws RemoteException {
        String fileName = tag;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/RevenueData/"+fileName+".ser";
        File file = new File(path);
        if(file.exists()){
            return read(path);
        }else{
            return "";
        }
    }

    @Override
    public boolean updateRevenueId(String tag, String id)
            throws RemoteException {
        String fileName = tag;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/RevenueData/"+fileName+".ser";
        write(path, id);
        return true;
    }

    @Override
    public String getTruckId(String tag) throws RemoteException {
        String fileName = tag;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/TruckData/"+fileName+".ser";
        File file = new File(path);
        if(file.exists()){
            return read(path);
        }else{
            return "";
        }
    }

    @Override
    public boolean updateTruckId(String tag, String id) throws RemoteException {
        String fileName = tag;
        String path = "c:/LIMS/database/"+this.getClass().getSimpleName()+"/TruckData/"+fileName+".ser";
        write(path, id);
        return true;
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
            e.printStackTrace();
        }
    }

    @Override
    public void finish() throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    private static String read(String filePath){
        File file = new File(filePath);
        if(!file.exists())
            return "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            br.close();
            return line;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
    
    private static boolean write(String filePath, String str){
        File file = new File(filePath);
        if(!file.exists())
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }



}
