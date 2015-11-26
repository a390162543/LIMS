package data;

 
import java.rmi.RemoteException;




 















import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import presentation.mainui.MainFrame;
 
import dataservice.AccountDataService;
import dataservice.ArrivalDataService;
import dataservice.CityDataService;
import dataservice.ConstantDataService;
import dataservice.DeliverDataService;
import dataservice.EmployeeDataService;
import dataservice.LoadDataService;
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

public class Main_tester {
	public static void main(String[] args) {
		
		   try
		    {
		                BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
		        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		    }
		    catch(Exception e)
		    {
		        //TODO exception
		    }
		try {
			EmployeeDataService e = new EmployeeData() ;
			e.init();
			OrganizationDataService o = new OrganizationData();
			o.init();
			ConstantDataService c = new ConstantData();
			c.init();
			CityDataService city = new CityData();
			city.init();
			UserDataService userDataService = new UserData();
			userDataService.init();
			AccountDataService accountDataService = new AccountData();
			accountDataService.init();
			ArrivalDataService arrivalDataService = new ArrivalData();
			arrivalDataService.init();
			DeliverDataService deliverDataService = new DeliverData();
			deliverDataService.init();
			LoadDataService loadDataService = new LoadData();
			loadDataService.init();
			OrderDataService orderDataService = new OrderData();
			orderDataService.init();
			PaymentDataService paymentDataService = new PaymentData();
			paymentDataService.init();
			PrimeInfoDataService primeInfoDataService = new PrimeInfoData();
			primeInfoDataService.init();
			RevenueDataService revenueDataService = new RevenueData();
			revenueDataService.init();
			StorageDataService storageDataService = new StorageData();
			storageDataService.init();
			StoreinDataService storeinDataService = new StoreinData();
			storeinDataService.init();
			StoreoutDataService storeoutDataService = new StoreoutData();
			storeoutDataService.init();
			TransferDataService transferDataService = new TransferData();
			transferDataService.init();
			TruckDataService truckDataService = new TruckData();
			truckDataService.init();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new MainFrame(); 	 
	} 

}

