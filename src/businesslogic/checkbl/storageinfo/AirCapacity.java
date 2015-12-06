package businesslogic.checkbl.storageinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.storagebl.StorageHelper;
import businesslogic.userbl.LoginController;

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
			checkResultMessage.addInfo(CheckResult.FALSE, "ÿ���������20����");
			return checkResultMessage;
		}
		if (airCapacity<0||airCapacity<max+1) {
			checkResultMessage.addInfo(CheckResult.FALSE, "�ŵĸ���Ӧ��1-"+(max+1)+"");
		}
		return checkResultMessage;
	}

}
