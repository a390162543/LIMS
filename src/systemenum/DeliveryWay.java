package systemenum;

public enum DeliveryWay {
	
	ECONOMIC("����"),STANDARD("��׼"),FAST("�ؿ�");
	
	private String name;
	
	private DeliveryWay(String name) {
		this.name = name;
	}

	public String getName(){
		return name;
	}
}
