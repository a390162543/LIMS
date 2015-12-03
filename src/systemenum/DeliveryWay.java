package systemenum;

public enum DeliveryWay {
	
	ECONOMIC("经济"),STANDARD("标准"),FAST("特快");
	
	private String name;
	
	private DeliveryWay(String name) {
		this.name = name;
	}

	public String getName(){
		return name;
	}
}
