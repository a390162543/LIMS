package presentation.courierui.orderqueryui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import vo.OrderQueryVO;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.orderinfo.OrderQueryId;
import businesslogic.orderbl.Order;
import businesslogicservice.OrderblService;


public class OrderInfoQueryDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6114630128196146508L;
	/**
	 * 
	 */
	
	
	private JLabel orderInfoQueryLabel;
	private JTextField orderInfoTextField;
	private JButton confirmButton;
	
	public OrderInfoQueryDialog(){
		
		this.setTitle("订单查询");	
		this.setSize(380, 210);
		this.setLayout(null);
		confirmButton = new JButton("确定");
		confirmButton.setBounds(275, 140, 70, 22);
		orderInfoQueryLabel = new JLabel("请输入您要查询的订单号：");
		orderInfoQueryLabel.setBounds(20, 54, 240, 22);
		orderInfoTextField = new JTextField();
		orderInfoTextField.setBounds(80, 95, 230, 24);
		this.add(orderInfoTextField);	
		this.add(orderInfoQueryLabel);
		this.add(confirmButton);
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
	
		Checker orderIdChecker = new Checker(orderInfoTextField, new CheckInfoGetter() {			
			@Override
			public CheckInfo getCheckInfo() {	
				return new OrderQueryId(orderInfoTextField.getText());
			}
		});
        
		orderInfoTextField.addKeyListener(new KeyListener() {
			
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
		
		
		confirmButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				OrderDetailDialog  deliveryDialog = new OrderDetailDialog();
				OrderblService orderblService = new Order();
				OrderQueryVO orderQueryVO = orderblService.returnOrderQueryVO(new String(orderInfoTextField.getText()));
				deliveryDialog.setInfo(orderQueryVO);
				deliveryDialog.repaint();
			}
		});
	}

}
