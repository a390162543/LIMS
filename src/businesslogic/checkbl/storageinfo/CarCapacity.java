package businesslogic.checkbl.storageinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.storagebl.StorageHelper;
import businesslogic.userbl.LoginController;

/**
 * �������ڼ����ת���Ĳֿ������Ա�ڽ���
 * ����������ʱ������������Ĵ�С�Ƿ���ȷ
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
			checkResultMessage.addInfo(CheckResult.FALSE, "ÿ���������20����");
			return checkResultMessage;
		}
		if (carCapacity<0||carCapacity<max+1) {
			checkResultMessage.addInfo(CheckResult.FALSE, "�ŵĸ���Ӧ�ڴ���"+(max+1)+"С��20");
		}
		return checkResultMessage;
	}
	
	

}
