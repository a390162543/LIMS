package systemenum;

public enum ShipForm {
	
	PLANE("����"),
	TRAIN("��·"),
	CAR("����");
	private String name;
	
	  ShipForm(String s){
		 name = s;
	}
	  public String getName(){
		  return name;
	  }
}
