package businesslogic.checkbl.truckinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

/**
 * 车辆的底盘号的{@code CheckInfo}的实现类
 * @author 林祖华
 * @version 1.0
 */
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
            checkResultMessage.addInfo(CheckResult.FALSE, "底盘号格式不正确，应为数字、字母与符号-的组合");
            return checkResultMessage;
        }
        return checkResultMessage;
    }
    
    
}
