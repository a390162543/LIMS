package presentation.managerui.constantui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vo.ConstantVO;
import businesslogic.BusinessLogicService;
import businesslogic.constantbl.Constant;
import businesslogicservice.ConstantblService;

/**
 * 查询，修改价格界面
 * @author 刘航伸
 * @version 1.2
 */
public class PriceDialog extends JDialog{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -4463982469330418268L;
 
	 
	
	public PriceDialog(){
		 
		this.setBounds(300, 200, 380, 170);
		this.setTitle("价格查询");
		JLabel priceLabel = new JLabel("当前价格");
		priceLabel.setBounds(80, 20, 90, 20);
		JTextField priceField = new JTextField();
		priceField.setBounds(190, 20, 60, 20);
		JLabel unitLabel = new JLabel(" 每公里每吨");
		unitLabel.setBounds(250, 20, 80, 20);
		JButton cancelButton = new JButton("取消");
		cancelButton.setBounds(185, 70, 70, 30);
		JButton sureButton = new JButton("确定");
		sureButton.setBounds(270, 70, 70, 30);
		
		this.add(priceLabel);
		this.add(priceField);
		this.add(cancelButton);
		this.add(sureButton);
		this.add(unitLabel);
	
	 
	 
		ConstantblService constantblService =  BusinessLogicService.getConstantblService();
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
				 PriceDialog.this.dispose();
				
			}
		});
		this.setLayout(null);
		this.setVisible(true);
	}
	
}
