package vo;

import java.util.Date;

import po.PayPO;
import systemenum.Position;
import systemenum.Sex;

public class EmployeeVO {
	private long id;
	private String name;
	private String organization;
	private Position position;
	private long telephone;
	private Date birthday;
	private long identityCardNum;
	private Sex sex;
	private PayPO pay;
	
	
	public EmployeeVO(long id, String name, String organization,
			Position position, long telephone, Date birthday,
			long identityCardNum, Sex sex) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.position = position;
		this.telephone = telephone;
		this.birthday = birthday;
		this.identityCardNum = identityCardNum;
		this.sex = sex;
	}
	
	 
}
