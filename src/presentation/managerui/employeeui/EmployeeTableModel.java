package presentation.managerui.employeeui;

 
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import presentation.util.PresentationUtil;
import businesslogic.BusinessLogicService;
import businesslogic.userbl.User;
import businesslogicservice.EmployeeblService;
import systemenum.Power;
import vo.EmployeeVO;
import vo.UserVO;

/**
 * 员工管理界面的数据管理
 * @author 刘航伸
 * @version 1.5
 */
public class EmployeeTableModel extends DefaultTableModel{   
    /**
	 * 
	 */
	private static final long serialVersionUID = 5749745959779424336L;
	private EmployeeblService EmployeeblService;
    private List<EmployeeVO> dataList;
    private static final String[] TABLE_HEADER = {"编号","姓名","所属机构","职位","电话","生日",
    	"身份证号","性别","工资"};
    
    
    public EmployeeTableModel() {
        EmployeeblService = BusinessLogicService.getEmployeeblService();
        dataList = EmployeeblService.getEmployeeVO();
        setDataVector(convertToVectorData(dataList), getColumnNamesVector());
    }
    
    public void create(EmployeeVO vo){
        addRow(convertToVector(vo));
        dataList.add(vo);
        EmployeeblService.createEmployeePO(vo);
        Power power = vo.getPosition().getPower();
     	 
        UserVO uservo = new UserVO(vo.getId(), "000000", power);
        User user = new User();
        user.creatUserPO(uservo);
    }
    
    public void delete(int row){
        removeRow(row);
        EmployeeVO vo = dataList.get(row);
        dataList.remove(row);
        EmployeeblService.deleteEmployeePO(vo);
    }
    
    public void modify(int row, EmployeeVO vo){
        removeRow(row);
        insertRow(row, convertToVector(vo));
        dataList.remove(row);
        dataList.add(row, vo);
        EmployeeblService.modifyEmployeePO(vo);
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
        rowVector.add(PresentationUtil.getDate(vo.getBirthday()));
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
    
}
