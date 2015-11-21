package vo;

import java.util.Date;

public class InOrderCheckResultVO {
	
	private String id;
	private Date date;
	private String destination;
	private int areaNum;
   	private int rowNum;
   	private int frameNum;
   	private int item; 
   	private double weight;
	private double size;
	
	public InOrderCheckResultVO(String id, int areaNum, int rowNum, int frameNum,
			int item, double weight, double size) {
		super();
		this.id = id;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
		this.weight = weight;
		this.size = size;
	}
	
	public String getOrderId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
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
	
	

}
