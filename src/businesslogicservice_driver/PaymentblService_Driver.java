package businesslogicservice_driver;

import java.util.Date;

import systemenum.Entry;
import vo.PaymentVO;
import businesslogicservice.PaymentblService;


public class PaymentblService_Driver {

	public void driver(PaymentblService PaymentblService){
		boolean result1=PaymentblService.createPaymentVO(new PaymentVO(new Long("00021160112000001"),new Date() , 30.00, "zhang", 1000000000000000000L, Entry.AWARDS, "yes"));
		if(result1==true)
			System.out.println("Creat succeed\n");
		
		boolean result2=PaymentblService.modifyPaymentVO(new PaymentVO(new Long("00021160112000001"),new Date() , 30.00, "zhang", 1000000000000000000L, Entry.AWARDS, "yes"));
		if(result2==true)
			System.out.println("Modify succeed\n");
		
		boolean result3=PaymentblService.execute(new PaymentVO(new Long("00021160112000001"),new Date() , 30.00, "zhang", 1000000000000000000L, Entry.AWARDS, "yes"));
		if(result3==true)
			System.out.println("Execute succeed\n");
	}
}
