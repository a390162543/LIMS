package dataservice_driver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.StoreoutPO;
import systemenum.ShipForm;
import dataservice.StoreoutDataService;

public class StoreoutDataService_Driver {
	
	public void drive(StoreoutDataService storeoutDateService){
		
		String storeinId = new String("0250151025000001");
		String transferId = new String("02501510250000001");
		List<String> orderId= new ArrayList<String>();
		String destination;
		ShipForm shipForm;
		orderId.add(new String("1025000001"));
		destination = "南京市栖霞区中转中心";
		shipForm = ShipForm.CAR;
		
		StoreoutPO storeoutPO = new StoreoutPO(storeinId, orderId, new Date(), destination,shipForm,transferId);
		
		try {
			storeoutDateService.insert(storeoutPO);
			System.out.println("Succeed！");
		} catch (RemoteException e) {
			System.out.println("false");
			e.printStackTrace();
		}
		
		try {
			storeoutDateService.update(storeoutPO);
			System.out.println("Succeed！");
		} catch (RemoteException e) {
			System.out.println("false");
			e.printStackTrace();
		}
		
		try {
			StoreoutPO storeoutFindPO = storeoutDateService.find(storeinId);
			if(storeoutFindPO.getOrderId()==orderId)
				System.out.println("Succeed！");
		} catch (RemoteException e) {
			System.out.println("false");
			e.printStackTrace();
		}
		
		try {
			boolean result = true;
			List<StoreoutPO> StoreoutPOs = storeoutDateService.finds("destination", destination);
			for(int i=0;i<StoreoutPOs.size();i++){
				if(StoreoutPOs.get(i).getDestination().equals(destination))
					result = false;		
			}
			System.out.println(result);
		} catch (RemoteException e) {
			System.out.println(false);
			e.printStackTrace();
		}
		
		try {
			List<StoreoutPO> StoreoutPOs = storeoutDateService.getAll();
			System.out.println("Succcced");
		} catch (RemoteException e) {
			System.out.println(false);
			e.printStackTrace();
		}
		
		try {
			storeoutDateService.init();
			System.out.println(true);
		} catch (RemoteException e) {
			System.out.println(false);
			e.printStackTrace();
		}
		
		try {
			storeoutDateService.finish();
			System.out.println(true);
		} catch (RemoteException e) {
			System.out.println(false);
			e.printStackTrace();
		}
	}

}
