package businesslogic.checkbl.storageinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.storagebl.StorageHelper;
import businesslogic.userbl.LoginController;

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
			checkResultMessage.addInfo(CheckResult.FALSE, "每个区最多有20个排");
			return checkResultMessage;
		}
		if (trainCapacity<0||trainCapacity<max+1) {
			checkResultMessage.addInfo(CheckResult.FALSE, "排的个数应在1-"+(max+1)+"");
		}
		return checkResultMessage;
		
	}

}
