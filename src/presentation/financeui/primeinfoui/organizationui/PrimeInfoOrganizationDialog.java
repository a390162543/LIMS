package presentation.financeui.primeinfoui.organizationui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DialogLayoutManager;
import vo.OrganizationVO;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.organizationinfo.OrganizationName;
import businesslogic.organizationbl.Organization; 
import businesslogicservice.IdblService;
import businesslogicservice.OrganizationblService;

/**
 * 初期建账时创建、修改和查询机构界面
 * @author 刘航伸
 * @see presentation.employeeui.OrganizationTableModel
 * @version 1.2
 */
public class PrimeInfoOrganizationDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3501551715388232778L;
 
 
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel idLabel;
	private JTextField idField;
	private JLabel cityLabel;
	private JComboBox<String> cityBox;
	private JButton cancleButton;
	private JButton sureButton;
	private PrimeInfoOrganizationTableModel tableModel;
	private OrganizationblService organizationblService;
	private Checker organizationNameChecker;
 
	
	public PrimeInfoOrganizationDialog(PrimeInfoOrganizationTableModel tm){
		tableModel = tm;	
		init();
		
		organizationblService =  BusinessLogicService.getOrganizationblService();
		cityBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub			
				setId(nameField.getText());
				organizationNameChecker.check();
			}
		});
			
		sureButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean isRight = organizationNameChecker.check();
				if(isRight){
					update(0,true);
					PrimeInfoOrganizationDialog.this.dispose();
				}
				else{
					return;
				}
				 
			}
		});
	}
	public void setId(String organizationName){
		String cityId =  organizationblService.getCityId
				((String)cityBox.getSelectedItem());
		if(organizationName.contains("中转中心")){
			IdblService idblService = organizationblService.getIdblService(1);
			idField.setText(idblService.createNewId(cityId));
		}
		else if(organizationName.contains("营业厅")){
			IdblService idblService = organizationblService.getIdblService(3);
			idField.setText(idblService.createNewId(cityId));
		}
		else{
			IdblService idblService = organizationblService.getIdblService();
			idField.setText(idblService.createNewId());
		}
		
	}
 
	
	public void init(){		 
		organizationblService = BusinessLogicService.getOrganizationblService();
		List<String> cityList = organizationblService.getAllCityName();
		String[] cityStr = cityList.toArray(new String[cityList.size()]);
		 
		nameLabel = new JLabel();
		nameField = new JTextField();
		cityBox = new JComboBox<String>(cityStr);
		
		if(!tableModel.getCityName().isEmpty()){
			for(String s : tableModel.getCityName())
			cityBox.addItem(s);
		}
		
		
		
		cityLabel = new JLabel();
		idField = new JTextField();
		idLabel = new JLabel();
		cancleButton = new JButton("取消");
		sureButton = new JButton("确定");		
		this.setBounds(0, 0, 380, 300);
		 
		nameLabel.setText("机构名称");
		nameLabel.setBounds(27, 65, 100, 20);
		nameField.setBounds(135, 65, 180, 20);
		cityLabel.setText("所在城市");
		cityLabel.setBounds(27, 100, 100, 20);
		cityBox.setBounds(137, 100, 80, 20);
		idLabel.setText("机构编号");
		idLabel.setBounds(27, 135, 100, 20);
		idField.setBounds(137, 135, 180, 20);		 
		cancleButton.setBounds(180, 185, 70, 30);
		sureButton.setBounds(270, 185, 70, 30);
		
		
		
		cancleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PrimeInfoOrganizationDialog.this.dispose();
			}
		});
		
		this.add(idLabel);
		this.add(idField);
		this.add(nameLabel);
		this.add(nameField);
		this.add(cityLabel);
		this.add(cityBox);
		this.add(sureButton);	
		this.add(cancleButton);		
		this.setLayout(new DialogLayoutManager());
		this.setVisible(true);
		
		//添加检查项
		organizationNameChecker = new Checker(nameField,new CheckInfoGetter() {
					
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(nameField.getText() == null){
					return null;
				}
				return new OrganizationName(nameField.getText(), (String)cityBox.getSelectedItem());
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
				organizationNameChecker.check();
			}
					
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
						
			}
		});
	}
	
	public PrimeInfoOrganizationDialog(PrimeInfoOrganizationTableModel em, int modelRow,boolean isEdit){
	
		this.tableModel = em;
		init();
		OrganizationVO vo = tableModel.getOrganizationVO(modelRow);
		nameField.setText(vo.getName());
		cityBox.setSelectedItem(vo.getCity());
		cityBox.setEnabled(false);
		idField.setText(""+vo.getId());	
		idField.setEnabled(false);
		if(!isEdit){
			nameField.setEnabled(false);
			cityBox.setEnabled(false);
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					PrimeInfoOrganizationDialog.this.dispose();
				}
			});
		}
		else{
			cancleButton.setVisible(false);
			cityBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub			
					setId(nameField.getText());
					organizationNameChecker.check();
				}
			});
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					boolean isRight = organizationNameChecker.check();
					if(isRight){
						update(modelRow,false);
						PrimeInfoOrganizationDialog.this.dispose();						
					}
					else{
						return;
					}
					
				}
			});
		}		
	}
	
 
	
	public void update( int modelRow, boolean isNew){
		OrganizationblService organizationblService = new Organization();
		String name = nameField.getText();
		String city = (String) cityBox.getSelectedItem();
		String id = idField.getText();
		OrganizationVO vo= new OrganizationVO(id, name, city);
		organizationblService.createOrganizationPO(vo); 
		if(isNew)
			tableModel.create(vo);
		else
			tableModel.modify(modelRow, vo);	 
	}
}
