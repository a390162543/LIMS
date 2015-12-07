package presentation.businesshallui.revenueui;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import vo.EmployeeVO;
import businesslogic.BusinessLogicService;
import businesslogicservice.RevenueblService;

/**
 * 快递员的{@code JComboBox}，显示可选的快递员信息
 * @author 林祖华
 * @version 1.1
 * @see businesslogicservice.RevenueblService
 */
class CourierComboBox extends JComboBox<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2948672356782782851L;
	
	private RevenueblService revenueblService;
    private List<EmployeeVO> couriersList;
    
	public CourierComboBox(){
		revenueblService = BusinessLogicService.getRevenueblService();
		couriersList = revenueblService.getAllCouriers();
		
		String[] couriers = new String[couriersList.size()];
		for(int i=0;i<couriersList.size();i++){
		    EmployeeVO vo = couriersList.get(i);
		    couriers[i] = new String(vo.getId()+"("+vo.getName()+")");
		}
		
		ComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>(couriers);
		this.setModel(comboBoxModel);
		this.setSize(180, 20);
	}
	

	
	public String getSelectedCourier(){
	    EmployeeVO vo = couriersList.get(getSelectedIndex());
	    return vo.getId();
	}

}
