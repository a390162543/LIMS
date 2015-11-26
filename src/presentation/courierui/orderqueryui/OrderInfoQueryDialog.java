package presentation.courierui.orderqueryui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vo.OrderQueryVO;
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
		init();
		buttonFuncton();
	}
	
	public void init(){
		this.setTitle("������ѯ");	
		this.setSize(380, 210);
		this.setLayout(null);
		confirmButton = new JButton("ȷ��");
		confirmButton.setBounds(275, 140, 70, 22);
		orderInfoQueryLabel = new JLabel("��������Ҫ��ѯ�Ķ����ţ�");
		orderInfoQueryLabel.setBounds(20, 54, 240, 22);
		orderInfoTextField = new JTextField();
		orderInfoTextField.setBounds(80, 95, 230, 24);
		this.add(orderInfoTextField);	
		this.add(orderInfoQueryLabel);
		this.add(confirmButton);
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
	}
	
	public void buttonFuncton(){
		
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
