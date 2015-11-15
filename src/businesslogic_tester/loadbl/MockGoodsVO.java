package businesslogic_tester.loadbl;

import vo.GoodsVO;

public class MockGoodsVO extends GoodsVO{
    double weight;
    
    public MockGoodsVO(double weight){
        this.weight = weight;
    }
    
    public double getWeight() {
        return this.weight;
    }
    
}
