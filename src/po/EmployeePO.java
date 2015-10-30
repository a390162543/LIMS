package po;

import java.util.Date;

import javax.xml.crypto.Data;

import systemenum.Position;
import systemenum.Sex;

 

 
public class EmployeePO {
	private long id;
	private String name;
	private String organization;
	private Position position;
	private long telephone;
	private Date birthday;
	private long identityCardNum;
	private Sex sex;
	private Date driverLDDL;
	private String truck;
	private PayPO pay;
	 
	public EmployeePO(long id, String name, String organization,
			Position position, long telephone, Date birthday,
			long identityCardNum, Sex sex, Date driverLDDL, String truck
			 ) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.position = position;
		this.telephone = telephone;
		this.birthday = birthday;
		this.identityCardNum = identityCardNum;
		this.sex = sex;
		this.driverLDDL = driverLDDL;
		this.truck = truck;
		 
	}

	
	public EmployeePO(long id, String name, String organization,
			Position position, long telephone, Date birthday,
			long identityCardNum, Sex sex  ) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.position = position;
		this.telephone = telephone;
		this.birthday = birthday;
		this.identityCardNum = identityCardNum;
		this.sex = sex;
		this.driverLDDL = null;
		this.truck = null;
		 
	}
	public String getTruck() {
		return truck;
	}

	public void setTruck(String truck) {
		this.truck = truck;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public long getIdentityCardNum() {
		return identityCardNum;
	}

	public void setIdentityCardNum(long identityCardNum) {
		this.identityCardNum = identityCardNum;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Date getDriverLDDL() {
		return driverLDDL;
	}

	public void setDriverLDDL(Date driverLDDL) {
		this.driverLDDL = driverLDDL;
	}

	public void initPayPO(){
		
	}
	
	public PayPO getPay() {
		return pay;
	}
	public void setPay(PayPO pay) {
		this.pay = pay;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
}
