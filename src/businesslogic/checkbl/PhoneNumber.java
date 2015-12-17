package businesslogic.checkbl;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class PhoneNumber implements CheckInfo{
	
	private String phoneNumber;
	
	public PhoneNumber(String phoneNumber) {
		// TODO Auto-generated constructor stub
		this.phoneNumber = phoneNumber;
	}
	@Override
	public CheckResultMessage check() {
		// TODO Auto-generated method stub
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(phoneNumber.length() == 0){
			 checkResultMessage.addInfo(CheckResult.FALSE, "手机号码不能为空");
	         return checkResultMessage;
		}
		if(!isNumeric(phoneNumber)){
			checkResultMessage.addInfo(CheckResult.FALSE, "手机号码应为以1开头的11位数字");
	         return checkResultMessage;
		}
		if(phoneNumber.length() != 11){
			 checkResultMessage.addInfo(CheckResult.FALSE, "手机号码应为11位");
	         return checkResultMessage;
		}
		
		return checkResultMessage;
	}
	
	public boolean isNumeric(String str){ 
		 
		Pattern p = Pattern.compile("[1]{1}[0-9]{10}");
		Matcher m = p.matcher(str);  
		return m.matches();
			  
	} 
	
		

}
