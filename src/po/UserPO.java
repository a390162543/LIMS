package po;

import java.io.Serializable;

import systemenum.Power;
import vo.UserVO;

public class UserPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2030249712916272105L;
	private String id;
	private String password;
	private Power power;
	
	public UserPO(String id, String password ,Power power){
		this.id = id;
		this.password = password;
		this.power = power;
	}
	public UserVO getUserVO(){
		return new UserVO(id, password, power);
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id =  id;
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
