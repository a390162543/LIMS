package systemenum;

public enum Sex {
	MALE("��"),
	FAMALE("Ů");
	private String name;
	
	Sex(String s){
		name = s;
	}
	
	public String getName(){
		return name;
	}
}
