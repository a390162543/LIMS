package businesslogic.loadbl;

import java.util.ArrayList;
import java.util.List;

import vo.GoodsVO;

public class GoodsList {

    private List<GoodsVO> goodsList = new ArrayList<GoodsVO>(); 
    
    public void add(GoodsVO vo){
        goodsList.add(vo);
    }
    
    public void delete(GoodsVO vo){
        goodsList.remove(vo);
    }
    
    public double getWeight(){
        double weight = 0;
        for(GoodsVO vo : goodsList)
            weight += vo.getWeight();
        return weight;
    }
}