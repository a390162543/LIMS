package presentation.managerui.cityui;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
 
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import vo.CityVO;
import businesslogic.citybl.City;
import businesslogicservice.CityblService;

public class CreateCityDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8582259066297268768L;
	
	 
	private CityblService cityblService;
	private JPanel mainPanel;
	
	
	public CreateCityDialog( ){
		 this.setTitle("新增城市");
		 mainPanel = new JPanel();
		 cityblService = new City();
		 mainPanel.setBounds(0, 0, 400, 300);
		 mainPanel.add(new InputCityPanel());
		 mainPanel.setLayout(null);
		 this.add(mainPanel);
		 this.setBounds(400, 200, 400, 250);
		 this.setLayout(null);
		 this.setVisible(true);
	}
	
	private class InputCityPanel extends JPanel{


		  /**
		 * 
		 */
		private static final long serialVersionUID = 3840173390122307371L;

		public InputCityPanel(){
			this.setBounds(0, 0, 400, 250);		
			 
			JLabel nameLabel = new JLabel("城市名称");
			nameLabel.setBounds(50, 50, 100, 25);
			JTextField nameField = new JTextField();
			nameField.setBounds(180, 50, 60, 20);
			JLabel warnLabel = new JLabel();
			warnLabel.setBounds(265, 50, 100, 25);		
			JLabel idLabel = new JLabel("城市编号");
			idLabel.setBounds(50, 100, 100, 25);
			JTextField idField = new JTextField();
			idField.setBounds(180, 100, 60, 20);		
			JButton cancelButton = new JButton("取消");
			cancelButton.setBounds(190, 150, 70, 30);
			cancelButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 CreateCityDialog.this.dispose();
				}
			});
			
			JButton nextButton = new JButton("下一步");
			nextButton.setBounds(280, 150, 70, 30);
			nextButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("click the surebutton ");
					if(nameField.getText().equals(""))
						warnLabel.setText("请输入城市名称");
						 
					else{
						if(cityblService.getAllName().isEmpty()){
							System.out.println("no city");
							HashMap<String, Double> map = new HashMap<String, Double>();
							String name = nameField.getText();
							String id = idField.getText();
							map.put(name, 0.0);
							cityblService.createCityPO(new CityVO(name, id, map));
						}
						else{
							mainPanel.removeAll();
							System.out.println("removeAll");
							CreateCityDialog.this.mainPanel.add(
							new InputDistancePanel(nameField.getText(),idField.getText()));
							mainPanel.repaint();
							}
					}
				}
			});
			 
			this.add(nameLabel);
			this.add(nameField);
			this.add(idField);
			this.add(idLabel);
			this.add(warnLabel);
			this.add(nextButton);
			this.add(cancelButton);
			this.setLayout(null);
			this.setVisible(true);
			
		}
	}

	private class InputDistancePanel extends JPanel{

		
		/**
		 * 
		 */
		private static final long serialVersionUID = 115690782502191733L;

		public InputDistancePanel(String name, String id){
			System.out.println("come in to distancepanel");	 
			String[] citySrt =  {"",name};		 
			String cityName[] =(String[]) 
					cityblService.getAllName().toArray(new String[cityblService.getAllName().size()]);
			 
			String[][] data = new String[cityName.length][2] ;
			
			for(int i = 0;i < cityName.length;i ++){
				data[i][0] = cityName[i]; 
				data[i][1] = "";
				System.out.println(data[i][0]);
			}
			JButton cancelButton = new JButton("取消");
			cancelButton.setBounds(100, 250, 80, 20);		
			JTable cityTabel = new JTable(data,citySrt);
			JScrollPane cityScrollpane = new JScrollPane(cityTabel);
			cityScrollpane.setBounds(0, 0, 200, 200);
			cancelButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});

			JButton sureButton = new JButton("确定");
			sureButton.setBounds(200, 250, 80, 20);
			sureButton.addActionListener(new ActionListener() {
				
			 
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Map<String, Double> distance = new HashMap<String, Double>();
					List<CityVO> vos = cityblService.getAll();
					for(int i = 0; i < cityName.length; i++){
						System.out.println(i+":"+cityTabel.getValueAt(i, 1));
						distance.put(cityName[i], new Double ((String)cityTabel.getValueAt(i, 1)) );
						for(CityVO vo:vos){
							if(vo.getName().equals(cityName[i])){
								vo.setDistance(name,new Double ((String)cityTabel.getValueAt(i, 1)) );
								cityblService.modifyCityPO(vo);
							}
						}
					}
					distance.put(name, 0.0);
					CityVO vo = new CityVO(name, id, distance);
					cityblService.createCityPO(vo);
				}
			});
			
			
			
			
			
			this.add(cityScrollpane);
			this.add(cancelButton);
			this.add(sureButton);
			this.setBounds(0, 0, 400, 300);
			this.setVisible(true);
			this.setLayout(null);
			 
		}
	}
}
