package businesslogic.orderbl;


import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.OrderPO;
import systemenum.DeliveryWay;
import systemenum.DocumentState;
import systemenum.ShipForm;
import systemenum.StorageState;
import systemenum.WrapWay;
import dataservice.DataService;
import dataservice.OrderDataService;
import vo.ConstantVO;
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
import businesslogic.constantbl.Constant;
import businesslogic.idbl.OrderIdManager;
import businesslogic.logbl.Log;
import businesslogicservice.IdblService;
import businesslogicservice.OrderblService;



/**
 * ʵ��OrderblService�еķ��������ṩ������ģ�齻���ķ���
 * 
 * @author lc
 * @version 1.5
 *
 */
public class Order implements OrderblService{

	
	public boolean createOrderPO(OrderCreateVO vo) {
		OrderDataService ods = DataService.getOrderDataService();
		try {
			OrderPO po = vo.getOrderPO();
			ods.insert(po);	
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String operation = "�����˶���"+"("+vo.getId()+")";
		Log log = new Log();
		log.createLogPO(operation);
		return true;
	}

	
	public boolean signOrder(OrderSignVO vo) {
		OrderDataService ods = DataService.getOrderDataService();
		
		OrderPO po = null;
		try {
			po = ods.find(vo.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrderPO updatePo = po.updateSignInfo(vo);
		try {
			ods.update(updatePo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String operation = "ǩ���˶���"+"("+vo.getId()+")";
		Log log = new Log();
		log.createLogPO(operation);
		return true;
	}

	
	public boolean modifyOrder(OrderCreateVO vo) {
		OrderDataService ods = DataService.getOrderDataService();
		
		OrderPO po = null;
		try {
			po = ods.find(vo.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ods.update(po.updateModifyInfo(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;	
	}


	public OrderQueryVO returnOrderQueryVO(String orderId) {
		
		OrderDataService ods = DataService.getOrderDataService();
		OrderQueryVO orderQueryVO = null;

		OrderPO po = null;
		try {
			po = ods.find(orderId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null) {
			return null;
		}
		orderQueryVO = po.getOrderQueryVO();

		return orderQueryVO;
	}

	/**
	 * ���鿴ʱҪ���ز�ѯ��ʱ����ڳ���Ļ��������
	 * Order�ṩ����ID������Ӧ��OutOrderCheckResultVO
	 * 
	 * @param id {@code String}
	 * @return �ɹ��򷵻�һ��{@code OutOrderCheckResultVO}��ʧ���򷵻�{@code null}
	 */
	public OutOrderCheckResultVO findStoreout(String id){

		OrderDataService orderDataService = DataService.getOrderDataService();
		OutOrderCheckResultVO outCheckResultVO = null;

		OrderPO po = null;
		try {
			po = orderDataService.find(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null) {
			return null;
		}
		outCheckResultVO = po.getOutOrderCheckResultVO();

		return outCheckResultVO;
	}
	
	
	/**
	 * ���鿴ʱҪ���ز�ѯ��ʱ��������Ļ��������
	 * Order�ṩ����ID������Ӧ��InOrderCheckResultVO
	 * 
	 * @param id {@code String}
	 * @return �ɹ��򷵻�һ��{@code InOrderCheckResultVO}��ʧ���򷵻�{@code null}
	 */
	public InOrderCheckResultVO findStorein(String id) {
		
		OrderDataService orderDataService = DataService.getOrderDataService();
		InOrderCheckResultVO inCheckResultVO = null;

		OrderPO po = null;
		try {
			po = orderDataService.find(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null) {
			return null;
		}
		inCheckResultVO = po.getInOrderCheckResultVO();
		return inCheckResultVO;
	}
	
	public double getTotal(OrderCreateVO vo) {
		double weight = vo.getWeight();
		WrapWay wrapWay = vo.getWrapWay();
		DeliveryWay deliveryWay = vo.getDeliverWay();
		double distance = getEximatedTime(vo.getSenderAddress(), vo.getReceiverAddress());
		int wrapCost = 0;
		double deliverCost = 0;
		Constant constant = new Constant();
		ConstantVO constantVO = constant.getPrice();
		double rato = constantVO.getPrice();
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
			deliverCost = distance/1000*(rato/23*18)*weight;
			break;
		case STANDARD:
			deliverCost = distance/1000*rato*weight;
			break;
		case FAST:
			deliverCost = distance/1000*(rato/23*25)*weight;
			break;
		}
		BigDecimal bg = new BigDecimal(deliverCost+wrapCost);  
        double cost = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return cost;
	}


	public int getEximatedTime(String senderAddress, String receiverAddress) {
		int fromBeginIndex = senderAddress.indexOf("ʡ");
		int fromEndIndex = senderAddress.indexOf("��");
		int toBeginIndex = receiverAddress.indexOf("ʡ");
		int toEndIndex = receiverAddress.indexOf("��");
		String fromCity = senderAddress.substring(fromBeginIndex+1, fromEndIndex);
		String toCity = receiverAddress.substring(toBeginIndex+1, toEndIndex);
		City city = new City();
		double distance = city.getDistance(fromCity, toCity);
		int time = (int) ((distance%30)/15+1);
		return time;
	}

	
	public boolean execute(OrderCreateVO vo) {
		OrderDataService ods = DataService.getOrderDataService();

		OrderPO po = null;
		try {
			po = ods.find(vo.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		po.setDocumentState(DocumentState.PASS);
		try {
			ods.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	
	
	/**
	 * ��ȡδ�����Ķ���
	 * 
	 * @return �ɹ��򷵻�һ��{@code List<OrderCreateVO>}��ʧ���򷵻�{@code null}
	 */
	public List<OrderCreateVO> getPendingOrderCreateVO() {
		OrderDataService ods = DataService.getOrderDataService();
		List<OrderCreateVO> orderPendingVOs = new ArrayList<OrderCreateVO>();
		List<OrderPO> pendingOrderPOs = null;

		try {
			pendingOrderPOs = ods.finds("documentState", DocumentState.PENDING);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (OrderPO po : pendingOrderPOs) {
			orderPendingVOs.add(po.getOrderPendingVO());
		}
		return orderPendingVOs;
	}
	
	
	/**
	 * ����̵�ʱ��Order�ṩ�����ڿ������Ķ���
	 * 
	 * @param orderId {@code String}
	 * @return �ɹ��򷵻�һ��{@code StoreinOrderVO}��ʧ���򷵻�{@code null}
	 */
	public StoreinOrderVO getStorageOrderVO(String orderId) {
		OrderDataService ods = DataService.getOrderDataService();
		StoreinOrderVO storeinOrderVO = null;

		OrderPO po = null;
		try {
			po = ods.find(orderId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null) {
			return null;
		}
		storeinOrderVO = po.getStorageOrderVO();

		return storeinOrderVO;
	}
	
	
	/**
	 * ��ⵥִ��ʱ�ı䶩���Ŀ��λ��
	 * 
	 * @param vo {@code StoreinOrderVO}
	 * @return �ɹ��򷵻�{@code true}��ʧ���򷵻�{@code false}
	 */
	public boolean setStorageState(StoreinOrderVO vo) {
		OrderDataService ods = DataService.getOrderDataService();

		OrderPO po = null;
		try {
			po = ods.find(vo.getOrderId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrderPO updatePO = po.updateStoreinOrderPo(vo);
		try {
			ods.update(updatePO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	
	/**
	 * ���ⵥִ��ʱ�ı䶩���Ŀ��λ��
	 * 
	 * @param orderId {@code String}
	 * @return �ɹ��򷵻�{@code true}��ʧ���򷵻�{@code false}
	 */
	public boolean setStoreoutState(String orderId) {
		OrderDataService ods = DataService.getOrderDataService();

		OrderPO po = null;
		try {
			po = ods.find(orderId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrderPO updatePO = po.updateOrderLoction();
		try {
			ods.update(updatePO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	
	
	/**
	 * ���������͹�������Ҫ����������Ϣ
	 * �÷����Ĺ������޸ġ����¶�����������Ϣ
	 * 
	 * @param vo {@code OrderDeliverInfoVO}
	 * @return �ɹ��򷵻�{@code true}��ʧ���򷵻�{@code false}
	 */
	public boolean modifyDeliverInfo(OrderDeliverInfoVO vo) {
		OrderDataService ods = DataService.getOrderDataService();

		OrderPO po = null;
		try {
			po = ods.find(vo.getOrderId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrderPO updatePO = po.updateOrderDeliverInfo(vo);
		try {
			ods.update(updatePO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	
	/**
	 * ��ȡ����ǩ�յ�����ṩ������
	 * 
	 * @param orderId {@code String}
	 * @return �ɹ��򷵻�һ��{@code OrderSignVO}��ʧ�ܷ���{@code null}
	 */
	public OrderSignVO getOrderSignVO(String orderId) {
		OrderDataService ods = DataService.getOrderDataService();
		OrderSignVO orderSignVO = null;

		OrderPO po = null;
		try {
			po = ods.find(orderId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null) {
			return null;
		}
		orderSignVO = po.getOrderSignVO();

		return orderSignVO;
	}
	
	/**
	 * �÷������ڻ�ȡ�����������Ϣ������ģ��
	 * 
	 * @param orderId {@code String}
	 * @return �ɹ��򷵻�һ��{@code GoodsVO}��ʧ���򷵻�{@code null}
	 */
	public GoodsVO getGoodsVO(String orderId) {
		OrderDataService ods = DataService.getOrderDataService();
		GoodsVO goodsVO = null;

		OrderPO po = null;
		try {
			po = ods.find(orderId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null) {
			return null;
		}
		goodsVO = po.getGoodsVO();

		return goodsVO;
	}
	
	
	/**
	 * �ṩװ������Ҫ��ȡ����Ϣ
	 * 
	 * @param orderId {@code String}
	 * @return �ɹ�
	 */
	public OrderRevenueVO getOrderRevenueVO(String orderId) {
		OrderDataService ods = DataService.getOrderDataService();
		OrderRevenueVO orderRevenueVO = null;

		OrderPO po = null;
		try {
			po = ods.find(orderId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null) {
			return null;
		}
		orderRevenueVO = po.getOrderRevenueVO();

		return orderRevenueVO;
	}
	
	
	
	@Override
	public IdblService getIdblService() {
		
		OrderDataService orderDataService = DataService.getOrderDataService();
		return new OrderIdManager(orderDataService, 6);
	}
	
	/**
	 * �ı��������Ķ�����״̬
	 * 
	 * @param orderId {@code String}
	 * @return �ɹ��򷵻�{@code true}��ʧ���򷵻�{@code false}
	 */
	public boolean storeinOrderState(String orderId, int areaNum) {
		OrderDataService orderDataService = DataService.getOrderDataService();
		ShipForm shipForm = null;
		switch (areaNum) {
		case 0:
			shipForm = ShipForm.PLANE;
			break;
		case 1:
			shipForm = ShipForm.TRAIN;
			break;
		case 2:
			shipForm = ShipForm.CAR;
			break;
		case 3:
			shipForm = ShipForm.FREE;
			break;	
		}
		OrderPO po = null;
		try {
			po = orderDataService.find(orderId);
			po.setStorageState(StorageState.ISSTORING);	
			po.setShipForm(shipForm);
			orderDataService.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null) {
			return false;
		}
			
		return true;
	}
	
	/**
	 * �ָ������Ŀ��״̬null
	 * 
	 * @param orderId {@code String}
	 * @return �ɹ��򷵻�{@code true}��ʧ���򷵻�{@code false}
	 */
	public boolean restoreOrderState(String orderId) {
		OrderDataService orderDataService = DataService.getOrderDataService();

		OrderPO po = null;
		try {
			po = orderDataService.find(orderId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		po.setStorageState(null);

		return true;
	}
	
	
	/**
	 * ���ڳ���Ķ���״̬�ĸı�
	 * 
	 * @param orderId {@code String}
	 * @return �ɹ��򷵻�{@code true}��ʧ���򷵻�{@code false}
	 */
	public boolean storeoutOrderState(String orderId) {
		OrderDataService orderDataService = DataService.getOrderDataService();

		OrderPO po = null;
		try {
			po = orderDataService.find(orderId);
			po.setStorageState(StorageState.ISSTORINGOUT);
			orderDataService.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	/**
	 * ��ȡ�����Ŀ��״̬
	 * 
	 * @param orderId {@code String}
	 * @return ����һ��{@code StorageState}
	 */
	public StorageState getStorageState(String orderId) {
		OrderPO po = null;
		OrderDataService orderDataService = DataService.getOrderDataService();

		try {
			po = orderDataService.find(orderId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null) {
			return null;
		}

		return po.getStorageState();
	}
	
	public boolean updateNextLocation(String orderId,String nextLocation){
		OrderPO po = null;
		OrderDataService orderDataService = DataService.getOrderDataService();

		try {
			po = orderDataService.find(orderId);
			po.setNextLocation(nextLocation);
			orderDataService.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
}
