package businesslogic.checkbl.truckinfo;

import java.util.Date;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class TruckPurchasedDate implements CheckInfo{
    
    private Date purchaseDate;
    
    public TruckPurchasedDate(Date purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    @Override
    public CheckResultMessage check() {
        CheckResultMessage checkResultMessage = new CheckResultMessage();
        long day = (this.purchaseDate.getTime() - System.currentTimeMillis())/(1000*60*60*24);
        if(day >= 1 && day< 30 ){
            checkResultMessage.addInfo(CheckResult.WARNING, "�������������ڽ��գ���ȷ��");
        }else if(day >= 30){
            checkResultMessage.addInfo(CheckResult.FALSE, "�������������ڽ���30�죬����");
        }
        return checkResultMessage;
    }
}
