package presentation.managerui.approvalui.arrivalui;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import vo.ArrivalVO;
import businesslogic.BusinessLogicService;
import businesslogicservice.ApprovalblService;

/**
 * 审批时到达单的{@code TableModel}，维护到达单信息列表的数据
 * @author 林祖华
 * @version 1.5
 * @see businesslogicservice.ApprovalblService
 */
public class ArrivalPendingTableModel extends DefaultTableModel {

	/**
     * 
     */
    private static final long serialVersionUID = -5943766483972270998L;
    private List<ArrivalVO> dataList;
    private static final String[] TABLE_HEADER = {"到达单编号","到达日期","中转单编号","出发地","到达地","货物状态"};
    private ApprovalblService approvalblService;
    
    public ArrivalPendingTableModel() {
        approvalblService = BusinessLogicService.getApprovalblService();
        dataList = approvalblService.getArrivalVO();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void modify(int row, ArrivalVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        approvalblService.modifyArrivalVO(vo);
    }
    
    public void approve(int row){
        ArrivalVO vo = dataList.get(row);
        removeRow(row);
        dataList.remove(row);
        approvalblService.approveArrivalVO(vo);
    }
    
    public ArrivalVO getArrivalVO(int row){
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
    
    private ArrivalVO getRowData(int row){
        return dataList.get(row);
    }
    
    private static Vector<Vector<Object>> convertToVectorData(List<ArrivalVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(ArrivalVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(ArrivalVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getId());
        rowVector.add(vo.getArrivalDate());
        rowVector.add(vo.getTransferId());
        rowVector.add(vo.getDepart());
        rowVector.add(vo.getDestination());
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
