package presentation.financeui.primeinfoui;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import vo.PrimeInfoVO;
import businesslogic.primeinfobl.PrimeInfo;
import businesslogicservice.PrimeInfoblService;

public class PrimeInfoTableModel extends DefaultTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2382624563118193368L;
	   private List<PrimeInfoVO> dataList;
	   private PrimeInfoblService primeInfoblService;
	    public PrimeInfoTableModel() {
	    	primeInfoblService = new PrimeInfo();
	        dataList = primeInfoblService.QueryPrimeInfoVO();
	        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
	    }
	    
	  
	    public PrimeInfoVO getPrimeInfoVO(int row){
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
	    
	    private PrimeInfoVO getRowData(int row){
	        return dataList.get(row);
	    }
	    
	    private static Vector<Vector<Object>> convertToVectorData(List<PrimeInfoVO> list){
	        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	        for(PrimeInfoVO vo:list){
	            data.add(convertToVector(vo));
	        }
	        return data;
	    }
	    
	    private static Vector<Object> convertToVector(PrimeInfoVO vo){
	        Vector<Object> rowVector = new Vector<Object>();
	        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
	        rowVector.add(sdf.format(vo.getDate()));
	        return rowVector;
	    }
	    
	    private static Vector<String> getColumnNamesVector(){
	        Vector<String> v = new Vector<String>();	        
	        v.add("账单列表(按创建日期)");
	        return v;
	    }
}
