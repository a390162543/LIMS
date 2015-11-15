package vo;

public class GoodsVO {
	private long id;
	private double weight;
	
	
	public GoodsVO() {
		 
	}


	public GoodsVO(long id,double weight)  {
		this.id = id;
		this.weight = weight;
	}
	
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
