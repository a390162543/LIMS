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
		
		long storeinId = new Long("0250151025000001");
		long transferId = new Long("02501510250000001");
		List<Long> orderId= new ArrayList<Long>();
		List<String> destination = new ArrayList<String>();
		List<ShipForm> shipForm = new ArrayList<ShipForm>();
		orderId.add(new Long("1025000001"));
		destination.add("南京市栖霞区中转中心");
		shipForm.add(ShipForm.CAR);
		
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
				if(StoreoutPOs.get(i).getDestination().get(i).equals(destination.get(i)))
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
