package businesslogic.checkbl.storeininfo;

import systemenum.CheckResult;
import systemenum.StorageState;
import vo.StorageLocationVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.storagebl.StorageHelper;


/**
 * �������ڼ����ת���Ĳֿ������Ա�ڽ���
 * �������ʱ�����λ���Ƿ���ȷ
 * @author lc
 * @version 1.1
 *
 */
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
			checkResultMessage.addInfo(CheckResult.FALSE, "λ��ӦΪ0-99");
			return checkResultMessage;
		}
		if (state != StorageState.ISAVAILABLE) {
			checkResultMessage.addInfo(CheckResult.FALSE, "��λ�ò����ã�������ѡ��");
		}
		return checkResultMessage;
	}

}
