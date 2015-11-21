package presentation.financeui.statisticsui;

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

import businesslogic.statisticsbl.Statistics;
import businesslogicservice.StatisticsblService;
import vo.PaymentVO;

public class StatisticsDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 564672213975177599L;
	private JPanel parent;
	private JComboBox yearBox1;
	private JComboBox monthBox1;
	private JComboBox dayBox1;
	private JComboBox yearBox2;
	private JComboBox monthBox2;
	private JComboBox dayBox2;
	
	public StatisticsDialog(JPanel panel){
	
		this.parent = panel;
		int dialogx = 380;
		int dialogy = 240;
		this.setSize(dialogx, dialogy);
		this.setLocationRelativeTo(null);
		
		JLabel promptLabel = new JLabel("您可以输入起始日期进行统计报表查询:");
		promptLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		promptLabel.setSize(343,22);
		promptLabel.setLocation((dialogx-240)/2, dialogy/10);
		promptLabel.setVisible(true);
		
		int labelWidth = 80;
		int labelHeight = 25;
		int labelx = 50;
		int labely = 70;
		JLabel dateLabel1 = new JLabel("日期(始)"); 
		dateLabel1.setSize(labelWidth,labelHeight);
		dateLabel1.setLocation(labelx, labely);
		int labely2 = 110;
		JLabel dateLabel2 = new JLabel("日期(终)"); 
		dateLabel2.setSize(labelWidth,labelHeight);
		dateLabel2.setLocation(labelx, labely2);
	
		int longWidth = 180;
		int shortWidth = 60;
		int textFieldHeight = 25;
		int textFieldx = 113;
		int textFieldy = 70;
		String[] year = new String[]{"2015","2016"};
		JLabel yearLabel  = new JLabel("年");
		yearLabel.setBounds(textFieldx+shortWidth+5,textFieldy,20,20);		
		JLabel monthLabel  = new JLabel("月");
		monthLabel.setBounds(textFieldx+shortWidth+(20+shortWidth)*1,textFieldy,20,20);	
		JLabel dayLabel  = new JLabel("日");
		dayLabel.setBounds(textFieldx+shortWidth+(20+shortWidth)*2,textFieldy,20,20);	
		yearBox1 = new JComboBox(year);
		yearBox1.setSize(shortWidth+5, textFieldHeight);
		yearBox1.setLocation(textFieldx, textFieldy);
		String[] month = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
		monthBox1 = new JComboBox(month);
		monthBox1.setSize(shortWidth, textFieldHeight);
		monthBox1.setLocation(textFieldx+shortWidth+20, textFieldy);
		String[] day = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		dayBox1 = new JComboBox(day);
		dayBox1.setSize(shortWidth, textFieldHeight);
		dayBox1.setLocation(textFieldx+(shortWidth+20)*2, textFieldy);
		
		int textFieldy2 = 110;
		String[] year2 = new String[]{"2015","2016"};
		JLabel yearLabel2  = new JLabel("年");
		yearLabel2.setBounds(textFieldx+shortWidth+5,textFieldy2,20,20);		
		JLabel monthLabel2  = new JLabel("月");
		monthLabel2.setBounds(textFieldx+shortWidth+(20+shortWidth)*1,textFieldy2,20,20);	
		JLabel dayLabel2  = new JLabel("日");
		dayLabel2.setBounds(textFieldx+shortWidth+(20+shortWidth)*2,textFieldy2,20,20);	
		yearBox2 = new JComboBox(year2);
		yearBox2.setSize(shortWidth+5, textFieldHeight);
		yearBox2.setLocation(textFieldx, textFieldy2);
		String[] month2 = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
		monthBox2 = new JComboBox(month2);
		monthBox2.setSize(shortWidth, textFieldHeight);
		monthBox2.setLocation(textFieldx+shortWidth+20, textFieldy2);
		String[] day2 = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		dayBox2 = new JComboBox(day2);
		dayBox2.setSize(shortWidth, textFieldHeight);
		dayBox2.setLocation(textFieldx+(shortWidth+20)*2, textFieldy2);
		
		JButton confirmButton = new JButton("确认");
		confirmButton.setBounds(280,160, 70, 30);
		confirmButton.addActionListener(new ConfirmButtonListener());
		JButton backButton = new JButton("返回");
		backButton.setBounds(190,160, 70, 30);
		backButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				StatisticsDialog.this.dispose();
			}
		});
		
		this.setLayout(null);
		this.add(promptLabel);
		this.add(dateLabel1);
		this.add(dateLabel2);
		this.add(yearLabel);
		this.add(monthLabel);
		this.add(dayLabel);
		this.add(yearLabel2);
		this.add(monthLabel2);
		this.add(dayLabel2);
		this.add(yearBox1);
		this.add(monthBox1);
		this.add(dayBox1);
		this.add(yearBox2);
		this.add(monthBox2);
		this.add(dayBox2);
		this.add(confirmButton);
		this.add(backButton);
		
	    this.setVisible(true);
	}
	
	
	class ConfirmButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {		
			StatisticsblService sbs = new Statistics();
			List<PaymentVO> vos = sbs.queryPaymentVO( new Date(Integer.parseInt(yearBox1.getSelectedItem().toString())-1900,Integer.parseInt(monthBox1.getSelectedItem().toString())-1,Integer.parseInt(dayBox1.getSelectedItem().toString())), new Date(Integer.parseInt(yearBox2.getSelectedItem().toString())-1900,Integer.parseInt(monthBox2.getSelectedItem().toString())-1,Integer.parseInt(dayBox2.getSelectedItem().toString())));
			PaymentPanel paymentPanel = new PaymentPanel(vos);
	        
			@SuppressWarnings("unused")
			StatisticsPanel statisticsPanel = new StatisticsPanel(parent, paymentPanel);
			StatisticsDialog.this.dispose();
		}
		
	}
}
