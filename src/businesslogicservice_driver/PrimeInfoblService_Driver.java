package businesslogicservice_driver;

import vo.AccountVO;
import vo.PrimeInfoVO;
import businesslogicservice.PrimeInfoblService;


public class PrimeInfoblService_Driver {

	public void driver(PrimeInfoblService primeInfoblService){
	
		boolean result=primeInfoblService.createPrimeInfoVO();
		if(result==true)
			System.out.println("Create succeed\n");
	}
}
