package presentation.businesshallui.loadui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import vo.TruckVO;
import businesslogic.BusinessLogicService;
import businesslogicservice.TruckblService;

/**
 * 车辆信息选择的{@code JComboBox}
 * @author 林祖华
 * @version 1.2
 */
public class TruckComboBox extends JComboBox<String>{

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
	
	public void update(String organization1,String organization2){
	    truckblService = BusinessLogicService.getTruckblService();
        trucksList = new ArrayList<TruckVO>();
        trucksList.addAll(truckblService.getTruckVO(organization1));
        if(!organization1.equals(organization2))
            trucksList.addAll(truckblService.getTruckVO(organization2));
        
        String[] trucks = new String[trucksList.size()];
        for(int i=0;i<trucksList.size();i++){
            TruckVO vo = trucksList.get(i);
            trucks[i] = new String(vo.getId()+"("+vo.getOrganization()+"/"+vo.getTruckNumber()+")");
        }
        
        ComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>(trucks);
        this.setModel(comboBoxModel);
        this.updateUI();
	}
	

	
	@Override
    public Dimension getSize() {
        Dimension dimension = super.getSize();
        dimension.width = (int) (dimension.width * 1.8);
        return dimension;
    }



    public String getSelectedTruck(){
	    TruckVO vo = trucksList.get(getSelectedIndex());
	    return vo.getId();
	}
    
    public void setSelectedTruck(String id){
        int index = 0;
        for(TruckVO vo:trucksList){
            if(vo.getId().equals(id)){
                break;
            }
            index++;
        }
        super.setSelectedIndex(index);
    }
}
