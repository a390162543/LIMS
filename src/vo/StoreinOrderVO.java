package vo;

public class StoreinOrderVO {
	
	//该VO是入库单添加一项货物时，将创建的VO传给storeinblService相应的方法来改变库存的位置
	//货物出库也传该VO
	private String storageId;
	private String orderId;
	private int areaNum;
   	private int rowNum;
   	private int frameNum;
   	private int item;
   	
	public StoreinOrderVO(String orderId, int areaNum, int rowNum,
			int frameNum, int item) {
		super();
		this.orderId = orderId;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}
   	
   	

}
