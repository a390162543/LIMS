package presentation.financeui.primeinfoui.orderui;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;




import vo.AccountVO;
import vo.OrderCreateVO;
import businesslogicservice.PrimeInfoblService;

public class PrimeInfoOrderTableModel extends DefaultTableModel {
	
	private PrimeInfoblService primeInfoblService;
    private List<OrderCreateVO> dataList;
    private static final String[] TABLE_HEADER = {"订单号","货物信息","运送方式","包装方式"};
    
    
    public PrimeInfoOrderTableModel(PrimeInfoblService primeInfoblService) {
    	this.primeInfoblService = primeInfoblService;
    	dataList = new ArrayList<OrderCreateVO>();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void create(OrderCreateVO vo){
        addRow(convertToVector(vo));
        dataList.add(vo);
        primeInfoblService.addOrderCheckResultVO(vo);
    }
    
    public void delete(int row){
        removeRow(row);
        OrderCreateVO vo = dataList.get(row);
        dataList.remove(row);
        primeInfoblService.removeOrderCheckResultVO(vo);
    }
    
    public void modify(int row, OrderCreateVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        primeInfoblService.modifyOrderVO(vo);
    }
    
    public OrderCreateVO getOrderVO(int row){
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
    
    private OrderCreateVO getRowData(int row){
        return dataList.get(row);
    }
    
    private static Vector<Vector<Object>> convertToVectorData(List<OrderCreateVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(OrderCreateVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(OrderCreateVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getId());
        rowVector.add(vo.getGoodsInfo());
        rowVector.add(vo.getDeliverWay());
        rowVector.add(vo.getWrapWay());
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
