package presentation.financeui.settlementui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.financeui.FinancePanel;
import presentation.financeui.logui.LogDialog;

public class SettlementDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1781730997983572841L;
	private JPanel parent;
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
		int labelx = 50;
		int labely = 70;
		JLabel dateLabel = new JLabel("日期");
		dateLabel.setSize(labelWidth,labelHeight);
		dateLabel.setLocation(labelx, labely);
		JLabel businessHallLabel = new JLabel("营业厅");
		businessHallLabel.setSize(labelWidth,labelHeight);
		businessHallLabel.setLocation(labelx, labely+70-labelHeight);
		
		
		int longWidth = 180;
		int shortWidth = 60;
		int textFieldHeight = 25;
		int textFieldx = 113;
		int textFieldy = 70;
		int interval2 = 20;
		String[] year = new String[]{"2015","2016"};
		JLabel yearLabel  = new JLabel("年");
		yearLabel.setBounds(textFieldx+shortWidth+5,textFieldy,20,20);		
		JLabel monthLabel  = new JLabel("月");
		monthLabel.setBounds(textFieldx+shortWidth+(20+shortWidth)*1,textFieldy,20,20);	
		JLabel dayLabel  = new JLabel("日");
		dayLabel.setBounds(textFieldx+shortWidth+(20+shortWidth)*2,textFieldy,20,20);	
		JComboBox yearBox = new JComboBox(year);
		yearBox.setSize(shortWidth+5, textFieldHeight);
		yearBox.setLocation(textFieldx, textFieldy);
		String[] month = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
		JComboBox monthBox = new JComboBox(month);
		monthBox.setSize(shortWidth, textFieldHeight);
		monthBox.setLocation(textFieldx+shortWidth+20, textFieldy);
		String[] day = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		JComboBox dayBox = new JComboBox(day);
		dayBox.setSize(shortWidth, textFieldHeight);
		dayBox.setLocation(textFieldx+(shortWidth+20)*2, textFieldy);
		String[] businessHall = new String[]{"南京市栖霞区营业厅"};
		JComboBox businessHallBox = new JComboBox(businessHall);
		businessHallBox.setSize(longWidth, textFieldHeight);
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
		this.add(yearLabel);
		this.add(monthLabel);
		this.add(dayLabel);
		this.add(yearBox);
		this.add(monthBox);
		this.add(dayBox);
		this.add(businessHallBox);
		this.add(confirmButton);
		this.add(backButton);
		
	    this.setVisible(true);
	}
	
	class ConfirmButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("unused")
			SettlementPanel settlementPanel = new SettlementPanel(SettlementDialog.this.parent);
			SettlementDialog.this.dispose();
		}
		
	}
}
