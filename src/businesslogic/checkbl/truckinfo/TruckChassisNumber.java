package businesslogic.checkbl.truckinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class TruckChassisNumber implements CheckInfo{
    
    private String chassisNumber;
    
    public TruckChassisNumber(String chassisNumber){
        this.chassisNumber = chassisNumber;
    }

    @Override
    public CheckResultMessage check() {
        CheckResultMessage checkResultMessage = new CheckResultMessage();
        if(!(chassisNumber.matches("[a-zA-Z0-9]+")||
                chassisNumber.matches("[a-zA-Z0-9]+[-]{1}[a-zA-Z0-9]+"))){
            checkResultMessage.addInfo(CheckResult.FALSE, "���̺Ÿ�ʽ����ȷ��ӦΪ���֡���ĸ�����-�����");
            return checkResultMessage;
        }
        return checkResultMessage;
    }
    
    
}
