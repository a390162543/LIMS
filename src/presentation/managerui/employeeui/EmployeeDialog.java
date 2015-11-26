package presentation.managerui.employeeui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import businesslogic.userbl.User;
import businesslogicservice.UserblService;
import po.PayPO;
import presentation.util.OrganizationComboBox;
import systemenum.Position;
import systemenum.Power;
import systemenum.Sex;
import vo.EmployeeVO;
import vo.UserVO;

public class EmployeeDialog {
	private JDialog employeeDialog ;	 
	private String positions[];
	private Integer year[];
	private Integer month[];
	private Integer day[] ;
	private JLabel infoLabel ;	 
	private JLabel nameLabel ; 
	private JTextField nameField;	 
	private JLabel sexLabel;	 
	private JRadioButton maleRadioButton;	 
	private JRadioButton femaleRadioButton;	 
	private ButtonGroup sex ;	 	 
	private JLabel idLabel;	  
	private JTextField idField;	 
	private JLabel organizationLabel;	 
	private OrganizationComboBox organizationBox;	 
	private JLabel positionLabel;	 
	private JComboBox<String> positionBox;	 
	private JLabel phoneLabel;	 
	private JTextField phoneField;	 
	private JLabel idCardLabel;	 
	private JTextField idCardField;
	private JLabel birthLabel;
	private JComboBox<Integer> yearBox;
	private JComboBox<Integer> monthBox;
	private JComboBox<Integer> dayBox;	 
	private JLabel yearLabel;
	private JLabel monthLabel;	 
	private JLabel dayLabel;	 
	private JLabel payLabel;
	private JLabel basePayLabel ;
	private JTextField basePayField;	 
	private JLabel unitLabel;
	private JLabel percentageLabel1; 
	private JTextField percentageField;
	private JLabel percentageLabel2;
	private JButton cancleButton;
	private JButton sureButton;
    private EmployeeTableModel tableModel;

	 
	public void init(){
 
		positions = new String[]{"总经理","营业厅业务员","中转中心业务员","快递员",
				 "中转中心仓库管理员","高级财务人员","财务人员","管理员","司机"};
	 
		year = new Integer[]{1996,1997};
		month = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12};
		day = new Integer[]{1,2,3,4,5,6,7,8,9,10};
		infoLabel = new JLabel("员工信息");
		nameLabel = new JLabel("姓名");
		nameField = new JTextField();
		sexLabel = new JLabel("性别");
		maleRadioButton = new JRadioButton("男");
		femaleRadioButton = new JRadioButton("女");	 
		sex = new ButtonGroup();
		idLabel = new JLabel("员工编号");	
		idField = new JTextField();
		organizationLabel = new JLabel("所在机构");
		organizationBox = new OrganizationComboBox();	
		positionLabel = new JLabel("职位");
		positionBox = new JComboBox<String>(positions);
		phoneLabel = new JLabel("电话");	
		phoneField = new JTextField();
		idCardLabel = new JLabel("身份证号");	
		idCardField = new JTextField();
		birthLabel = new JLabel("出生日期");
		yearBox = new JComboBox<Integer>(year);
		monthBox = new JComboBox<Integer>(month);
		dayBox = new JComboBox<Integer>(day);
		yearLabel = new JLabel("年");
		monthLabel = new JLabel("月");	
		dayLabel = new JLabel("日");	 
		payLabel = new JLabel("工资");
		basePayLabel = new JLabel();
		basePayField = new JTextField();	
		unitLabel = new JLabel();
		percentageLabel1 = new JLabel("提成率"); 
		percentageField = new JTextField();
		percentageLabel2 = new JLabel("%");
		cancleButton = new JButton("取消");
		sureButton = new JButton("确认");
		
		employeeDialog = new JDialog();
		employeeDialog.setBounds(300, 100, 380, 460);		 			 
		infoLabel.setBounds(90, 16, 170, 34);	 
		nameLabel.setBounds(4, 60, 100, 24);	 
		nameField.setBounds(100, 60, 60, 20);
		sexLabel.setBounds(0, 90, 100, 24);	 
		maleRadioButton.setBounds(100, 90, 60, 20);	 
		femaleRadioButton.setBounds(170, 90, 60, 20);	 
		sex.add(maleRadioButton);
		sex.add(femaleRadioButton);	 
		idLabel.setBounds(0, 120, 100, 24);
		idField.setBounds(100, 120, 180, 20);	 
		organizationLabel.setBounds(0, 150, 100, 24);	 
		organizationBox.setBounds(100, 150, 180, 20);	 
		positionLabel.setBounds(0, 180, 100, 24);	 
		positionBox.setBounds(100, 180, 180, 20);	 
		phoneLabel.setBounds(0, 210, 180, 20);
		phoneField.setBounds(100, 210, 180, 20);	 
		idCardLabel.setBounds(0, 245, 100, 20);	 
		idCardField.setBounds(100, 245, 180, 20);	 
		birthLabel.setBounds(0, 275, 100, 20);		 
		yearBox.setBounds(100, 275, 60, 20);	 
		monthBox.setBounds(180, 275, 60, 20); 
		dayBox.setBounds(260, 275, 60, 20);
		yearLabel.setBounds(160, 275, 20, 20);
		monthLabel.setBounds(240, 275, 20, 20);	 
		dayLabel.setBounds(320,275, 20, 20);	 
		payLabel.setBounds(0, 310, 100, 20);	 
		basePayLabel.setBounds(95, 310, 70, 24);	 
		basePayField.setBounds(175, 310, 60, 20);	 
		unitLabel.setBounds(235, 310, 70, 24);	 
		percentageLabel1.setBounds(95, 345, 70, 24);
		percentageField.setBounds(175, 345, 60, 20);
		percentageLabel2.setBounds(235, 345, 70, 24);		
		positionBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(positionBox.getSelectedItem().toString().equals("快递员")){
					basePayLabel.setText("基础工资");
					unitLabel.setText("/月");
					percentageField.setVisible(true);
					percentageLabel1.setVisible(true);
					percentageLabel2.setVisible(true);
					employeeDialog.add(percentageLabel1);
					employeeDialog.add(percentageLabel2);
					employeeDialog.add(percentageField);
					employeeDialog.repaint();
				}
				else if(positionBox.getSelectedItem().toString().equals("司机")){
					basePayLabel.setText("按此计费");
					unitLabel.setText("/次");
					percentageField.setVisible(false);
					percentageLabel1.setVisible(false);
					percentageLabel2.setVisible(false);
					employeeDialog.repaint();
				}
				else{
					basePayLabel.setText("月薪");
					unitLabel.setText("");
					percentageField.setVisible(false);
					percentageLabel1.setVisible(false);
					percentageLabel2.setVisible(false);
					employeeDialog.repaint();
				}
			}
		});
	
		
		 
		   
		cancleButton.setBounds(175, 380, 70, 30);
		sureButton.setBounds(265, 380, 70, 30);
	 
		employeeDialog.add(infoLabel);
		employeeDialog.add(nameField);
		employeeDialog.add(nameLabel);
		employeeDialog.add(sexLabel);
		employeeDialog.add(femaleRadioButton);
		employeeDialog.add(maleRadioButton);	
		employeeDialog.add(idField);
		employeeDialog.add(idLabel);
		employeeDialog.add(organizationLabel);
		employeeDialog.add(organizationBox);
		employeeDialog.add(positionLabel);
		employeeDialog.add(positionBox);
		employeeDialog.add(phoneField);
		employeeDialog.add(phoneLabel);
		employeeDialog.add(idCardLabel);
		employeeDialog.add(idCardField);
		employeeDialog.add(birthLabel);
		employeeDialog.add(yearBox);
		employeeDialog.add(yearLabel);
		employeeDialog.add(monthBox);
		employeeDialog.add(monthLabel);
		employeeDialog.add(dayBox);
		employeeDialog.add(dayLabel);
		employeeDialog.add(cancleButton);
		employeeDialog.add(sureButton);
		employeeDialog.add(payLabel);
		employeeDialog.add(basePayLabel);
		employeeDialog.add(basePayField);
		employeeDialog.add(unitLabel);
		
		
		employeeDialog.setLayout(null);
		employeeDialog.setVisible(true);
	}
	
	public void update(boolean isNew,int modelRow){

		  
		  String id = idField.getText();		
		  String name = nameField.getText();
		  String organization = organizationBox.getSelectedItem().toString();
		  String phone = phoneField.getText();	
		  String identityCardNum = new String(idCardField.getText());
			@SuppressWarnings("deprecation")
		 Date birth = new Date((int)yearBox.getSelectedItem(), 
					   (int)monthBox.getSelectedItem(),(int)dayBox.getSelectedItem());
			//String idCardNum = new String(idCardField.getText());
			Sex sex1 ;
			 if(maleRadioButton.isSelected())
				 sex1 = Sex.MALE;
			else 
				 sex1 = Sex.FAMALE;			 
			PayPO paypo = null ;						
			 Position p = null ;
			 switch (positionBox.getSelectedItem().toString()) {
			   	case "总经理":
			   		p = Position.MANAGER; 
			   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   
			   	case "营业厅业务员":
			   		p = Position.SELLINGBUSINESSMAN;
			   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "中转中心业务员":
			   		p = Position.TRANSFERCENTREBUSINESSMAN;
			   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "快递员":
			   		p = Position.COURIER; 
			   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
			   				0, 0, 0,Double.valueOf(percentageField.getText())/100 );
			   		break;
			   	
			   	case "中转中心仓库管理员":
			   		p = Position.STORAGEMANAGER;
			   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "高级财务人员":
			   		p = Position.SENIORFINANCIALSTAFF;
			   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "财务人员":
			   		p = Position.FINANCIALSTAFF;
			   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "管理员":
			   		p = Position.SYSTEMMANAGER;
			   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "司机":
			   		p = Position.DRIVER;
			   		paypo = new PayPO(0,Double.valueOf(basePayField.getText()), 0, 0, 0);
			   		break;			   			 
			   	
			}
			 EmployeeVO vo = new EmployeeVO(id, name, organization,
					 p, phone, birth, identityCardNum, sex1, paypo);
			 Power power = Power.valueOf(p.toString());
			 UserVO uservo = new UserVO(id, "000000", power);
			 UserblService userblService = new User();
			 if(isNew){
				 tableModel.create(vo);
				 userblService.creatUserPO(uservo);
				 }
			 else
				 tableModel.modify(modelRow, vo);
	}
	
	public void showCreateDialog(EmployeeTableModel em){
		init();		
		tableModel = em;
		cancleButton.addActionListener(new ActionListener(){
	
			  @Override
			  public void actionPerformed(ActionEvent e){
				  employeeDialog.dispose();
			  }
		});
			 
		
		sureButton.addActionListener(new ActionListener(){			
			  @Override
			  public void actionPerformed(ActionEvent e){
				  update(true,0);
				  employeeDialog.dispose();
			  }
		});
		
	}
	
	@SuppressWarnings("deprecation")
	public void showQueryDialog(EmployeeTableModel em, int modelRow, boolean isEdit){

		init();
		this.tableModel = em;
		EmployeeVO vo = tableModel.getEmployeeVO(modelRow);
		nameField.setText(vo.getName());
		idField.setText(""+vo.getId());
		idField.setEnabled(false);
		organizationBox.setSelectedItem(vo.getOrganization());
		if(vo.getSex().equals(Sex.MALE))
			maleRadioButton.setSelected(true);
		else 
			femaleRadioButton.setSelected(true);	
		
		switch (vo.getPosition()) {
		case MANAGER: 
			positionBox.setSelectedIndex(0); break;
		case SELLINGBUSINESSMAN: 
			positionBox.setSelectedIndex(1); break;
		case TRANSFERCENTREBUSINESSMAN: 
			positionBox.setSelectedIndex(2) ;break;
		case COURIER:
			positionBox.setSelectedIndex(3); break;
		case STORAGEMANAGER:
			positionBox.setSelectedIndex(4); break;
		case SENIORFINANCIALSTAFF:
			positionBox.setSelectedIndex(5); break;
		case FINANCIALSTAFF:
			positionBox.setSelectedIndex(6); break;
		case SYSTEMMANAGER:
			positionBox.setSelectedIndex(7); break;
		case DRIVER:
			positionBox.setSelectedIndex(8); break;		
		}
		
		 phoneField.setText(""+vo.getTelephone());
		 idCardField.setText(""+vo.getIdentityCardNum());
		 yearBox.setSelectedIndex(vo.getBirthday().getYear()-1996);
		 monthBox.setSelectedIndex(vo.getBirthday().getMonth()-1);
		 dayBox.setSelectedIndex(vo.getBirthday().getDay()-1);	
		  
			
			 
				if(positionBox.getSelectedItem().toString().equals("快递员")){
					basePayLabel.setText("基础工资");
					unitLabel.setText("/月");
					percentageField.setVisible(true);
					percentageLabel1.setVisible(true);
					percentageLabel2.setVisible(true);
					basePayField.setText(""+vo.getPay().getBasePay());
					percentageField.setText(""+vo.getPay().getRate()*100);
					employeeDialog.add(percentageLabel1);
					employeeDialog.add(percentageLabel2);
					employeeDialog.add(percentageField);
										
				}
				else if(positionBox.getSelectedItem().toString().equals("司机")){
					basePayLabel.setText("按次计费");
					unitLabel.setText("/次");
					basePayField.setText(""+vo.getPay().getPayByCount());
					percentageField.setVisible(false);
					percentageLabel1.setVisible(false);
					percentageLabel2.setVisible(false);
				}
				else{
					basePayLabel.setText("月薪");
					unitLabel.setText("");
					basePayField.setText(""+vo.getPay().getBasePay());
					percentageField.setVisible(false);
					percentageLabel1.setVisible(false);
					percentageLabel2.setVisible(false);

				}
			
	 
		
		if(!isEdit){
			nameField.setEnabled(false);
			maleRadioButton.setEnabled(false);
			femaleRadioButton.setEnabled(false);
			idCardField.setEnabled(false);
			organizationBox.setEnabled(false);
			positionBox.setEnabled(false);
			phoneField.setEnabled(false);
			idCardField.setEnabled(false);
			yearBox.setEnabled(false);
			monthBox.setEnabled(false);
			dayBox.setEnabled(false);
			basePayField.setEnabled(false);
			percentageField.setEnabled(false);
			cancleButton.setVisible(false);
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					employeeDialog.dispose();
				}
			});
		}
		else{
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					// TODO Auto-generated method stub
					update(false,modelRow);
					employeeDialog.dispose();
				}
			});
			
			cancleButton.addActionListener(new  ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					employeeDialog.dispose();
				}
			});
		}
	}
}