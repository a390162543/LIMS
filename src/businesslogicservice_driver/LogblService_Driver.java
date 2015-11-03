package businesslogicservice_driver;

import java.util.Date;
import java.util.List;

import vo.AccountVO;
import vo.LogVO;
import businesslogicservice.LogblService;

public class LogblService_Driver {

	public void drive(LogblService logblService){
	
		boolean result=logblService.createLogPO(new LogVO("createAccountVO by zhang ", new Date()));
		if(result==true)
			System.out.println("Create succeed\n");
		
		List<LogVO> vos = logblService.queryLogVO(new Date());
	    System.out.println("get "+vos.size()+" LogVO!");
		
	}
}
