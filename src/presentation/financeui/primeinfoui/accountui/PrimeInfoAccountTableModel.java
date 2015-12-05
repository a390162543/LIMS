package presentation.financeui.primeinfoui.accountui;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import vo.AccountVO;
import businesslogicservice.PrimeInfoblService;

public class PrimeInfoAccountTableModel extends DefaultTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7252107630881078125L;
	private PrimeInfoblService primeInfoblService;
    private List<AccountVO> dataList;
    private static final String[] TABLE_HEADER = {"账户编号","账户名称","账户金额"};
    
    
    public PrimeInfoAccountTableModel(PrimeInfoblService primeInfoblService) {
    	this.primeInfoblService = primeInfoblService;
    	dataList = new ArrayList<AccountVO>();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    public PrimeInfoAccountTableModel(List<AccountVO> vos) {  
	    dataList = vos;
	    setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }


    public void create(AccountVO vo){
        addRow(convertToVector(vo));
        dataList.add(vo);
        primeInfoblService.addAccountVO(vo);
    }
    
    public void delete(int row){
        removeRow(row);
        AccountVO vo = dataList.get(row);
        dataList.remove(row);
        primeInfoblService.removeAccountVO(vo);
    }   
    public void modify(int row, AccountVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        primeInfoblService.modifyAccountVO(vo);
    }
    public AccountVO getAccountVO(int row){
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
    
    private AccountVO getRowData(int row){
        return dataList.get(row);
    }
    
    private static Vector<Vector<Object>> convertToVectorData(List<AccountVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(AccountVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(AccountVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getId());
        rowVector.add(vo.getName());
        rowVector.add(String.format( "%.2f",vo.getMoney()));
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
