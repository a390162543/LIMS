package presentation.courierui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.UIManager;




import presentation.courierui.ordercreateui.OrderCreateDialog;
import presentation.courierui.ordersignui.OrderSignDialog;

public class OrderUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4720179693668770018L;
	
	private JButton orderCreateButton;
	private JButton orderSignButton;
	
	public OrderUI(){
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		init(); 
        buttonFunction();
               
	}
	
	
	public void init(){
		
		this.setSize(800, 540);
        this.setLayout(null);
        orderCreateButton = new JButton("创建订单");
        orderSignButton = new JButton("订单签收");
        orderCreateButton.setBounds(30, 380, 150, 40);
        orderSignButton.setBounds(30, 450, 150, 40);
        this.add(orderCreateButton);
        this.add(orderSignButton);
        this.setVisible(true);  	
	}
	

	public void buttonFunction(){
		
		orderCreateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new OrderCreateDialog();	
			}
		});;
		
		orderSignButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new OrderSignDialog();			
			}
		});
	}
	
	

	
	
	

}
