package vo;

import po.UserPO;
import systemenum.Power;

public class UserVO {
	private String id;
	private String password;
	private Power power;
	
	public UserVO(String id, String password, Power power){
		this.id = id;
		this.password = password;
		this.power = power;
	}
	public UserPO getUserPO(){
		return new po.UserPO(id, password, power);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}
	
}
