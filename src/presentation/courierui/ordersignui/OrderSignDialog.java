package presentation.courierui.ordersignui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.lang.model.element.Modifier;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DialogLayoutManager;
import presentation.util.RecentDatePickPanel;
import presentation.util.ScreenMessage;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.Name;
import businesslogic.checkbl.orderinfo.OrderSignId;
import businesslogicservice.OrderblService;
import vo.OrderSignVO;


/**
 * 这是订单签收的界面
 * @author lc
 * @version 1.4
 *
 */
public class OrderSignDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 20144494769692224L;
	
	
	private JLabel orderIdLabel;
	private JTextField orderIdTextField;
	
	private JLabel dateLabel;
	
	
	private JLabel signNameLabel;	
	private JTextField signNameTextField;
	
	private JButton confirmButton;
	private JButton cancleButton;
	
	private RecentDatePickPanel datePickPanel;
	

	public OrderSignDialog(){
	
		this.setTitle("订单签收");	
		this.setSize(380, 360);
        	
        
        confirmButton = new JButton("确定");
        cancleButton = new JButton("取消");
        confirmButton.setBounds(290, 190, 70, 30);
        cancleButton.setBounds(200, 190, 70, 30);
        this.add(confirmButton);
        this.add(cancleButton);
        
        
	
		orderIdLabel = new JLabel("订单号");
        orderIdLabel.setBounds(30, 48, 40, 16);
        orderIdTextField = new JTextField();
        orderIdTextField.setBounds(100, 45, 180, 20);
        
        this.add(orderIdLabel);
        this.add(orderIdTextField);
	
		dateLabel = new JLabel("签收日期");
        dateLabel.setBounds(30, 84, 60, 16);
        datePickPanel = new RecentDatePickPanel();
        datePickPanel.setBounds(100, 84, 300, 25);
        this.add(dateLabel);
        this.add(datePickPanel);
	
        
		signNameLabel = new JLabel("签收人");
        signNameLabel.setBounds(30, 130, 40, 16);
        signNameTextField = new JTextField();
        signNameTextField.setBounds(102, 128, 60, 20);
        this.add(signNameTextField);
        this.add(signNameLabel);
	
        
       
        
        Checker orderIdChecker = new Checker(orderIdTextField, new CheckInfoGetter() {	
			@Override
			public CheckInfo getCheckInfo() {
				return new OrderSignId(orderIdTextField.getText());
			}
		});
        
        orderIdTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				orderIdChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        Checker orderSignName = new Checker(signNameTextField,new CheckInfoGetter() {		
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				return new Name(signNameTextField.getText());
			}
		});
        
        signNameTextField.addKeyListener(new KeyListener() {	
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				orderSignName.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (orderIdChecker.check()&&orderSignName.check()) {
					OrderSignVO orderSignVO = new OrderSignVO(orderIdTextField.getText(), 
							signNameTextField.getText(),datePickPanel.getDate());
					OrderblService orderblService = BusinessLogicService.getOrderblService();
					orderblService.signOrder(orderSignVO);	
					OrderSignDialog.this.dispose();
					ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
				}
				else {
					ScreenMessage.putOnScreen(ScreenMessage.SAVE_FAILURE);
				}
				
			}
		});
		
		cancleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderSignDialog.this.dispose();
				
			}
		});
		
		 this.setLayout(new DialogLayoutManager());      
	     this.setModalityType(ModalityType.APPLICATION_MODAL);
	     this.setResizable(false);
	     this.setVisible(true);
		
	}
}
