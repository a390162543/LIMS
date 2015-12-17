package systemenum;

public enum ShipForm {
	
	PLANE("航空"),
	TRAIN("铁路"),
	CAR("汽运"),
	FREE("机动");
	private String name;
	
	  ShipForm(String s){
		 name = s;
	}
	  public String getName(){
		  return name;
	  }
}
