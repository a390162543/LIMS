package presentation.managerui.approvalui;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import vo.PaymentVO;
import businesslogic.paymentbl.Payment;


public class PaymentPendingTableModel extends DefaultTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8338988125172581384L;
	private List<PaymentVO> dataList;
    private static final String[] TABLE_HEADER = {"付款单编号","付款日期","付款金额","收款人姓名","收款方账户","付款方账户","条目","备注"};
    private Payment payment;
    
    public PaymentPendingTableModel() {
    	payment = new Payment();
        dataList = payment.getPendingPaymentVO();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }   
    
    public void modify(int row, PaymentVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        payment.modifyPaymentPO(vo);
    }
    
    public PaymentVO getPaymentVO(int row){
        return getRowData(row);
    }
    public void approve(int row){
		PaymentVO vo = dataList.get(row);
		removeRow(row);
		dataList.remove(row);
		payment.execute(vo);
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
    
    private PaymentVO getRowData(int row){
        return dataList.get(row);
    }
    
    private static Vector<Vector<Object>> convertToVectorData(List<PaymentVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(PaymentVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(PaymentVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        rowVector.add(sdf.format(vo.getDate()));
        rowVector.add(String.format( "%.2f",vo.getMoney()));
        rowVector.add(vo.getName());
        rowVector.add(vo.getAccountId());
        rowVector.add(vo.getPayeeAccountId());
        rowVector.add(vo.getEntry().getName());
        rowVector.add(vo.getRemarks());
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
