package businesslogic.checkbl;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;


public class Name implements CheckInfo{
	
	String name;

	public Name(String name) {
		this.name = name;
	}
	
	@Override
	public CheckResultMessage check() {
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		String regx = "^(([\u4e00-\u9fa5]{2,8})|([a-zA-Z]{2,16}))$";
		if (!name.matches(regx)) {
			checkResultMessage.addInfo(CheckResult.FALSE, "姓名必须为2-8位汉字或2-16位英文字母");
		}
		return checkResultMessage;
	}

	
	

}
