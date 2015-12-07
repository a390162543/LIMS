package businesslogic.checkbl.revenueinfo;

import systemenum.CheckResult;
import vo.OrderRevenueVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.orderbl.Order;
import businesslogic.userbl.LoginController;

/**
 * 收款单的订单编号的{@code CheckInfo}的实现类
 * @author 林祖华
 * @version 1.1
 */
public class RevenueOrderId implements CheckInfo{

    private String orderId;
    private String organization;
    
    public RevenueOrderId(String orderId){
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
            OrderRevenueVO orderRevenueVO = orderbl.getOrderRevenueVO(orderId);
            if(orderRevenueVO == null){
                checkResultMessage.addInfo(CheckResult.FALSE, "不存在该订单，请确认输入");
                return checkResultMessage;
            }else{
                if(!orderRevenueVO.getOrganization().equals(organization)){
                    checkResultMessage.addInfo(CheckResult.FALSE, "该订单对应的货物不在本地，请确认输入");
                }
            }

        }
        
        return checkResultMessage;
    }

}
