package businesslogicservice;

import java.util.List;

import po.UserPO;
import systemenum.Power;
import vo.UserVO;

public interface UserblService {
	public boolean creatUserPO(UserVO vo);
	
	public boolean deleteUserPO(UserVO vo);
	
	public boolean queryUserPO(String id,String passWord);
	
	public boolean initialize(String id);
	
	public boolean modifyPower(UserVO vo);
	
	public boolean modifyPassword(UserVO vo);
	 
	public List<UserVO> getUserVO();
	
	public UserVO find(String id);
}
