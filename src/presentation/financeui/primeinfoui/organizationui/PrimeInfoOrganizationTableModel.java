package presentation.financeui.primeinfoui.organizationui;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import vo.OrganizationVO;
import businesslogicservice.PrimeInfoblService;
public class PrimeInfoOrganizationTableModel extends DefaultTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4859333754654184781L;
	private PrimeInfoblService primeInfoblService;
    private List<OrganizationVO> dataList;
    private static final String[] TABLE_HEADER = {"编号","名称","所在城市"};
    
    public PrimeInfoOrganizationTableModel(PrimeInfoblService p){
    	primeInfoblService = p;
		dataList = new ArrayList<OrganizationVO>();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public PrimeInfoOrganizationTableModel(List<OrganizationVO> vos){
    	 dataList = vos;
 	    setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void create(OrganizationVO vo){
        addRow(convertToVector(vo));
        dataList.add(vo);
        primeInfoblService.addOrganizationVO(vo);
 
    }
    
    public void delete(int row){
        removeRow(row);
        OrganizationVO vo = dataList.get(row);
        dataList.remove(row);
        primeInfoblService.removeOrganizationVO(vo);
    }
    
    public void modify(int row, OrganizationVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        primeInfoblService.modifyOrganizationVO(vo);
    }
    
    public OrganizationVO getOrganizationVO(int row){
        return getRowData(row);
    }
    
    public List<String> getCityName(){    
	    List<String> names = new ArrayList<String>();
	    if(primeInfoblService.getCityName()!=null){
	    	for(String s:primeInfoblService.getCityName())
	    		names.add(s);
	    }    
	   	return names;	    
    }
    
    public String getCityId(String name){
    	return primeInfoblService.getCityId(name);
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
    
    private OrganizationVO getRowData(int row){
        return dataList.get(row);
    }
    
    private static Vector<Vector<Object>> convertToVectorData(List<OrganizationVO> list){
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(OrganizationVO vo:list){
            data.add(convertToVector(vo));
        }
        return data;
    }
    
    private static Vector<Object> convertToVector(OrganizationVO vo){
        Vector<Object> rowVector = new Vector<Object>();
        rowVector.add(vo.getId());
        rowVector.add(vo.getName());
        rowVector.add(vo.getCity());
         
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
