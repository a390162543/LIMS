package dataservice_driver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.AccountPO;
import po.EmployeePO;
import po.OrganizationPO;
import po.PayPO;
import po.PrimeInfoPO;
import po.StoragePO;
import po.TruckPO;
import systemenum.Position;
import systemenum.Sex;
import dataservice.PrimeInfoDataService;

public class PrimeInfoDataService_Driver {
	
	public void drive(PrimeInfoDataService primeInfoDataService){
		List<OrganizationPO> organizationPOList= new ArrayList<OrganizationPO>();
		organizationPOList.add(new OrganizationPO("025001", "南京市鼓楼区营业厅", "南京市"));
		List<EmployeePO> employeePOList= new ArrayList<EmployeePO>();
		employeePOList.add(new EmployeePO("025001001", "李华",
				"南京市栖霞区中转中心", Position.COURIER, "18355555555",
				new Date(), "350232230230230230", Sex.FAMALE, new PayPO(1.0,1.0,1,11.0,1.0), new Date(),"aasf"));
		List<TruckPO> truckPOList= new ArrayList<TruckPO>();
		truckPOList.add(new TruckPO(new String("025001014"), "EA043247", "苏A·88888", "EA162736", new Date(), null));
		List<StoragePO> storagePOList= new ArrayList<StoragePO>();
		storagePOList.add(new StoragePO(10, 50, 90, 50, 2000000, 1000000, 0.85, 
				new Date(2015, 10, 29, 13, 50),new String("0011503480")));
		List<AccountPO> accountPOList= new ArrayList<AccountPO>();
		accountPOList.add(new AccountPO("2000000000002345678", "2000000000002345678",100.00));
		
		PrimeInfoPO po=new PrimeInfoPO(organizationPOList, employeePOList, truckPOList,storagePOList, accountPOList);
		try {
			primeInfoDataService.init();
			primeInfoDataService.insert(po);

	        List<PrimeInfoPO> allPO = primeInfoDataService.getAll();
	        System.out.println("get "+allPO.size()+" PrimeInfoPO!");
	        
	        primeInfoDataService.finish();
	    } catch (RemoteException e) {
	        e.printStackTrace();
	    }
	}

}
