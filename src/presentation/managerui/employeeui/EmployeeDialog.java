package presentation.managerui.employeeui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.Name;
import businesslogic.checkbl.employeeinfo.EmployeeIdCard;
import businesslogic.checkbl.employeeinfo.Rate;
import businesslogic.checkbl.priceinfo.Price;
import businesslogic.checkbl.PhoneNumber;
import businesslogicservice.EmployeeblService;
import businesslogicservice.IdblService;
 
import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DatePickPanel;
import presentation.util.DialogLayoutManager;
import presentation.util.OrganizationComboBox;
import systemenum.Position;
import systemenum.Sex;
import vo.EmployeeVO;
import vo.PayVO;

/**
 * 创建、修改和查询员工界面
 * @author 刘航伸
 * @see @see presentation.employeeui.EmployeeTableModel
 * @version 1.2
 */
public class EmployeeDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4592042591265103245L;
		 
	private String positions[]; 
 
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
	private DatePickPanel datePickPanel;
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
    private EmployeeblService employeeblService;
    private Checker phoneNumberChecker;
    private Checker idcardChecker;
    private Checker nameChecker;
    private Checker payChecker;
    private Checker rateChecker;
    
    //创建员工的Dialog   
    public EmployeeDialog(EmployeeTableModel em){
		init();		
		
		tableModel = em;
			
		setId();
		organizationBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				setId();
			}
		});
				
		
		
		cancleButton.addActionListener(new ActionListener(){	
			  @Override
			  public void actionPerformed(ActionEvent e){
				  EmployeeDialog.this.dispose();
			  }
		});
			
		sureButton.addActionListener(new ActionListener(){			
			  @Override
			  public void actionPerformed(ActionEvent e){
				  
				  boolean isCorrect = idcardChecker.check() & phoneNumberChecker.check() & 
						  				nameChecker.check() & payChecker.check() ;
				  if(isCorrect){
					  update(true,0);
					  EmployeeDialog.this.dispose();
				  }
				  else{
					  return;
				  }
			  }
		});		
		
		//界面置顶
		this.setModalityType(ModalityType.APPLICATION_MODAL);	
		
	}
	
    //修改、查看员工信息的Dialog
	public EmployeeDialog(EmployeeTableModel em, int modelRow, boolean isEdit){


		init();
		tableModel = em;
		EmployeeVO vo = tableModel.getEmployeeVO(modelRow);
		
		// 显示相应员工信息
		nameField.setText(vo.getName());
		idField.setText(""+vo.getId());
		idField.setEnabled(false);
		organizationBox.setSelectedItem(vo.getOrganization());
		datePickPanel.setDate(vo.getBirthday());
		if(vo.getSex().equals(Sex.MALE))
			maleRadioButton.setSelected(true);
		else 
			femaleRadioButton.setSelected(true);	
		
		 positionBox.setSelectedIndex(vo.getPosition().ordinal());		
		 phoneField.setText(""+vo.getTelephone());
		 idCardField.setText(""+vo.getIdentityCardNum());
		 		 		 
		if(positionBox.getSelectedItem().toString().equals("快递员")){
			basePayLabel.setText("基础工资");
			unitLabel.setText("/月");
			percentageField.setVisible(true);
			percentageLabel1.setVisible(true);
			percentageLabel2.setVisible(true);
			basePayField.setText(""+vo.getPay().getBasePay());
			percentageField.setText(""+vo.getPay().getRate()*100);
			 							
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
			
	 
		//查询时将界面设定成不可修改
		if(!isEdit){
			nameField.setEnabled(false);
			maleRadioButton.setEnabled(false);
			femaleRadioButton.setEnabled(false);
			idCardField.setEnabled(false);
			organizationBox.setEnabled(false);
			positionBox.setEnabled(false);
			phoneField.setEnabled(false);
			idCardField.setEnabled(false);
			datePickPanel.setEnabled(false);
			basePayField.setEnabled(false);
			percentageField.setEnabled(false);
			cancleButton.setVisible(false);
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					EmployeeDialog.this.dispose();
				}
			});
		}
		else{
			cancleButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					EmployeeDialog.this.dispose();
				}
			}); 
			
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					  boolean isCorrect = idcardChecker.check() & phoneNumberChecker.check() & 
				  				nameChecker.check() & payChecker.check() ;
					  if(isCorrect){
						  if(idField.getText().equals(vo.getId())){
							  update(false,modelRow);
							  EmployeeDialog.this.dispose();
						  }
						  else{
							  tableModel.delete(modelRow);
							  update(true,0);
							  EmployeeDialog.this.dispose();
						  }
						  
					  }
					  else{
						  return;
					  }
				}
			});
			organizationBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					setId();
				}
			});
		}
		
		//界面置顶
		this.setModalityType(ModalityType.APPLICATION_MODAL);	
	}
	
	/**
	 * 生成id的方法
	 */
	public void setId(){
		String organizationId = employeeblService.getOrganizationId
				(organizationBox.getSelectedOrganization());
		IdblService idblService = employeeblService.getIdblService();
		idField.setText(idblService.createNewId(organizationId));		 
	}
		
    /**
     * 将界面组件添加到界面中
     */
	public void init(){
	 
		employeeblService =  BusinessLogicService.getEmployeeblService();				
		positions = new String[]{"总经理","营业厅业务员","中转中心业务员","快递员",
				 "中转中心仓库管理员","高级财务人员","财务人员","管理员","司机"};
	  
	 
		nameLabel = new JLabel("姓名");
		nameField = new JTextField();
		sexLabel = new JLabel("性别");
		maleRadioButton = new JRadioButton("男");
		femaleRadioButton = new JRadioButton("女");	 
		sex = new ButtonGroup();
		idLabel = new JLabel("员工编号");	
		idField = new JTextField();
		organizationLabel = new JLabel("所在机构");
		organizationBox = new OrganizationComboBox(true);	
		positionLabel = new JLabel("职位");
		positionBox = new JComboBox<String>(positions);
		phoneLabel = new JLabel("电话");	
		phoneField = new JTextField();
		idCardLabel = new JLabel("身份证号");	
		idCardField = new JTextField();
		birthLabel = new JLabel("出生日期");
		datePickPanel = new DatePickPanel();
		payLabel = new JLabel("工资");
		basePayLabel = new JLabel();
		basePayField = new JTextField();	
		unitLabel = new JLabel();
		percentageLabel1 = new JLabel("提成率"); 
		percentageLabel1.setVisible(false);
		percentageField = new JTextField();
		percentageField.setVisible(false);
		percentageLabel2 = new JLabel("%");
		percentageLabel2.setVisible(false);
		cancleButton = new JButton("取消");
		sureButton = new JButton("确认");
		
		 
		this.setBounds(300, 100, 380, 460);		 			 
	 
		nameLabel.setBounds(4, 90, 100, 24);	 
		nameField.setBounds(100, 90, 60, 20);
		sexLabel.setBounds(0, 120, 100, 24);	 
		maleRadioButton.setBounds(100, 120, 60, 20);	 
		femaleRadioButton.setBounds(170, 120, 60, 20);	
		
		//默认性别为男
		maleRadioButton.setSelected(true);
		
		sex.add(maleRadioButton);
		sex.add(femaleRadioButton);	 
		idLabel.setBounds(0, 60, 100, 24);
		idField.setBounds(100, 60, 180, 20);
		idField.setEnabled(false);
		organizationLabel.setBounds(0, 150, 100, 24);	 
		organizationBox.setBounds(100, 150, 180, 20);	 
		positionLabel.setBounds(0, 180, 100, 24);	 
		positionBox.setBounds(100, 180, 180, 20);	 
		phoneLabel.setBounds(0, 210, 180, 20);
		phoneField.setBounds(100, 210, 180, 20);	 
		idCardLabel.setBounds(0, 245, 100, 20);	 
		idCardField.setBounds(100, 245, 180, 20);	 
		birthLabel.setBounds(0, 275, 100, 20);		 
		datePickPanel.setBounds(95, 275, 200, 25);
		payLabel.setBounds(0, 310, 100, 20);	 
		basePayLabel.setBounds(95, 310, 70, 24);	 
		basePayField.setBounds(175, 310, 60, 20);	 
		unitLabel.setBounds(235, 310, 70, 24);	 
		percentageLabel1.setBounds(95, 345, 70, 24);
		percentageField.setBounds(175, 345, 60, 20);
		percentageLabel2.setBounds(235, 345, 70, 24);
		
	//
		
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
					EmployeeDialog.this.repaint();
				}
				else if(positionBox.getSelectedItem().toString().equals("司机")){
					basePayLabel.setText("按次计费");
					unitLabel.setText("/次");
					percentageField.setVisible(false);
					percentageLabel1.setVisible(false);
					percentageLabel2.setVisible(false);
					EmployeeDialog.this.repaint();
				}
				else{
					basePayLabel.setText("月薪");
					unitLabel.setText("");
					percentageField.setVisible(false);
					percentageLabel1.setVisible(false);
					percentageLabel2.setVisible(false);
					EmployeeDialog.this.repaint();
				}
			}
		});
	
		
		 
		   
		cancleButton.setBounds(175, 380, 70, 30);
		sureButton.setBounds(265, 380, 70, 30);
 
		
		this.add(idLabel);
		this.add(idField);		
		this.add(nameField);
		this.add(nameLabel);
		
		this.add(sexLabel);
		this.add(maleRadioButton);
		this.add(femaleRadioButton);
		DialogLayoutManager.fix(maleRadioButton, femaleRadioButton);	
		
		this.add(organizationLabel);
		this.add(organizationBox);
		this.add(positionLabel);
		this.add(positionBox);
		this.add(phoneField);
		this.add(phoneLabel);
		this.add(idCardLabel);
		this.add(idCardField);
		this.add(birthLabel);
		this.add(datePickPanel);
		
		
		this.add(payLabel);	
		this.add(basePayLabel);
		this.add(basePayField);
		this.add(unitLabel);
		DialogLayoutManager.fix(basePayLabel, basePayField, unitLabel);
		
		JLabel label = new JLabel();
		label.setBounds(0, 345, 0, 0);
		this.add(label);
		this.add(percentageLabel1);
		this.add(percentageLabel2);
		this.add(percentageField);
		DialogLayoutManager.fix(percentageLabel1, percentageLabel2, percentageField);
		
		this.add(sureButton);
		this.add(cancleButton);
		
		
		this.setLayout(new DialogLayoutManager());
	 
		this.setVisible(true);
		
		
		
		
		//添加检查项
		phoneNumberChecker = new Checker(phoneField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(phoneField.getText() == null){
					return null;
				}
				return new PhoneNumber(phoneField.getText());
			}
		});
		phoneField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				phoneNumberChecker.check();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		idcardChecker = new Checker(idCardField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(idCardField.getText() == null){
					return null;
				}
				return new EmployeeIdCard(idCardField.getText());
			}
		});
		
		
		idCardField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				idcardChecker.check();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		nameChecker = new Checker(nameField,new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(nameField.getText() == null){
					return null;
				}
				return new Name(nameField.getText());
			}
		});
		nameField.addKeyListener( new KeyListener() {
			
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
		
		payChecker = new Checker(basePayField,new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(basePayField.getText() == null){
					return null;
				}
				return new Price(basePayField.getText());
			}
		});
		
		basePayField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				payChecker.check();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		rateChecker = new Checker(percentageField,new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(percentageField.getText() == null){
					return null;
				}
				else{
					return new Rate(percentageField.getText());
				}
			}
		});
		percentageField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				rateChecker.check();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	//将界面数据更新到数据区
	public void update(boolean isNew,int modelRow){	
		//获取界面信息
		  String id = idField.getText();		
		  String name = nameField.getText();
		  String organization = organizationBox.getSelectedItem().toString();
		  String phone = phoneField.getText();	
		  String identityCardNum = new String(idCardField.getText());			 
		  Date birth =  datePickPanel.getDate();		
		  Sex sex1 ;
		  if(maleRadioButton.isSelected())
			 sex1 = Sex.MALE;
		  else 
			 sex1 = Sex.FAMALE;			 
		  PayVO payvo = null ;						
		  Position p = null ;
		  switch (positionBox.getSelectedItem().toString()) {
			  	case "总经理":
			   		p = Position.MANAGER; 
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   
			   	case "营业厅业务员":
			   		p = Position.SELLINGBUSINESSMAN;
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "中转中心业务员":
			   		p = Position.TRANSFERCENTREBUSINESSMAN;
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "快递员":
			   		p = Position.COURIER; 
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0, 0, 0,Double.valueOf(percentageField.getText())/100 );
			   		break;
			   	
			   	case "中转中心仓库管理员":
			   		p = Position.STORAGEMANAGER;
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "高级财务人员":
			   		p = Position.SENIORFINANCIALSTAFF;
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "财务人员":
			   		p = Position.FINANCIALSTAFF;
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "管理员":
			   		p = Position.SYSTEMMANAGER;
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "司机":
			   		p = Position.DRIVER;
			   		payvo = new PayVO(0,Double.valueOf(basePayField.getText()), 0, 0, 0);
			   		break;			   			 
			   	
			}
			 EmployeeVO vo = new EmployeeVO(id, name, organization,
					 p, phone, birth, identityCardNum, sex1, payvo);
			 
			 if(isNew)
				 tableModel.create(vo);							 
			 else
				 tableModel.modify(modelRow, vo);
	}
}