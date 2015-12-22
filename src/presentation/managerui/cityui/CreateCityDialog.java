package presentation.managerui.cityui;

 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

import presentation.mainui.MainFrame;
import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.ScreenMessage;
import vo.CityVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.cityinfo.CityId;
import businesslogic.checkbl.cityinfo.CityName;
import businesslogic.citybl.City;
import businesslogicservice.CityblService;

/**
 * 新建城市的Dialog
 * @author 刘航伸
 *@see businesslogic.City
 *@version 1.2
 */
public class CreateCityDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8582259066297268768L;
	
	 
	private CityblService cityblService;
	private JPanel mainPanel;
	private Checker nameChecker;
	private Checker idChecker;
	
	public CreateCityDialog( ){
		 this.setTitle("新增城市");
		 mainPanel = new JPanel();
		 cityblService = new City();
		 mainPanel.setBounds(0, 0, 400, 300);
		 mainPanel.add(new InputCityPanel());
		 mainPanel.setLayout(null);
		 this.setModalityType(ModalityType.APPLICATION_MODAL);
		 this.setLocationRelativeTo(MainFrame.getMainFrame());
		 this.add(mainPanel);
		 this.setBounds(400, 200, 400, 250);
		 this.setLayout(null);
		 this.setVisible(true);
	}
	
	/**
	 * 输出城市名称，编号的Panel
	 * @author 刘航伸
	 *	
	 */
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
			JLabel idLabel = new JLabel("城市编号");
			idLabel.setBounds(50, 100, 100, 25);
			JTextField idField = new JTextField();
			idField.setBounds(180, 100, 60, 20);		
			JButton cancelButton = new JButton("取消");
			cancelButton.setBounds(190, 150, 70, 30);
			
			//设置idField只能输入数字
			idField.addKeyListener(new KeyAdapter() {
				  public void keyTyped(KeyEvent e) {  
		                int keyChar = e.getKeyChar();                 
		                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {  
		 
		                }else{  
		                     e.consume();
		                     
		                }  
		            }            
			});
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
					 
					 boolean isRight = idChecker.check() && nameChecker.check();
					 if(!isRight){
						 return;
					 }
					 
					if(cityblService.getAllName().isEmpty()){
						HashMap<String, Double> map = new HashMap<String, Double>();
						String name = nameField.getText();
						String id = idField.getText();
						map.put(name, 0.0);
						cityblService.createCityPO(new CityVO(name, id, map));
					}
					else{
						mainPanel.removeAll();
						 
						CreateCityDialog.this.mainPanel.add(
						new InputDistancePanel(nameField.getText(),idField.getText()));
						mainPanel.repaint();
						}
					
				}
			});
			
			this.add(nameLabel);
			this.add(nameField);
			this.add(idField);
			this.add(idLabel);
		    this.add(cancelButton);
			this.add(nextButton);			
			this.setLayout(null);
			this.setVisible(true);
			
			//添加检查项
			nameChecker = new Checker(nameField,new CheckInfoGetter() {
				
				@Override
				public CheckInfo getCheckInfo() {
					// TODO Auto-generated method stub
					if(nameField.getText() == null){
						return null;
					}
					else{
						return new CityName(nameField.getText());
					}
				}
			});
			nameField.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					nameChecker.check();
					 
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			idChecker = new Checker(idField,new CheckInfoGetter() {
				
				@Override
				public CheckInfo getCheckInfo() {
					// TODO Auto-generated method stub
					if(idField.getText() == null){
						return null;
					}
					else{
						return new CityId(idField.getText());
					}
				}
			});
			idField.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					idChecker.check();
				 					 
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
	}

	/*
	 * 输入城市间距离的panel
	 */
	private class InputDistancePanel extends JPanel{

		
		/**
		 * 
		 */
		private static final long serialVersionUID = 115690782502191733L;

		public InputDistancePanel(String name, String id){
			 
			String[] citySrt =  {"",name};		 
			String cityName[] =(String[]) 
					cityblService.getAllName().toArray(new String[cityblService.getAllName().size()]);
			 
			String[][] data = new String[cityName.length][2] ;
			
			for(int i = 0;i < cityName.length;i ++){
				data[i][0] = cityName[i]; 
				data[i][1] = "";
				 
			}
			JButton cancelButton = new JButton("取消");
			cancelButton.setBounds(10, 250, 80, 20);		
			JTable cityTabel = new JTable(data,citySrt);
			JScrollPane cityScrollpane = new JScrollPane(cityTabel);
			cityScrollpane.setBounds(0, 0, 200, 200);
			cancelButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					mainPanel.removeAll();
					 mainPanel.add(new InputCityPanel());
					 mainPanel.repaint();
				}
			});

			JButton sureButton = new JButton("确定");
			sureButton.setBounds(100, 250, 80, 20);
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
					ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
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
