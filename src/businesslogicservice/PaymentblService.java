package businesslogicservice;

import java.util.Date;

import po.AccountPO;
import po.PaymentPO;
import systemenum.Entry;

public interface PaymentblService {

	public PaymentPO createPaymentPO(Date date ,double value ,String name ,long accountId,Entry entry ,String remarks,AccountPO account);
}
