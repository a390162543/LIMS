package dataservice;

import java.util.List;

import po.AccountPO;
import po.ApprovalPO;
import po.PaymentPO;

public interface PaymentDataService {

	public boolean insert(PaymentPO po);
	
	public boolean delete(PaymentPO po);
	
	public boolean update(PaymentPO po);
	
	public PaymentPO find(long id);
	
	public List<PaymentPO> finds(String field, Object value);
	
	public List<PaymentPO> getAll();
	
	public boolean insert(ApprovalPO po);
	
	public boolean update(ApprovalPO po);
}
