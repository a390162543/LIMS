package businesslogicservice;

import java.util.List;

import po.UserPO;
import systemenum.Power;

public interface UserblService {
	public UserPO creatUserPO(long id, String password, Power power);
	
	public boolean deleteUserPO();
	
	public boolean queryUserPO();
	
	public boolean initialize();
	
	public boolean modifyPower(Power power);
	
	public boolean setFocuedUserPO(int index);
	
	public List<UserPO> getUserPO();
}
