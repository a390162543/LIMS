package businesslogic.checkbl.transferinfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;

public class TransferNumber implements CheckInfo{
	
	private String number;
	
	public TransferNumber(String number) {
		// TODO Auto-generated constructor stub
		this.number = number;
	}
	@Override
	public CheckResultMessage check() {
		// TODO Auto-generated method stub
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(number.length() == 0){
			checkResultMessage.addInfo(CheckResult.FALSE, "���벻��Ϊ��");
			return checkResultMessage;
		}
		if(!isNumeric(number)){
			checkResultMessage.addInfo(CheckResult.FALSE, "�����ʽ����ӦΪ������");
			return checkResultMessage;
		}
		return checkResultMessage;
	}
	
	public boolean isNumeric(String str){
          Pattern pattern = Pattern.compile("[0-9]*");
          Matcher isNum = pattern.matcher(str);
           
          return isNum.matches();
    }

}
