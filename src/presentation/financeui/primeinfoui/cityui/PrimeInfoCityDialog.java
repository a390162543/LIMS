package presentation.financeui.primeinfoui.cityui;


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
 

public class PrimeInfoCityDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6722175178600991034L;
	private CityblService cityblService;
	private JPanel mainPanel;
	private Checker nameChecker;
	private Checker idChecker;
	private PrimeInfoCityTableModel tableModel;
	
	public PrimeInfoCityDialog(PrimeInfoCityTableModel em ){
		 this.setTitle("��������");
		 this.tableModel = em;
		 mainPanel = new JPanel();
		 cityblService = new City();
		 mainPanel.setBounds(0, 0, 400, 300);
		 mainPanel.add(new InputCityPanel());
		 mainPanel.setLayout(null);

		 this.add(mainPanel);
		 this.setSize(250, 180);
		 this.setLayout(null);
		 this.setVisible(true);	
		 this.setModalityType(ModalityType.APPLICATION_MODAL);
		 this.setLocationRelativeTo(MainFrame.getMainFrame());
	}
	
	public PrimeInfoCityDialog(PrimeInfoCityTableModel em, int modelRow, boolean isEdit) {
	// TODO Auto-generated constructor stub
		 this.tableModel = em;
		 mainPanel = new JPanel();
		 cityblService = new City();
		 mainPanel.setBounds(0, 0, 400, 300);
		 mainPanel.add(new InputCityPanel(  em,   modelRow,   isEdit));
		 mainPanel.setLayout(null);
		 this.setModalityType(ModalityType.APPLICATION_MODAL);
		 this.setLocationRelativeTo(MainFrame.getMainFrame());
		 this.add(mainPanel);
		 this.setSize(250, 180);
		 this.setLayout(null);
		 this.setVisible(true);
}
	
	/**
	 * ����������ƣ���ŵ�Panel
	 * @author ������
	 *	
	 */
	private class InputCityPanel extends JPanel{


		  /**
		 * 
		 */
		private static final long serialVersionUID = 3840173390122307371L;

		public InputCityPanel(){
			this.setBounds(0, 0, 250, 150);					 
			JLabel nameLabel = new JLabel("��������");
			nameLabel.setBounds(10, 10, 100, 25);
			JTextField nameField = new JTextField();
			nameField.setBounds(100, 10, 65, 25);		 
			JLabel idLabel = new JLabel("���б��");
			idLabel.setBounds(10, 50, 100, 25);
			JTextField idField = new JTextField();
			idField.setBounds(100, 50, 60, 25);		
			JButton cancelButton = new JButton("ȡ��");
			cancelButton.setBounds(60, 90, 70, 30);			
			JButton nextButton = new JButton("��һ��");
			nextButton.setBounds(150, 90, 70, 30);
			
			//����idFieldֻ����������
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
					 PrimeInfoCityDialog.this.dispose();
				}
			});
			
 
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
						 
						PrimeInfoCityDialog.this.mainPanel.add(
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
			
			//��Ӽ����
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
		
	//�鿴��Panel
		public InputCityPanel(PrimeInfoCityTableModel em, int modelRow, boolean isEdit){
			CityVO vo = tableModel.getCityVO(modelRow);
			this.setBounds(0, 0, 400, 250);					 
			JLabel nameLabel = new JLabel("��������");
			nameLabel.setBounds(50, 50, 100, 25);
			JTextField nameField = new JTextField();
			nameField.setBounds(180, 50, 60, 25);		 
			JLabel idLabel = new JLabel("���б��");
			idLabel.setBounds(50, 100, 100, 25);
			JTextField idField = new JTextField();
			idField.setBounds(180, 100, 60, 25);	
			idField.setEnabled(false);
			
			
			//�������
			idField.setText(vo.getId());
			nameField.setText(vo.getName());
			
			JButton cancelButton = new JButton("ȡ��");
			cancelButton.setBounds(190, 150, 70, 30);
			cancelButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 PrimeInfoCityDialog.this.dispose();
				}
			});
			
			if(!isEdit){
				nameField.setEnabled(false);
				cancelButton.setVisible(false);
			}
			
			JButton nextButton = new JButton("ȷ��");
			nextButton.setBounds(280, 150, 70, 30);
			nextButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub	
					if(isEdit){									
						boolean isRight = idChecker.check() && nameChecker.check();
						if(!isRight){
							ScreenMessage.putOnScreen(ScreenMessage.SAVE_FAILURE);  
						}
						else {
							vo.setName(nameField.getName());
							tableModel.modify(modelRow,vo);
							PrimeInfoCityDialog.this.dispose();
							ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);  
						}
					}
					else{
						 PrimeInfoCityDialog.this.dispose();
					}
					
				}
			});
			this.add(idField);
			this.add(idLabel);
			this.add(nameLabel);
			this.add(nameField);
		    this.add(cancelButton);
			this.add(nextButton);			
			this.setLayout(null);
			this.setVisible(true);
			
			//��Ӽ����
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
	 * ������м�����panel
	 */
	private class InputDistancePanel extends JPanel{

		
		/**
		 * 
		 */
		private static final long serialVersionUID = 115690782502191733L;

		public InputDistancePanel(String name, String id){
			List<String> names =   tableModel.getCityName();
			List<String> names1 =   cityblService.getAllName();
			for(int i = 0; i < names1.size(); i ++){
				names.add(names1.get(i));
			}
			String[] citySrt =  {"",name};		
		 
			String cityName[] =(String[]) 
					names.toArray(new String[names.size()]);
			 
			String[][] data = new String[cityName.length][2] ;
			
			for(int i = 0;i < cityName.length;i ++){
				data[i][0] = cityName[i]; 
				data[i][1] = "";
				 
			}
			JButton cancelButton = new JButton("ȡ��");
			cancelButton.setBounds(60, 220, 80, 20);		
			JTable cityTabel = new JTable(data,citySrt);
			JScrollPane cityScrollpane = new JScrollPane(cityTabel);
			cityScrollpane.setBounds(0, 0, 230, 200);
			cancelButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					mainPanel.removeAll();
					PrimeInfoCityDialog.this.setSize(250, 180);
					mainPanel.add(new InputCityPanel());
					mainPanel.repaint();
				}
			});

			JButton sureButton = new JButton("ȷ��");
			sureButton.setBounds(150, 220, 80, 20);
			sureButton.addActionListener(new ActionListener() {
				
			 
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Map<String, Double> distance = new HashMap<String, Double>();
					List<CityVO> vos = cityblService.getAll();
					List<CityVO> vos1 = tableModel.getCityVO();
					for(int i = 0; i < vos1.size(); i ++){
						vos.add(vos1.get(i));
					}
					
					for(int i = 0; i < cityName.length; i++){
						distance.put(cityName[i], new Double ((String)cityTabel.getValueAt(i, 1)) );
						for(CityVO vo:vos){
							if(vo.getName().equals(cityName[i])){
								vo.setDistance(name,new Double ((String)cityTabel.getValueAt(i, 1)) );
								tableModel.modify( vo);;
							}
						}
					}
					distance.put(name, 0.0);
					CityVO vo = new CityVO(name, id, distance);
					tableModel.create(vo);
					PrimeInfoCityDialog.this.dispose();
					ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);  
				}
			});
			
			
			
			PrimeInfoCityDialog.this.setSize(250, 300);
			
			this.add(cityScrollpane);
			this.add(cancelButton);
			this.add(sureButton);
			this.setBounds(0, 0, 400, 300);
			this.setVisible(true);
			this.setLayout(null);
		 
		}
	}
}
