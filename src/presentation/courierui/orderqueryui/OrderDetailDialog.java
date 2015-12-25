package presentation.courierui.orderqueryui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import presentation.util.DialogLayoutManager;
import vo.OrderQueryVO;


/**
 * 这是查询订单物流信息的VO
 * @author lc
 * @version 1.5
 *
 */
public class OrderDetailDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8938986217493006948L;
	
	private JLabel goodsStateLabel;
	private JTextField goodsStateTextField;
	private JLabel orderIdLabel;
	private JTextField orderIdTextField;
	private JLabel deliveryInfoLabel;
	private JPanel deliverLabel;
	private JTextArea deliveryInfoTestTextArea;
	
	private JButton confirmButton;
	
	public OrderDetailDialog(OrderQueryVO vo){
		
		this.setTitle("货物信息");	
		this.setSize(380, 480);

		goodsStateLabel = new JLabel("货物状态");
		goodsStateLabel.setBounds(20, 61, 80, 22);
		goodsStateTextField = new JTextField();
		goodsStateTextField.setBounds(90, 61, 60, 22);
		goodsStateTextField.setEditable(false);
		orderIdLabel = new JLabel("订单号");
		orderIdLabel.setBounds(20, 100, 60, 22);
		orderIdTextField = new JTextField();
		orderIdTextField.setEditable(false);
		orderIdTextField.setBounds(90, 100, 180, 22);
		deliveryInfoLabel = new JLabel("物流轨迹");
		deliveryInfoLabel.setBounds(20, 145, 80, 22);
		deliveryInfoTestTextArea = new JTextArea();
		deliveryInfoTestTextArea.setBounds(90, 147, 220, 300);
		deliveryInfoTestTextArea.setEditable(false);
		confirmButton = new JButton("确定");
		confirmButton.setBounds(280, 388, 70, 30);
	    deliverLabel = new JPanel();
		this.add(orderIdLabel);
		this.add(orderIdTextField);
		this.add(goodsStateLabel);
		this.add(goodsStateTextField);
		this.add(deliveryInfoLabel);
		this.add(deliverLabel);	
		this.add(confirmButton);
		
		goodsStateTextField.setText(vo.getState().getName());
		
		String info = vo.getDeliverInfo();
		int length = 0;
		for (int i = 0; i < info.length(); i++) {
			if (info.charAt(i)=='\n') {
				length++;
			}
		}
		deliverLabel.setBounds(10, 100, 500, 28*length+10);
		deliverLabel.add(deliveryInfoTestTextArea);
		deliverLabel.setLayout(null);
		deliveryInfoTestTextArea.setBounds(0, 0, 480, 28*length);
		orderIdTextField.setText(vo.getId());	
		System.out.println(vo.getDeliverInfo());
		
		deliveryInfoTestTextArea.setText(vo.getDeliverInfo());
		
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderDetailDialog.this.dispose();
				
			}
		});
		
		this.setLayout(new DialogLayoutManager());
		this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setResizable(false);
        this.setVisible(true);
	}

	
}
