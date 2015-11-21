package presentation.financeui.settlementui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class SetAccountDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7483943739022897155L;

	public SetAccountDialog(){
		int dialogx = 380;
		int dialogy = 210;
		this.setSize(dialogx, dialogy); 
		this.setLocationRelativeTo(null);
		
		JLabel promptLabel = new JLabel("您可以选择账户进行付款:");
		promptLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		promptLabel.setSize(217,22);
		promptLabel.setLocation((dialogx-190)/2, dialogy/8);
		promptLabel.setVisible(true);
		int labelWidth = 80;
		int labelHeight = 25;
		int labelx = 62;
		int labely = 75;
		JLabel accountLabel = new JLabel("账户编号");
		accountLabel.setSize(labelWidth,labelHeight);
		accountLabel.setLocation(labelx, labely);
		String[] account = new String[]{"10000000000000000000"};
		JComboBox accountBox = new JComboBox(account);
		accountBox.setSize(180, 25);
		accountBox.setLocation(140, 75);
		
		JButton confirmButton = new JButton("确认");
		confirmButton.setBounds(280,130, 70, 30);
		JButton cancelButton = new JButton("取消");
		cancelButton.setBounds(190,130, 70, 30);
		
		this.setLayout(null);
		this.add(promptLabel);
		this.add(promptLabel);
		this.add(accountLabel);
		this.add(accountBox);
		this.add(confirmButton);
		this.add(cancelButton);
		
		this.setVisible(true);
	}
}
