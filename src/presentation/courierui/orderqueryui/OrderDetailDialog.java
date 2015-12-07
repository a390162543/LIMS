package presentation.courierui.orderqueryui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import vo.OrderQueryVO;


/**
 * ���ǲ�ѯ����������Ϣ��VO
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
	private JTextArea deliveryInfoTestTextArea;
	
	private JButton confirmButton;
	
	public OrderDetailDialog(){
		
		this.setTitle("������Ϣ");	
		this.setSize(380, 460);
		this.setLayout(null);
		goodsStateLabel = new JLabel("����״̬");
		goodsStateLabel.setBounds(20, 61, 80, 22);
		goodsStateTextField = new JTextField();
		goodsStateTextField.setBounds(90, 61, 60, 22);
		goodsStateTextField.setEditable(false);
		orderIdLabel = new JLabel("������");
		orderIdLabel.setBounds(20, 100, 60, 22);
		orderIdTextField = new JTextField();
		orderIdTextField.setEditable(false);
		orderIdTextField.setBounds(90, 100, 180, 22);
		deliveryInfoLabel = new JLabel("�����켣");
		deliveryInfoLabel.setBounds(20, 145, 80, 22);
		deliveryInfoTestTextArea = new JTextArea();
		deliveryInfoTestTextArea.setBounds(90, 147, 220, 220);
		deliveryInfoTestTextArea.setEditable(false);
		confirmButton = new JButton("ȷ��");
		confirmButton.setBounds(280, 388, 70, 30);
		this.add(confirmButton);
		this.add(deliveryInfoTestTextArea);
		this.add(deliveryInfoLabel);
		this.add(orderIdTextField);
		this.add(orderIdLabel);
		this.add(goodsStateTextField);
		this.add(goodsStateLabel);
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
		
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderDetailDialog.this.dispose();
				
			}
		});
	}

	public void setInfo(OrderQueryVO vo) {
		goodsStateTextField.setText(vo.getState().getName());
		orderIdTextField.setText(vo.getId());
		deliveryInfoTestTextArea.setText(vo.getDeliverInfo() + "\n"
				+ vo.getNowLocation() + "����" + vo.getNextLocation());
	}
}
