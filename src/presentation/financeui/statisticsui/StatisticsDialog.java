package presentation.financeui.statisticsui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.util.DatePickPanel;
import businesslogic.BusinessLogicService;
import businesslogicservice.StatisticsblService;
import vo.PaymentVO;
import vo.RevenueVO;
/**
 * {@code StatisticsDialog}继承{@code JDialog}，是查询统计报表的界面层对话框展示
 * @author 刘德宽
 *
 */
public class StatisticsDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 564672213975177599L;
	private JPanel parent;
	private DatePickPanel datePickPanel1;
	private DatePickPanel datePickPanel2;

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
		int labelx = 70;
		int labely = 70;
		JLabel dateLabel1 = new JLabel("日期(始)"); 
		dateLabel1.setSize(labelWidth,labelHeight);
		dateLabel1.setLocation(labelx, labely);
		int labely2 = 110;
		JLabel dateLabel2 = new JLabel("日期(终)"); 
		dateLabel2.setSize(labelWidth,labelHeight);
		dateLabel2.setLocation(labelx, labely2);

		int textFieldx = 133;
		int textFieldy = 70;
		datePickPanel1 = new DatePickPanel();
		datePickPanel1.setLocation(textFieldx, textFieldy);
		
		int textFieldy2 = 110;
		datePickPanel2 = new DatePickPanel();
		datePickPanel2.setLocation(textFieldx, textFieldy2);
		
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
		this.add(datePickPanel1);
		this.add(datePickPanel2);
		this.add(confirmButton);
		this.add(backButton);
		
	    this.setVisible(true);
	}
	
	
	class ConfirmButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {		
			StatisticsblService sbs = BusinessLogicService.getStatisticsblService();
			List<RevenueVO> ros = sbs.queryRevenueVO( datePickPanel1.getDate(),datePickPanel2.getDate());
			RevenuePanel revenuePanel = new RevenuePanel(ros);
			List<PaymentVO> vos = sbs.queryPaymentVO( datePickPanel1.getDate(),datePickPanel2.getDate());
			PaymentPanel paymentPanel = new PaymentPanel(vos);
	        
			@SuppressWarnings("unused")
			StatisticsPanel statisticsPanel = new StatisticsPanel(parent, paymentPanel,revenuePanel);
			StatisticsDialog.this.dispose();
		}
		
	}
}
