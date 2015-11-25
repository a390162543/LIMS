package presentation.transitcenterui.transferui;

import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import vo.TransferVO;
import businesslogic.transferbl.Transfer;

public class TransferPendingTableModel extends DefaultTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1828574105866597049L;
	private List<TransferVO> dataList;
    private static final String[] TABLE_HEADER = {"��ת�����","װ������","�����","������","�����",
    												"�����","��װԱ","������","�˷�"};
    private Transfer transfer;
    
    public TransferPendingTableModel() {
        transfer = new Transfer();
        dataList = transfer.getPendingTransferVO();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void modify(int row, TransferVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        transfer.modifyTransferPO(vo);
    }
    
    public void approve(int row){
        TransferVO vo = dataList.get(row);
        removeRow(row);
        dataList.remove(row);
        transfer.execute(vo);
    }
    
    public TransferVO getTransferVO(int row){
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
    
    private TransferVO getRowData(int row){
        return dataList.get(row);
    }
    
    private static Vector<Vector<Object>> convertToVectorData(List<TransferVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(TransferVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(TransferVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        
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