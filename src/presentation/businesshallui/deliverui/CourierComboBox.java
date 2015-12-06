package presentation.businesshallui.deliverui;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import vo.EmployeeVO;
import businesslogic.BusinessLogicService;
import businesslogicservice.DeliverblService;

public class CourierComboBox extends JComboBox<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2948672356782782851L;
	
	private DeliverblService deliverblService;
    private List<EmployeeVO> couriersList;
    
	public CourierComboBox(){
		deliverblService = BusinessLogicService.getDeliverblService();
		couriersList = deliverblService.getAllCouriers();
		
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
