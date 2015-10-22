package po;

import systemenum.Power;

public class UserPO {
	private long id;
	private String password;
	private Power power;
	
	public UserPO(long id, String password, Power power){
		this.id = id;
		this.password = password;
		this.power = power;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
