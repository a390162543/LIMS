package vo;

import java.util.Date;
import java.util.List;

public class StoreinQueryVO {
	
	private List<String> orderId;
	private List<Integer> areaNum;
	private List<Integer> rowNum;
	private List<Integer> frameNum;
	private List<Integer> item;
	private Date date;
	private String destination;
	
	public StoreinQueryVO(List<String> orderId, List<Integer> areaNum,
			List<Integer> rowNum, List<Integer> frameNum, List<Integer> item,
			Date date, String destination) {
		super();
		this.orderId = orderId;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
		this.date = date;
		this.destination = destination;
	}

	public List<String> getOrderId() {
		return orderId;
	}

	public List<Integer> getAreaNum() {
		return areaNum;
	}

	public List<Integer> getRowNum() {
		return rowNum;
	}

	public List<Integer> getFrameNum() {
		return frameNum;
	}

	public List<Integer> getItem() {
		return item;
	}

	public Date getDate() {
		return date;
	}

	public String getDestination() {
		return destination;
	}
	
	

}
