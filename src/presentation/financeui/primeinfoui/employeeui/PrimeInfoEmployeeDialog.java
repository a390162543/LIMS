package presentation.financeui.primeinfoui.employeeui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import businesslogic.employeebl.Employee;
import businesslogic.organizationbl.Organization;
import businesslogicservice.EmployeeblService;
import businesslogicservice.IdblService;
import businesslogicservice.OrganizationblService;
import presentation.util.DatePickPanel;
import presentation.util.OrganizationComboBox;
import systemenum.Position;
import systemenum.Sex;
import vo.EmployeeVO;
import vo.PayVO;


public class PrimeInfoEmployeeDialog extends JDialog{

 	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 3879597517984936427L;
 

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
    private PrimeInfoEmployeeTableModel tableModel;
    private OrganizationblService organizationblService;
    private EmployeeblService employeeblService;
    
    public PrimeInfoEmployeeDialog(PrimeInfoEmployeeTableModel em){		
		tableModel = em;
		organizationblService = new Organization();
		employeeblService = new Employee();
		
		init();		
		
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
				  PrimeInfoEmployeeDialog.this.dispose();
			  }
		});
			 
		
		sureButton.addActionListener(new ActionListener(){			
			  @Override
			  public void actionPerformed(ActionEvent e){
				  update(true, 0);
				  PrimeInfoEmployeeDialog.this.dispose();
			  }
		});		
	}
	 
	public PrimeInfoEmployeeDialog(PrimeInfoEmployeeTableModel em, int modelRow, boolean isEdit){
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
		   			 
		if(positionBox.getSelectedItem().toString().equals("���Ա")){
			basePayLabel.setText("��������");
			unitLabel.setText("/��");
			percentageField.setVisible(true);
			percentageLabel1.setVisible(true);
			percentageLabel2.setVisible(true);
			basePayField.setText(""+vo.getPay().getBasePay());
			percentageField.setText(""+vo.getPay().getRate()*100);
			this.add(percentageLabel1);
			this.add(percentageLabel2);
			this.add(percentageField);
										
		}
		else if(positionBox.getSelectedItem().toString().equals("˾��")){
			basePayLabel.setText("���μƷ�");
			unitLabel.setText("/��");
			basePayField.setText(""+vo.getPay().getPayByCount());
			percentageField.setVisible(false);
			percentageLabel1.setVisible(false);
			percentageLabel2.setVisible(false);
		}
		else{
			basePayLabel.setText("��н");
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
			basePayField.setEnabled(false);
			percentageField.setEnabled(false);
			cancleButton.setVisible(false);
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 PrimeInfoEmployeeDialog.this.dispose();
				}
			});
		}
		else{
			sureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					// TODO Auto-generated method stub
					update(false,modelRow);
					PrimeInfoEmployeeDialog.this.dispose();					 						
				}
			});
			
			cancleButton.addActionListener(new  ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 PrimeInfoEmployeeDialog.this.dispose();
				}
			});
		}
	}
	
	public void setId(){
		String organizationId =  tableModel.getOrganizationId((String)organizationBox.getSelectedItem());
		IdblService idblService = employeeblService.getIdblService();
		idField.setText(idblService.createNewId(organizationId));		 
	}
	
    public void init(){    	 
		positions = new String[]{"�ܾ���","Ӫҵ��ҵ��Ա","��ת����ҵ��Ա","���Ա",
				 "��ת���Ĳֿ����Ա","�߼�������Ա","������Ա","����Ա","˾��"};
		idField.setEnabled(false);	 
		nameLabel = new JLabel("����");
		nameField = new JTextField();
		sexLabel = new JLabel("�Ա�");
		maleRadioButton = new JRadioButton("��");
		femaleRadioButton = new JRadioButton("Ů");	 
		sex = new ButtonGroup();
		idLabel = new JLabel("Ա�����");	
		idField = new JTextField();
		organizationLabel = new JLabel("���ڻ���");
		organizationBox = new OrganizationComboBox();
		datePickPanel = new DatePickPanel();
		positionLabel = new JLabel("ְλ");
		positionBox = new JComboBox<String>(positions);
		phoneLabel = new JLabel("�绰");	
		phoneField = new JTextField();
		idCardLabel = new JLabel("����֤��");	
		idCardField = new JTextField();
		birthLabel = new JLabel("��������");	  
		payLabel = new JLabel("����");
		basePayLabel = new JLabel();
		basePayField = new JTextField();	
		unitLabel = new JLabel();
		percentageLabel1 = new JLabel("�����"); 
		percentageField = new JTextField();
		percentageLabel2 = new JLabel("%");
		cancleButton = new JButton("ȡ��");
		sureButton = new JButton("ȷ��");
		
		List<String> organizationName = tableModel.getOrganizationName();
		if(!organizationName.isEmpty()){
			for(String s : organizationName)
				organizationBox.addItem(s);
		}
		
		
		 
		this.setBounds(300, 100, 380, 460);		 			 
		nameLabel.setBounds(4, 60, 100, 24);	 
		nameField.setBounds(100, 60, 60, 20);
		sexLabel.setBounds(0, 90, 100, 24);	 
		maleRadioButton.setBounds(100, 90, 60, 20);	 
		femaleRadioButton.setBounds(170, 90, 60, 20);	 
		sex.add(maleRadioButton);
		sex.add(femaleRadioButton);	 
		idLabel.setBounds(0, 120, 100, 24);
		idField.setBounds(100, 120, 180, 20);	
		datePickPanel.setBounds(95, 275, 200, 25);
		organizationLabel.setBounds(0, 150, 100, 24);	 
		organizationBox.setBounds(100, 150, 180, 20);	 
		positionLabel.setBounds(0, 180, 100, 24);	 
		positionBox.setBounds(100, 180, 180, 20);	 
		phoneLabel.setBounds(0, 210, 180, 20);
		phoneField.setBounds(100, 210, 180, 20);	 
		idCardLabel.setBounds(0, 245, 100, 20);	 
		idCardField.setBounds(100, 245, 180, 20);	 
		birthLabel.setBounds(0, 275, 100, 20);		 
		  
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
				if(positionBox.getSelectedItem().toString().equals("���Ա")){
					basePayLabel.setText("��������");
					unitLabel.setText("/��");
					percentageField.setVisible(true);
					percentageLabel1.setVisible(true);
					percentageLabel2.setVisible(true);
					PrimeInfoEmployeeDialog.this.add(percentageLabel1);
					PrimeInfoEmployeeDialog.this.add(percentageLabel2);
					PrimeInfoEmployeeDialog.this.add(percentageField);
					PrimeInfoEmployeeDialog.this.repaint();
				}
				else if(positionBox.getSelectedItem().toString().equals("˾��")){
					basePayLabel.setText("���˼Ʒ�");
					unitLabel.setText("/��");
					percentageField.setVisible(false);
					percentageLabel1.setVisible(false);
					percentageLabel2.setVisible(false);
				}
				else{
					basePayLabel.setText("��н");
					unitLabel.setText("");
					percentageField.setVisible(false);
					percentageLabel1.setVisible(false);
					percentageLabel2.setVisible(false);
					PrimeInfoEmployeeDialog.this.repaint();
				}
			}
		});
	
		
		 
		   
		cancleButton.setBounds(175, 380, 70, 30);
		sureButton.setBounds(265, 380, 70, 30);
		this.add(nameField);
		this.add(nameLabel);
		this.add(sexLabel);
		this.add(femaleRadioButton);
		this.add(maleRadioButton);	
		this.add(idField);
		this.add(idLabel);
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
		this.add(cancleButton);
		this.add(sureButton);
		this.add(payLabel);
		this.add(basePayLabel);
		this.add(basePayField);
		this.add(unitLabel);
		
	
		this.setLayout(null);
		this.setVisible(true);
		 
	}
	
	public void update(boolean isNew,int modelRow ){

		  
		  String id = idField.getText();		
		  String name = nameField.getText();
		  String organization = organizationBox.getSelectedItem().toString();
		  String phone = phoneField.getText();	
		  String identityCardNum = new String(idCardField.getText());
		 
		  Date birth = datePickPanel.getDate();
			//String idCardNum = new String(idCardField.getText());
			Sex sex1 ;
			 if(maleRadioButton.isSelected())
				 sex1 = Sex.MALE;
			else 
				 sex1 = Sex.FAMALE;			 
			PayVO payvo = null ;						
			 Position p = null ;
			 switch (positionBox.getSelectedItem().toString()) {
			   	case "�ܾ���":
			   		p = Position.MANAGER; 
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   
			   	case "Ӫҵ��ҵ��Ա":
			   		p = Position.SELLINGBUSINESSMAN;
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "��ת����ҵ��Ա":
			   		p = Position.TRANSFERCENTREBUSINESSMAN;
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "���Ա":
			   		p = Position.COURIER; 
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0, 0, 0,Double.valueOf(percentageField.getText())/100 );
			   		break;
			   	
			   	case "��ת���Ĳֿ����Ա":
			   		p = Position.STORAGEMANAGER;
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "�߼�������Ա":
			   		p = Position.SENIORFINANCIALSTAFF;
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "������Ա":
			   		p = Position.FINANCIALSTAFF;
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "����Ա":
			   		p = Position.SYSTEMMANAGER;
			   		payvo = new PayVO(Double.valueOf(basePayField.getText()),
			   				0.0, 0, 0, 0);
			   		break;
			   	
			   	case "˾��":
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