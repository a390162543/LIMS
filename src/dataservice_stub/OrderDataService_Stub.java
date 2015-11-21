package dataservice_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.OrderPO;
import systemenum.DeliveryWay;
import systemenum.DocumentState;
import systemenum.GoodsState;
import systemenum.ShipForm;
import systemenum.WrapWay;
import dataservice.OrderDataService;

public class OrderDataService_Stub implements OrderDataService {

	String id;
	
	DocumentState documentState;
	
	WrapWay wrapWay;
    DeliveryWay deliverWay;
    GoodsState state;
   	ShipForm shipForm;

	String nowLocation;
	String nextLocation;
	
	String senderName;
	String senderAddress;
	String senderTel;
	String senderCell;
	
	String receiverName;
	String receiverAddress;
	String receiverTel;
	String receiverCell;
	
	String goodsInfo;
	double weight;
	double size;
    double cost;
       
    String signName;
    String deliverInfo;
   	Date signData;
   	
   	int areaNum;
   	int rowNum;
   	int frameNum;
   	int item; 
   	
   	Date inDate;
   	
   	

	public OrderDataService_Stub(String id,
			WrapWay wrapWay, DeliveryWay deliverWay,
			ShipForm shipForm, String nowLocation, String nextLocation,
			String senderName, String senderAddress, String senderTel,
			String senderCell, String receiverName, String receiverAddress,
			String receiverTel, String receiverCell, String goodsInfo,
			double weight, double size, double cost, String signName,
			String deliverInfo, Date signData, int areaNum, int rowNum,
			int frameNum, int item, Date inDate) {
		super();
		this.id = id;
		this.documentState = DocumentState.PENDING;
		this.wrapWay = wrapWay;
		this.deliverWay = deliverWay;
		this.state = GoodsState.COMPLETE;
		this.shipForm = shipForm;
		this.nowLocation = nowLocation;
		this.nextLocation = nextLocation;
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.senderTel = senderTel;
		this.senderCell = senderCell;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.receiverTel = receiverTel;
		this.receiverCell = receiverCell;
		this.goodsInfo = goodsInfo;
		this.weight = weight;
		this.size = size;
		this.cost = cost;
		this.signName = signName;
		this.deliverInfo = deliverInfo;
		this.signData = signData;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
		this.inDate = inDate;
	}

		
	@Override
	public void insert(OrderPO po) throws RemoteException {
		System.out.println("Insert Succeed!\n");
	}

	@Override
	public void update(OrderPO po) throws RemoteException {
		System.out.println("Update Succeed!\n");
	}

	@Override
	public OrderPO find(String id) throws RemoteException {
		System.out.println("Find Succeed!\n");
		OrderPO po = new OrderPO(this.id, wrapWay, deliverWay, senderName, senderAddress, senderTel, senderCell,
				receiverName, receiverAddress, receiverTel, receiverCell, goodsInfo, this.weight, this.size, this.cost);		
		return po;
	}

	@Override
	public List<OrderPO> finds(String field, Object value)
			throws RemoteException {
		List<OrderPO> orderPOs = new ArrayList<OrderPO>();
		orderPOs.add(new OrderPO(this.id, wrapWay, deliverWay, senderName, senderAddress, senderTel, senderCell,
				receiverName, receiverAddress, receiverTel, receiverCell, goodsInfo, weight, size, cost));
		return orderPOs;
	}

	@Override
	public List<OrderPO> getAll() throws RemoteException {
		List<OrderPO> orderPOs = new ArrayList<OrderPO>();
		orderPOs.add(new OrderPO(this.id, wrapWay, deliverWay, senderName, senderAddress, senderTel, senderCell,
				receiverName, receiverAddress, receiverTel, receiverCell, goodsInfo, weight, size, cost));
		return orderPOs;
	}

	@Override
	public void init() throws RemoteException {
		System.out.println("Init Succeed!\n");
	}

	@Override
	public void finish() throws RemoteException {
		System.out.println("Finish Succeed!\n");
	}

}
