package presentation.managerui.organizationui;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import businesslogic.BusinessLogicService;
import businesslogic.organizationbl.Organization;
import businesslogicservice.OrganizationblService;
import vo.OrganizationVO;

/**
 * 机构管理界面的数据管理
 * @author 刘航伸
 * @version 1.2
 */
public class OrganizationTableModel extends DefaultTableModel{

 
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1956052006398598844L;
	private OrganizationblService OrganizationblService;
    private List<OrganizationVO> dataList;
    private static final String[] TABLE_HEADER = {"编号","名称","所在城市"};
    
    
    public OrganizationTableModel() {
        OrganizationblService = BusinessLogicService.getOrganizationblService();
        dataList = OrganizationblService.getOrganizationVO();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void create(OrganizationVO vo){
        addRow(convertToVector(vo));
        dataList.add(vo);
        OrganizationblService.createOrganizationPO(vo);
    }
    
    public void delete(int row){
        removeRow(row);
        OrganizationVO vo = dataList.get(row);
        dataList.remove(row);
        OrganizationblService.deleteOrganizationPO(vo);
    }
    
    public void modify(int row, OrganizationVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        OrganizationblService.modifyOrganizationPO(vo);
    }
    
    public OrganizationVO getOrganizationVO(int row){
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
