package presentation.businesshallui.driverui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import businesslogic.userbl.User;
import businesslogicservice.UserblService;
import presentation.util.DatePickPanel;
import presentation.util.OrganizationComboBox;
import systemenum.Position;
import systemenum.Power;
import systemenum.Sex;
import vo.EmployeeVO;
import vo.PayVO;
import vo.UserVO;

public class DriverDialog extends JDialog {
	/**
     * 
     */
    private static final long serialVersionUID = -5004812207169992358L;
    
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
	private JLabel phoneLabel;	 
	private JTextField phoneField;	 
	private JLabel idCardLabel;	 
	private JTextField idCardField;
	private JLabel birthLabel; 
	private JLabel payLabel;
	private JLabel basePayLabel;
	private JTextField basePayField;
	private JLabel unitLabel;
	
	private OrganizationComboBox organizationComboBox;
	private DatePickPanel datePickPanel;
	
	private JButton cancleButton;
	private JButton sureButton;
    private DriverTableModel tableModel;

	 
	public void init(){

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
		organizationComboBox = new OrganizationComboBox();
		phoneLabel = new JLabel("电话");	
		phoneField = new JTextField();
		idCardLabel = new JLabel("身份证号");	
		idCardField = new JTextField();
		birthLabel = new JLabel("出生日期");
		datePickPanel = new DatePickPanel();
		payLabel = new JLabel("工资");
		basePayLabel = new JLabel();
		basePayField = new JTextField();	
		unitLabel = new JLabel("元/次");
		
		cancleButton = new JButton("取消");
		sureButton = new JButton("确认");
		
		this.setBounds(0, 0, 380, 460);		 			 
		infoLabel.setBounds(90, 16, 170, 34);	 
		nameLabel.setBounds(4, 60, 100, 24);	 
		nameField.setBounds(100, 60, 60, 25);
		sexLabel.setBounds(0, 90, 100, 24);	 
		maleRadioButton.setBounds(100, 90, 40, 16);	 
		femaleRadioButton.setBounds(135, 90, 40, 16);	 
		sex.add(maleRadioButton);
		sex.add(femaleRadioButton);	 
		idLabel.setBounds(0, 120, 100, 24);
		idField.setBounds(100, 120, 180, 25);	 
		organizationLabel.setBounds(0, 150, 100, 24);	 
		organizationComboBox.setBounds(100, 150, 180, 25);	 

		phoneLabel.setBounds(0, 210, 180, 25);
		phoneField.setBounds(100, 210, 180, 25);	 
		idCardLabel.setBounds(0, 245, 100, 25);	 
		idCardField.setBounds(100, 245, 180, 25);	 
		birthLabel.setBounds(0, 275, 100, 25);		 
		datePickPanel.setBounds(100, 275, 180, 25);
		payLabel.setBounds(0, 310, 100, 25);	 
		basePayLabel.setBounds(95, 310, 70, 24);	 
		basePayField.setBounds(175, 310, 60, 25);	 
		unitLabel.setBounds(235, 310, 70, 24);	 
		   
		cancleButton.setBounds(175, 380, 70, 30);
		sureButton.setBounds(265, 380, 70, 30);
	 
		this.add(infoLabel);
		this.add(nameField);
		this.add(nameLabel);
		this.add(sexLabel);
		this.add(femaleRadioButton);
		this.add(maleRadioButton);	
		this.add(idField);
		this.add(idLabel);
		this.add(organizationLabel);
		this.add(organizationComboBox);
		this.add(phoneField);
		this.add(phoneLabel);
		this.add(idCardLabel);
		this.add(idCardField);
		this.add(birthLabel);
		this.add(datePickPanel);
		this.add(organizationComboBox);
		this.add(cancleButton);
		this.add(sureButton);
		this.add(payLabel);
		this.add(basePayLabel);
		this.add(basePayField);
		this.add(unitLabel);
		
		
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public void update(boolean isNew,int modelRow){

		  
		  String id = idCardField.getText();		
		  String name = nameField.getText();
		  String organization = organizationComboBox.getSelectedItem().toString();
		  String phone = phoneField.getText();	
		  String identityCardNum = new String(idCardField.getText());
		  Date birth = datePickPanel.getDate();
			
		  Sex sex1 ;
		  if(maleRadioButton.isSelected())
		      sex1 = Sex.MALE;
		  else 
		      sex1 = Sex.FAMALE;			 					
		  Position p = Position.DRIVER;
		  PayVO paypo = new PayVO(0,Double.valueOf(basePayField.getText()), 0, 0, 0);
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
				  DriverDialog.this.dispose();
			  }
		});
			 
		
		sureButton.addActionListener(new ActionListener(){			
			  @Override
			  public void actionPerformed(ActionEvent e){
				  update(true,0);
				  DriverDialog.this.dispose();
			  }
		});
		
	}
	
	public void showQueryDialog(DriverTableModel em, int modelRow, boolean isEditable){

		init();
		this.tableModel = em;
		EmployeeVO vo = tableModel.getEmployeeVO(modelRow);
		nameField.setText(vo.getName());
		idField.setText(""+vo.getId());
		idField.setEnabled(false);
		organizationComboBox.setSelectedItem(vo.getOrganization());
		if(vo.getSex().equals(Sex.MALE))
			maleRadioButton.setSelected(true);
		else 
			femaleRadioButton.setSelected(true);	

        phoneField.setText(""+vo.getTelephone());
        idCardField.setText(""+vo.getIdentityCardNum());
        datePickPanel.setDate(vo.getBirthday());

		basePayLabel.setText("按次计费");
		unitLabel.setText("/次");
		basePayField.setText(""+vo.getPay().getPayByCount());
		
		if(!isEditable){
			nameField.setEnabled(false);
			maleRadioButton.setEnabled(false);
			femaleRadioButton.setEnabled(false);
			idCardField.setEnabled(false);
			organizationComboBox.setEnabled(false);
			phoneField.setEnabled(false);
			idCardField.setEnabled(false);
			datePickPanel.setEnabled(false);
			basePayField.setEnabled(false);

			cancleButton.setVisible(false);
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					DriverDialog.this.dispose();
				}
			});
		}
		else{
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					// TODO Auto-generated method stub
					update(false,modelRow);
					DriverDialog.this.dispose();
				}
			});
		}
	}
}