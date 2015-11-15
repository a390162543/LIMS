package businesslogic_tester.trasferbl;

import vo.GoodsVO;

public class MockGoodsVO extends GoodsVO{
 
	double weight;

	
	public MockGoodsVO(double w){
		weight = w;
		 
	}
	 
	
	 
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	 
	
}
