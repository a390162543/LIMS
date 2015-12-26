package presentation.financeui.primeinfoui.storeinui;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import vo.StoreinCreateVO;
import businesslogicservice.PrimeInfoblService;


/**
 * 该类用于保存所有入库单的数据
 * @author lc
 * @version 1.3
 *
 */
public class PrimeInfoStoreinTableModel extends DefaultTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5394935988487031345L;
	
	private PrimeInfoblService primeInfoblService;
    private List<StoreinCreateVO> dataList;
    private static final String[] TABLE_HEADER = {"入库地","目的地","日期"};
    
    
    public PrimeInfoStoreinTableModel(PrimeInfoblService primeInfoblService) {
    	this.primeInfoblService = primeInfoblService;
    	dataList = new ArrayList<StoreinCreateVO>();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public PrimeInfoStoreinTableModel(List<StoreinCreateVO> vos) {  
	    dataList = vos;
	    setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void create(StoreinCreateVO vo){
        addRow(convertToVector(vo));
        dataList.add(vo);
        primeInfoblService.addStoreinCheckResultVO(vo);
    }
    
    public void delete(int row){
        removeRow(row);
        StoreinCreateVO vo = dataList.get(row);
        dataList.remove(row);
        primeInfoblService.removeStoreinCheckResultVO(vo);
    }
    
    public void modify(int row, StoreinCreateVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        primeInfoblService.modifyStoreinVO(vo);
    }
    
    public StoreinCreateVO getStoreinCreateVO(int row){
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
        rowVector.add(vo.getOrganization());
        rowVector.add(vo.getDestination());
        rowVector.add(vo.getInDate());        
        return rowVector;
    }
    
    private static Vector<String> getColumnNamesVector(){
        Vector<String> v = new Vector<String>();
        for(String s:TABLE_HEADER){
            v.add(s);
        }
        return v;
    }

    public PrimeInfoblService getPrimeInfoblService(){
    	return primeInfoblService;
    }
}
