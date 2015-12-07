package presentation.managerui.approvalui.loadui;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import vo.LoadVO;
import businesslogic.BusinessLogicService;
import businesslogicservice.ApprovalblService;

/**
 * ����ʱװ������{@code TableModel}��ά��װ������Ϣ�б������
 * @author ���滪
 * @version 1.7
 * @see businesslogicservice.ApprovalblService
 */
public class LoadPendingTableModel extends DefaultTableModel {

	/**
     * 
     */
    private static final long serialVersionUID = -5943766483972270998L;
    private List<LoadVO> dataList;
    private static final String[] TABLE_HEADER = {"װ�������","�������","������","Ŀ�ĵ�","װ������"};
    private ApprovalblService approvalblService;
    
    public LoadPendingTableModel() {
        approvalblService = BusinessLogicService.getApprovalblService();
        dataList = approvalblService.getLoadVO();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void modify(int row, LoadVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        approvalblService.modifyLoadVO(vo);
    }
    
    public void approve(int row){
        LoadVO vo = dataList.get(row);
        removeRow(row);
        dataList.remove(row);
        approvalblService.approveLoadVO(vo);
    }
    
    public LoadVO getLoadVO(int row){
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
    
    private LoadVO getRowData(int row){
        return dataList.get(row);
    }
    
    private static Vector<Vector<Object>> convertToVectorData(List<LoadVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(LoadVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(LoadVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getId());
        rowVector.add(vo.getTruckId());
        rowVector.add(vo.getDepart());
        rowVector.add(vo.getDestination());
        rowVector.add(vo.getLoadingDate());
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
