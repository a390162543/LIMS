package presentation.storeoutCheck;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;



import vo.OutOrderCheckResultVO;

public class StoreoutCheckTableModel extends DefaultTableModel {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6744956344103556816L;
	
	
	@SuppressWarnings("unused")
	private List<OutOrderCheckResultVO> dataList;
    private static final String[] TABLE_HEADER = {"订单号","出库日期","目的地","区号","排号","架号","位号","重量","体积"};
    
    
    public StoreoutCheckTableModel(List<OutOrderCheckResultVO> dataList) {
        
        this.dataList = dataList;
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Class getColumnClass(int column) {  
        Class returnValue;  
        if ((column >= 0) && (column < getColumnCount())) {  
            returnValue = getValueAt(0, column).getClass();  
        } else {  
            returnValue = Object.class;  
        }  
        return returnValue;  
    }  
    
    public boolean isCellEditable(int row, int column) { 
        return false;
    }
    
    
    private static Vector<Vector<Object>> convertToVectorData(List<OutOrderCheckResultVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(OutOrderCheckResultVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(OutOrderCheckResultVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getOrderId());
        rowVector.add(vo.getDate());
        rowVector.add(vo.getDestination());
        rowVector.add(vo.getAreaNum());
        rowVector.add(vo.getRowNum());
        rowVector.add(vo.getFrameNum());
        rowVector.add(vo.getItem());
        rowVector.add(vo.getWeight());
        rowVector.add(vo.getSize());
        
        return rowVector;
    }
    
    private static Vector<String> getColumnNamesVector(){
        Vector<String> v = new Vector<String>();
        for(String s:TABLE_HEADER){
            v.add(s);
        }
        return v;
    }


}
