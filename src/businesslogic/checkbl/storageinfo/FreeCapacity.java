package businesslogic.checkbl.storageinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.storagebl.StorageHelper;
import businesslogic.userbl.LoginController;

public class FreeCapacity implements CheckInfo{
	
	private int freeCapacity;

	public FreeCapacity(int freeCapacity) {
		super();
		this.freeCapacity = freeCapacity;
	}

	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		StorageHelper helper = new StorageHelper();
		int max = helper.getMaxAir(LoginController.getOrganizationId());
		if (freeCapacity>20) {
			checkResultMessage.addInfo(CheckResult.FALSE, "ÿ���������20����");
			return checkResultMessage;
		}
		if (freeCapacity<0||freeCapacity<max+1) {
			checkResultMessage.addInfo(CheckResult.FALSE, "�ŵĸ���Ӧ��1-"+(max+1)+"");
		}
		return checkResultMessage;
	}
		

}