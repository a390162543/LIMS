package systemenum;

public enum Position {
	MANAGER("�ܾ���"), 
	SELLINGBUSINESSMAN("Ӫҵ��ҵ��Ա"), 
	TRANSFERCENTREBUSINESSMAN("��ת����ҵ��Ա"), 
	COURIER("���Ա"),
	STORAGEMANAGER("��ת���Ĳֿ����Ա"), 
	SENIORFINANCIALSTAFF("�߼�������Ա"),
	FINANCIALSTAFF("������Ա"), 
	SYSTEMMANAGER("����Ա"), 
	DRIVER("˾��"); 
	
	private String name;
	
	Position(String s){
		this.name = s;
	}
	
	public String getName() {
		return name;
	}
}
