package presentation.transitcenterui.transferui;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import businesslogicservice.TransferblService;
import vo.GoodsVO;

/**
 * 订单数据管理服务
 * @author 刘航伸
 * @version 1.3
 */
public class OrderTableModel extends DefaultTableModel{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 3918481690066300511L;
 
    private List<GoodsVO> dataList;
    private static final String[] TABLE_HEADER = {"订单编号","重量","出发地","目的地"};
    private TransferblService transferblService;
 
    
    public OrderTableModel(TransferblService tbs) {      
       transferblService = tbs; 
       dataList = new ArrayList<GoodsVO>();
       setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void add(String id){
    	GoodsVO vo = transferblService.getGoodsVO(id);
    	if(vo != null){
    		addRow(convertToVector(vo));
    		dataList.add(vo); 
    		transferblService.addGoods(vo);
    	}
              
    }
    
    public void delete(int row){
        removeRow(row);              
        transferblService.deleteGoods(dataList.get(row));
        dataList.remove(row);
         
    }
    
    
    
    public GoodsVO getGoodsVO(int row){
        return getRowData(row);
    }
    
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//    public Class getColumnClass(int column) {  
//        Class returnValue;  
//        if ((column >= 0) && (column < getColumnCount())) {  
//            returnValue = getValueAt(0, column).getClass();  
//        } else {  
//            returnValue = Object.class;  
//        }  
//        return returnValue;  
//    }  
    
    public boolean isCellEditable(int row, int column) { 
        return false;
    }
    
    private GoodsVO getRowData(int row){
        return dataList.get(row);
    }
    
    private static Vector<Vector<Object>> convertToVectorData(List<GoodsVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(GoodsVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(GoodsVO vo){
        Vector<Object> rowVector = new Vector<Object>();
       rowVector.add(vo.getId());
       rowVector.add(vo.getWeight());
       rowVector.add(vo.getDepart());
       rowVector.add(vo.getDestination());
        
        return rowVector;
    }
//    
    private static Vector<String> getColumnNamesVector(){
        Vector<String> v = new Vector<String>();
        for(String s:TABLE_HEADER){
            v.add(s);
        }
        return v;
    }
    
 
}
