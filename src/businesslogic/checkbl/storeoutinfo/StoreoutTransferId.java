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
 * 该类用于检查中转中心仓库管理人员在进行
 * 货物出库时添加的订单号是否正确
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
	            checkResultMessage.addInfo(CheckResult.FALSE, "中转单或装车单编号长度不正确");
	            checkResultMessage.addInfo(CheckResult.FALSE, "中转单编号长度应为19位");
	            checkResultMessage.addInfo(CheckResult.FALSE, "装车单编号长度应为18或20位");
	            return checkResultMessage;
	        }else if(transferId.length() == 18 || transferId.length() == 20 ){
	            Load loadbl = new Load();
	            LoadVO loadVO = loadbl.getLoadVO(transferId);
	            if(loadVO == null){
	                checkResultMessage.addInfo(CheckResult.FALSE, "不存在该装车单，请确认输入");
	            }else if(!loadVO.getDepart().equals(organization)){
	                checkResultMessage.addInfo(CheckResult.FALSE, "装车单出发地与本地不一致，请确认输入");
	            }
	        }else{
	            Transfer transferbl = new Transfer();
	            TransferVO transferVO = transferbl.getTransferVO(transferId);

	            if(transferVO == null){
	                checkResultMessage.addInfo(CheckResult.FALSE, "不存在该中转单，请确认输入");
	            }else if(!transferVO.getDepart().equals(organization)){
	                checkResultMessage.addInfo(CheckResult.FALSE, "中转单出发地与本地不一致，请确认输入");
	            }
	        }
	        return checkResultMessage;
	    }

}
