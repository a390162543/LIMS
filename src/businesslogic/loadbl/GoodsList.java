package businesslogic.loadbl;

import java.util.ArrayList;
import java.util.List;

import vo.GoodsVO;

/**
 * ά��һ��װ������¼����Ҫ�Ļ����б�
 * @author ���滪
 * @version 1.2
 * @see Load
 */
public class GoodsList {
    /**
     * ������б�
     */
    private List<GoodsVO> goodsList = new ArrayList<GoodsVO>(); 
    
    /**
     * ���һ�����
     * @param vo ��Ҫ��ӵĻ���
     */
    public void add(GoodsVO vo){
        goodsList.add(vo);
    }
    
    /**
     * ɾ��һ�����
     * @param vo ��Ҫɾ���Ļ���
     */
    public void delete(GoodsVO vo){
        goodsList.remove(vo);
    }
    
    /**
     * ��ȡ�����������
     * @return ����������
     */
    public double getWeight(){
        double weight = 0;
        for(GoodsVO vo : goodsList)
            weight += vo.getWeight();
        return weight;
    }
}