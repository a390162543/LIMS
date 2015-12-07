package dataservice;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.AccountDataService;
import dataservice.ApprovalDataService;
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
 * @version 1.2
 */
public class DataService {
    
    public static AccountDataService getAccountDataService(){
        try {
            return (AccountDataService) Naming.lookup("rmi://localhost/AccountData");
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
    
    public static ApprovalDataService getApprovalDataService(){
        try {
            return (ApprovalDataService) Naming.lookup("rmi://localhost/ApprovalData");
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
            return (ArrivalDataService) Naming.lookup("rmi://localhost/ArrivalData");
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
            return (CityDataService) Naming.lookup("rmi://localhost/CityData");
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
            return (ConstantDataService) Naming.lookup("rmi://localhost/ConstantData");
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
            return (DeliverDataService) Naming.lookup("rmi://localhost/DeliverData");
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
            return (EmployeeDataService) Naming.lookup("rmi://localhost/EmployeeData");
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
            return (LoadDataService) Naming.lookup("rmi://localhost/LoadData");
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
            return (LogDataService) Naming.lookup("rmi://localhost/LogData");
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
            return (OrderDataService) Naming.lookup("rmi://localhost/OrderData");
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
            return (OrganizationDataService) Naming.lookup("rmi://localhost/OrganizationData");
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
            return (PaymentDataService) Naming.lookup("rmi://localhost/PaymentData");
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
            return (PrimeInfoDataService) Naming.lookup("rmi://localhost/PrimeInfoData");
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
            return (RevenueDataService) Naming.lookup("rmi://localhost/RevenueData");
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
            return (StorageDataService) Naming.lookup("rmi://localhost/StorageData");
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
            return (StoreinDataService) Naming.lookup("rmi://localhost/StoreinData");
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
            return (StorageLocationDataService) Naming.lookup("rmi://localhost/StorageLocationData");
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
            return (StoreoutDataService) Naming.lookup("rmi://localhost/StoreoutData");
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
            return (TransferDataService) Naming.lookup("rmi://localhost/TransferData");
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
            return (TruckDataService) Naming.lookup("rmi://localhost/TruckData");
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
            return (UserDataService) Naming.lookup("rmi://localhost/UserData");
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
            return (IdDataService) Naming.lookup("rmi://localhost/IdData");
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
}
