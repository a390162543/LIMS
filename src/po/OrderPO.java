package po;

import java.io.Serializable;
import java.util.Date;

import systemenum.DeliveryWay;
import systemenum.DocumentState;
import systemenum.ShipForm;
import systemenum.StorageState;
import systemenum.WrapWay;
import systemenum.GoodsState;
import vo.GoodsVO;
import vo.OrderCreateVO;
import vo.OrderDeliverInfoVO;
import vo.OrderQueryVO;
import vo.OrderRevenueVO;
import vo.OrderSignVO;
import vo.InOrderCheckResultVO;
import vo.OutOrderCheckResultVO;
import vo.StoreinOrderVO;



/**
 * 用于保存订单的信息
 * @author lc
 * @version 1.3
 *
 */
public class OrderPO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4266123865786848909L;



	public OrderPO(String id, WrapWay wrapWay, DeliveryWay deliverWay,
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
		this.documentState = DocumentState.PENDING;
	}
	
	
	public OrderPO(String id, WrapWay wrapWay, DeliveryWay deliverWay,
			String senderName, String senderAddress,
			String senderTel, String senderCell, String receiverName,
			String receiverAddress, String receiverTel, String receiverCell,
			String goodsInfo, double weight, double size, double cost, int totalTime) {
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
		this.totalTime = totalTime;
		this.documentState = DocumentState.PENDING;
	}
	
	
	public OrderPO(String id, WrapWay wrapWay, DeliveryWay deliverWay,
			String senderName, String senderAddress,
			String senderTel, String senderCell, String receiverName,
			String receiverAddress, String receiverTel, String receiverCell,
			String goodsInfo, double weight, double size, double cost, int totalTime, String organzation) {
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
		this.totalTime = totalTime;
		this.documentState = DocumentState.PENDING;
		this.organization = organzation;
	}
	
	private String id;
	
	private DocumentState documentState;
	
	private WrapWay wrapWay;
    private DeliveryWay deliverWay;
    private GoodsState state;
   	private ShipForm shipForm;

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
   	
   	private int areaNum;  //区号
   	private int rowNum;    //排号
   	private int frameNum;   //架号
   	private int item;      //位号
   	
   	private Date inDate;
   	
   	private int totalTime;
   	
   	private String organization;
   	

   	private StorageState storageState = null;
   	
   	
   	
   	public StorageState getStorageState() {
		return storageState;
	}

	public void setStorageState(StorageState storageState) {
		this.storageState = storageState;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public DocumentState getDocumentState() {
		return documentState;
	}

	public void setDocumentState(DocumentState documentState) {
		this.documentState = documentState;
	}
   	
   	
    public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public String getOrderId() {
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
	
	public void setCost(double cost) {
		this.cost = cost;
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
	
	public GoodsState getState() {
		return state;
	}

	public void setState(GoodsState state) {
		this.state = state;
	}

	public ShipForm getShipForm() {
		return shipForm;
	}

	public void setShipForm(ShipForm shipForm) {
		this.shipForm = shipForm;
	}

	public WrapWay getWrapWay() {
		return wrapWay;
	}

	public DeliveryWay getDeliverWay() {
		return deliverWay;
	}
	
	/**
	 * 更新修改的订单的信息
	 * 
	 * @param vo {@code OrderCreateVO}
	 * @return 返回一个{@code OrderPO}
	 */
	public OrderPO updateModifyInfo(OrderCreateVO vo) {
		setCost(vo.getCost());	
		return this;
	}
	
	
	/**
	 * 更新订单的签收信息
	 * 
	 * @param vo {@code OrderSignVO}
	 * @return 返回一个{@code OrderPO}
	 */
	public OrderPO updateSignInfo(OrderSignVO vo){
		setSignName(vo.getSignName());
		setSignData(vo.getSignData());
		return this;
	}
	
	/**
	 * 入库后更新订单的库存位置信息
	 * 
	 * @param vo {@code StoreinOrderVO}
	 * @return 返回一个{@code OrderPO}
	 */
	public OrderPO updateStoreinOrderPo(StoreinOrderVO vo) {
		setAreaNum(vo.getAreaNum());
		setRowNum(vo.getRowNum());
		setFrameNum(vo.getFrameNum());
		setItem(vo.getItem());
		return this;
	}
	
	/**
	 * 
	 * 出库后更新订单的库存位置信息
	 * 
	 * @return 返回一个{@code OrderPO}
	 */
	public OrderPO updateOrderLoction() {
		setAreaNum(-1);
		setRowNum(-1);
		setFrameNum(-1);
		setItem(-1);
		return this;
	}
	
	/**
	 * 
	 * 装运过程更新订单的运送信息
	 * 
	 * @param vo {@code OrderDeliverInfoVO}
	 * @return 返回一个{@code OrderPO}
	 */
	public OrderPO updateOrderDeliverInfo(OrderDeliverInfoVO vo) {
		setNowLocation(vo.getNowLocation());
		setNextLocation(vo.getNextLocation());
		deliverInfo = deliverInfo+"\n"+vo.getDeliverInfo();
		return this;
	}
	
	/**
	 * 获取订单相应的信息
	 * 
	 * @return 返回一个{@code OrderQueryVO}
	 */
	public OrderQueryVO getOrderQueryVO(){
		return new OrderQueryVO(id, state, deliverInfo, nowLocation, nextLocation, shipForm);
	}
	
	/**
	 * 获取出库货物相应的信息
	 * 
	 * @return 返回一个{@code OutOrderCheckResultVO}
	 */
	public OutOrderCheckResultVO getOutOrderCheckResultVO(){
		return new OutOrderCheckResultVO(id, areaNum, rowNum, frameNum, item, weight, size);
	}
	
	/**
	 * 获取入库货物相应的信息
	 * 
	 * @return 返回一个{@code OutOrderCheckResultVO}
	 */
	public InOrderCheckResultVO getInOrderCheckResultVO() {
		return new InOrderCheckResultVO(id, areaNum, rowNum, frameNum, item, weight, size);
	}
	
	/**
	 * 返回带审批的订单
	 * 
	 * @return 返回一个{@code OrderCreateVO}
	 */
	public OrderCreateVO getOrderPendingVO() {
		return new OrderCreateVO(id, senderName, senderAddress, senderTel, senderCell, receiverName,
				receiverAddress, receiverTel, receiverCell, goodsInfo, weight, size, cost, wrapWay, deliverWay,
				totalTime);
	}
	
	/**
	 * 返回在库存中获取的信息
	 * 
	 * @return 返回一个{@code OrderCreateVO}
	 */
	public StoreinOrderVO getStorageOrderVO() {
		return new StoreinOrderVO(id, areaNum, rowNum, frameNum, item);
	}
	
	
	public GoodsVO getGoodsVO() {
		return new GoodsVO(id, weight, nowLocation, nextLocation);
	}
	
	
	public OrderRevenueVO getOrderRevenueVO() {
		return new OrderRevenueVO(id, organization, cost, goodsInfo);
	}
	
	/**
	 * 返回订单的签收的信息
	 * 
	 * @return 返回一个{@code OrderSignVO}
	 */
	public OrderSignVO getOrderSignVO () {
		return new OrderSignVO(id, signName, signData);
	}
}
