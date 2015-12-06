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
			checkResultMessage.addInfo(CheckResult.FALSE, "�������Ʋ���Ϊ��");
			return checkResultMessage;
		}
		if(!organizationName.equals("�ܲ�")){
			if(!isChinese(organizationName)){
				checkResultMessage.addInfo(CheckResult.FALSE, "��������ֻ��Ϊ����");
				return checkResultMessage;
			}
			if(!organizationName.contains(cityName)){
				checkResultMessage.addInfo(CheckResult.FALSE, "������������в���Ӧ");
				return checkResultMessage;
			}
			if(!organizationName.contains("��ת����") && !organizationName.contains("Ӫҵ��")){
				checkResultMessage.addInfo(CheckResult.FALSE, "�������Ʋ���ȷ��Ӧ��������ת���ġ���Ӫҵ����");
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
