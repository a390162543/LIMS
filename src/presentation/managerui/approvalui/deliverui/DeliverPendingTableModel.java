package presentation.managerui.approvalui.deliverui;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import vo.DeliverVO;
import businesslogic.deliverbl.Deliver;

/**
 * 审批时派件单的{@code TableModel}，维护派件单信息列表的数据
 * @author 林祖华
 * @version 1.3
 * @see businesslogicservice.ApprovalblService
 */
public class DeliverPendingTableModel extends DefaultTableModel {
    /**
     * 
     */
    private static final long serialVersionUID = -5731347015059326420L;
    private List<DeliverVO> dataList;
    private static final String[] TABLE_HEADER = {"派件单编号","订单编号","快递员编号","派件日期"};
    private Deliver deliver;
    
    public DeliverPendingTableModel() {
        deliver = new Deliver();
        dataList = deliver.getPendingDeliverVO();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void modify(int row, DeliverVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        deliver.modifyDeliverPO(vo);
    }
    
    public void approve(int row){
        DeliverVO vo = dataList.get(row);
        removeRow(row);
        dataList.remove(row);
        deliver.execute(vo);
    }
    
    public DeliverVO getDeliverVO(int row){
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
    
    private DeliverVO getRowData(int row){
        return dataList.get(row);
    }
    
    private static Vector<Vector<Object>> convertToVectorData(List<DeliverVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(DeliverVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(DeliverVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getId());
        rowVector.add(vo.getOrderId());
        rowVector.add(vo.getCourierId());
        rowVector.add(vo.getDeliverDate());
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
