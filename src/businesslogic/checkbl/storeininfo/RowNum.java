package businesslogic.checkbl.storeininfo;

import systemenum.CheckResult;
import vo.StorageSetAreaVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.storagebl.Storage;
import businesslogic.userbl.LoginController;


/**
 * 该类用于检查中转中心仓库管理人员在进行
 * 货物入库时输入的排号是否正确
 * @author lc
 * @version 1.1
 *
 */
public class RowNum implements CheckInfo{

	private int areaNum;
	private int rowNum;
	private String storageId;
	
	public RowNum(int areaNum, int rowNum) {
		this.areaNum = areaNum;
		this.rowNum = rowNum;
	}
	
	@Override
	public CheckResultMessage check() {
		Storage storage = new Storage();
		StorageSetAreaVO storageSetAreaVO = storage.getStorageData(LoginController.getOrganizationId());
		if (storageSetAreaVO == null) {
			storageSetAreaVO = storage.getStorageData(storageId);
		}
		int maxRow = -2;
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		switch (areaNum) {
		case 0:
			maxRow = storageSetAreaVO.getAirCapacity();
			break;
		case 1:
			maxRow = storageSetAreaVO.getTrainCapacity();
			break;
		case 2:
			maxRow = storageSetAreaVO.getCarCapacity();
			break;
		case 3:
			maxRow = storageSetAreaVO.getMotorCapacity();
		default:
			break;
		}
		
		if (maxRow == -2 && rowNum>=0 && rowNum <= 19) {
			checkResultMessage.addInfo(CheckResult.WARNING, "区号不能为空");
			return checkResultMessage;
		}
		if (rowNum<0 || rowNum>19) {
			checkResultMessage.addInfo(CheckResult.FALSE, "排号只能在0-19之间");
			return checkResultMessage;
		}
		if (maxRow == -2) {
			checkResultMessage.addInfo(CheckResult.WARNING, "输入的区号错误");
			return checkResultMessage;
		}
		
		if (rowNum>maxRow) {
			checkResultMessage.addInfo(CheckResult.FALSE, "排号不能超过该区的最大排："+maxRow);
			return checkResultMessage;
		}
		
		return checkResultMessage;
	}
	
	public void getStorageId(String id){
		this.storageId = id;
	}

}
