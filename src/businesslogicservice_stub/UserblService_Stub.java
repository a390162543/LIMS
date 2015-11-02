package businesslogicservice_stub;

import java.util.ArrayList;
import java.util.List;

import po.UserPO;
import businesslogicservice.UserblService;
import systemenum.Position;
import systemenum.Power;
import vo.UserVO;

public class UserblService_Stub implements UserblService{
	long id;
	String password;
	Power power;
	
	
	public UserblService_Stub(long id, String password, Power power) {
		super();
		this.id = id;
		this.password = password;
		this.power = power;
	}


	@Override
	public UserPO creatUserPO(UserVO vo) {
		// TODO Auto-generated method stub
		return new UserPO(id,password );
	}


	@Override
	public boolean deleteUserPO(UserVO vo) {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean queryUserPO(UserVO vo) {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean initialize(UserVO vo) {
		// TODO Auto-generated method stub
		password = "0000000";
		return true;
	}


	@Override
	public boolean modifyPower(UserVO vo) {
		// TODO Auto-generated method stub
		power = Power.SELLINGBUSINESSMAN;
		return false;
	}


	@Override
	public List<UserVO> getUserVO() {
		// TODO Auto-generated method stub
		List<UserVO> uservo = new ArrayList<UserVO>();
		uservo.add(new UserVO(id,password,power));
		return uservo;
	}
	
	
}
