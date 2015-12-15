package presentation.financeui.primeinfoui.truckui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import vo.TruckVO;
import businesslogicservice.PrimeInfoblService;

/**
 * 期初建账时车辆信息列表的{@code TableModel}
 * @author 林祖华
 * @version 1.3
 * @see businesslogicservice.PrimeInfoblService
 */
public class PrimeInfoTruckTableModel extends DefaultTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5823541828980422757L;
	private PrimeInfoblService primeInfoblService;
	private List<TruckVO> dataList;
	private static final String[] TABLE_HEADER = {"车辆编号","发动机号","车牌号","底盘号","购买日期"};

	public PrimeInfoTruckTableModel(PrimeInfoblService primeInfoblService) {
	    	this.primeInfoblService = primeInfoblService;
	    	dataList = new ArrayList<TruckVO>();
	        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
	}
	public PrimeInfoTruckTableModel(List<TruckVO> vos) {  
		    dataList = vos;
		    setDataVector(convertToVectorData(dataList), getColumnNamesVector());
	}
	
	public void create(TruckVO vo){
	        addRow(convertToVector(vo));
	        dataList.add(vo);
	        primeInfoblService.addTruckVO(vo);	   
	}
	    
	public void delete(int row){
	        removeRow(row);
	        TruckVO vo = dataList.get(row);
	        dataList.remove(row);
	        primeInfoblService.removeTruckVO(vo);	
	}
	    
	public void modify(int row, TruckVO vo){
	        removeRow(row);
	        insertRow(row, convertToVector(vo));
	        dataList.remove(row);
	        dataList.add(row, vo);
	        primeInfoblService.modifyTruckVO(vo);
	}
	    
	public TruckVO getTruckVO(int row){
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
	    
	    private TruckVO getRowData(int row){
	        return dataList.get(row);
	    }
	    
	    private static Vector<Vector<Object>> convertToVectorData(List<TruckVO> list){
	        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	        for(TruckVO vo:list){
	            data.add(convertToVector(vo));
	        }
	        return data;
	    }
	    
	    private static Vector<Object> convertToVector(TruckVO vo){
	        Vector<Object> rowVector = new Vector<Object>();
	        rowVector.add(vo.getId());
	        rowVector.add(vo.getEngineNumber());
	        rowVector.add(vo.getTruckNumber());
	        rowVector.add(vo.getChassisNumber());
	        rowVector.add(new SimpleDateFormat().format(vo.getPurchaseDate()));
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
