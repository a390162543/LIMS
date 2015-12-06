package businesslogic.checkbl.transferinfo;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import systemenum.CheckResult;
import systemenum.ShipForm;
import vo.OrderQueryVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.orderbl.Order;

public class OrderChecker implements CheckInfo{
	
	private ShipForm shipForm;
	private String destination;
	private String orderId; 
 
	public OrderChecker(ShipForm shipForm, String destination, String orderId) { 
		this.shipForm = shipForm;
		this.destination = destination;
		this.orderId = orderId;
	}
	
	@Override
	public CheckResultMessage check() {
		// TODO Auto-generated method stub
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		Order order = new Order();
		if(orderId.length() == 0){
			checkResultMessage.addInfo(CheckResult.FALSE, "�����Ų���Ϊ��");
			return checkResultMessage;
		}
		if(!isNumeric(orderId)){
			checkResultMessage.addInfo(CheckResult.FALSE, "������ӦΪ������");
			return checkResultMessage;
		}
		OrderQueryVO vo = order.returnOrderQueryVO(orderId);
		if(vo == null){
			checkResultMessage.addInfo(CheckResult.FALSE, "�ö���������");
			return checkResultMessage;
		}
		if(vo.getShipForm() != shipForm){
			checkResultMessage.addInfo(CheckResult.FALSE, "�ö������˷�ʽ����ת����һ��");
			return checkResultMessage;
		}
		if(!vo.getNextLocation().equals(destination)){
			checkResultMessage.addInfo(CheckResult.FALSE, "�ö���Ŀ�ĵ�����ת����һ��");
			return checkResultMessage;
		}
		return checkResultMessage;
	}
	
	
	public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
         
        return isNum.matches();
  }

}
