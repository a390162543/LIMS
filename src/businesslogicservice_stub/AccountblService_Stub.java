package businesslogicservice_stub;

import java.util.ArrayList;
import java.util.List;

import vo.AccountVO;
import businesslogicservice.AccountblService;

public class AccountblService_Stub implements AccountblService {

	AccountVO vo;
	
	public AccountblService_Stub(AccountVO vo){
		this.vo=vo;
	}
	
	public boolean createAccountPO(AccountVO vo) {
		return true;
	}

	public boolean deleteAccountPO(AccountVO vo) {
		return true;
	}

	public boolean modifyAccountPO(AccountVO vo) {
		return true;
	}

	public List<AccountVO> getAccountVO() {
		List<AccountVO> list=new ArrayList<AccountVO>();
		list.add(vo);
		return list;
	}
	

}
