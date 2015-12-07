package presentation.managerui.approvalui.revenueui;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import vo.RevenueVO;
import businesslogic.BusinessLogicService;
import businesslogicservice.ApprovalblService;

/**
 * ����ʱ�տ��{@code TableModel}��ά���տ��Ϣ�б������
 * @author ���滪
 * @version 1.4
 * @see businesslogicservice.ApprovalblService
 */
public class RevenuePendingTableModel extends DefaultTableModel {
    /**
     * 
     */
    private static final long serialVersionUID = -5731347015059326420L;
    private List<RevenueVO> dataList;
    private static final String[] TABLE_HEADER = {"�տ���","���Ա���","�տ�Ӫҵ��","�տ�����","�տ����"};
    private ApprovalblService approvalblService;
    
    public RevenuePendingTableModel() {
        approvalblService = BusinessLogicService.getApprovalblService();
        dataList = approvalblService.getRevenueVO();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void modify(int row, RevenueVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        approvalblService.modifyRevenueVO(vo);
    }
    
    public void approve(int row){
        RevenueVO vo = dataList.get(row);
        removeRow(row);
        dataList.remove(row);
        approvalblService.approveRevenueVO(vo);
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
