package businesslogic.checkbl.driverinfo;

import java.util.Date;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class DriverLDDL implements CheckInfo{
    
    private Date driverLDDL;
    
    public DriverLDDL(Date driverLDDL){
        this.driverLDDL = driverLDDL;
    }

    @Override
    public CheckResultMessage check() {
        CheckResultMessage checkResultMessage = new CheckResultMessage();
        long day = (driverLDDL.getTime() - System.currentTimeMillis())/(1000*60*60*24);
        if(day < -365){
            checkResultMessage.addInfo(CheckResult.FALSE, "行驶证已过期一年,应当注销资料");
        }else if(day < 0){
            checkResultMessage.addInfo(CheckResult.WARNING, "行驶证已过期,请尽快更换");
        }else if(day < 90){
            checkResultMessage.addInfo(CheckResult.WARNING, "行驶证即将过期,请尽快更换");
        }
        return checkResultMessage;
    }
}
