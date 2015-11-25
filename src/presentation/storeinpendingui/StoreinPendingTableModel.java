package presentation.storeinpendingui;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import vo.StoreinCreateVO;
import businesslogic.orderbl.Order;
import businesslogic.storeinbl.Storein;

public class StoreinPendingTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5965270961913676526L;
	
	private List<StoreinCreateVO> dataList;
    private static final String[] TABLE_HEADER = {"入库单号","入库日期","入库地","目的地","货物数量"};
    private Storein storein;
    
    public StoreinPendingTableModel() {
        storein = new Storein();
        dataList = storein.getStoreinPendingVOs();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void approve(int row){
    	StoreinCreateVO vo = dataList.get(row);
    	removeRow(row);
    	dataList.remove(row);
    	storein.execute(vo);
    }
    
    
    public void modify(int row, StoreinCreateVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        storein.modifyStorein(vo);
    }
    
    public StoreinCreateVO getStoreinPendingVO(int row){
        return getRowData(row);
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
    
    private StoreinCreateVO getRowData(int row){
        return dataList.get(row);
    }
    
    private static Vector<Vector<Object>> convertToVectorData(List<StoreinCreateVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(StoreinCreateVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(StoreinCreateVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getId()); 
        rowVector.add(vo.getInDate());
        rowVector.add(vo.getOrganization());
        rowVector.add(vo.getDestination());
        rowVector.add(vo.getOrderId().size());
        
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
