package dataservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.AccountDataService;
import dataservice.ArrivalDataService;
import dataservice.CityDataService;
import dataservice.ConstantDataService;
import dataservice.DeliverDataService;
import dataservice.EmployeeDataService;
import dataservice.LoadDataService;
import dataservice.LogDataService;
import dataservice.OrderDataService;
import dataservice.OrganizationDataService;
import dataservice.PaymentDataService;
import dataservice.PrimeInfoDataService;
import dataservice.RevenueDataService;
import dataservice.StorageDataService;
import dataservice.StoreinDataService;
import dataservice.StoreoutDataService;
import dataservice.TransferDataService;
import dataservice.TruckDataService;
import dataservice.UserDataService;

/**
 * {@code DataService}是数据层服务的工厂，提供了获取所有数据层服务实例的静态方法
 * @author 林祖华
 * @version 1.4
 */
public class DataService {
    
    private static final String IP = readIP();
    
    public static AccountDataService getAccountDataService(){
        try {
            return (AccountDataService) Naming.lookup("rmi://"+IP+"/AccountData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrivalDataService getArrivalDataService(){
        try {
            return (ArrivalDataService) Naming.lookup("rmi://"+IP+"/ArrivalData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static CityDataService getcCityDataService(){
        try {
            return (CityDataService) Naming.lookup("rmi://"+IP+"/CityData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static ConstantDataService getConstantDataService(){
        try {
            return (ConstantDataService) Naming.lookup("rmi://"+IP+"/ConstantData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static DeliverDataService getDeliverDataService(){
        try {
            return (DeliverDataService) Naming.lookup("rmi://"+IP+"/DeliverData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static EmployeeDataService getEmployeeDataService(){
        try {
            return (EmployeeDataService) Naming.lookup("rmi://"+IP+"/EmployeeData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static LoadDataService getLoadDataService(){
        try {
            return (LoadDataService) Naming.lookup("rmi://"+IP+"/LoadData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static LogDataService getLogDataService(){
        try {
            return (LogDataService) Naming.lookup("rmi://"+IP+"/LogData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static OrderDataService getOrderDataService(){
        try {
            return (OrderDataService) Naming.lookup("rmi://"+IP+"/OrderData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static OrganizationDataService getOrganizationDataService(){
        try {
            return (OrganizationDataService) Naming.lookup("rmi://"+IP+"/OrganizationData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static PaymentDataService getPaymentDataService(){
        try {
            return (PaymentDataService) Naming.lookup("rmi://"+IP+"/PaymentData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static PrimeInfoDataService getPrimeInfoDataService(){
        try {
            return (PrimeInfoDataService) Naming.lookup("rmi://"+IP+"/PrimeInfoData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static RevenueDataService getRevenueDataService(){
        try {
            return (RevenueDataService) Naming.lookup("rmi://"+IP+"/RevenueData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static StorageDataService getStorageDataService(){
        try {
            return (StorageDataService) Naming.lookup("rmi://"+IP+"/StorageData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    

    
    public static StoreinDataService getStoreinDataService(){
        try {
            return (StoreinDataService) Naming.lookup("rmi://"+IP+"/StoreinData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static StorageLocationDataService getStorageLocationDataService(){
        try {
            return (StorageLocationDataService) Naming.lookup("rmi://"+IP+"/StorageLocationData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static StoreoutDataService getStoreoutDataService(){
        try {
            return (StoreoutDataService) Naming.lookup("rmi://"+IP+"/StoreoutData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static TransferDataService getTransferDataService(){
        try {
            return (TransferDataService) Naming.lookup("rmi://"+IP+"/TransferData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static TruckDataService getTruckDataService(){
        try {
            return (TruckDataService) Naming.lookup("rmi://"+IP+"/TruckData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static UserDataService getUserDataService(){
        try {
            return (UserDataService) Naming.lookup("rmi://"+IP+"/UserData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static IdDataService getIdDataService(){
        try {
            return (IdDataService) Naming.lookup("rmi://"+IP+"/IdData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    private static String readIP(){
        String filePath = "C:/LIMS/IP.ini";
        File file = new File(filePath);
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        if(!file.exists()){
            write(filePath, "127.0.0.1");
            return "localhost";
        }
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
        return "localhost";
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
