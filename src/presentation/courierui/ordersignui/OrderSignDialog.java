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
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;
	private JComboBox<String> yearComboBox;
	private JComboBox<String> monthComboBox;
	private JComboBox<String> dayComboBox;
	
	private JLabel signNameLabel;	
	private JTextField signNameTextField;
	
	private JButton confirmButton;
	private JButton cancleButton;
	
	private String[] year = {"2015","2016","2017","2018","2019","2010"};
	private String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    private String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
    		"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	

	public OrderSignDialog(){
		init();
		buttonFunction();
	}

	
	public void init(){
		this.setTitle("订单签收");	
		this.setSize(380, 270);
		this.setLayout(null);
        		
		orderIdInit();
		signDateInit();
        signNameinit();
        
        confirmButton = new JButton("确定");
        cancleButton = new JButton("取消");
        confirmButton.setBounds(290, 190, 70, 30);
        cancleButton.setBounds(200, 190, 70, 30);
        this.add(confirmButton);
        this.add(cancleButton);
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
	}
	
	public void orderIdInit(){
		orderIdLabel = new JLabel("订单号");
        orderIdLabel.setFont(new Font("订单号", 0, 13));
        orderIdLabel.setBounds(30, 48, 40, 16);
        orderIdTextField = new JTextField();
        orderIdTextField.setBounds(100, 45, 180, 20);
        this.add(orderIdLabel);
        this.add(orderIdTextField);
	}
	
	public void signDateInit(){
		dateLabel = new JLabel("签收日期");
        dateLabel.setFont(new Font("签收日期", 0, 13));
        dateLabel.setBounds(30, 84, 60, 16);
        yearLabel = new JLabel("年");
        yearLabel.setFont(new Font("年", 0, 16));
        yearLabel.setBounds(173, 84, 20, 25);
        monthLabel = new JLabel("月");
        monthLabel.setFont(new Font("月", 0, 16));
        monthLabel.setBounds(243, 84, 20, 25);
        dayLabel = new JLabel("日");
        dayLabel.setFont(new Font("日", 0, 16));
        dayLabel.setBounds(313,84, 20, 25);
    
        
        
        yearComboBox = new JComboBox<String>(year);
        yearComboBox.setBounds(100, 84, 70, 25);
        yearComboBox.setEditable(false);
        monthComboBox = new JComboBox<String>(month);
        monthComboBox.setBounds(190, 84, 50, 25);
        monthComboBox.setEditable(false);
        dayComboBox = new JComboBox<String>(day);
        dayComboBox.setBounds(260, 84, 50, 25);
        dayComboBox.setEditable(false);
        this.add(yearLabel);
        this.add(dayLabel);
        this.add(monthLabel);
        this.add(monthComboBox);
        this.add(yearComboBox);
        this.add(dayComboBox);
        this.add(dateLabel);
	}
	
	public void signNameinit(){
		signNameLabel = new JLabel("签收人");
        signNameLabel.setFont(new Font("签收人", 0, 13));
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
				int yearDate = Integer.parseInt(year[yearComboBox.getSelectedIndex()]);
				int monthDate = Integer.parseInt(month[monthComboBox.getSelectedIndex()]);
				int dayDate = Integer.parseInt(day[dayComboBox.getSelectedIndex()]);
	
				@SuppressWarnings("deprecation")
				OrderSignVO orderSignVO = new OrderSignVO(new String(orderIdTextField.getText()), 
						signNameTextField.getText(),new Date(yearDate, monthDate, dayDate));
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
