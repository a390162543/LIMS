package businesslogicservice_stub;

import vo.ConstantVO;
import businesslogicservice.ConstantblService;

 

public class ConstantblService_Stub implements ConstantblService {
	double price;
	 
	double distance;
	public ConstantblService_Stub(double p  ,double d){
		price = p;		 
		distance = d;
	}
	@Override
	public boolean priceModify(double price) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	@Override
	public boolean distanceModify(ConstantVO vo) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public double getDistance(ConstantVO vo) {
		// TODO Auto-generated method stub
		return distance;
	}
	
	 
}
