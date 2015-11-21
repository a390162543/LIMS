package presentation.financeui.logui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogic.logbl.Log;
import businesslogicservice.LogblService;
import vo.LogVO;

public class LogDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5032227141174912005L;
	private JPanel parent;
	private JComboBox yearBox;
	private JComboBox monthBox;
	private JComboBox dayBox;

	public LogDialog(JPanel panel){
		this.parent=panel;
		
		int dialogx = 380;
		int dialogy = 240;
		this.setSize(dialogx, dialogy);
		this.setLocationRelativeTo(null);
		
		JLabel promptLabel = new JLabel("您可以输入日期进行主要操作查询:");
		promptLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		promptLabel.setSize(343,22);
		promptLabel.setLocation((dialogx-230)/2, dialogy/8);
		promptLabel.setVisible(true);
		
		int labelWidth = 80;
		int labelHeight = 25;
		int labelx = 50;
		int labely = 90;
		JLabel dateLabel = new JLabel("日期"); 
		dateLabel.setSize(labelWidth,labelHeight);
		dateLabel.setLocation(labelx, labely);
	
		int longWidth = 180;
		int shortWidth = 60;
		int textFieldHeight = 25;
		int textFieldx = 113;
		int textFieldy = 90;
		int interval2 = 20;
		
		JLabel yearLabel  = new JLabel("年");
		yearLabel.setBounds(textFieldx+shortWidth+5,textFieldy,20,20);		
		JLabel monthLabel  = new JLabel("月");
		monthLabel.setBounds(textFieldx+shortWidth+(20+shortWidth)*1,textFieldy,20,20);	
		JLabel dayLabel  = new JLabel("日");
		dayLabel.setBounds(textFieldx+shortWidth+(20+shortWidth)*2,textFieldy,20,20);	
		String[] year = new String[]{"2015","2016"};
		yearBox = new JComboBox(year);
		yearBox.setSize(shortWidth+5, textFieldHeight);
		yearBox.setLocation(textFieldx, textFieldy);
		String[] month1 = new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"};
		monthBox = new JComboBox(month1);
		monthBox.setSize(shortWidth, textFieldHeight);
		monthBox.setLocation(textFieldx+shortWidth+20, textFieldy);
		String[] day = new String[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		dayBox = new JComboBox(day);
		dayBox.setSize(shortWidth, textFieldHeight);
		dayBox.setLocation(textFieldx+(shortWidth+20)*2, textFieldy);

		
		JButton confirmButton = new JButton("确认");
		confirmButton.setBounds(280,160, 70, 30);
		confirmButton.addActionListener(new ConfirmButtonListener());
		JButton backButton = new JButton("返回");
		backButton.setBounds(190,160, 70, 30);
		backButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				LogDialog.this.dispose();
			}
		});
		
		this.setLayout(null);
		this.add(promptLabel);
		this.add(dateLabel);
		this.add(yearLabel);
		this.add(monthLabel);
		this.add(dayLabel);
		this.add(yearBox);
		this.add(monthBox);
		this.add(dayBox);
		this.add(confirmButton);
		this.add(backButton);
		
	    this.setVisible(true);
	}
	
	class ConfirmButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {		
			LogblService lbs = new Log();
			List<LogVO> vos = lbs.queryLogVO( new Date(Integer.parseInt(yearBox.getSelectedItem().toString())-1900,Integer.parseInt(monthBox.getSelectedItem().toString())-1,Integer.parseInt(dayBox.getSelectedItem().toString())));
			
			@SuppressWarnings("unused")
			LogPanel logPanel = new LogPanel(parent, vos);
			LogDialog.this.dispose();
		}
		
	}
}
