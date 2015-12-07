package businesslogic.checkbl.deliverinfo;

import systemenum.CheckResult;
import vo.OrderQueryVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.orderbl.Order;
import businesslogic.userbl.LoginController;

/**
 * �ɼ����Ķ�����ŵ�{@code CheckInfo}��ʵ����
 * @author ���滪
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
            checkResultMessage.addInfo(CheckResult.FALSE, "������ų��Ȳ���ȷ,ӦΪ10λ");
            return checkResultMessage;
        }else{
            Order orderbl = new Order();
            OrderQueryVO orderQueryVO = orderbl.returnOrderQueryVO(orderId);
            if(orderQueryVO == null){
                checkResultMessage.addInfo(CheckResult.FALSE, "�����ڸö�������ȷ������");
                return checkResultMessage;
            }else{
                if(!orderQueryVO.getNowLocation().equals(organization)){
                    checkResultMessage.addInfo(CheckResult.FALSE, "�ö�����Ӧ�Ļ��ﲻ�ڱ��أ���ȷ������");
                }
            }
        }
        
        return checkResultMessage;
    }

}
