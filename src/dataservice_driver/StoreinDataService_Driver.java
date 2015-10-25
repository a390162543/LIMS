package dataservice_driver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.OrderPO;
import po.StoreinPO;
import systemenum.WrapWay;
import dataservice.StoreinDataService;

public class StoreinDataService_Driver {
	
	public void drive(StoreinDataService storeinDateService){
		
		long storeinId = new Long("0250151025000001");
		List<Long> orderId= new ArrayList<Long>();
		List<String> destination = new ArrayList<String>();
		List<Integer> areaNum= new ArrayList<Integer>();
		List<Integer> rowNum= new ArrayList<Integer>();
		List<Integer> frameNum= new ArrayList<Integer>();
		List<Integer> item= new ArrayList<Integer>();
		orderId.add(new Long("1025000001"));
		destination.add("南京市栖霞区中转中心");
		areaNum.add(10);
		rowNum.add(20);
		frameNum.add(30);
		item.add(10);
		
		StoreinPO storeinPO = new StoreinPO(storeinId, orderId, new Date(), destination, areaNum, rowNum, frameNum, item);
		
		try {
			storeinDateService.insert(storeinPO);
			System.out.println("Succeed！");
		} catch (RemoteException e) {
			System.out.println("false");
			e.printStackTrace();
		}
		
		try {
			storeinDateService.update(storeinPO);
			System.out.println("Succeed！");
		} catch (RemoteException e) {
			System.out.println("false");
			e.printStackTrace();
		}
		
		try {
			StoreinPO storeinFindPO = storeinDateService.find(storeinId);
			if(storeinFindPO.getOrderId()==orderId)
				System.out.println("Succeed！");
		} catch (RemoteException e) {
			System.out.println("false");
			e.printStackTrace();
		}
		
		try {
			boolean result = true;
			List<StoreinPO> StoreinPOs = storeinDateService.finds("destination", destination);
			for(int i=0;i<StoreinPOs.size();i++){
				if(StoreinPOs.get(i).getDestination().get(i).equals(destination.get(i)))
					result = false;		
			}
			System.out.println(result);
		} catch (RemoteException e) {
			System.out.println(false);
			e.printStackTrace();
		}
		
		try {
			List<StoreinPO> StoreinPOs = storeinDateService.getAll();
			System.out.println("Succcced");
		} catch (RemoteException e) {
			System.out.println(false);
			e.printStackTrace();
		}
		
		try {
			storeinDateService.init();
			System.out.println(true);
		} catch (RemoteException e) {
			System.out.println(false);
			e.printStackTrace();
		}
		
		try {
			storeinDateService.finish();
			System.out.println(true);
		} catch (RemoteException e) {
			System.out.println(false);
			e.printStackTrace();
		}
	}

}
