package businesslogic.checkbl.deliverinfo;

import systemenum.CheckResult;
import vo.OrderQueryVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.orderbl.Order;
import businesslogic.userbl.LoginController;

/**
 * 派件单的订单编号的{@code CheckInfo}的实现类
 * @author 林祖华
 * @version 1.2
 */
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
            checkResultMessage.addInfo(CheckResult.FALSE, "订单编号长度不正确,应为10位");
            return checkResultMessage;
        }else{
            Order orderbl = new Order();
            OrderQueryVO orderQueryVO = orderbl.returnOrderQueryVO(orderId);
            if(orderQueryVO == null){
                checkResultMessage.addInfo(CheckResult.FALSE, "不存在该订单，请确认输入");
                return checkResultMessage;
            }else{
                if(!orderQueryVO.getNowLocation().equals(organization)){
                    checkResultMessage.addInfo(CheckResult.FALSE, "该订单对应的货物不在本地，请确认输入");
                }
            }
        }
        
        return checkResultMessage;
    }

}
