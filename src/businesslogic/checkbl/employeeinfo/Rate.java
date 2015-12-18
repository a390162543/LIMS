package businesslogic.checkbl.employeeinfo;
 
import java.util.regex.Pattern;

import systemenum.CheckResult;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.CheckResultMessage;
 

public class Rate implements CheckInfo {
   private String rate;
   
	public Rate(String rate) {
	super();
	this.rate = rate;
	}
	
	@Override
	public CheckResultMessage check() {
		// TODO Auto-generated method stub
		CheckResultMessage checkResultMessage = new CheckResultMessage();
		if(rate.length() == 0){
			checkResultMessage.addInfo(CheckResult.FALSE, "���벻��Ϊ��");
			return checkResultMessage;
		}
		if(!isNumeric(rate)){
			checkResultMessage.addInfo(CheckResult.FALSE, "����ӦΪ������");
			return checkResultMessage;
		}
		double r = new Double(rate);
		if(r == 0){
			checkResultMessage.addInfo(CheckResult.WARNING, " �����Ϊ��");
			return checkResultMessage;
		}
		if(r < 0){
			checkResultMessage.addInfo(CheckResult.FALSE, "����ʲ���Ϊ��");
			return checkResultMessage;
		}
		if(r > 100){
			checkResultMessage.addInfo(CheckResult.FALSE, "����ʲ��ܴ���100%");
			return checkResultMessage;
		}
		
		return checkResultMessage;
	}
	public boolean isNumeric(String str){
		 Pattern pattern = Pattern.compile("[0-9]+");  
		 Pattern pattern2 = Pattern.compile("[0-9]+[.]{1}[0-9]+");	 
		 return pattern.matcher(str).matches() || pattern2.matcher(str).matches();  
  }
}
