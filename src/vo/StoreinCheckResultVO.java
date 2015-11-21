package vo;

import java.util.Date;


public class StoreinCheckResultVO {
	
	private String orderId;
	private Integer areaNum;
	private Integer rowNum;
	private Integer frameNum;
	private Integer item;
	private Date date; //�������
	private String desination;  //Ŀ�ĵ�
	
	public StoreinCheckResultVO(String orderId, Integer areaNum, Integer rowNum,
			Integer frameNum, Integer item) {
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

	public Integer getAreaNum() {
		return areaNum;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public Integer getFrameNum() {
		return frameNum;
	}

	public Integer getItem() {
		return item;
	}
	
	

	

}
