package businesslogic.checkbl.orderinfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class OrderTelNum implements CheckInfo {
	
	private String telNum;

	public OrderTelNum(String telNum) {
		this.telNum = telNum;
	}
	
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(telNum.length() == 0){
			 checkResultMessage.addInfo(CheckResult.FALSE, "电话号码不能为空");
	         return checkResultMessage;
		}
		if(!isPhoneNumber(telNum)){
			checkResultMessage.addInfo(CheckResult.FALSE, "电话号码不符合格式 ");
	         return checkResultMessage;
		}
		return checkResultMessage;
	}
	

	private boolean isPhoneNumber(String str){  		
		Pattern p = Pattern.compile("(\\(\\d{3,4}\\)|\\d{3,4}-|\\s)?\\d{8}");  			  
		Matcher m = p.matcher(str);  
		return m.matches();
	} 
	
}
