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
 */
public class TrainCapacity implements CheckInfo{

	private int trainCapacity;
	
	
	
	public TrainCapacity(int trainCapacity) {
		super();
		this.trainCapacity = trainCapacity;
	}


	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		StorageHelper helper = new StorageHelper();
		int max = helper.getMaxTrain(LoginController.getOrganizationId());
		if (trainCapacity>20) {
			checkResultMessage.addInfo(CheckResult.FALSE, "ÿ���������20����");
			return checkResultMessage;
		}
		if (trainCapacity<0||trainCapacity<max+1) {
			checkResultMessage.addInfo(CheckResult.FALSE, "�ŵĸ���Ӧ����"+(max+1)+"С��20");
		}
		return checkResultMessage;
		
	}

}
