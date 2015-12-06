package businesslogic.checkbl.userinfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

 


import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.userbl.User;

public class UserId implements CheckInfo{
	private String id;
	
	public UserId(String id) {
		super();
		this.id = id;
	}

	@Override
	public CheckResultMessage check() {
		// TODO Auto-generated method stub
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(id.length() == 0){
			checkResultMessage.addInfo(CheckResult.FALSE, "用户帐号 不能为空");
	        return checkResultMessage;
		}
		if(!isNumeric(id)){
			checkResultMessage.addInfo(CheckResult.FALSE, "用户帐号只能为纯数字");
	         return checkResultMessage;
		}
		
		User user = new User();
		if(user.find(id) == null){
			checkResultMessage.addInfo(CheckResult.FALSE, "该用户不存在");
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
