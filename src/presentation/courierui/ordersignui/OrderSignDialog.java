package presentation.courierui.ordersignui;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentation.util.DatePickPanel;
import presentation.util.RecentDatePickPanel;
import businesslogic.orderbl.Order;
import businesslogicservice.OrderblService;
import vo.OrderSignVO;

public class OrderSignDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 20144494769692224L;
	/**
	 * 
	 */
	

	private JLabel orderIdLabel;
	private JTextField orderIdTextField;
	
	private JLabel dateLabel;
	
	
	private JLabel signNameLabel;	
	private JTextField signNameTextField;
	
	private JButton confirmButton;
	private JButton cancleButton;
	
	private RecentDatePickPanel datePickPanel;
	

	public OrderSignDialog(){
		init();
		buttonFunction();
	}

	
	public void init(){
		this.setTitle("����ǩ��");	
		this.setSize(380, 270);
		this.setLayout(null);
        		
		orderIdInit();
		signDateInit();
        signNameinit();
        
        confirmButton = new JButton("ȷ��");
        cancleButton = new JButton("ȡ��");
        confirmButton.setBounds(290, 190, 70, 30);
        cancleButton.setBounds(200, 190, 70, 30);
        this.add(confirmButton);
        this.add(cancleButton);
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
	}
	
	public void orderIdInit(){
		orderIdLabel = new JLabel("������");
        orderIdLabel.setFont(new Font("������", 0, 13));
        orderIdLabel.setBounds(30, 48, 40, 16);
        orderIdTextField = new JTextField();
        orderIdTextField.setBounds(100, 45, 180, 20);
        this.add(orderIdLabel);
        this.add(orderIdTextField);
	}
	
	public void signDateInit(){
		dateLabel = new JLabel("ǩ������");
        dateLabel.setFont(new Font("ǩ������", 0, 13));
        dateLabel.setBounds(30, 84, 60, 16);
        datePickPanel = new RecentDatePickPanel();
        datePickPanel.setBounds(100, 84, 300, 25);
        this.add(dateLabel);
        this.add(datePickPanel);
	}
	
	public void signNameinit(){
		signNameLabel = new JLabel("ǩ����");
        signNameLabel.setFont(new Font("ǩ����", 0, 13));
        signNameLabel.setBounds(30, 130, 40, 16);
        signNameTextField = new JTextField();
        signNameTextField.setBounds(102, 128, 60, 20);
        this.add(signNameTextField);
        this.add(signNameLabel);
	}
	

	public void buttonFunction(){
		
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				OrderSignVO orderSignVO = new OrderSignVO(new String(orderIdTextField.getText()), 
						signNameTextField.getText(),datePickPanel.getDate());
				OrderblService orderblService = new Order();
				orderblService.signOrder(orderSignVO);	
			}
		});
		
		cancleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
