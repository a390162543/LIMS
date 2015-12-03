package presentation.financeui.settlementui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.util.DatePickPanel;
import presentation.util.OrganizationComboBox;
import businesslogic.settlementbl.Settlement;
import businesslogicservice.SettlementblService;
import vo.RevenueVO;

public class SettlementDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1781730997983572841L;
	private JPanel parent;
	
	private DatePickPanel datePickPanel;
	private JComboBox businessHallBox;
	
	public SettlementDialog(JPanel panel){
		this.parent = panel;
		int dialogx = 380;
		int dialogy = 240;
		this.setSize(dialogx, dialogy);
		this.setLocationRelativeTo(null);
		
		JLabel promptLabel = new JLabel("您可以输入日期和营业厅进行收款单查询:");
		promptLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		promptLabel.setSize(343,22);
		promptLabel.setLocation((dialogx-280)/2, dialogy/10);
		promptLabel.setVisible(true);
		
		int labelWidth = 80;
		int labelHeight = 25;
		int labelx = 70;
		int labely = 70;
		JLabel dateLabel = new JLabel("日期");
		dateLabel.setSize(labelWidth,labelHeight);
		dateLabel.setLocation(labelx, labely);
		JLabel businessHallLabel = new JLabel("营业厅");
		businessHallLabel.setSize(labelWidth,labelHeight);
		businessHallLabel.setLocation(labelx, labely+70-labelHeight);
		
		
		int longWidth = 180;
		int textFieldHeight = 25;
		int textFieldx = 123;
		int textFieldy = 70;
		int interval2 = 20;
		datePickPanel = new DatePickPanel();
		datePickPanel.setLocation(textFieldx, textFieldy);
		
		businessHallBox = new OrganizationComboBox("营业厅");
		businessHallBox.setLocation(textFieldx, textFieldy+(interval2+textFieldHeight)*1);
		
		JButton confirmButton = new JButton("确认");
		confirmButton.setBounds(280,160, 70, 30);
		confirmButton.addActionListener(new ConfirmButtonListener());
		JButton backButton = new JButton("返回");
		backButton.setBounds(190,160, 70, 30);
		backButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				SettlementDialog.this.dispose();
			}
		});
		
		this.setLayout(null);
		this.add(promptLabel);
		this.add(dateLabel);
		this.add(businessHallLabel);
		this.add(datePickPanel);
		this.add(businessHallBox);
		this.add(confirmButton);
		this.add(backButton);
		
	    this.setVisible(true);
	}
	
	class ConfirmButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			SettlementblService sbs = new Settlement();
			List<RevenueVO> ros = sbs.queryRevenueVO( datePickPanel.getDate(), businessHallBox.getSelectedItem().toString());

			@SuppressWarnings("unused")
			SettlementPanel settlementPanel = new SettlementPanel(SettlementDialog.this.parent,ros);
			SettlementDialog.this.dispose();
		}
		
	}
}
