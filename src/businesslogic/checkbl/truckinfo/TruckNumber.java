package businesslogic.checkbl.truckinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

/**
 * 车辆的车牌号的{@code CheckInfo}的实现类
 * @author 林祖华
 * @version 1.0
 */
public class TruckNumber implements CheckInfo{

    private String truckNumber;
    
    public TruckNumber(String truckNumber){
        this.truckNumber = truckNumber;
    }
    
    
    @Override
    public CheckResultMessage check() {
        CheckResultMessage checkResultMessage = new CheckResultMessage();
        if(!(truckNumber.matches("[\\u4e00-\\u9fa5]{1}[a-zA-Z]{1}[a-zA-Z0-9]{5}")
                || truckNumber.matches("[\\u4e00-\\u9fa5]{1}[a-zA-Z]{1}[·]{1}[a-zA-Z0-9]{5}"))){
            checkResultMessage.addInfo(CheckResult.FALSE, "车牌号格式不正确，正确示例：苏A·00000");
        }
        return checkResultMessage;
    }

}
