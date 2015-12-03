package systemenum;

public enum WrapWay {
	
	CARTON("Ö½Ïä"),WOODEN("Ä¾Ïä"),BAG("¿ìµÝ´ü");
	private String name;
	
	private WrapWay(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
