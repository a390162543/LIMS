package presentation.managerui.approvalui.revenueui;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import vo.RevenueVO;
import businesslogic.revenuebl.Revenue;

public class RevenuePendingTableModel extends DefaultTableModel {
    /**
     * 
     */
    private static final long serialVersionUID = -5731347015059326420L;
    private List<RevenueVO> dataList;
    private static final String[] TABLE_HEADER = {"收款单编号","快递员编号","收款营业厅","收款日期","收款订单号"};
    private Revenue revenue;
    
    public RevenuePendingTableModel() {
        revenue = new Revenue();
        dataList = revenue.getPendingRevenueVO();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void modify(int row, RevenueVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        revenue.modifyRevenuePO(vo);
    }
    
    public void approve(int row){
        RevenueVO vo = dataList.get(row);
        removeRow(row);
        dataList.remove(row);
        revenue.execute(vo);
    }
    
    public RevenueVO getRevenueVO(int row){
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
    
    private RevenueVO getRowData(int row){
        return dataList.get(row);
    }
    
    private static Vector<Vector<Object>> convertToVectorData(List<RevenueVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(RevenueVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(RevenueVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getId());
        rowVector.add(vo.getCourierId());
        rowVector.add(vo.getOrganization());
        rowVector.add(vo.getRevenueDate());
        rowVector.add(vo.getOrderId());
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
