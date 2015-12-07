package businesslogic.checkbl.arrivalinfo;

import systemenum.CheckResult;
import vo.LoadVO;
import vo.TransferVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.loadbl.Load;
import businesslogic.transferbl.Transfer;
import businesslogic.userbl.LoginController;

/**
 * 到达单的中转单编号的{@code CheckInfo}的实现类
 * @author 林祖华
 * @version 1.4
 */
public class ArrivalTransferId implements CheckInfo{
    
    private String transferId;
    private String organization;
    
    public ArrivalTransferId(String transferId) {
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
            }else if(!loadVO.getDestination().equals(organization)){
                checkResultMessage.addInfo(CheckResult.FALSE, "装车单目的地与本地不一致，请确认输入");
            }
        }else{
            Transfer transferbl = new Transfer();
            TransferVO transferVO = transferbl.getTransferVO(transferId);
            if(transferVO == null){
                checkResultMessage.addInfo(CheckResult.FALSE, "不存在该中转单，请确认输入");
            }else if(!transferVO.getDestination().equals(organization)){
                checkResultMessage.addInfo(CheckResult.FALSE, "中转单目的地与本地不一致，请确认输入");
            }
        }
        return checkResultMessage;
    }
}
