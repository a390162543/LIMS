package presentation.financeui.primeinfoui.cityui;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import vo.CityVO;
 
import businesslogicservice.PrimeInfoblService;

public class PrimeInfoCityTableModel extends DefaultTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5521046257920046856L;
	private PrimeInfoblService primeInfoblService;
    private List<CityVO> dataList;
    private static final String[] TABLE_HEADER = {"±àºÅ","³ÇÊÐÃû³Æ"};
    
    public PrimeInfoCityTableModel(PrimeInfoblService p){
    	primeInfoblService = p;
		dataList = new ArrayList<CityVO>();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public PrimeInfoCityTableModel(List<CityVO> vos){
    	dataList = vos;
 	    setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public List<String> getCityName(){
    	return primeInfoblService.getCityName();
    }
    public List<CityVO> getCityVO(){
    	return primeInfoblService.getCityVO();
    }
    
    public void create(CityVO vo){
        addRow(convertToVector(vo));
        dataList.add(vo);
        primeInfoblService.addCityVO(vo);
    }
    
    public void delete(int row){
        removeRow(row);
        CityVO vo = dataList.get(row);
        dataList.remove(row);
        primeInfoblService.removeCityVO(vo);
    }
    
    public void modify(int row, CityVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        primeInfoblService.modifyCityVO(vo);
    }
    
    public void modify(  CityVO vo){
        primeInfoblService.modifyCityVO(vo);
    }
    
    public CityVO getCityVO(int row){
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
    
    private CityVO getRowData(int row){
        return dataList.get(row);
    }
    
 
    
    private static Vector<Vector<Object>> convertToVectorData(List<CityVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(CityVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(CityVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getId());
        rowVector.add(vo.getName());
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
