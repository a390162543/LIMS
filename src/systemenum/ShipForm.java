package systemenum;

public enum ShipForm {
	
	PLANE("����"),
	TRAIN("��·"),
	CAR("����"),
	FREE("����");
	private String name;
	
	  ShipForm(String s){
		 name = s;
	}
	  public String getName(){
		  return name;
	  }
}
