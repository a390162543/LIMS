package businesslogic.transferbl;

import java.util.ArrayList;
import java.util.List;

import vo.GoodsVO;
/**
 * {@code GoodsList}是Transfer的辅助类，负责货物的增删和计算总量
 * @author 刘航伸
 *@version 1.6
 */
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
