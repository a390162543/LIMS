package businesslogic.checkbl.userinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.userbl.User;

public class NewPassword implements CheckInfo{
	
	private String password;
	
	public NewPassword(String password) {
		// TODO Auto-generated constructor stub
		this.password = password;
	}
	@Override
	public CheckResultMessage check() {
		// TODO Auto-generated method stub
		 
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(password.length() == 0){
			checkResultMessage.addInfo(CheckResult.FALSE, "���벻��Ϊ��");
			return checkResultMessage;
		}
		if(password.length() < 6){
			checkResultMessage.addInfo(CheckResult.FALSE, "����̫��");
			return checkResultMessage;
		}
		if(password.length() > 16){
			checkResultMessage.addInfo(CheckResult.FALSE, "����̫��");
			return checkResultMessage;
		}
		return checkResultMessage;
	}

}
