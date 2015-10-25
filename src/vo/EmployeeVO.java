package vo;

import po.PayPO;
import systemenum.Position;

public class EmployeeVO {
	private long id;
	private String name;
	private String organization;
	private Position position;
	private PayPO pay;
	
	public EmployeeVO(long i, String n, String o, Position p ){
		id= i;
		name = n;
		organization = o;
		position = p;
		 	
	}
}
