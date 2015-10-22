package businesslogicservice;

public interface ConstantblService {
	public boolean priceModify(double price);
	
	public double getPrice();
	
	public boolean distanceModify(String city1,String city2,double distance);
	
	public double getDistance(String location1 ,String location2);
}
