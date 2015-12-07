package presentation.managerui.approvalui.storeoutui;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;


import vo.StoreoutCreateVO;
import businesslogic.storeoutbl.Storeout;

/**
 * 该TableModel用于记录出库单的订单的信息
 * @author lc
 * @version 1.4
 *
 */
public class StoreoutPendingTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8553547129390941187L;
	
	private List<StoreoutCreateVO> dataList;
    private static final String[] TABLE_HEADER = {"出库单号","出库时间","入库地","目的地","中转单号","装运形式","装运形式"};
    private Storeout storeout;
    
    public StoreoutPendingTableModel() {
        storeout = new Storeout();
        dataList = storeout.getPendingStoreoutCreateVO();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void approve(int row) {
    	StoreoutCreateVO vo = dataList.get(row);
    	removeRow(row);
    	dataList.remove(row);
    	storeout.execute(vo);
    }
    
    public void modify(int row, StoreoutCreateVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        storeout.modifyStoreout(vo);
    }
    
    public StoreoutCreateVO getStoreoutPendingVO(int row){
        return getRowData(row);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Class getColumnClass(int column) {  
        Class returnValue = null;  
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
    
    private StoreoutCreateVO getRowData(int row){
        return dataList.get(row);
    }
    
    private static Vector<Vector<Object>> convertToVectorData(List<StoreoutCreateVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(StoreoutCreateVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(StoreoutCreateVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getId()); 
        rowVector.add(vo.getDate());
        rowVector.add(vo.getOrganization());
        rowVector.add(vo.getDestination());
        rowVector.add(vo.getTransferId());
        rowVector.add(vo.getShipForm().toString());
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
