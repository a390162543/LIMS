package businesslogicservice_stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.AccountVO;
import vo.RevenueVO;
import businesslogicservice.SettlementblService;

public class SettlementblService_Stub implements SettlementblService{
	RevenueVO vo;
	
	public SettlementblService_Stub(RevenueVO vo){
		this.vo=vo;
	}
	
	public List<RevenueVO> queryRevenueVO(Date date, String organization) {
		List<RevenueVO> list=new ArrayList<RevenueVO>();
		list.add(vo);
		return list;
	
	}

	public boolean setAccountId(RevenueVO vo, String accountId) {
		
		return true;
	}

}
