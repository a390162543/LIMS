package businesslogic.checkbl.storeininfo;

import systemenum.CheckResult;
import systemenum.StorageState;
import vo.StorageLocationVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.storagebl.StorageHelper;

public class Item implements CheckInfo{

	private StorageLocationVO storageLocationVO;
	
	
	public Item (StorageLocationVO storageLocationVO) {
		this.storageLocationVO = storageLocationVO;
	}
	
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		StorageHelper helper = new StorageHelper();
		StorageState state = helper.getLocationState(storageLocationVO);
		if (storageLocationVO.getItem()<0 || storageLocationVO.getItem()>99) {
			checkResultMessage.addInfo(CheckResult.FALSE, "位号应为0-99");
			return checkResultMessage;
		}
		if (state != StorageState.ISAVAILABLE) {
			checkResultMessage.addInfo(CheckResult.FALSE, "该位置不可用，请重新选择");
		}
		return checkResultMessage;
	}

}
