package vo;

import java.util.Date;


/**
 * 该VO包含了在库存中获取的信息，用于库存盘点时返回信息
 * 
 * @author lc
 * @version 1.3
 *
 */
public class StorageCheckVO {
	
	private String id;
	private Date inDate;
	private String nextLocation;
	
	private int areaNum;
   	private int rowNum;
   	private int frameNum;
   	private int item;
   	
   	
	public StorageCheckVO(String id, Date inDate, String nextLocation,
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


	public String getId() {
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
