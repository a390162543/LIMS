package presentation.orderpendingui;


import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import systemenum.GoodsState;
import vo.OrderCreateVO;
import businesslogic.orderbl.Order;


public class OrderPendingTableModel extends DefaultTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7332439880625316550L;
	/**
	 * 
	 */
	
	//private OrderblService orderblService;
    private List<OrderCreateVO> dataList;
    private static final String[] TABLE_HEADER = {"订单号","寄件地址","收件地址","物品信息","重量","体积","包装方式","运送方式","总费用"};
    private Order order;
    
    public OrderPendingTableModel() {
        order = new Order();
        dataList = order.getPendingOrderCreateVO();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void approve(int row) {
    	OrderCreateVO vo = dataList.get(row);
    	removeRow(row);
    	dataList.remove(row);
    	order.execute(vo);
    }
    
    
    
    public void modify(int row, OrderCreateVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        order.modifyOrder(vo);
    }
    
    public OrderCreateVO getOrderPendingVO(int row){
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
        rowVector.add(vo.getSenderAddress());
        rowVector.add(vo.getReceiverAddress());
        rowVector.add(vo.getGoodsInfo());
        rowVector.add(vo.getWeight());
        rowVector.add(vo.getSize());
        rowVector.add(vo.getWrapWay());
        rowVector.add(vo.getDeliverWay());
        rowVector.add(vo.getCost());
        rowVector.add(vo.getGoodsState());
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
