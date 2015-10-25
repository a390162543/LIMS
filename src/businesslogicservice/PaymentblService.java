package businesslogicservice;

import po.PaymentPO;
import vo.PaymentVO;

public interface PaymentblService {

	public boolean createPaymentVO(PaymentVO vo);
	
	public boolean modifyPaymentVO(PaymentVO vo);
	
	public boolean execute(PaymentVO vo);
}
