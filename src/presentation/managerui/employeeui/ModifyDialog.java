package presentation.managerui.employeeui;

 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.beancontext.BeanContext;
import java.sql.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import businesslogic.employeebl.Employee;
import businesslogicservice.EmployeeblService;
import po.PayPO;
import systemenum.Position;
import systemenum.Sex;
import vo.EmployeeVO;

public class ModifyDialog {
	JDialog createDialog ;
	
	public static void main(String[] args) {
		ModifyDialog m = new ModifyDialog();
		//m.show(); 
	}
	@SuppressWarnings("deprecation")
	public void show(EmployeeVO vo){
		 
		EmployeeblService employeeblService = new Employee();
		createDialog = new JDialog();
		createDialog.setBounds(0, 0, 380, 430);
		String positions[] = {"�ܾ���","Ӫҵ��ҵ��Ա","��ת����ҵ��Ա","���Ա",
				 "��ת���Ĳֿ����Ա","�߼�������Ա","������Ա","����Ա","˾��"};
		String organizationStr[] = {"�ܲ�","�Ͼ�����ת����","�Ͼ�����ϼ��Ӫҵ��"};
		Integer year[] = {1996,1997};
		Integer month[] = {1,2};
		Integer day[] = {1,2};

		
		JLabel infoLabel = new JLabel("Ա����Ϣ");
		infoLabel.setBounds(90, 16, 170, 34);
		JLabel nameLabel = new JLabel("����");
		nameLabel.setBounds(4, 60, 100, 24);
		JTextField nameField = new JTextField();
		nameField.setBounds(100, 60, 60, 20);
		JLabel sexLabel = new JLabel("�Ա�");
		sexLabel.setBounds(0, 90, 100, 24);
		JRadioButton maleRadioButton = new JRadioButton("��");
		maleRadioButton.setBounds(100, 90, 40, 16);
		JRadioButton femaleRadioButton = new JRadioButton("Ů");
		femaleRadioButton.setBounds(135, 90, 40, 16);
		ButtonGroup sex = new ButtonGroup();
		sex.add(maleRadioButton);
		sex.add(femaleRadioButton);
		JLabel idLabel = new JLabel("Ա�����");
		idLabel.setBounds(0, 120, 100, 24);
		JTextField idField = new JTextField();
		idField.setBounds(100, 120, 180, 20);
		JLabel organizationLabel = new JLabel("���ڻ���");
		organizationLabel.setBounds(0, 150, 100, 24);
		JComboBox<String> organizationBox = new JComboBox<String>(organizationStr);
		organizationBox.setBounds(100, 150, 180, 20);
		JLabel positionLabel = new JLabel("ְλ");
		positionLabel.setBounds(0, 180, 100, 24);
		JComboBox<String> positionBox = new JComboBox<String>(positions);
		positionBox.setBounds(100, 180, 86, 20);
		JLabel phoneLabel = new JLabel("�绰");
		phoneLabel.setBounds(0, 210, 180, 20);
		JTextField phoneField = new JTextField();
		phoneField.setBounds(100, 210, 180, 20);
		JLabel idCardLabel = new JLabel("���֤��");
		idCardLabel.setBounds(0, 245, 100, 20);
		JTextField idCardField = new JTextField();
		idCardField.setBounds(100, 245, 180, 20);
		JLabel birthLabel = new JLabel("��������");
		birthLabel.setBounds(0, 275, 100, 20);
		JComboBox<Integer> yearBox = new JComboBox<Integer>(year);
		yearBox.setBounds(100, 275, 60, 20);
		JComboBox<Integer> monthBox = new JComboBox<Integer>(month);
		monthBox.setBounds(180, 275, 60, 20);
		JComboBox<Integer> dayBox = new JComboBox<Integer>(day);
		dayBox.setBounds(260, 275, 60, 20);
		JLabel yearLabel = new JLabel("��");
		yearLabel.setBounds(160, 275, 20, 20);
		JLabel monthLabel = new JLabel("��");
		monthLabel.setBounds(240, 275, 20, 20);
		JLabel dayLabel = new JLabel("��");
		dayLabel.setBounds(320,275, 20, 20);
		JLabel payLabel = new JLabel("����");
		payLabel.setBounds(0, 310, 100, 20);
		JLabel basePayLabel = new JLabel();
		basePayLabel.setBounds(95, 310, 70, 24);
		JTextField basePayField = new JTextField();
		basePayField.setBounds(175, 310, 60, 20);
		JLabel unitLabel = new JLabel();
		unitLabel.setBounds(235, 310, 70, 24);
		JLabel percentageLabel1 = new JLabel("�����");
		percentageLabel1.setBounds(95, 345, 70, 24);
		JTextField percentageField = new JTextField();
		percentageField.setBounds(175, 345, 60, 20);
		JLabel percentageLabel2 = new JLabel("%");
		percentageLabel2.setBounds(235, 345, 70, 24);
		
// show employee information
		nameField.setText(vo.getName());
		idCardField.setText(""+vo.getId());
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
		 yearBox.setSelectedIndex(vo.getBirthday().getYear()-1);
		 monthBox.setSelectedIndex(vo.getBirthday().getMonth()-1);
		 dayBox.setSelectedIndex(vo.getBirthday().getDay()-1);
		 
		
		
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
					basePayField.setText(""+vo.getPay().getBasePay());
					percentageField.setText(""+vo.getPay().getRate());
					createDialog.add(percentageLabel1);
					createDialog.add(percentageLabel2);
					createDialog.add(percentageField);
										
				}
				else if(positionBox.getSelectedItem().toString().equals("˾��")){
					basePayLabel.setText("���˼Ʒ�");
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
			}
		});
	
		
		 
		   
		   
	 
		JButton cancleButton = new JButton("ȡ��");
		cancleButton.setBounds(175, 380, 70, 30);
		cancleButton.addActionListener(new ActionListener(){
	
			  @Override
			  public void actionPerformed(ActionEvent e){
				  createDialog.dispose();
			  }
		});
		
		JButton sureButton = new JButton("ȷ��");
		sureButton.setBounds(265, 380, 70, 30);
		sureButton.addActionListener(new ActionListener(){
			
			  @Override
			  public void actionPerformed(ActionEvent e){
				  long id = new Long(idCardField.getText());
				  String name = nameField.getText();
				  String organization = organizationBox.getSelectedItem().toString();
				  long phone = new Long(phoneField.getText());	
				  long identityCardNum = new Long(idCardField.getText());
					@SuppressWarnings("deprecation")
				 Date birth = new Date((int)yearBox.getSelectedItem(), 
							   (int)monthBox.getSelectedItem(),(int)dayBox.getSelectedItem());
					//long idCardNum = new Long(idCardField.getText());
					Sex sex1 ;
					 if(maleRadioButton.isSelected())
						 sex1 = Sex.MALE;
					else 
						 sex1 = Sex.FAMALE;			 
					 PayPO paypo = null ;						
					 Position p = null ;
					 switch (positionBox.getSelectedItem().toString()) {
					   	case "�ܾ���":{
					   		p = Position.MANAGER; 
					   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
					   				0.0, 0, 0, 0);
					   		break;
					   	}
					   	case "Ӫҵ��ҵ��Ա":{
					   		p = Position.SELLINGBUSINESSMAN;
					   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
					   				0.0, 0, 0, 0);
					   		break;
					   	}
					   	case "��ת����ҵ��Ա":{
					   		p = Position.TRANSFERCENTREBUSINESSMAN;
					   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
					   				0.0, 0, 0, 0);
					   		break;
					   	}
					   	case "���Ա":{
					   		p = Position.COURIER; 
					   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
					   				0, 0, 0,Double.valueOf(phoneField.getText())/100 );
					   		break;
					   	}
					   	case "��ת���Ĳֿ����Ա":{
					   		p = Position.STORAGEMANAGER;
					   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
					   				0.0, 0, 0, 0);
					   		break;
					   	}
					   	case "�߼�������Ա":{
					   		p = Position.SENIORFINANCIALSTAFF;
					   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
					   				0.0, 0, 0, 0);
					   		break;
					   	}
					   	case "������Ա":{
					   		p = Position.SYSTEMMANAGER;
					   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
					   				0.0, 0, 0, 0);
					   		break;
					   	}
					   	case "����Ա":{
					   		p = Position.SYSTEMMANAGER;
					   		paypo = new PayPO(Double.valueOf(basePayField.getText()),
					   				0.0, 0, 0, 0);
					   		break;
					   	}
					   	case "˾��":{
					   		p = Position.DRIVER;
					   		paypo = new PayPO(0,Double.valueOf(basePayField.getText()), 0, 0, 0);
					   		break;			   			 
					   	}
					}	
					 EmployeeVO vo1 = new EmployeeVO(id, name, organization,
							 p, phone, birth, identityCardNum, sex1, paypo);
					 employeeblService.modifyEmloyeePO(vo1);
			  }
		});
		
		createDialog.add(infoLabel);
		createDialog.add(nameField);
		createDialog.add(nameLabel);
		createDialog.add(sexLabel);
		createDialog.add(femaleRadioButton);
		createDialog.add(maleRadioButton);	
		createDialog.add(idField);
		createDialog.add(idLabel);
		createDialog.add(organizationLabel);
		createDialog.add(organizationBox);
		createDialog.add(positionLabel);
		createDialog.add(positionBox);
		createDialog.add(phoneField);
		createDialog.add(phoneLabel);
		createDialog.add(idCardLabel);
		createDialog.add(idCardField);
		createDialog.add(birthLabel);
		createDialog.add(yearBox);
		createDialog.add(yearLabel);
		createDialog.add(monthBox);
		createDialog.add(monthLabel);
		createDialog.add(dayBox);
		createDialog.add(dayLabel);
		createDialog.add(cancleButton);
		createDialog.add(sureButton);
		createDialog.add(payLabel);
		createDialog.add(basePayLabel);
		createDialog.add(basePayField);
		createDialog.add(unitLabel);
		
		
		createDialog.setLayout(null);
		createDialog.setVisible(true);
	}
}

