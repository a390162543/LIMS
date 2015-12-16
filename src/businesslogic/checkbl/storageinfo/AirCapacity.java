package businesslogic.checkbl.storageinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.storagebl.StorageHelper;
import businesslogic.userbl.LoginController;


/**
 * 该类用于检查中转中心仓库管理人员在进行
 * 库存分区调整时输入的航空区的大小是否正确
 * 
 * @author lc
 * @version 1.1
 *
 */
public class AirCapacity implements CheckInfo{

	private int airCapacity;
	
	public AirCapacity(int airCapacity) {
		this.airCapacity = airCapacity;
	}
	
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		StorageHelper helper = new StorageHelper();
		int max = helper.getMaxAir(LoginController.getOrganizationId());
		if (airCapacity>20) {
			checkResultMessage.addInfo(CheckResult.FALSE, "每个区最多有20个排");
			return checkResultMessage;
		}
		if (airCapacity<0||airCapacity<max+1) {
			checkResultMessage.addInfo(CheckResult.FALSE, "排的个数应在1-"+(max+1)+"");
		}
		return checkResultMessage;
	}

}
