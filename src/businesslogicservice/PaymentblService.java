package businesslogicservice;

import vo.PaymentVO;

public interface PaymentblService {

	public boolean createPaymentPO(PaymentVO vo);
	
	public boolean modifyPaymentPO(PaymentVO vo);
	
	public boolean execute(PaymentVO vo);

}
