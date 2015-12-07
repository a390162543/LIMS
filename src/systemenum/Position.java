package systemenum;

public enum Position {
	MANAGER("�ܾ���",Power.MANAGER), 
	SELLINGBUSINESSMAN("Ӫҵ��ҵ��Ա", Power.SELLINGBUSINESSMAN), 
	TRANSFERCENTREBUSINESSMAN("��ת����ҵ��Ա", Power.TRANSFERCENTREBUSINESSMAN), 
	COURIER("���Ա", Power.COURIER),
	STORAGEMANAGER("��ת���Ĳֿ����Ա", Power.STORAGEMANAGER), 
	SENIORFINANCIALSTAFF("�߼�������Ա", Power.SENIORFINANCIALSTAFF),
	FINANCIALSTAFF("������Ա", Power.FINANCIALSTAFF), 
	SYSTEMMANAGER("����Ա", Power.SYSTEMMANAGER), 
	DRIVER("˾��", Power.DRIVER); 
	
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
