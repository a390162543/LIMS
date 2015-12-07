package presentation.financeui.statisticsui;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import vo.RevenueVO;
/**
 * {@code RevenueTableModel}继承{@code DefaultTableModel}，持有收款单数据，提供界面层数据操作业务
 * @author 刘德宽
 *
 */
public class RevenueTableModel extends DefaultTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8489890826140700921L;
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
