package businesslogicservice;

import java.util.Date;
import java.util.List;

import po.RevenuePO;

public interface SettlementblService {

	public List<RevenuePO> queryRevenuePO (Date date ,String organization);
	
	public boolean deposit(long  accountId, RevenuePO revenue);
}
