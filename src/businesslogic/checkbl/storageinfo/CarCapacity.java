package businesslogic.checkbl.storageinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.storagebl.StorageHelper;
import businesslogic.userbl.LoginController;

/**
 * 该类用于检查中转中心仓库管理人员在进行
 * 库存分区调整时输入的汽运区的大小是否正确
 * @author lc
 * @version 1.1
 *
 */
public class CarCapacity implements CheckInfo{
	
	private int carCapacity;

	public CarCapacity(int carCapacity) {
		super();
		this.carCapacity = carCapacity;
	}

	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		StorageHelper helper = new StorageHelper();
		int max = helper.getMaxCar(LoginController.getOrganizationId());
		if (carCapacity>20) {
			checkResultMessage.addInfo(CheckResult.FALSE, "每个区最多有20个排");
			return checkResultMessage;
		}
		if (carCapacity<0||carCapacity<max+1) {
			checkResultMessage.addInfo(CheckResult.FALSE, "排的个数应在大于"+(max+1)+"小于20");
		}
		return checkResultMessage;
	}
	
	

}
