package vo;

import java.util.Date;


public class StorageCheckVO {
	
	private long id;
	private Date inDate;
	private String nextLocation;
	
	private int areaNum;
   	private int rowNum;
   	private int frameNum;
   	private int item;
   	
   	
	public StorageCheckVO(long id, Date inDate, String nextLocation,
			int areaNum, int rowNum, int frameNum, int item) {
		super();
		this.id = id;
		this.inDate = inDate;
		this.nextLocation = nextLocation;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
	}


	public long getId() {
		return id;
	}

	public Date getInDate() {
		return inDate;
	}

	public String getNextLocation() {
		return nextLocation;
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
   	
	
	
}
