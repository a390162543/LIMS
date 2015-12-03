package businesslogic.orderbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.OrderPO;
import systemenum.DeliveryWay;
import systemenum.DocumentState;
import systemenum.WrapWay;
import dataservice.OrderDataService;
import vo.GoodsVO;
import vo.OrderCreateVO;
import vo.OrderDeliverInfoVO;
import vo.OrderQueryVO;
import vo.OrderRevenueVO;
import vo.OrderSignVO;
import vo.InOrderCheckResultVO;
import vo.OutOrderCheckResultVO;
import vo.StoreinOrderVO;
import businesslogic.citybl.City;
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
		try {
			OrderDataService ods = (OrderDataService) Naming.lookup("rmi://localhost/OrderData");
			OrderPO po = ods.find(vo.getId());
			ods.update(po.updateModifyInfo(vo));
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
		double weight = vo.getWeight();
		WrapWay wrapWay = vo.getWrapWay();
		DeliveryWay deliveryWay = vo.getDeliverWay();
		double distance = getEximatedTime(vo.getSenderAddress(), vo.getReceiverAddress());
		int wrapCost = 0;
		double deliverCost = 0;
		switch (wrapWay) {
		case CARTON:
			wrapCost = 5;
			break;
		case WOODEN:
			wrapCost = 10;
			break;
		case BAG:
			wrapCost = 1;
			break;
		}
		switch (deliveryWay) {
		case ECONOMIC:
			deliverCost = distance/1000*18*weight;
			break;
		case STANDARD:
			deliverCost = distance/1000*23*weight;
			break;
		case FAST:
			deliverCost = distance/1000*25*weight;
			break;
		}
		return deliverCost+wrapCost;
	}


	public int getEximatedTime(String senderAddress, String receiverAddress) {
		int fromBeginIndex = senderAddress.indexOf("省");
		int fromEndIndex = senderAddress.indexOf("市");
		int toBeginIndex = receiverAddress.indexOf("省");
		int toEndIndex = receiverAddress.indexOf("市");
		String fromCity = senderAddress.substring(fromBeginIndex+1, fromEndIndex);
		String toCity = receiverAddress.substring(toBeginIndex+1, toEndIndex);
		City city = new City();
		double distance = city.getDistance(fromCity, toCity);
		int time = (int) ((distance%30)/2+1);
		return time;
	}

	
	public boolean execute(OrderCreateVO vo) {
		
		try {
			OrderDataService ods = (OrderDataService) Naming.lookup("rmi://localhost/OrderData");
			OrderPO po = ods.find(vo.getId());
			po.setDocumentState(DocumentState.PASS);
			ods.update(po);
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
	
	public List<OrderCreateVO> getPendingOrderCreateVO() {
		List<OrderCreateVO> orderPendingVOs = new ArrayList<OrderCreateVO>();
		List<OrderPO> pendingOrderPOs = null;
		try {
			OrderDataService ods = (OrderDataService) Naming.lookup("rmi://localhost/OrderData");
			pendingOrderPOs = ods.finds("documentState", DocumentState.PENDING);
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
		for (OrderPO po : pendingOrderPOs) {
			orderPendingVOs.add(po.getOrderPendingVO());
		}
		return orderPendingVOs;
	}
	
	public StoreinOrderVO getStorageOrderVO(String orderId) {
		StoreinOrderVO storeinOrderVO = null;
		try {
			OrderDataService ods = (OrderDataService) Naming.lookup("rmi://localhost/OrderData");
			OrderPO po = ods.find(orderId);
			storeinOrderVO = po.getStorageOrderVO();
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
		return storeinOrderVO;
	}
	
	public boolean setStorageState(StoreinOrderVO vo){
		try {
			OrderDataService ods = (OrderDataService) Naming.lookup("rmi://localhost/OrderData");
			OrderPO po = ods.find(vo.getOrderId());
			OrderPO updatePO = po.updateStoreinOrderPo(vo);
			ods.update(updatePO);
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
	
	public boolean setStoreoutState (String orderId) {
		try {
			OrderDataService ods = (OrderDataService) Naming.lookup("rmi://localhost/OrderData");
			OrderPO po = ods.find(orderId);
			OrderPO updatePO = po.updateOrderLoction();
			ods.update(updatePO);
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
	
	public boolean modifyDeliverInfo (OrderDeliverInfoVO vo) {
		try {
			OrderDataService ods = (OrderDataService) Naming.lookup("rmi://localhost/OrderData");
			OrderPO po = ods.find(vo.getOrderId());
			OrderPO updatePO = po.updateOrderDeliverInfo(vo);
			ods.update(updatePO);
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
	
	public GoodsVO getGoodsVO (String orderId) {
		GoodsVO goodsVO = null;
		try {
			OrderDataService ods = (OrderDataService) Naming.lookup("rmi://localhost/OrderData");
			OrderPO po = ods.find(orderId);
			goodsVO = po.getGoodsVO();	
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
		return goodsVO;
	} 
	
	public OrderRevenueVO getOrderRevenueVO (String orderId) {
		OrderRevenueVO orderRevenueVO = null;
		try {
			OrderDataService ods = (OrderDataService) Naming.lookup("rmi://localhost/OrderData");
			OrderPO po = ods.find(orderId);
			orderRevenueVO = po.getOrderRevenueVO();
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
		return orderRevenueVO;
	}
	
	public boolean primeInfoExecute (List<OrderCreateVO> vos) {
		try {
			OrderDataService ods = (OrderDataService) Naming.lookup("rmi://localhost/OrderData");
			for (OrderCreateVO orderCreateVO : vos) {
				OrderPO po = orderCreateVO.getOrderPO();
				ods.insert(po);
			}
			
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
}
