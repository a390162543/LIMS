package businesslogic.checkbl.storeininfo;

import systemenum.CheckResult;
import vo.StorageVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.storagebl.Storage;
import businesslogic.userbl.LoginController;


/**
 * 该类用于检查中转中心仓库管理人员在进行
 * 货物入库添加货物后库存是否超过警戒值
 * @author lc
 * @version 1.1
 *
 */
public class AlarmNum implements CheckInfo{

	private int addedOrder;
	
	public AlarmNum(int addedOrder) {
		this.addedOrder = addedOrder;
	}
	
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		Storage storage = new Storage();
		StorageVO storageVO = storage.getStorageVO(LoginController.getOrganizationId());
		if (storageVO == null) {
			checkResultMessage.addInfo(CheckResult.FALSE, "库存未被初始化");
			return checkResultMessage;
		}
		if ((double)(addedOrder+storageVO.getNowCapacity())/storageVO.getAllCapacity()>storageVO.getAlarm()) {
			checkResultMessage.addInfo(CheckResult.WARNING, "库存超过警戒值");
		}
		return checkResultMessage;
	}

}
