package presentation.businesshallui.driverui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import businesslogic.organizationbl.Organization;
import businesslogic.userbl.User;
import businesslogicservice.OrganizationblService;
import businesslogicservice.UserblService;
import po.PayPO;
import systemenum.Position;
import systemenum.Power;
import systemenum.Sex;
import vo.EmployeeVO;
import vo.UserVO;

public class DriverDialog {
	private JDialog employeeDialog ;
	private String[] organizationStr; 
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
	private JComboBox<String> organizationBox;	 
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

	private JButton cancleButton;
	private JButton sureButton;
    private DriverTableModel tableModel;

	 
	public void init(){
		OrganizationblService organizationblService = new Organization();
		
	    List<String> nameLise = organizationblService.getAllOrganizationName();
	    organizationStr =    nameLise.toArray(new String[nameLise.size()]);
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
		organizationBox = new JComboBox<String>(organizationStr);	
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
		unitLabel = new JLabel("元/次");
		
		cancleButton = new JButton("取消");
		sureButton = new JButton("确认");
		
		employeeDialog = new JDialog();
		employeeDialog.setBounds(0, 0, 380, 460);		 			 
		infoLabel.setBounds(90, 16, 170, 34);	 
		nameLabel.setBounds(4, 60, 100, 24);	 
		nameField.setBounds(100, 60, 60, 20);
		sexLabel.setBounds(0, 90, 100, 24);	 
		maleRadioButton.setBounds(100, 90, 40, 16);	 
		femaleRadioButton.setBounds(135, 90, 40, 16);	 
		sex.add(maleRadioButton);
		sex.add(femaleRadioButton);	 
		idLabel.setBounds(0, 120, 100, 24);
		idField.setBounds(100, 120, 180, 20);	 
		organizationLabel.setBounds(0, 150, 100, 24);	 
		organizationBox.setBounds(100, 150, 180, 20);	 

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

		  
		  String id = idCardField.getText();		
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
			 Position p = Position.DRIVER;
			 PayPO paypo = new PayPO(0,Double.valueOf(basePayField.getText()), 0, 0, 0);
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
	
	public void showCreateDialog(DriverTableModel em){
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
	public void showQueryDialog(DriverTableModel em, int modelRow, boolean isEdit){

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

        phoneField.setText(""+vo.getTelephone());
        idCardField.setText(""+vo.getIdentityCardNum());
        yearBox.setSelectedIndex(vo.getBirthday().getYear()-1996);
        monthBox.setSelectedIndex(vo.getBirthday().getMonth()-1);
        dayBox.setSelectedIndex(vo.getBirthday().getDay()-1);	

		basePayLabel.setText("按次计费");
		unitLabel.setText("/次");
		basePayField.setText(""+vo.getPay().getPayByCount());
		
		if(!isEdit){
			nameField.setEnabled(false);
			maleRadioButton.setEnabled(false);
			femaleRadioButton.setEnabled(false);
			idCardField.setEnabled(false);
			organizationBox.setEnabled(false);
			phoneField.setEnabled(false);
			idCardField.setEnabled(false);
			yearBox.setEnabled(false);
			monthBox.setEnabled(false);
			dayBox.setEnabled(false);
			basePayField.setEnabled(false);

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
		}
	}
}