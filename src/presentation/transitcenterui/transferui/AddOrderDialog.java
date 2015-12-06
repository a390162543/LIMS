//package presentation.transitcenterui.transferui;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//
//public class AddOrderDialog extends JDialog{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -3860740538880961142L;
//	private OrderTableModel tableModel;
//	
//	
//	public AddOrderDialog(OrderTableModel tm, TransferDialog dialog){
//		this.tableModel = tm;
//		JLabel infoLanel = new JLabel("订单");
//		infoLanel.setBounds(105, 10, 170, 35);
//		JLabel orderLabel = new JLabel("订单号");
//		orderLabel.setBounds(35, 85, 100, 24);
//		JTextField orderField = new JTextField();
//		orderField.setBounds(145, 85, 180, 20);
//		JButton cancelButton = new JButton("取消");
//		cancelButton.setBounds(190, 150, 70, 30);
//		JButton confirmButton = new JButton("确定");
//		confirmButton.setBounds(275, 150, 70, 30);
//		
//		cancelButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				AddOrderDialog.this.dispose();
//			}
//		});
//		
//		confirmButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				tableModel.add(orderField.getText());
//				dialog.setExpensesField();
//				
//			}
//		});
//		
//		this.add(infoLanel);
//		this.add(orderLabel);
//		this.add(orderField);
//		this.add(cancelButton);
//		this.add(confirmButton);
//		this.setLayout(null);
//		this.setBounds(100, 100, 380, 240);
//		this.setVisible(true);		
//	}
//
//}
