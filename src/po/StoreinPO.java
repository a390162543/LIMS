package po;

import java.util.Date;
import java.util.List;

public class StoreinPO {
	
		
	public StoreinPO(long id,List<Long> orderId, Date inDate, List<String> destination,
			List<Integer> areaNum, List<Integer> rowNum,
			List<Integer> frameNum, List<Integer> item) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.inDate = inDate;
		this.destination = destination;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
	}

	private long id;
	private List<Long> orderId;
	private Date inDate;
	private List<String> destination; 
	private List<Integer> areaNum;
	private List<Integer> rowNum;
	private List<Integer> frameNum;
	private List<Integer> item;
	
	
	public long getStoreinId() {
		return id;
	}
	
	public List<Long> getOrderId() {
		return orderId;
	}
	
	public Date getInDate() {
		return inDate;
	}
	
	public List<String> getDestination() {
		return destination;
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

}
