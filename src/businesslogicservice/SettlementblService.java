package businesslogicservice;

import java.util.Date;
import java.util.List;

import po.RevenuePO;
import vo.RevenueVO;

public interface SettlementblService {

	public List<RevenueVO> queryRevenueVO (Date date ,String organization);
	
	public boolean deposit(long  accountId, RevenueVO vo);
	
	public boolean execute(RevenueVO vo);
}
