package businesslogic.checkbl.employeeinfo;


import java.util.Date;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;


public class EmployeeBirth implements CheckInfo{
    
    private Date purchaseDate;
    
    public EmployeeBirth(Date purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    @Override
    public CheckResultMessage check() {
        CheckResultMessage checkResultMessage = new CheckResultMessage();
        long year = (System.currentTimeMillis()-this.purchaseDate.getTime())/(1000*60*60*24 );
        year = year / 365 ;
        System.out.println( year);
        if(year <= 16 ){
            checkResultMessage.addInfo(CheckResult.FALSE, "��Ա��С��16�꣬��������");
        }
        else if(year >60){
        	 checkResultMessage.addInfo(CheckResult.WARNING, "��Ա������60�꣬��������");
        }
        return checkResultMessage;
    }
}
