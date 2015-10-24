package po;

import java.util.HashMap;
import java.util.Map;

public class ConstantPO {
	private double price;
	Map<String,Double> map = new HashMap<String,Double>();
	
	public ConstantPO(double price){
		this.price = price;
	}
	
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDistance(String city1,String city2) { 
		return  (double) map.get(city1+city2);
	}
	public void setDistance(String city1,String city2,double distance) {
		 
	}
}
