package dataservice_driver;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.OrderPO;
import systemenum.DeliveryWay;
import systemenum.WrapWay;
import dataservice.OrderDataService;

public class OrderDataService_Driver {
	
	public void drive(OrderDataService orderDataService){
		
		long orderId = new Long("1025000001");
		OrderPO orderPO = new OrderPO(orderId, WrapWay.BAG, DeliveryWay.FAST, "张三", "南京市南京大学仙林校区", "86-020-12345687",
				"13812301230", "李四", "上海XX", "86-020-12345678",  "18312341234", "1件", 
				3.56, 2.56, 15.00);
		
		try {
			orderDataService.insert(orderPO);
			System.out.println("Succeed！");
		} catch (RemoteException e) {
			System.out.println("false");
			e.printStackTrace();
		}
		
		try {
			orderDataService.update(orderPO);
			System.out.println("Succeed！");
		} catch (RemoteException e) {
			System.out.println("false");
			e.printStackTrace();
		}
		
		try {
			OrderPO orderFindPO = orderDataService.find(orderId);
			if(orderFindPO.getOrderId()==orderId)
				System.out.println("Succeed！");
		} catch (RemoteException e) {
			System.out.println("false");
			e.printStackTrace();
		}
		
		try {
			boolean result = true;
			List<OrderPO> orderPOs = orderDataService.finds("wrapWay", WrapWay.BAG);
			for(int i=0;i<orderPOs.size();i++){
				if(orderPOs.get(i).getWrapWay() != WrapWay.BAG)
					result = false;		
			}
			System.out.println(result);
		} catch (RemoteException e) {
			System.out.println(false);
			e.printStackTrace();
		}
		
		
		try {
			List<OrderPO> orderPOs = orderDataService.getAll();
			System.out.println("Succcced");
		} catch (RemoteException e) {
			System.out.println(false);
			e.printStackTrace();
		}
		
		try {
			orderDataService.init();
			System.out.println(true);
		} catch (RemoteException e) {
			System.out.println(false);
			e.printStackTrace();
		}
		
		try {
			orderDataService.finish();
			System.out.println(true);
		} catch (RemoteException e) {
			System.out.println(false);
			e.printStackTrace();
		}
		
	}

}
