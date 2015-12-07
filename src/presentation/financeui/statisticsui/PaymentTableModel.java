package presentation.financeui.statisticsui;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import vo.PaymentVO;
/**
 * {@code PaymentTableModel}�̳�{@code DefaultTableModel}�����и�����ݣ��ṩ��������ݲ���ҵ��
 * @author ���¿�
 *
 */
public class PaymentTableModel extends DefaultTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4009177035415301182L;
	
    private List<PaymentVO> dataList;
    private static final String[] TABLE_HEADER = {"������","��������","������","�տ�������","�տ�˻�","����˻�","��Ŀ","��ע"};
    
    public PaymentTableModel(List<PaymentVO> vos){
    	dataList = vos;
    	setDataVector(convertToVectorData(dataList), getColumnNamesVector());
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
