package systemenum;

public enum Position {
	MANAGER("总经理",Power.MANAGER), 
	SELLINGBUSINESSMAN("营业厅业务员", Power.SELLINGBUSINESSMAN), 
	TRANSFERCENTREBUSINESSMAN("中转中心业务员", Power.TRANSFERCENTREBUSINESSMAN), 
	COURIER("快递员", Power.COURIER),
	STORAGEMANAGER("中转中心仓库管理员", Power.STORAGEMANAGER), 
	SENIORFINANCIALSTAFF("高级财务人员", Power.SENIORFINANCIALSTAFF),
	FINANCIALSTAFF("财务人员", Power.FINANCIALSTAFF), 
	SYSTEMMANAGER("管理员", Power.SYSTEMMANAGER), 
	DRIVER("司机", Power.DRIVER); 
	
	private String name;
	private Power power;
	Position(String s, Power power){
		this.name = s;
		this.power = power;
	}
	
	public String getName() {
		return name;
	}
	
	public Power getPower(){
		return power;
	}
}
