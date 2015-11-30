package vo;

import java.util.Date;

import po.EmployeePO;
import po.PayPO;
import systemenum.Position;
import systemenum.Sex;

public class EmployeeVO {
	private String id;
	private String name;
	private String organization;
	private Position position;
	private String telephone;
	private Date birthday;
	private String identityCardNum;
	private Sex sex;
	private PayVO pay;
	
	
	public EmployeeVO(String id, String name, String organization,
			Position position, String telephone, Date birthday,
			String identityCardNum, Sex sex,PayVO pay) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.position = position;
		this.telephone = telephone;
		this.birthday = birthday;
		this.identityCardNum = identityCardNum;
		this.sex = sex;
		this.pay = pay;
	}
	
	 public EmployeePO getEmployeePO(){
		 PayPO paypo = pay.getPayPO();
		 return new EmployeePO(id, name, organization, position, 
				 telephone, birthday, identityCardNum, sex, paypo, null, null);
	 }
	 
	 

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdentityCardNum() {
		return identityCardNum;
	}

	public void setIdentityCardNum(String identityCardNum) {
		this.identityCardNum = identityCardNum;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public PayVO getPay() {
		return pay;
	}

	public void setPay(PayVO pay) {
		this.pay = pay;
	}
}
