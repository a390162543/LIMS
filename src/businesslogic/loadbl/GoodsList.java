package businesslogic.loadbl;

import java.util.ArrayList;
import java.util.List;

import vo.GoodsVO;

/**
 * 维护一次装车单记录所需要的货物列表
 * @author 林祖华
 * @version 1.2
 * @see Load
 */
public class GoodsList {
    /**
     * 货物的列表
     */
    private List<GoodsVO> goodsList = new ArrayList<GoodsVO>(); 
    
    /**
     * 添加一项货物
     * @param vo 需要添加的货物
     */
    public void add(GoodsVO vo){
        goodsList.add(vo);
    }
    
    /**
     * 删除一项货物
     * @param vo 需要删除的货物
     */
    public void delete(GoodsVO vo){
        goodsList.remove(vo);
    }
    
    /**
     * 获取货物的总重量
     * @return 货物总重量
     */
    public double getWeight(){
        double weight = 0;
        for(GoodsVO vo : goodsList)
            weight += vo.getWeight();
        return weight;
    }
}