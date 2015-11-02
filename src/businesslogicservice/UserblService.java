package businesslogicservice;

import java.util.List;

import po.UserPO;
import systemenum.Power;
import vo.UserVO;

public interface UserblService {
	public UserPO creatUserPO(UserVO vo);
	
	public boolean deleteUserPO(UserVO vo);
	
	public boolean queryUserPO(UserVO vo);
	
	public boolean initialize(UserVO vo);
	
	public boolean modifyPower(UserVO vo);
	 
	public List<UserVO> getUserVO();
}
