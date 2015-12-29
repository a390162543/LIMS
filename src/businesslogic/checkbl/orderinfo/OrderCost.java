package businesslogic.checkbl.orderinfo;

import java.util.regex.Pattern;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class OrderCost implements CheckInfo{

	
private String price;
	
	public OrderCost(String price) {
		// TODO Auto-generated constructor stub
		this.price = price;
	}
	@Override
	public CheckResultMessage check() {
		// TODO Auto-generated method stub
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		 
		if(price.length() == 0){
			checkResultMessage.addInfo(CheckResult.FALSE, "输入不能为空");
			return checkResultMessage;
		}
		if(!isNumeric(price)){
			checkResultMessage.addInfo(CheckResult.FALSE, "输入应为纯数字");
			return checkResultMessage;
		}
		double p = new Double(price);
		if(p <= 0){
			checkResultMessage.addInfo(CheckResult.FALSE, "输入值应大于等于0");
			return checkResultMessage;
		}
		if (p<1) {
			checkResultMessage.addInfo(CheckResult.WARNING, "运费过低，请确认");
			return checkResultMessage;
		}
		if (p>=100) {
			checkResultMessage.addInfo(CheckResult.WARNING, "运费过高，请确认");
		}
		return checkResultMessage;
	}
	
	public boolean isNumeric(String str){
		 Pattern pattern = Pattern.compile("[0-9]+");  
		 Pattern pattern2 = Pattern.compile("[0-9]+[.]{1}[0-9]+");	 
		 return pattern.matcher(str).matches() || pattern2.matcher(str).matches();  
		  
	}  	
}
