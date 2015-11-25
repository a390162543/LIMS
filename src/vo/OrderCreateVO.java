package vo;

import po.OrderPO;
import systemenum.DeliveryWay;
import systemenum.DocumentState;
import systemenum.GoodsState;
import systemenum.WrapWay;

public class OrderCreateVO {
	
	private String id;
	
	private String senderName;
	private String senderAddress;
	private String senderTel;
	private String senderCell;
	
	private String receiverName;
	private String receiverAddress;
	private String receiverTel;
	private String receiverCell;
	
	private String goodsInfo;
	private double weight;
	private double size;
    private double cost;
    
    private WrapWay wrapWay;
    private DeliveryWay deliverWay;
   
    private int totalTime;
    private GoodsState goodsState;
    
    
	public OrderCreateVO(String id, String senderName, String senderAddress,
			String senderTel, String senderCell, String receiverName,
			String receiverAddress, String receiverTel, String receiverCell,
			String goodsInfo, double weight, double size, double cost,
			WrapWay wrapWay, DeliveryWay deliverWay) {
		super();
		this.id = id;//
		this.senderName = senderName;
		this.senderAddress = senderAddress;//
		this.senderTel = senderTel;
		this.senderCell = senderCell;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;//
		this.receiverTel = receiverTel;
		this.receiverCell = receiverCell;
		this.goodsInfo = goodsInfo;//
		this.weight = weight;//
		this.size = size;//
		this.cost = cost;//
		this.wrapWay = wrapWay;//
		this.deliverWay = deliverWay;//
	}
	
	//add total time
	public OrderCreateVO(String id, String senderName, String senderAddress,
			String senderTel, String senderCell, String receiverName,
			String receiverAddress, String receiverTel, String receiverCell,
			String goodsInfo, double weight, double size, double cost,
			WrapWay wrapWay, DeliveryWay deliverWay, int totalTime) {
		super();
		this.id = id;
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
		this.wrapWay = wrapWay;
		this.deliverWay = deliverWay;
		this.totalTime = totalTime;
	}


	
	
	public GoodsState getGoodsState() {
		return goodsState;
	}

	public void setGoodsState(GoodsState goodsState) {
		this.goodsState = goodsState;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public String getId() {
		return id;
	}


	public String getSenderName() {
		return senderName;
	}


	public String getSenderAddress() {
		return senderAddress;
	}


	public String getSenderTel() {
		return senderTel;
	}


	public String getSenderCell() {
		return senderCell;
	}


	public String getReceiverName() {
		return receiverName;
	}


	public String getReceiverAddress() {
		return receiverAddress;
	}


	public String getReceiverTel() {
		return receiverTel;
	}


	public String getReceiverCell() {
		return receiverCell;
	}


	public String getGoodsInfo() {
		return goodsInfo;
	}


	public double getWeight() {
		return weight;
	}


	public double getSize() {
		return size;
	}


	public double getCost() {
		return cost;
	}


	public WrapWay getWrapWay() {
		return wrapWay;
	}


	public DeliveryWay getDeliverWay() {
		return deliverWay;
	}
    
    public OrderPO getOrderPO(){
    	return new OrderPO(id, wrapWay, deliverWay, senderName, senderAddress, senderTel,
    			senderCell, receiverName, receiverAddress, receiverTel, receiverCell,
    			goodsInfo, weight, size, cost);
    }
	

}
