package presentation.financeui.settlementui;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import vo.RevenueVO;

public class RevenueTableModel extends DefaultTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9105861957566660994L;
	private List<RevenueVO> dataList;
    private static final String[] TABLE_HEADER = {"收款单编号","收款日期","快递员编号","收款金额","订单数量","收款账户","收款机构"};
    
    public RevenueTableModel(List<RevenueVO> vos){
    	dataList = vos;
    	setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    private static Vector<Vector<Object>> convertToVectorData(List<RevenueVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(RevenueVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    public RevenueVO getRevenueVO(int row){
        return getRowData(row);
    }
    
    public RevenueVO getRowData(int row){
        return dataList.get(row);
    }
    
    public void delete(int row){
        removeRow(row);
        dataList.remove(row);       
    }
    private static Vector<Object> convertToVector(RevenueVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        rowVector.add(sdf.format(vo.getRevenueDate()));
        rowVector.add(vo.getCourierId());
        rowVector.add(String.format( "%.2f",vo.getRevenue()));
        rowVector.add(vo.getOrderId().size());
        rowVector.add(vo.getAccountId());
        rowVector.add(vo.getOrganization());

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
