package systemenum;

public enum Sex {
	MALE("ÄÐ"),
	FAMALE("Å®");
	private String name;
	
	Sex(String s){
		name = s;
	}
	
	public String getName(){
		return name;
	}
}
