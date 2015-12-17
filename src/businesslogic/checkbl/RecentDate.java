package businesslogic.checkbl;

import java.util.Date;

import systemenum.CheckResult;

public class RecentDate implements CheckInfo{
    
    private Date date;
    
    public RecentDate(Date date) {
        this.date = date;
    }
    
    @Override
    public CheckResultMessage check() {
        CheckResultMessage checkResultMessage = new CheckResultMessage();
        long day = (date.getTime() - System.currentTimeMillis())/(1000*60*60*24);
        day = Math.abs(day);
        
        if(day > 15){
            checkResultMessage.addInfo(CheckResult.FALSE, "日期与今日相距过长,请确认输入");
        }else if(day > 3){
            checkResultMessage.addInfo(CheckResult.WARNING, "日期与今日相距超过3天，请确认");
        }
        return checkResultMessage;
    }

}
