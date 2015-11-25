package vo;

public class GoodsVO {
	private String id;
	private double weight;
	private String depart;
	private String destination;
	
	
	public GoodsVO() {
		 
	}
   
    public GoodsVO(String id, double weight, String depart, String destination) {
		super();
		this.id = id;
		this.weight = weight;
		this.depart = depart;
		this.destination = destination;
	}


	public String getDepart() {
		return depart;
	}



	public void setDepart(String depart) {
		this.depart = depart;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
}
