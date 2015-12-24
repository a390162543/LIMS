package presentation.financeui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import presentation.financeui.accountui.AccountPanel;
import presentation.financeui.logui.LogDialog;
import presentation.financeui.primeinfoui.PrimeInfoDialog;
import presentation.financeui.settlementui.RevenuePanel;
import presentation.financeui.settlementui.SettlementDialog;
import presentation.financeui.statisticsui.StatisticsDialog;
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
		 JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

	        tabbedPane.addTab("  账户管理   ", new AccountPanel());
	        tabbedPane.addTab("成本管理", null);
	        tabbedPane.addTab("结算管理", null);
	        tabbedPane.addTab("设置收款账户", new RevenuePanel());
	        tabbedPane.addTab("查看统计报表", null);
	        tabbedPane.addTab("查看日志记录", null);
	        tabbedPane.addTab("期初建账", null);
	        tabbedPane.setBounds(0, 30, 800, 480);
	        this.add(tabbedPane);
	        tabbedPane.setSelectedIndex(-1);
	        tabbedPane.addChangeListener(new ChangeListener() {
	            
	            @Override
	            public void stateChanged(ChangeEvent e) {
	                int index = tabbedPane.getSelectedIndex();
	                if(index==1)
	                    tabbedPane.setSelectedIndex(-1);
	                switch (index) {
	                case 2:
	                    new SettlementDialog(tabbedPane);
	                    break;
	                case 4:
	                    new StatisticsDialog(tabbedPane);
	                    break;
	                case 5:
	                    new LogDialog(tabbedPane);
	                    break;
	                case 6:
	                    new PrimeInfoDialog(tabbedPane);
	                    break;
	                default:
	                    break;
	                }
	            }
	        });
	        
	        this.setSize(800, 540);
	        this.setLayout(null);
	}
}
