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
			 checkResultMessage.addInfo(CheckResult.FALSE, "�ֻ����벻��Ϊ��");
	         return checkResultMessage;
		}
		if(!isNumeric(phoneNumber)){
			checkResultMessage.addInfo(CheckResult.FALSE, "�ֻ�����ӦΪ��1��ͷ��11λ����");
	         return checkResultMessage;
		}
		if(phoneNumber.length() != 11){
			 checkResultMessage.addInfo(CheckResult.FALSE, "�ֻ�����ӦΪ11λ");
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
