package businesslogic.checkbl.arrivalinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.loadbl.Load;

public class ArrivalTransferId implements CheckInfo{
    
    private String transferId;
    
    public ArrivalTransferId(String transferId) {
        this.transferId = transferId;
    }
    
    @Override
    public CheckResultMessage check() {
        CheckResultMessage checkResultMessage = new CheckResultMessage();
        Load load = new Load();
        if(transferId.length()<16 || transferId.length()>18){
            checkResultMessage.addInfo(CheckResult.FALSE, "��ת����װ������ų���ӦΪ16-18λ");
            return checkResultMessage;
        }
        if((transferId.length() == 16 || transferId.length() == 18 ) 
                && load.getLoadVO(transferId) == null){
            checkResultMessage.addInfo(CheckResult.FALSE, "�����ڸ�װ��������ȷ������");
        }

        return checkResultMessage;
    }

}
