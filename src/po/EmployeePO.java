package po;

import systemenum.Position;

 

 
public class EmployeePO {
	private long id;
	private String name;
	private String organization;
	private Position position;
	private PayPO pay;
	
	
	public EmployeePO
	(long id,String name,String organization,Position position ){
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.position = position;	 
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
