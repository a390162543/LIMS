package businesslogicservice_driver;

import java.util.Date;

import systemenum.Entry;
import vo.PaymentVO;
import businesslogicservice.PaymentblService;
import businesslogicservice_stub.PaymentblService_Stub;


public class PaymentblService_Driver {
	
	public void drive(PaymentblService paymentblService){
		boolean result1=paymentblService.createPaymentPO(new PaymentVO(new Long("00021160112000001"),new Date() , 30.00, "zhang", new Long("00021160112000001"), Entry.AWARDS, "yes",new Long("00021160112000001")));
		if(result1==true)
			System.out.println("Creat succeed\n");
		
		boolean result2=paymentblService.modifyPaymentPO(new PaymentVO(new Long("00021160112000001"),new Date() , 30.00, "zhang",new Long("00021160112000001"), Entry.AWARDS, "yes",new Long("00021160112000001")));
		if(result2==true)
			System.out.println("Modify succeed\n");
		
		boolean result3=paymentblService.execute(new PaymentVO(new Long("00021160112000001"),new Date() , 30.00, "zhang", new Long("00021160112000001"), Entry.AWARDS, "yes",new Long("00021160112000001")));
		if(result3==true)
			System.out.println("Execute succeed\n");
	}
}
