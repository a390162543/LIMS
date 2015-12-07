package presentation.managerui.approvalui.transferui;

import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import vo.TransferVO;
import businesslogic.transferbl.Transfer;

/**
 * ������ת����������ݷ���
 * @author ������
 * @see Transfer ��
 * @version 1.2
 */
public class TransferPendingTableModel extends DefaultTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1828574105866597049L;
	private List<TransferVO> dataList;
    private static final String[] TABLE_HEADER = {"��ת�����","���˷�ʽ","װ������","�����","������","�����",
    												"�����","��װԱ","������","�˷�"};
    private Transfer transfer;
    
    public TransferPendingTableModel() {
        transfer = new Transfer();
        dataList = transfer.getPendingTransferVO();
        System.out.println(dataList.size());
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
        rowVector.add(vo.getId());
        rowVector.add(vo.getShipForm().getName());
        rowVector.add(vo.getLoadDate());
        rowVector.add(vo.getFlightNumbe());
        rowVector.add(vo.getDepart());
        rowVector.add(vo.getDestination());
        rowVector.add(getColumnNamesVector());
        rowVector.add(vo.getLoadMan());
        rowVector.add(vo.getOrderId());
        rowVector.add(vo.getExpenses());
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
