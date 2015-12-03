package systemenum;

public enum ShipForm {
	
	PLANE("º½¿Õ"),
	TRAIN("ÌúÂ·"),
	CAR("ÆûÔË");
	private String name;
	
	  ShipForm(String s){
		 name = s;
	}
	  public String getName(){
		  return name;
	  }
}
