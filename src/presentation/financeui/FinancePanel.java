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
 * {@code FinancePanel}�̳�{@code JPanel}���ǲ�����Ա������Ľ�������չʾ
 * @author ���¿�
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

	        tabbedPane.addTab("  �˻�����   ", new AccountPanel());
	        tabbedPane.addTab("�ɱ�����", null);
	        tabbedPane.addTab("�������", null);
	        tabbedPane.addTab("�����տ��˻�", new RevenuePanel());
	        tabbedPane.addTab("�鿴ͳ�Ʊ���", null);
	        tabbedPane.addTab("�鿴��־��¼", null);
	        tabbedPane.addTab("�ڳ�����", null);
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
