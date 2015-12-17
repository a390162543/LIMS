package businesslogic.checkbl.userinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class ConfirmPassword implements CheckInfo{
	
	private String new_Password;
	private String confirm_New_Password;
	
	
	public ConfirmPassword(String new_Password, String confirm_New_Password) {
		super();
		this.new_Password = new_Password;
		this.confirm_New_Password = confirm_New_Password;
	}


	@Override
	public CheckResultMessage check() {
		// TODO Auto-generated method stub
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(!new_Password.equals(confirm_New_Password)){
			checkResultMessage.addInfo(CheckResult.FALSE, "两次新密码不一致");
			return checkResultMessage;
		}
		return checkResultMessage;
	}

}
