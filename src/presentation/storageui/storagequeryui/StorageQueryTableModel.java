package presentation.storageui.storagequeryui;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import vo.StorageQueryResultVO;


/**
 * ��TableModel���ڼ�¼������ʾ�Ļ������Ϣ
 * @author lc
 * @version 1.3
 *
 */
public class StorageQueryTableModel extends DefaultTableModel{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5225401278611579534L;
	
	@SuppressWarnings("unused")
	private List<StorageQueryResultVO> dataList;
    private static final String[] TABLE_HEADER = {"������","�������","Ŀ�ĵ�","����","�ź�","�ܺ�","λ��"};
    
    
    public StorageQueryTableModel(List<StorageQueryResultVO> dataList) {
        this.dataList = dataList;
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
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
    
    
    private static Vector<Vector<Object>> convertToVectorData(List<StorageQueryResultVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(StorageQueryResultVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(StorageQueryResultVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getOrderId());
        rowVector.add(vo.getDate());
        rowVector.add(vo.getDestination());
        rowVector.add(vo.getAreaNum());
        rowVector.add(vo.getRowNum());
        rowVector.add(vo.getFrameNum());
        rowVector.add(vo.getItem());
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
