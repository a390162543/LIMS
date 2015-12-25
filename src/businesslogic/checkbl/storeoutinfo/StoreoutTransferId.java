package businesslogic.checkbl.storeoutinfo;

import systemenum.CheckResult;
import systemenum.StorageState;
import vo.LoadVO;
import vo.OrderQueryVO;
import vo.StoreinOrderVO;
import vo.TransferVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.loadbl.Load;
import businesslogic.orderbl.Order;
import businesslogic.transferbl.Transfer;
import businesslogic.userbl.LoginController;


/**
 * �������ڼ����ת���Ĳֿ������Ա�ڽ���
 * �������ʱ��ӵĶ������Ƿ���ȷ
 * 
 * @author lc
 * @version 1.1
 *
 */
public class StoreoutTransferId implements CheckInfo{

	private String transferId;
	private String organization;
	
	public StoreoutTransferId(String transferId) {
		this.transferId = transferId;
		this.organization = LoginController.getOrganizationName();
	}
	
	@Override
	public CheckResultMessage check() {
		 CheckResultMessage checkResultMessage = new CheckResultMessage();
	        if(transferId.length()<18 || transferId.length()>20){
	            checkResultMessage.addInfo(CheckResult.FALSE, "��ת����װ������ų��Ȳ���ȷ");
	            checkResultMessage.addInfo(CheckResult.FALSE, "��ת����ų���ӦΪ19λ");
	            checkResultMessage.addInfo(CheckResult.FALSE, "װ������ų���ӦΪ18��20λ");
	            return checkResultMessage;
	        }else if(transferId.length() == 18 || transferId.length() == 20 ){
	            Load loadbl = new Load();
	            LoadVO loadVO = loadbl.getLoadVO(transferId);
	            if(loadVO == null){
	                checkResultMessage.addInfo(CheckResult.FALSE, "�����ڸ�װ��������ȷ������");
	            }else if(!loadVO.getDepart().equals(organization)){
	                checkResultMessage.addInfo(CheckResult.FALSE, "װ�����������뱾�ز�һ�£���ȷ������");
	            }
	        }else{
	            Transfer transferbl = new Transfer();
	            TransferVO transferVO = transferbl.getTransferVO(transferId);

	            if(transferVO == null){
	                checkResultMessage.addInfo(CheckResult.FALSE, "�����ڸ���ת������ȷ������");
	            }else if(!transferVO.getDepart().equals(organization)){
	                checkResultMessage.addInfo(CheckResult.FALSE, "��ת���������뱾�ز�һ�£���ȷ������");
	            }
	        }
	        return checkResultMessage;
	    }

}
