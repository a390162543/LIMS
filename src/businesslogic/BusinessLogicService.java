package businesslogic;

import businesslogic.accountbl.Account;
import businesslogic.approvalbl.Approval;
import businesslogic.arrivalbl.Arrival;
import businesslogic.citybl.City;
import businesslogic.constantbl.Constant;
import businesslogic.deliverbl.Deliver;
import businesslogic.employeebl.Employee;
import businesslogic.loadbl.Load;
import businesslogic.logbl.Log;
import businesslogic.orderbl.Order;
import businesslogic.organizationbl.Organization;
import businesslogic.paybl.Pay;
import businesslogic.paymentbl.Payment;
import businesslogic.primeinfobl.PrimeInfo;
import businesslogic.revenuebl.Revenue;
import businesslogic.settlementbl.Settlement;
import businesslogic.statisticsbl.Statistics;
import businesslogic.storagebl.Storage;
import businesslogic.storeinbl.Storein;
import businesslogic.storeoutbl.Storeout;
import businesslogic.transferbl.Transfer;
import businesslogic.truckbl.Truck;
import businesslogic.userbl.User;
import businesslogicservice.AccountblService;
import businesslogicservice.ApprovalblService;
import businesslogicservice.ArrivalblService;
import businesslogicservice.CityblService;
import businesslogicservice.ConstantblService;
import businesslogicservice.DeliverblService;
import businesslogicservice.EmployeeblService;
import businesslogicservice.LoadblService;
import businesslogicservice.LogblService;
import businesslogicservice.OrderblService;
import businesslogicservice.OrganizationblService;
import businesslogicservice.PayblService;
import businesslogicservice.PaymentblService;
import businesslogicservice.PrimeInfoblService;
import businesslogicservice.RevenueblService;
import businesslogicservice.SettlementblService;
import businesslogicservice.StatisticsblService;
import businesslogicservice.StorageblService;
import businesslogicservice.StoreinblService;
import businesslogicservice.StoreoutblService;
import businesslogicservice.TransferblService;
import businesslogicservice.TruckblService;
import businesslogicservice.UserblService;

public class BusinessLogicService {
    
    public static AccountblService getAccountblService(){
        return new Account();
    }
    
    public static ApprovalblService getApprovalblService(){
        return new Approval();
    }
    
    public static ArrivalblService getArrivalblService(){
        return new Arrival();
    }
    
    public static CityblService getcCityblService(){
        return new City();
    }
    
    public static ConstantblService getConstantblService(){
        return new Constant();
    }
    
    public static DeliverblService getDeliverblService(){
        return new Deliver();
    }
    
    public static EmployeeblService getEmployeeblService(){
        return new Employee();
    }
    
    public static LoadblService getLoadblService(){
        return new Load();
    }
    
    public static LogblService getLogblService(){
        return new Log();
    }
    
    public static OrderblService getOrderblService(){
        return new Order();
    }
    
    public static OrganizationblService getOrganizationblService(){
        return new Organization();
    }
    
    public static PayblService getPayblService(){
        return new Pay();
    }
    
    public static PaymentblService getPaymentblService(){
        return new Payment();
    }
    
    public static PrimeInfoblService getPrimeInfoblService(){
        return new PrimeInfo();
    }
    
    public static RevenueblService getRevenueblService(){
        return new Revenue();
    }
    
    public static SettlementblService getSettlementblService(){
        return new Settlement();
    }
    
    public static StatisticsblService getStatisticsblService(){
        return new Statistics();
    }
    
    public static StorageblService getStorageblService(){
        return new Storage();
    }
    
    public static StoreinblService getStoreinblService(){
        return new Storein();
    }
    
    public static StoreoutblService getStoreoutblService(){
        return new Storeout();
    }
    
    public static TransferblService getTransferblService(){
        return new Transfer();
    }
    
    public static TruckblService getTruckblService(){
        return new Truck();
    }
    
    public static UserblService getUserblService(){
        return new User();
    }
    
    
    
    
    
    
    
}
