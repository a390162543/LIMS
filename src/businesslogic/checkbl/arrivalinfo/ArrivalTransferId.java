package businesslogic.checkbl.arrivalinfo;

import systemenum.CheckResult;
import vo.LoadVO;
import vo.TransferVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.loadbl.Load;
import businesslogic.transferbl.Transfer;
import businesslogic.userbl.LoginController;

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
        if(transferId.length()<16 || transferId.length()>18){
            checkResultMessage.addInfo(CheckResult.FALSE, "��ת����װ������ų��Ȳ���ȷ");
            checkResultMessage.addInfo(CheckResult.FALSE, "��ת����ų���ӦΪ17λ");
            checkResultMessage.addInfo(CheckResult.FALSE, "װ������ų���ӦΪ16��18λ");
            return checkResultMessage;
        }else if(transferId.length() == 16 || transferId.length() == 18 ){
            Load loadbl = new Load();
            LoadVO loadVO = loadbl.getLoadVO(transferId);
            if(loadVO == null){
                checkResultMessage.addInfo(CheckResult.FALSE, "�����ڸ�װ��������ȷ������");
            }else if(!loadVO.getDestination().equals(organization)){
                checkResultMessage.addInfo(CheckResult.FALSE, "װ����Ŀ�ĵ��뱾�ز�һ�£���ȷ������");
            }
        }else{
            Transfer transferbl = new Transfer();
            TransferVO transferVO = transferbl.getTransferVO(transferId);
            if(transferVO == null){
                checkResultMessage.addInfo(CheckResult.FALSE, "�����ڸ���ת������ȷ������");
            }else if(!transferVO.getDestination().equals(organization)){
                checkResultMessage.addInfo(CheckResult.FALSE, "��ת��Ŀ�ĵ��뱾�ز�һ�£���ȷ������");
            }
        }
        return checkResultMessage;
    }
}
