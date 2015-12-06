package presentation.managerui.approvalui.loadui;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import vo.LoadVO;
import businesslogic.loadbl.Load;

public class LoadPendingTableModel extends DefaultTableModel {

	/**
     * 
     */
    private static final long serialVersionUID = -5943766483972270998L;
    private List<LoadVO> dataList;
    private static final String[] TABLE_HEADER = {"装车单编号","车辆编号","出发地","目的地","装车日期"};
    private Load load;
    
    public LoadPendingTableModel() {
        load = new Load();
        dataList = load.getPendingLoadVO();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void modify(int row, LoadVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        load.modifyLoadPO(vo);
    }
    
    public void approve(int row){
        LoadVO vo = dataList.get(row);
        removeRow(row);
        dataList.remove(row);
        load.execute(vo);
    }
    
    public LoadVO getLoadVO(int row){
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
    
    private LoadVO getRowData(int row){
        return dataList.get(row);
    }
    
    private static Vector<Vector<Object>> convertToVectorData(List<LoadVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(LoadVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(LoadVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getId());
        rowVector.add(vo.getTruckId());
        rowVector.add(vo.getDepart());
        rowVector.add(vo.getDestination());
        rowVector.add(vo.getLoadingDate());
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
