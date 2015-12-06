package businesslogic.checkbl.organizationinfo;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class OrganizationName implements CheckInfo{
	
	private String organizationName;
	private String cityName;
	
	public OrganizationName(String organizationName, String cityName) {
		 
		this.organizationName = organizationName;
		this.cityName = cityName;
	}

	@Override
	public CheckResultMessage check() {
		// TODO Auto-generated method stub
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(organizationName.length() == 0){
			checkResultMessage.addInfo(CheckResult.FALSE, "机构名称不能为空");
			return checkResultMessage;
		}
		if(!organizationName.equals("总部")){
			if(!isChinese(organizationName)){
				checkResultMessage.addInfo(CheckResult.FALSE, "机构名称只能为汉字");
				return checkResultMessage;
			}
			if(!organizationName.contains(cityName)){
				checkResultMessage.addInfo(CheckResult.FALSE, "机构名称与城市不对应");
				return checkResultMessage;
			}
			if(!organizationName.contains("中转中心") && !organizationName.contains("营业厅")){
				checkResultMessage.addInfo(CheckResult.FALSE, "机构名称不正确，应包含“中转中心”或“营业厅”");
				return checkResultMessage;
			}
		}			
		return checkResultMessage;
	}
	
	public boolean isChinese(String str){
		String reg = "[\\u4e00-\\u9fa5]+";
		return str.matches(reg);
	}

}
