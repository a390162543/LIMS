package vo;

import java.util.Map;

import po.CityPO;

public class CityVO {
	private String name;
	private String id;
	private Map<String,Double> distance;
	
	
	
	public CityVO(String name, String id, Map<String, Double> distance) {
		super();
		this.name = name;
		this.id = id;
		this.distance = distance;
	}
	
	public CityPO getCityPO(){
		return new CityPO(name, id, distance);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, Double> getDistance() {
		return distance;
	}
	public void setDistance(String name,double distance) {
		this.distance.put(name, distance);
	}
	
	
}
