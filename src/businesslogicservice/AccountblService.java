package businesslogicservice;

import java.util.List;

import vo.AccountVO;

public interface AccountblService {
	public boolean createAccountPO(AccountVO vo);
	
	public boolean deleteAccountPO(AccountVO vo);
	
	public boolean modifyAccountPO(AccountVO vo);
	
	public List<AccountVO> getAccountVO();
	
}
