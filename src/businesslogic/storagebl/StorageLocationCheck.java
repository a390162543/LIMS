package businesslogic.storagebl;

public class StorageLocationCheck {
	
	private int areaNum;
   	private int rowNum;
   	private int frameNum;
   	private int item;
   	
	public StorageLocationCheck(int areaNum, int rowNum, int frameNum, int item) {
		super();
		this.areaNum = areaNum;
		this.rowNum = rowNum;
		this.frameNum = frameNum;
		this.item = item;
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
   	
   	
	

}
