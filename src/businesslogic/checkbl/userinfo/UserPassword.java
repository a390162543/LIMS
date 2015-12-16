package businesslogic.checkbl.userinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.userbl.User;

public class UserPassword implements CheckInfo{
	String password;
	String id;
	 
	public UserPassword(String password, String id) {
		super();
		this.password = password;
		this.id = id;
	}

	@Override
	public CheckResultMessage check() {
		// TODO Auto-generated method stub
		User user = new User();
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(password == null){
			checkResultMessage.addInfo(CheckResult.FALSE, "密码不能为空");
			return checkResultMessage;
		}
		if(!user.queryUserPO(id, password)){
			 checkResultMessage.addInfo(CheckResult.FALSE, "密码不正确");
				return checkResultMessage;
		 }
		
		return checkResultMessage;
	}

}
