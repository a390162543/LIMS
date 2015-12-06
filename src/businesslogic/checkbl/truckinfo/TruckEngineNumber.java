package businesslogic.checkbl.truckinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

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
            checkResultMessage.addInfo(CheckResult.FALSE, "引擎号格式不正确，应为数字、字母与符号-的组合");
            return checkResultMessage;
        }
        return checkResultMessage;
    }
}
