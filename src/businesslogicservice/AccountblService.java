package businesslogicservice;

import java.util.List;

import vo.AccountVO;

public interface AccountblService {
	public boolean createAccountVO(AccountVO vo);
	
	public boolean deleteAccountVO(AccountVO vo);
	
	public boolean modifyAccountVO(AccountVO vo);
	
	public List<AccountVO> getAccountVO();
	
}
