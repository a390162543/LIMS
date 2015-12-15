package presentation.businesshallui.loadui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import vo.EmployeeVO;
import businesslogic.BusinessLogicService;
import businesslogic.userbl.LoginController;
import businesslogicservice.EmployeeblService;

/**
 * 快递员的{@code JComboBox}，显示可选的快递员信息
 * @author 林祖华
 * @version 1.1
 * @see businesslogicservice.RevenueblService
 */
public class DriverComboBox extends JComboBox<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2948672356782782851L;
	
	private EmployeeblService employeeblService;
    private List<EmployeeVO> driversList;
    
	public DriverComboBox(){
		employeeblService = BusinessLogicService.getEmployeeblService();
		driversList = new ArrayList<EmployeeVO>();
		driversList.addAll(employeeblService.getDriverVO(LoginController.getOrganizationName()));
		
		String[] drivers = new String[driversList.size()];
		for(int i=0;i<driversList.size();i++){
		    EmployeeVO vo = driversList.get(i);
		    drivers[i] = new String(vo.getId()+"("+vo.getName()+"/"+vo.getOrganization()+")");
		}
		
		ComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>(drivers);
		this.setModel(comboBoxModel);
		this.setSize(180, 20);
	}

	
	public String getSelectedDriver(){
	    EmployeeVO vo = driversList.get(getSelectedIndex());
	    return vo.getId();
	}
	
    @Override
    public Dimension getSize() {
        Dimension dimension = super.getSize();
        dimension.width = (int) (dimension.width * 1.2);
        return dimension;
    }
    
    public void update(String organization1,String organization2){
        employeeblService = BusinessLogicService.getEmployeeblService();
        driversList = new ArrayList<EmployeeVO>();
        driversList.addAll(employeeblService.getDriverVO(organization1));
        if(!organization1.equals(organization2))
            driversList.addAll(employeeblService.getDriverVO(organization2));
        
        String[] drivers = new String[driversList.size()];
        for(int i=0;i<driversList.size();i++){
            EmployeeVO vo = driversList.get(i);
            drivers[i] = new String(vo.getId()+"("+vo.getName()+"/"+vo.getOrganization()+")");
        }
        
        ComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>(drivers);
        this.setModel(comboBoxModel);
        this.updateUI();
    }
    
    
    public void setSelectedDriver(String id){
        int index = 0;
        for(EmployeeVO vo:driversList){
            if(vo.getId().equals(id)){
                break;
            }
            index++;
        }
        super.setSelectedIndex(index);
    }
    
}
