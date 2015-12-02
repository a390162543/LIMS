package vo;

public class OrderRevenueVO {
	
	private String orderId;
	private String organization;
	private double expense;
	private String info;
	
	public OrderRevenueVO(String orderId, String organization, double expense,
			String info) {
		super();
		this.orderId = orderId;
		this.organization = organization;
		this.expense = expense;
		this.info = info;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	

}
