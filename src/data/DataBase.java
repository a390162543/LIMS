package data;

import java.rmi.RemoteException;

import dataservice.CityDataService;
import dataservice.ConstantDataService;
import dataservice.DeliverDataService;
import dataservice.EmployeeDataService;
import dataservice.IdDataService;
import dataservice.LoadDataService;
import dataservice.LogDataService;
import dataservice.OrderDataService;
import dataservice.OrganizationDataService;
import dataservice.PaymentDataService;
import dataservice.PrimeInfoDataService;
import dataservice.RevenueDataService;
import dataservice.StorageDataService;
import dataservice.StorageLocationDataService;
import dataservice.StoreinDataService;
import dataservice.StoreoutDataService;
import dataservice.TransferDataService;
import dataservice.TruckDataService;
import dataservice.UserDataService;

public class DataBase {
    
    public static void initDataBase(){
        try {
            AccountData accountData = new AccountData();
            ArrivalData arrivalData = new ArrivalData();
            CityDataService cityData = new CityData();
            ConstantDataService constantData = new ConstantData();
            DeliverDataService deliverData = new DeliverData();
            EmployeeDataService employeeData = new EmployeeData() ;
            IdDataService idData = new IdData();
            LoadDataService loadData = new LoadData();
            LogDataService logData = new LogData();
            OrderDataService orderData = new OrderData();
            OrganizationDataService organizationData = new OrganizationData();
            PaymentDataService paymentData = new PaymentData();
            PrimeInfoDataService primeInfoData = new PrimeInfoData();
            RevenueDataService revenueData = new RevenueData();
            StorageDataService storageData = new StorageData();
            StorageLocationDataService storageLocationData = new StorageLocationData();
            StoreinDataService storeinData = new StoreinData();     
            StoreoutDataService storeoutData = new StoreoutData();
            TransferDataService transferData = new TransferData();
            TruckDataService truckData = new TruckData();
            UserDataService userData = new UserData();
            accountData.init();
            arrivalData.init();
            cityData.init();
            constantData.init();
            deliverData.init();
            employeeData.init();
            idData.init();
            loadData.init();
            logData.init();
            orderData.init();
            organizationData.init();
            paymentData.init();
            primeInfoData.init();
            revenueData.init();
            storageData.init();
            storageLocationData.init();
            storeinData.init();
            storeoutData.init();
            transferData.init();
            truckData.init();
            userData.init();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
