package businesslogicservice_driver;

import vo.AccountVO;
import vo.PrimeInfoVO;
import businesslogicservice.PrimeInfoblService;


public class PrimeInfoblService_Driver {

	public void drive(PrimeInfoblService primeInfoblService){
	
		boolean result=primeInfoblService.createPrimeInfoPO();
		if(result==true)
			System.out.println("Create succeed\n");
	}
}
