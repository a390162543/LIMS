package presentation.financeui.primeinfoui.employeeui;

import java.util.ArrayList;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import vo.EmployeeVO;
import businesslogicservice.PrimeInfoblService;

public class PrimeInfoEmployeeTableModel extends DefaultTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5381899261070675186L;
	private PrimeInfoblService primeInfoblService;
	private List<EmployeeVO> dataList;
	private static final String[] TABLE_HEADER = {"编号","姓名","所属机构","职位","电话","生日",
	    	"身份证号","性别","工资"};
	
	public PrimeInfoEmployeeTableModel(PrimeInfoblService p) {
		primeInfoblService = p;
		dataList = new ArrayList<EmployeeVO>();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
	}
	public PrimeInfoEmployeeTableModel(List<EmployeeVO> vos) {
		 
		dataList = vos;
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
	}
	
	public void create(EmployeeVO vo){
	    addRow(convertToVector(vo));
	    dataList.add(vo);
	    primeInfoblService.addEmployeeVO(vo);
	}
	    
	    public void delete(int row){
	     removeRow(row);
	     EmployeeVO vo = dataList.get(row);
	     dataList.remove(row);
	     primeInfoblService.removeEmployeeVO(vo);         
	    }
	    
	    public void modify(int row, EmployeeVO vo){
	        removeRow(row);
	        insertRow(row, convertToVector(vo));
	        dataList.remove(row);
	        dataList.add(row, vo);
	        
	    }
	    
	    public List<String> getOrganizationName(){
	    	List<String> names = new ArrayList<String>();
	    	if(primeInfoblService.getOrganizationName()!=null){
	    		for(String s:primeInfoblService.getOrganizationName())
	    			names.add(s);
	    	}
	    
	    	return names;
	    }
 
	    public EmployeeVO getEmployeeVO(int row){
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
	    
	    private EmployeeVO getRowData(int row){
	        return dataList.get(row);
	    }
	    
	    private static Vector<Vector<Object>> convertToVectorData(List<EmployeeVO> list){
	        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	        for(EmployeeVO vo:list){
	            data.add(convertToVector(vo));
	        }
	        return data;
	    }
	    
	    private static Vector<Object> convertToVector(EmployeeVO vo){
	        Vector<Object> rowVector = new Vector<Object>();
	        rowVector.add(vo.getId());
	        rowVector.add(vo.getName());
	        rowVector.add(vo.getOrganization());
	        rowVector.add(vo.getPosition().getName());
	        rowVector.add(vo.getTelephone());
	        rowVector.add(vo.getBirthday().toString());
	        rowVector.add(vo.getIdentityCardNum());
	        rowVector.add(vo.getSex().getName());
	        rowVector.add(vo.getPay().getPayString());
	        
	        return rowVector;
	    }
	    
	    private static Vector<String> getColumnNamesVector(){
	        Vector<String> v = new Vector<String>();
	        for(String s:TABLE_HEADER){
	            v.add(s);
	        }
	        return v;
	    }
		public String getOrganizationId(String selectedItem) {
			// TODO Auto-generated method stub
		   
		    String id = primeInfoblService.getOrganizationId(selectedItem);
			return id;

		}
}
