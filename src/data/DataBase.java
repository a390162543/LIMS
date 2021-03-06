package data;

import java.rmi.RemoteException;

import data.CityData;
import data.ConstantData;
import data.DeliverData;
import data.EmployeeData;
import data.LoadData;
import data.LogData;
import data.OrderData;
import data.OrganizationData;
import data.PaymentData;
import data.PrimeInfoData;
import data.RevenueData;
import data.StorageData;
import data.StorageLocationData;
import data.StoreinData;
import data.StoreoutData;
import data.TransferData;
import data.TruckData;
import data.UserData;

/**
 * {@code Database}提供了初始化数据层服务的方法
 * @author 林祖华
 * @version 1.0
 */
public class DataBase {
    
    /**
     * 初始化数据层服务
     */
    public static void initDataBase(){
        try {
            AccountData accountData = new AccountData();
            ArrivalData arrivalData = new ArrivalData();
            CityData cityData = new CityData();
            ConstantData constantData = new ConstantData();
            DeliverData deliverData = new DeliverData();
            EmployeeData employeeData = new EmployeeData();
            LoadData loadData = new LoadData();
            LogData logData = new LogData();
            OrderData orderData = new OrderData();
            OrganizationData organizationData = new OrganizationData();
            PaymentData paymentData = new PaymentData();
            PrimeInfoData primeInfoData = new PrimeInfoData();
            RevenueData revenueData = new RevenueData();
            StorageData storageData = new StorageData();
            StorageLocationData storageLocationData = new StorageLocationData();
            StoreinData storeinData = new StoreinData();     
            StoreoutData storeoutData = new StoreoutData();
            TransferData transferData = new TransferData();
            TruckData truckData = new TruckData();
            UserData userData = new UserData();
            accountData.init();
            arrivalData.init();
            cityData.init();
            constantData.init();
            deliverData.init();
            employeeData.init();
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
            System.out.println("数据层服务已启动");
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            System.out.println("数据层服务启动失败");
            e.printStackTrace();
        }
    }
}
