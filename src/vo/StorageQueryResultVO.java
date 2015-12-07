package vo;

import java.util.Date;


/**
 * 库存查看时的VO，用于传递库存货物的信息
 * @author lc
 * @version 1.3
 *
 */
public class StorageQueryResultVO {

	private String orderId;
	private int areaNum;
	private int rowNum;
	private int frameNum;
	private int item;
	private Date date;
	private String destination;
	
	public StorageQueryResultVO(String orderId, int areaNum, int rowNum,
			int frameNum, int item, Date date, String destination) {
		super();
		this.orderId = orderId;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
		this.date = date;
		this.destination = destination;
	}

	public String getOrderId() {
		return orderId;
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

	public Date getDate() {
		return date;
	}

	public String getDestination() {
		return destination;
	}
	
	
	
}
