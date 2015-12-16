package businesslogic.checkbl.storeininfo;

import systemenum.CheckResult;
import vo.StorageVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.storagebl.Storage;
import businesslogic.userbl.LoginController;


/**
 * �������ڼ����ת���Ĳֿ������Ա�ڽ���
 * ���������ӻ�������Ƿ񳬹�����ֵ
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
			checkResultMessage.addInfo(CheckResult.FALSE, "���δ����ʼ��");
			return checkResultMessage;
		}
		if ((double)(addedOrder+storageVO.getNowCapacity())/storageVO.getAllCapacity()>storageVO.getAlarm()) {
			checkResultMessage.addInfo(CheckResult.WARNING, "��泬������ֵ");
		}
		return checkResultMessage;
	}

}
