package presentation.businesshallui.revenueui;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import businesslogicservice.RevenueblService;
import vo.OrderRevenueVO;
 
 
 
/**
 * 收款单信息中订单列表所需要的{@code TableModel}
 * @author 林祖华
 * @version 1.3
 * @see businesslogicservice.RevenueblService
 */
public class OrderTableModel extends DefaultTableModel{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 3918481690066300511L;
 
    private List<OrderRevenueVO> dataList;
    private static final String[] TABLE_HEADER = {"订单编号","货物信息","订单费用"};
    private RevenueblService revenueblService;
 
    
    public OrderTableModel(RevenueblService rbs) {      
       revenueblService = rbs; 
       dataList = new ArrayList<OrderRevenueVO>();
       setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public OrderTableModel(RevenueblService rbs, List<String> idList){
    	revenueblService = rbs;
    	dataList = new ArrayList<OrderRevenueVO>();
    	for(String id : idList)
    		dataList.add(revenueblService.getOrderRevenueVO(id));    	
    	setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void add(String id){
    	OrderRevenueVO vo = revenueblService.getOrderRevenueVO(id);
    	if(vo != null){
    		addRow(convertToVector(vo));
    		dataList.add(vo); 
    		System.out.println(dataList.size());
    		revenueblService.add(vo);
    	}
    }
    
    public void delete(int row){
        removeRow(row);
        revenueblService.delete(dataList.get(row));
        dataList.remove(row);  
    }
    
    
    
    public OrderRevenueVO getOrderRevenueVO(int row){
        return getRowData(row);
    }
    
 //   @SuppressWarnings({ "unchecked", "rawtypes" })
//    public Class getColumnClass(int column) {  
//        Class returnValue;  
//        if ((column >= 0) && (column < getColumnCount())) {  
//            returnValue = getValueAt(0, column).getClass();  
//        } else {  
//            returnValue = Object.class;  
//        }  
//        return returnValue;  
//    }  
//    
    public boolean isCellEditable(int row, int column) { 
        return false;
    }
    
    private OrderRevenueVO getRowData(int row){
        return dataList.get(row);
    }
    
    private static Vector<Vector<Object>> convertToVectorData(List<OrderRevenueVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(OrderRevenueVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(OrderRevenueVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getOrderId()); 
        rowVector.add(vo.getInfo());
        rowVector.add(vo.getExpense());
       
        
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
