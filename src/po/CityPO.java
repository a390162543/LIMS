package po;

import java.io.Serializable;
import java.util.Map;

import vo.CityVO;

/**
 * {@code CityPO}是城市业务逻辑层与数据层之间传递的持久化对象，
 * 记录了城市的所有信息
 * @author 刘航伸
 */
public class CityPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5508191612376800622L;
	
	private String name;
	private String id;
	private Map<String,Double> distance;
	
	
	
	public CityPO(String name, String id, Map<String, Double> distance) {
		super();
		this.name = name;
		this.id = id;
		this.distance = distance;
	}
	
	public CityVO getCityVO(){
		return new CityVO(name, id, distance);
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
