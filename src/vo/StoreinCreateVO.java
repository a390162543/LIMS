package vo;

import java.util.Date;
import java.util.List;

import po.StoreinPO;

public class StoreinCreateVO {
	
	private String id;
	private List<String> orderId;
	private Date inDate;
	private String destination; 
	private List<Integer> areaNum;
	private List<Integer> rowNum;
	private List<Integer> frameNum;
	private List<Integer> item;
	private String organization;
	
	
	public StoreinCreateVO(String id, List<String> orderId, Date inDate,
			 String destination,List<Integer> areaNum,
			List<Integer> rowNum, List<Integer> frameNum, List<Integer> item) {
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

	

	public StoreinCreateVO(String id, List<String> orderId, Date inDate,
			String destination, List<Integer> areaNum, List<Integer> rowNum,
			List<Integer> frameNum, List<Integer> item, String organization) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.inDate = inDate;
		this.destination = destination;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
		this.organization = organization;
	}


	

	public String getOrganization() {
		return organization;
	}



	public void setOrganization(String organization) {
		this.organization = organization;
	}



	public String getId() {
		return id;
	}

	public List<String> getOrderId() {
		return orderId;
	}

	public Date getInDate() {
		return inDate;
	}

	public String getDestination(){
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
	
	public StoreinPO getStoreinPO(){
		return new StoreinPO(id, orderId, inDate, destination, areaNum, rowNum, frameNum, item, organization);
	}

}
