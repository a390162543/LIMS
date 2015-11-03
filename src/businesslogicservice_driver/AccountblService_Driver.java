package businesslogicservice_driver;

import java.util.List;

import vo.AccountVO;
import businesslogicservice.AccountblService;

public class AccountblService_Driver {

	public void drive(AccountblService accountblService){
		boolean result1=accountblService.createAccountPO(new AccountVO(new Long("1000000000000000000"), 30.00));
		if(result1==true)
			System.out.println("Create succeed\n");
		
		boolean result2=accountblService.deleteAccountPO(new AccountVO(new Long("1000000000000000000"), 30.00));
		if(result2==true)
			System.out.println("Delete succeed\n");
		
		boolean result3=accountblService.modifyAccountPO(new AccountVO(new Long("1000000000000000000"), 30.00));
		if(result3==true)
			System.out.println("Modify succeed\n");
		
		List<AccountVO> vos = accountblService.getAccountVO();
	    System.out.println("get "+vos.size()+" AccountVO!");
		
	}
}
