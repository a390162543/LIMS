package vo;

import java.util.Date;

public class OutOrderCheckResultVO {
	
	private String orderId;
	private String destination;
	private Date date;
	private int areaNum;
   	private int rowNum;
   	private int frameNum;
   	private int item;  	
   	private double weight;
	private double size;
	
	public OutOrderCheckResultVO(String orderId,int areaNum, int rowNum, int frameNum, 
			int item, double weight, double size) {
		super();
		this.orderId = orderId;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
		this.weight = weight;
		this.size = size;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getDestination() {
		return destination;
	}

	public Date getDate() {
		return date;
	}

	public int getAreaNum() {
		return areaNum;
	}

	public int getRowNum() {
		return rowNum;
	}

	public int getFrameNum() {
		return frameNum;
	}

	public int getItem() {
		return item;
	}

	public double getWeight() {
		return weight;
	}

	public double getSize() {
		return size;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

	
}
