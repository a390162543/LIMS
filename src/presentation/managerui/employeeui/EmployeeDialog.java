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
import businesslogic.checkbl.employeeinfo.EmployeeIdCard;
import businesslogic.checkbl.employeeinfo.EmployeePhoneNumber;
import businesslogicservice.EmployeeblService;
import businesslogicservice.IdblService;
import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DatePickPanel;
import presentation.util.OrganizationComboBox;
import systemenum.Position;
import systemenum.Sex;
import vo.EmployeeVO;
import vo.PayVO;

/**
 * �������޸ĺͲ�ѯԱ������
 * @author ������
 * @see @see presentation.employeeui.EmployeeTableModel
 * @version 1.2
 */
public class EmployeeDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4592042591265103245L;
		 
	private String positions[]; 
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
 
    
    //����Ա����Dialog   
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
				  boolean isCorrect = idcardChecker.check() && phoneNumberChecker.check();
				  if(isCorrect){
					  update(true,0);
					  EmployeeDialog.this.dispose();
				  }
				  else{
					  return;
				  }
			  }
		});		
		
		
		
		
	}
	
    //�޸ġ��鿴Ա����Ϣ��Dialog
	public EmployeeDialog(EmployeeTableModel em, int modelRow, boolean isEdit){


		init();
		tableModel = em;
		EmployeeVO vo = tableModel.getEmployeeVO(modelRow);
		
		// ��ʾ��ӦԱ����Ϣ
		nameField.setText(vo.getName());
		idField.setText(""+vo.getId());
		idField.setEnabled(false);
		organizationBox.setSelectedItem(vo.getOrganization());
		datePickPanel.setDate(vo.getBirthday());
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
			
	 
		//��ѯʱ�������趨�ɲ����޸�
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
					 boolean isCorrect = idcardChecker.check() && phoneNumberChecker.check();
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
	}
	
	/**
	 * ����id�ķ���
	 */
	public void setId(){
		String organizationId = employeeblService.getOrganizationId
				(organizationBox.getSelectedOrganization());
		IdblService idblService = employeeblService.getIdblService();
		idField.setText(idblService.createNewId(organizationId));		 
	}
		
    /**
     * �����������ӵ�������
     */
	public void init(){
	 
		employeeblService =  BusinessLogicService.getEmployeeblService();				
		positions = new String[]{"�ܾ���","Ӫҵ��ҵ��Ա","��ת����ҵ��Ա","���Ա",
				 "��ת���Ĳֿ����Ա","�߼�������Ա","������Ա","����Ա","˾��"};
	  
		infoLabel = new JLabel("Ա����Ϣ");
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
		positionLabel = new JLabel("ְλ");
		positionBox = new JComboBox<String>(positions);
		phoneLabel = new JLabel("�绰");	
		phoneField = new JTextField();
		idCardLabel = new JLabel("���֤��");	
		idCardField = new JTextField();
		birthLabel = new JLabel("��������");
		datePickPanel = new DatePickPanel();
		payLabel = new JLabel("����");
		basePayLabel = new JLabel();
		basePayField = new JTextField();	
		unitLabel = new JLabel();
		percentageLabel1 = new JLabel("�����"); 
		percentageField = new JTextField();
		percentageLabel2 = new JLabel("%");
		cancleButton = new JButton("ȡ��");
		sureButton = new JButton("ȷ��");
		
		 
		this.setBounds(300, 100, 380, 460);		 			 
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
				if(positionBox.getSelectedItem().toString().equals("���Ա")){
					basePayLabel.setText("��������");
					unitLabel.setText("/��");
					percentageField.setVisible(true);
					percentageLabel1.setVisible(true);
					percentageLabel2.setVisible(true);
					EmployeeDialog.this.add(percentageLabel1);
					EmployeeDialog.this.add(percentageLabel2);
					EmployeeDialog.this.add(percentageField);
					EmployeeDialog.this.repaint();
				}
				else if(positionBox.getSelectedItem().toString().equals("˾��")){
					basePayLabel.setText("���˼Ʒ�");
					unitLabel.setText("/��");
					percentageField.setVisible(false);
					percentageLabel1.setVisible(false);
					percentageLabel2.setVisible(false);
					EmployeeDialog.this.repaint();
				}
				else{
					basePayLabel.setText("��н");
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
	 
		this.add(infoLabel);
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
	
		
		
		
		//��Ӽ����
		phoneNumberChecker = new Checker(phoneField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(phoneField.getText() == null){
					return null;
				}
				return new EmployeePhoneNumber(phoneField.getText());
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
	}
	
	//���������ݸ��µ�������
	public void update(boolean isNew,int modelRow){	
		//��ȡ������Ϣ
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