package businesslogic.checkbl.deliverinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.orderbl.Order;
import businesslogic.userbl.LoginController;

public class DeliverOrderId implements CheckInfo{
    
    private String orderId;
    private String organization;
    
    public DeliverOrderId(String orderId){
        this.orderId = orderId;
        this.organization = LoginController.getOrganizationName();
    }
    
    @Override
    public CheckResultMessage check() {
        CheckResultMessage checkResultMessage = new CheckResultMessage();
        if(orderId.length() != 10){
            checkResultMessage.addInfo(CheckResult.FALSE, "������ų��Ȳ���ȷ,ӦΪ10λ");
            return checkResultMessage;
        }else{
            Order orderbl = new Order();

        }
        
        return checkResultMessage;
    }

}
