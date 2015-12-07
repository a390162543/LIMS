package businesslogic.checkbl.revenueinfo;

import systemenum.CheckResult;
import vo.OrderRevenueVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.orderbl.Order;
import businesslogic.userbl.LoginController;

/**
 * �տ�Ķ�����ŵ�{@code CheckInfo}��ʵ����
 * @author ���滪
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
            checkResultMessage.addInfo(CheckResult.FALSE, "������ų��Ȳ���ȷ,ӦΪ10λ");
            return checkResultMessage;
        }else{
            Order orderbl = new Order();
            OrderRevenueVO orderRevenueVO = orderbl.getOrderRevenueVO(orderId);
            if(orderRevenueVO == null){
                checkResultMessage.addInfo(CheckResult.FALSE, "�����ڸö�������ȷ������");
                return checkResultMessage;
            }else{
                if(!orderRevenueVO.getOrganization().equals(organization)){
                    checkResultMessage.addInfo(CheckResult.FALSE, "�ö�����Ӧ�Ļ��ﲻ�ڱ��أ���ȷ������");
                }
            }

        }
        
        return checkResultMessage;
    }

}
