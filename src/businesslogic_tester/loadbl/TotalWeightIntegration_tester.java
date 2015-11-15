package businesslogic_tester.loadbl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.loadbl.GoodsList;

public class TotalWeightIntegration_tester {
    @SuppressWarnings("deprecation")
    @Test
    public void testTatol(){
        
        MockGoodsVO vo1 = new MockGoodsVO(10);
        MockGoodsVO vo2 = new MockGoodsVO(15);
        
        GoodsList list = new GoodsList();
        list.add(vo1);
        list.add(vo2);
        
        assertEquals(25,list.getWeight());
    }
}
