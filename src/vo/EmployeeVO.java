package vo;

import java.util.Date;

import po.EmployeePO;
import po.PayPO;
import systemenum.Position;
import systemenum.Sex;

/**
 * {@code EmployeePO}是员工业务逻辑层与界面层之间传递的 对象，
 * 记录了员工的所有信息
 * @author 刘航伸
 * @see po.PayPO
 * @see systemenum.Sex
 * @see systemenum.Position
 */
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
    private Date driverLDDL;
	private String truck;
	
	
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
		this.driverLDDL = null;
		this.truck = null;
	}
	
	 public EmployeeVO(String id, String name, String organization,
			Position position, String telephone, Date birthday,
			String identityCardNum, Sex sex, PayVO pay, Date driverLDDL,
			String truck) {
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
		this.driverLDDL = driverLDDL;
		this.truck = truck;
	}



	public EmployeePO getEmployeePO(){
		 PayPO paypo = pay.getPayPO();
		 return new EmployeePO(id, name, organization, position, 
				 telephone, birthday, identityCardNum, sex, paypo, driverLDDL, truck);
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
	
    public Date getDriverLDDL() {
        return driverLDDL;
    }

    public void setDriverLDDL(Date driverLDDL) {
        this.driverLDDL = driverLDDL;
    }

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }


}
