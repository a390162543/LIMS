package po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import systemenum.StorageState;


/**
 * 保存库存中该位置的存储状态
 * 
 * @author lc
 * @version 1.4
 *
 */
public class StorageLocationPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1665465044600120945L;
	
	private String storageId;
	private int areaNum;
	private int rowNum;
	private int frameNum;
	private int item;
	private Date date;
	private StorageState state;
	
	public StorageLocationPO( int areaNum, int rowNum,int frameNum, int item, Date date, StorageState state, String storageId) {
		super();
		this.storageId = storageId;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
		this.date = date;
		this.state = state;
	}

	
	
	
	public StorageLocationPO(String info) {
		this.areaNum = Integer.parseInt(info.substring(1, 2));
		this.rowNum = Integer.parseInt(info.substring(2, 4));
		this.frameNum = Integer.parseInt(info.substring(4, 6));
		this.item = Integer.parseInt(info.substring(6, 8));
		this.state = StorageState.valueOf(info.substring(8, 22).trim());
		this.storageId = info.substring(32, 36);
		this.date = new Date();
	}
	

	
	public StorageLocationPO(String storageId, int areaNum, int rowNum,
			int frameNum, int item, Date date) {
		super();
		this.storageId = storageId;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
		this.date = date;
	}




	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StorageState getState() {
		return state;
	}

	public void setStste(StorageState state) {
		this.state = state;
	}
	
	
	/**
	 * 获取库存位置的信息
	 * 
	 * @return 返回库存信息{@code String}
	 */
	public String getStorageLocationInfo() {
		String stateString = state.toString();
		int length = state.toString().length();
		
		for (int i = 0; i < 14-length; i++) {
			stateString = stateString+" ";
		}
		return String.format("%02d", areaNum)+String.format("%02d", rowNum)+String.format("%02d", frameNum)+String.format("%02d", item)
				+stateString+new SimpleDateFormat("yyyy-MM-dd").format(date).toString()+storageId;
	}
	
}
