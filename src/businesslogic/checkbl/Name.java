package businesslogic.checkbl;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;


/**
 * 该类用于用于输入姓名时检查名字输入的格式是否正确
 * 
 * @author lc
 * @version 1.1
 *
 */
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
			checkResultMessage.addInfo(CheckResult.FALSE, "输入的名字格式不正确");
		}
		return checkResultMessage;
	}

	
	

}
