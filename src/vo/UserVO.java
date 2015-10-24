package vo;

import systemenum.Power;

public class UserVO {
	private long id;
	private String password;
	private Power power;
	
	public UserVO(long id, String password, Power power){
		this.id = id;
		this.password = password;
		this.power = power;
	}
}
