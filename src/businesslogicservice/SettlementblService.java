package businesslogicservice;

import java.util.Date;
import java.util.List;

import vo.RevenueVO;

public interface SettlementblService {

	public List<RevenueVO> queryRevenueVO (Date date ,String organization);
	
	public boolean setAccountId(RevenueVO vo,String accountId);
	
	public List<RevenueVO> getUncommittedRevenueVO();
	
	public String[] getAllAccountId();
}
