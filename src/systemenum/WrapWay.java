package systemenum;

public enum WrapWay {
	
	CARTON("ֽ��"),WOODEN("ľ��"),BAG("��ݴ�");
	private String name;
	
	private WrapWay(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
