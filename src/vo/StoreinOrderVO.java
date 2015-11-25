package vo;

public class StoreinOrderVO {
	
	//��VO����ⵥ���һ�����ʱ����������VO����storeinblService��Ӧ�ķ������ı����λ��
	//�������Ҳ����VO
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
