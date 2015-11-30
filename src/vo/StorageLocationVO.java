package vo;

import java.util.Date;

import po.StorageLocationPO;
import systemenum.StorageState;

public class StorageLocationVO {
	
	String storageId;
	int areaNum;
	int rowNum;
	int frameNum;
	int item;
	StorageState state;
	
	public StorageLocationVO(String storageId, int areaNum, int rowNum,
			int frameNum, int item) {
		super();
		this.storageId = storageId;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
	}
	
	

	public StorageLocationVO(String storageId, int areaNum, int rowNum,
			int frameNum, int item, StorageState state) {
		super();
		this.storageId = storageId;
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
		this.state = state;
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
	
		
	public StorageState getState() {
		return state;
	}

	public void setState(StorageState state) {
		this.state = state;
	}



	public StorageLocationPO getStorageLocationPO() {
		return new StorageLocationPO(areaNum, rowNum, frameNum, item, new Date(), state, storageId);
	}

}
