package businesslogic.checkbl.employeeinfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class EmployeePhoneNumber implements CheckInfo{
	
	private String phoneNumber;
	
	public EmployeePhoneNumber(String phoneNumber) {
		// TODO Auto-generated constructor stub
		this.phoneNumber = phoneNumber;
	}
	@Override
	public CheckResultMessage check() {
		// TODO Auto-generated method stub
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(!isNumeric(phoneNumber)){
			checkResultMessage.addInfo(CheckResult.FALSE, "电话号码不符合格式，应为纯数字");
	         return checkResultMessage;
		}
		if(phoneNumber.length() != 11){
			 checkResultMessage.addInfo(CheckResult.FALSE, "电话号码应为11位");
	         return checkResultMessage;
		}
		
		return checkResultMessage;
	}
	
	public boolean isNumeric(String str){ 
		 
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");  			  
		Matcher m = p.matcher(str);  
		return m.matches();
			  
	} 
		

}
