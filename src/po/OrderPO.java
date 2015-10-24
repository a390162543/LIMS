package po;

import java.util.Date;

import systemenum.DeliveryWay;
import systemenum.ShipForm;
import systemenum.WrapWay;
import systemenum.GoodsState;

public class OrderPO {
	
	
	public OrderPO(long id, WrapWay wrapWay, DeliveryWay deliverWay,
			String senderName, String senderAddress,
			String senderTel, String senderCell, String receiverName,
			String receiverAddress, String receiverTel, String receiverCell,
			String goodsInfo, double weight, double size, double cost) {
		super();
		this.state = GoodsState.COMPLETE;
		this.id = id;
		this.wrapWay = wrapWay;
		this.deliverWay = deliverWay;
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
	}
	
	
	private long id;
	
	WrapWay wrapWay;
    DeliveryWay deliverWay;
    GoodsState state;
   	ShipForm shipForm;
   	
	private String nowLocation;
	private String nextLocation;
	
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
       
    private String signName;
    private String deliverInfo;
   	private Date signData;
   	
   	private int areaNum;
   	private int rowNum;
   	private int frameNum;
   	private int item; 
   	
   	
    public long getOrderId() {
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
	
	
	
	public String getNowLocation() {
		return nowLocation;
	}
	public void setNowLocation(String nowLocation) {
		this.nowLocation = nowLocation;
	}
	
	public String getNextLocation() {
		return nextLocation;
	}
	public void setNextLocation(String nextLocation) {
		this.nextLocation = nextLocation;
	}
	
	public String getSignName() {
		return signName;
	}
	public void setSignName(String signName) {
		this.signName = signName;
	}
	
	public String getDeliverInfo() {
		return deliverInfo;
	}
	public void setDeliverInfo(String deliverInfo) {
		this.deliverInfo = deliverInfo;
	}
	
	public Date getSignData() {
		return signData;
	}
	public void setSignData(Date signData) {
		this.signData = signData;
	}
	
	public int getAreaNum() {
		return areaNum;
	}
	public void setAreaNum(int areaNum) {
		this.areaNum = areaNum;
	}
	
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	
	public int getFrameNum() {
		return frameNum;
	}
	public void setFrameNum(int frameNum) {
		this.frameNum = frameNum;
	}
	
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	
	
}
