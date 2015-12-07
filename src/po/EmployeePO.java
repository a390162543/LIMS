package po;

import java.io.Serializable;
import java.util.Date;

import systemenum.Position;
import systemenum.Sex;
import vo.EmployeeVO;
import vo.PayVO;

/**
 * {@code EmployeePO}是员工业务逻辑层与数据层之间传递的持久化对象，
 * 记录了员工的所有信息
 * @author 刘航伸
 * @see po.PayPO
 * @see systemenum.Sex
 * @see systemenum.Position
 */
public class EmployeePO implements Serializable{
	/**
	 * 
	 */
	private static final long  serialVersionUID = 5922672707662548075L;
	private String id;
	private String name;
	private String organization;
	private Position position;
	private String telephone;
	private Date birthday;
	private String identityCardNum;
	private Sex sex;
	private Date driverLDDL;
	private String truck;
	private PayPO pay;
	 
	public EmployeePO(String id, String name, String organization,
			Position position, String telephone, Date birthday,
			String identityCardNum, Sex sex, PayPO pay  ,Date driverLDDL, String truck) {
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
	

	public EmployeeVO getEmployeeVO(){
		PayVO payvo =  pay.getPayVO();
		return new EmployeeVO(id, name, organization, position, telephone, birthday, identityCardNum, 
				sex, payvo,driverLDDL, truck);
	}
	public String getTruck() {
		return truck;
	}

	public void setTruck(String truck) {
		this.truck = truck;
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
	
}
