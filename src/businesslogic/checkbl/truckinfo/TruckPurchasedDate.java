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
            checkResultMessage.addInfo(CheckResult.WARNING, "购买日期已晚于今日，请确认");
        }else if(day >= 30){
            checkResultMessage.addInfo(CheckResult.FALSE, "购买日期已晚于今日30天，请检查");
        }
        return checkResultMessage;
    }
}
