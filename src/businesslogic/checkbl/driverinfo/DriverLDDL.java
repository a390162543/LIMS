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
            checkResultMessage.addInfo(CheckResult.FALSE, "��ʻ֤�ѹ���һ��,Ӧ��ע������");
        }else if(day < 0){
            checkResultMessage.addInfo(CheckResult.WARNING, "��ʻ֤�ѹ���,�뾡�����");
        }else if(day < 90){
            checkResultMessage.addInfo(CheckResult.WARNING, "��ʻ֤��������,�뾡�����");
        }
        return checkResultMessage;
    }
}
