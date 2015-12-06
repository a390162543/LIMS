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
			checkResultMessage.addInfo(CheckResult.FALSE, "�������Ʋ���Ϊ��");
			return checkResultMessage;
		}
		if(!isChinese(name)){
			checkResultMessage.addInfo(CheckResult.FALSE, "��������ֻ��Ϊ����");
			return checkResultMessage;
		}
		return checkResultMessage;
	}
	
	public boolean isChinese(String str){
		String reg = "[\\u4e00-\\u9fa5]+";
		return str.matches(reg);
	}

}
