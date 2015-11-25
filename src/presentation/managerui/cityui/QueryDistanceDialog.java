package presentation.managerui.cityui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vo.CityVO;
import businesslogic.citybl.City;
import businesslogicservice.CityblService;

public class QueryDistanceDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3684448798999850433L;
	private CityblService cityblService;
	private JComboBox<String> city1Box ;
	private JComboBox<String> city2Box;
	private JTextField distanceField;
	private CityVO cityvo1;
	private CityVO cityvo2;
	
	public QueryDistanceDialog() {	 
		// TODO Auto-generated constructor stub	 
		cityblService = new City();
		String[] cityStr1 = (String[])cityblService.getAllName().toArray(new String[cityblService.getAllName().size()]);
		String[] cityStr2 = cityStr1;
		JLabel infoLabel = new JLabel("距离查询");
		infoLabel.setBounds(105, 15, 170, 35);
		JLabel city1Label = new JLabel("城市");
		city1Label.setBounds(80, 70, 80, 20);
		JLabel city2Label = new JLabel("城市");
		city2Label.setBounds(215, 70, 80, 20);	
		JLabel markLabel = new JLabel("---");
		markLabel.setBounds(140, 100, 80, 20);
		distanceField = new JTextField();
		distanceField.setBounds(145, 145, 60, 20);
		JLabel unitLabel = new JLabel("km");
		unitLabel.setBounds(205, 145, 80, 20);
		JButton cancelButton = new JButton("取消");
		cancelButton.setBounds(190, 190, 70, 30);
		JButton sureButton = new JButton("确认");
		sureButton.setBounds(280, 190, 70, 30);
		city1Box = new JComboBox<String>(cityStr1);
		city1Box.setBounds(90, 100, 60, 20);
		city1Box.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				showDistance();
			}
		});
		
		city2Box = new JComboBox<String>(cityStr2);
		city2Box.setBounds(220, 100, 60, 20);
		city2Box.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				showDistance();
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				QueryDistanceDialog.this.dispose();
			}
		});
		
		sureButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!distanceField.getText().equals("")){
					cityvo1.getDistance().remove((String)city2Box.getSelectedItem());
					cityvo1.getDistance().put((String) city2Box.getSelectedItem(),
							new Double(distanceField.getText()));
					cityvo2.getDistance().remove((String)city1Box.getSelectedItem());
					cityvo2.getDistance().put((String) city1Box.getSelectedItem(),
							new Double(distanceField.getText()));
					cityblService.modifyCityPO(cityvo1);
					cityblService.modifyCityPO(cityvo1);
				}
			}
		});
		this.setBounds(300, 200, 380, 300);
		this.add(infoLabel);
		this.add(city1Label);
		this.add(city2Label);
		this.add(city1Box);
		this.add(city2Box);
		this.add(markLabel);
		this.add(distanceField);
		this.add(unitLabel);
		this.add(cancelButton);
		this.add(sureButton);		
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public void showDistance(){
		List<CityVO> vos = cityblService.getAll();
		for(CityVO vo:vos){
			if(vo.getName().equals(city1Box.getSelectedItem())){
				cityvo1 = vo;			 
				distanceField.setText(""+vo.getDistance().get(city2Box.getSelectedItem()));	
			}	
			if(vo.getName().equals(city2Box.getSelectedItem()))
				cityvo2 = vo;				
		}
		 
	}
	
	 
}
