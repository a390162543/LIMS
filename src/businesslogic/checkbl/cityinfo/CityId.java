package businesslogic.checkbl.cityinfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
import businesslogic.citybl.City;

public class CityId implements CheckInfo{

	private String id; 
	public CityId(String id) {
		super();
		this.id = id;
	}
	@Override
	public CheckResultMessage check() {
		// TODO Auto-generated method stub
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(id.length() == 0){
			checkResultMessage.addInfo(CheckResult.FALSE, "���б�Ų���Ϊ��");
			return checkResultMessage;
		}
		if(id.length() != 3){		
			checkResultMessage.addInfo(CheckResult.FALSE, "���б��ӦΪ3λ");
			return checkResultMessage;
		}
		if(!isAreaCode(id)){
			checkResultMessage.addInfo(CheckResult.FALSE, "���б��Ӧ��0��ͷ");
			return checkResultMessage;
		}
		City city = new City();
		if(city.getCity(id) != null){
			checkResultMessage.addInfo(CheckResult.FALSE, "�ó����Ѵ���");
			return checkResultMessage;

		}
		return checkResultMessage;
	}
	
	public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);        
        return isNum.matches();
  }
	public boolean isAreaCode(String str){
		String regex="^0\\d*$";
		return str.matches(regex);
	}
}
