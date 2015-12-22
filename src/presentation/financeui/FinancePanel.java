package presentation.financeui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import businesslogic.userbl.LoginController;
import presentation.financeui.accountui.AccountPanel;
import presentation.financeui.logui.LogDialog;
import presentation.financeui.paymentui.PaymentDialog;
import presentation.financeui.primeinfoui.PrimeInfoDialog;
import presentation.financeui.settlementui.RevenuePanel;
import presentation.financeui.settlementui.SettlementDialog;
import presentation.financeui.statisticsui.StatisticsDialog;
import systemenum.Position;
/**
 * {@code FinancePanel}继承{@code JPanel}，是财务人员主界面的界面层面板展示
 * @author 刘德宽
 *
 */
public class FinancePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2566043597154593838L;
	JPanel panel;
	public FinancePanel(){
		int buttonWidth = 150;
	    int buttonHeight = 40;
	    
	    JButton primeInfoButton = new JButton("期初建账");
	    primeInfoButton.addActionListener(new PrimeInfoButtonListener());
	    JButton accountButton = new JButton("账户管理");
	    accountButton.addActionListener(new AccountButtonListener());
	    if(LoginController.getPosition()==Position.FINANCIALSTAFF)
	    	accountButton.setEnabled(false);
	    JButton paymentButton = new JButton("成本管理");
	    paymentButton.addActionListener(new PaymentButtonListener());
	    JButton setAccountIdButton = new JButton("设置收款账户");
	    setAccountIdButton.addActionListener(new SetAccountIdButtonListener());
	    JButton revenueButton = new JButton("查看收款单");
	    revenueButton.addActionListener(new RevenueButtonListener());
	    JButton statisticsButton = new JButton("查看统计报表");
	    statisticsButton.addActionListener(new StatisticsButtonListener());
	    JButton logButton = new JButton("查看操作日志");
	    logButton.addActionListener(new LogButtonListener());
	    
	    int buttonx = 30; 
	    int buttony = 40;
	    int interval = 25;    
	    
	    accountButton.setBounds(buttonx,buttony,buttonWidth, buttonHeight);	
	    paymentButton.setBounds(buttonx,buttony+buttonHeight*1+interval*1,buttonWidth, buttonHeight);	
	    setAccountIdButton.setBounds(buttonx,buttony+buttonHeight*2+interval*2,buttonWidth, buttonHeight);	
	    revenueButton.setBounds(buttonx,buttony+buttonHeight*3+interval*3,buttonWidth, buttonHeight);	
	    statisticsButton.setBounds(buttonx,buttony+buttonHeight*4+interval*4,buttonWidth, buttonHeight);	
	    logButton.setBounds(buttonx,buttony+buttonHeight*5+interval*5,buttonWidth, buttonHeight);	
	    primeInfoButton.setBounds(buttonx,buttony+buttonHeight*6+interval*6,buttonWidth, buttonHeight);
	    
	    panel = new JPanel();
	    panel.setLayout(null);
	    panel.setBounds(220, 30, 800-220, 470);
	    		
	    this.setLayout(null);
	    this.add(panel);
	    this.setBounds(0, 0, 800, 540);
	    this.add(primeInfoButton);
	    this.add(accountButton);
	    this.add(paymentButton);
	    this.add(setAccountIdButton);
	    this.add(revenueButton);
	    this.add(statisticsButton);
	    this.add(logButton);
	}
	
	class PrimeInfoButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("unused")
			PrimeInfoDialog primeInfoDialog = new PrimeInfoDialog(panel);
		}	
	}
	class AccountButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			@SuppressWarnings("unused")
			AccountPanel accountPanel = new AccountPanel(panel);
		}	
	}
	class PaymentButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {	
			@SuppressWarnings("unused")
			PaymentDialog paymentDialog = new PaymentDialog();
		}	
	}
	class RevenueButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {	
			@SuppressWarnings("unused")
			SettlementDialog settlementDialog = new SettlementDialog(panel);

		}	
	}
	class SetAccountIdButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			@SuppressWarnings("unused")
			RevenuePanel revenuePanel = new RevenuePanel(panel);			
		}
	}
	class StatisticsButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			@SuppressWarnings("unused")
			StatisticsDialog statisticsDialog = new StatisticsDialog(panel);
		}		
	}
	class LogButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			@SuppressWarnings("unused")
			LogDialog logDialog = new LogDialog(panel);
		}
		
	}
}
