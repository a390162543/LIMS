package presentation.managerui.constantui;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vo.ConstantVO;
import businesslogic.constantbl.Constant;
import businesslogicservice.ConstantblService;

public class PriceDialog extends JDialog{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -4463982469330418268L;
	private JLabel infoLabel;
	private JLabel priceLabel;
	private JTextField priceField;
	private JButton cancelButton;
	private JButton sureButton;
	
	public PriceDialog(){
		 
		this.setBounds(300, 200, 380, 200);
		infoLabel = new JLabel("价格查询");
		infoLabel.setBounds(105, 15, 170, 35);
		priceLabel = new JLabel("当前价格");
		priceLabel.setBounds(80, 70, 90, 20);
		priceField = new JTextField();
		priceField.setBounds(190, 70, 60, 20);
		cancelButton = new JButton("取消");
		cancelButton.setBounds(185, 110, 70, 30);
		sureButton = new JButton("确定");
		sureButton.setBounds(270, 110, 70, 30);
		
		this.add(infoLabel);
		this.add(priceLabel);
		this.add(priceField);
		this.add(cancelButton);
		this.add(sureButton);
		
	
	 
	 
		ConstantblService constantblService = new Constant();
		ConstantVO vo1 = constantblService.getPrice();
		priceField.setText(""+vo1.getPrice());
		cancelButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PriceDialog.this.dispose();
			}
		});
		
		sureButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 ConstantVO vo2 = new ConstantVO(Double.valueOf(priceField.getText()));
				 constantblService.modifyPrice(vo2);
				
			}
		});
		this.setLayout(null);
		this.setVisible(true);
	}
	
}
