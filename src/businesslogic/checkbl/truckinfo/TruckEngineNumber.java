package businesslogic.checkbl.truckinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

/**
 * �����ķ������ŵ�{@code CheckInfo}��ʵ����
 * @author ���滪
 * @version 1.0
 */
public class TruckEngineNumber implements CheckInfo{
    private String engineNumber;
    
    public TruckEngineNumber(String engineNumber){
        this.engineNumber = engineNumber;
    }

    @Override
    public CheckResultMessage check() {
        CheckResultMessage checkResultMessage = new CheckResultMessage();
        if(!(engineNumber.matches("[a-zA-Z0-9]+")||
                engineNumber.matches("[a-zA-Z0-9]+[-]{1}[a-zA-Z0-9]+"))){
            checkResultMessage.addInfo(CheckResult.FALSE, "����Ÿ�ʽ����ȷ��ӦΪ���֡���ĸ�����-�����");
            return checkResultMessage;
        }
        return checkResultMessage;
    }
}
