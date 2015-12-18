package businesslogic.checkbl.paymentinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
/**
 * {@code CheckInfo}的实现类，为界面层提供付款人姓名的检查服务
 * @author 刘德宽
 *
 */
public class PayeeName implements CheckInfo{

	private String payeeName;
	
	public PayeeName(String payeeName){
		this.payeeName = payeeName;
	}
	@Override
	public CheckResultMessage check(){
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(!payeeName.matches("[\\u4e00-\\u9fa5]")){
			checkResultMessage.addInfo(CheckResult.FALSE, "收款人姓名应由中英文组成");
			return checkResultMessage;
		}
			
		return checkResultMessage;
	}

}
