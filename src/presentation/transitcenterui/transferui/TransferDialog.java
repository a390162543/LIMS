package presentation.transitcenterui.transferui;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TransferDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3513694959788276702L;
	 
	
	public void init(){
		Integer[] yearArray = new Integer[]{2015,2016};
		Integer[] monthArray = new Integer[]{1,2};
		Integer[] dayArray = new Integer[]{1,2};
		 		 
		 
		JLabel infoLabel = new JLabel("��ת��");
		infoLabel.setBounds(105, 5, 170, 35);
		JTextField idField = new JTextField();
		idField.setBounds(105, 50, 180, 20);
		JLabel idLabel = new JLabel("��ת�����");
		idLabel.setBounds(20, 50, 80, 20);
		JLabel dateLabel = new JLabel("װ������");
		dateLabel.setBounds(20, 90, 80, 20);
		JComboBox<Integer> yearBox = new JComboBox<Integer>(yearArray);
		yearBox.setBounds(105,90, 60, 20);
		JComboBox<Integer> monthBox = new JComboBox<Integer>(monthArray);
		monthBox.setBounds(185, 90, 60, 20);
		JComboBox<Integer> dayBox = new JComboBox<Integer>(dayArray);
		dayBox.setBounds(265, 90, 60, 20);
		JLabel yearLabel = new JLabel("��");
		yearLabel.setBounds(165, 90, 20, 20);
		JLabel monthLabel = new JLabel("��");
		monthLabel.setBounds(245, 90, 20, 20);
		JLabel dayLabel = new JLabel("��");
		dateLabel.setBounds(325, 90, 20, 20);
		JLabel flightNumLabel = new JLabel("�����");
		flightNumLabel.setBounds(20, 130, 80, 20);
		JTextField flightNumField = new JTextField();
		flightNumField.setBounds(105, 130, 180, 20);
		JLabel departLabel = new JLabel("������");
		departLabel.setBounds(20, 170, 80, 20);
		JComboBox< String> departBox = new JComboBox<String>();
		departBox.setBounds(105, 170, 180, 20);
		JLabel destinationLabel = new JLabel("Ŀ�ĵ�");
		destinationLabel.setBounds(20, 210, 80, 20);
		JComboBox<String> destinationBox = new JComboBox<String>();
		destinationBox.setBounds(105, 210, 180, 20);
		JLabel containerIdLabel = new JLabel("�����");
		containerIdLabel.setBounds(20, 250, 80, 20);
		JTextField containerIdField = new JTextField();
		containerIdField.setBounds(105, 250, 60, 20);
		JLabel loanManLabel = new JLabel("��װԱ");
		loanManLabel.setBounds(175, 250, 80, 20);
		JTextField loanManField = new JTextField();
		loanManField.setBounds(245, 250, 60, 20);
		JLabel orderIdLabel = new JLabel("����");
		orderIdLabel.setBounds(20, 290, 80, 20);
		JLabel expensesLabel = new JLabel("�˷�");
		expensesLabel.setBounds(20, 370, 80, 20);
		JTextField expensesField = new JTextField();
		expensesField.setBounds(105, 370, 60, 20);
		JButton cancleButton = new JButton("ȡ��");
		cancleButton.setBounds(190, 410, 70, 30);
		JButton sureButton = new JButton("ȷ��");
		sureButton.setBounds(280, 410, 70, 30);
		cancleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TransferDialog.this.dispose();
			}
		});
		
		sureButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(infoLabel);
		this.add(idLabel);
		this.add(idField);
		this.add(dateLabel);
		this.add(dateLabel);
		this.add(yearBox);
		this.add(yearLabel);
		this.add(monthBox);
		this.add(monthLabel);
		this.add(dayBox);
		this.add(dayLabel);
		this.add(flightNumLabel);
		this.add(flightNumField);
		this.add(departLabel);
		this.add(departBox);
		this.add(destinationLabel);
		this.add(destinationBox);
		this.add(containerIdLabel);
		this.add(containerIdField);
		this.add(loanManLabel);
		this.add(loanManField);
		this.add(orderIdLabel);
		this.add(expensesLabel);
		this.add(expensesField);
		this.add(cancleButton);
		this.add(sureButton);
		this.setBounds(0, 0, 380, 470);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	 
	
}
