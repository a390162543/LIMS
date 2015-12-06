package businesslogic.checkbl.cityinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class CityName implements CheckInfo{

	private String name;
	
	public CityName(String name) {		 
		this.name = name;
	}
	

	@Override
	public CheckResultMessage check() {
		// TODO Auto-generated method stub
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(name.length() == 0){
			checkResultMessage.addInfo(CheckResult.FALSE, "城市名称不能为空");
			return checkResultMessage;
		}
		if(!isChinese(name)){
			checkResultMessage.addInfo(CheckResult.FALSE, "城市名称只能为汉字");
			return checkResultMessage;
		}
		return checkResultMessage;
	}
	
	public boolean isChinese(String str){
		String reg = "[\\u4e00-\\u9fa5]+";
		return str.matches(reg);
	}

}
