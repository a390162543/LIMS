package businesslogic.settlementbl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import vo.RevenueVO;
import businesslogic.accountbl.Account;
import businesslogic.revenuebl.Revenue;
import businesslogicservice.SettlementblService;

/**
 * {@code Settlement}是结算管理的业务逻辑的实现类，提供所有有关结算管理的业务逻辑服务
 * @author 刘德宽
 * @version 1.6
 */
public class Settlement implements SettlementblService{

	@Override
	public List<RevenueVO> queryRevenueVO(Date date, String organization) {
      List<RevenueVO> vos = new ArrayList<RevenueVO>();
	  Revenue revenue = new Revenue();
	  vos = revenue.queryRevenueVO(date, organization);
      return vos;
		
	}

	@Override
	public boolean setAccountId(RevenueVO vo ,String accountId) {
		vo.setAccountId(accountId);
		Revenue revenue = new Revenue();
		revenue.modifyAndCommitRevenuePO(vo);		
		return true;
	}

	@Override
	public List<RevenueVO> getUncommittedRevenueVO() {
		List<RevenueVO> vos = new ArrayList<RevenueVO>();
		Revenue revenue = new Revenue();
		vos = revenue.getUncommittedRevenueVO();
		return vos;
	}

	@Override
	public String[] getAllAccountId() {
		Account account = new Account();
		String[] accountId = account.getAllAccountId();
		return accountId;
	}

}
