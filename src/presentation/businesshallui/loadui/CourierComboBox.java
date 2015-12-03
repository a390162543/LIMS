package presentation.businesshallui.loadui;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import vo.TruckVO;
import businesslogic.BusinessLogicService;
import businesslogicservice.TruckblService;

class TruckComboBox extends JComboBox<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2948672356782782851L;
	
	private TruckblService truckblService;
    private List<TruckVO> trucksList;
    
	public TruckComboBox(){
		truckblService = BusinessLogicService.getTruckblService();
		trucksList = truckblService.getTruckVO();
		
		String[] trucks = new String[trucksList.size()];
		for(int i=0;i<trucksList.size();i++){
		    TruckVO vo = trucksList.get(i);
		    trucks[i] = new String(vo.getId()+"("+vo.getOrganization()+"/"+vo.getTruckNumber()+")");
		}
		
		ComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>(trucks);
		this.setModel(comboBoxModel);
		this.setSize(180, 20);
	}
	

	
	public String getSelectedTruck(){
	    TruckVO vo = trucksList.get(getSelectedIndex());
	    return vo.getId();
	}

}
