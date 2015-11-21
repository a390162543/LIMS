package businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.OrderPO;
import dataservice.OrderDataService;
import vo.OrderCreateVO;
import vo.OrderQueryVO;
import vo.OrderSignVO;
import vo.InOrderCheckResultVO;
import vo.OutOrderCheckResultVO;
import businesslogicservice.OrderblService;

public class Order implements OrderblService{

	
	public boolean createOrderPO(OrderCreateVO vo) {
		try {
			OrderDataService ods = (OrderDataService) Naming.lookup("rmi://localhost/OrderData");
			ods.insert(vo.getOrderPO());
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
		return true;
	}

	
	public boolean signOrder(OrderSignVO vo) {
		try {
			OrderDataService ods = (OrderDataService) Naming.lookup("rmi://localhost/OrderData");
			OrderPO po = ods.find(vo.getId());
			OrderPO updatePo = po.updateSignInfo(vo);
			ods.update(updatePo);
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
		return true;
	}

	
	public boolean modifyOrder(OrderCreateVO vo) {
		
		return false;
	}


	public OrderQueryVO returnOrderQueryVO(String orderId) {
		
		OrderQueryVO orderQueryVO = null;
		try {
			OrderDataService ods = (OrderDataService)Naming.lookup("rmi://localhost/OrderData");
			OrderPO po = ods.find(orderId);
			orderQueryVO = po.getOrderQueryVO();
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
		
		return orderQueryVO;
	}

	public OutOrderCheckResultVO findStoreout(String id){
		
		OutOrderCheckResultVO outCheckResultVO = null;
		
		try {
			OrderDataService orderDataService = (OrderDataService)Naming.lookup("rmi://localhost/OrderData");
			OrderPO po = orderDataService.find(id);
			outCheckResultVO = po.getOutOrderCheckResultVO();
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
		
		return outCheckResultVO;
	}
	
	public InOrderCheckResultVO findStorein(String id) {
		
		InOrderCheckResultVO inCheckResultVO = null;
		
		try {
			OrderDataService orderDataService = (OrderDataService)Naming.lookup("rmi://localhost/OrderData");
			OrderPO po = orderDataService.find(id);
			inCheckResultVO = po.getInOrderCheckResultVO();
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
		
		return inCheckResultVO;
	}
	
	public double getTotal(OrderCreateVO vo) {
		
		return 0;
	}


	public int getEximatedTime(OrderCreateVO vo) {
		
		return 0;
	}

	
	public boolean excute(OrderCreateVO vo) {
		
		return false;
	}
	
	
}
