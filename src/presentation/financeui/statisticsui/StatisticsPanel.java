package presentation.financeui.statisticsui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import businesslogic.statisticsbl.Statistics;
import businesslogicservice.StatisticsblService;

public class StatisticsPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8910285590324569708L;

	public StatisticsPanel(JPanel panel, JPanel paymentPanel){
		panel.removeAll();
		this.setBounds(0, 100, 560, 410);
		
		int labelWidth = 65;
		int labelHeight = 20;
		int interval=10;
		int scrollPaneWidth = 560;
		int scrollPaneHeight = 160;
		JLabel revenueLabel = new JLabel("收款单：");
		revenueLabel.setBounds(0,0,labelWidth,labelHeight);
		JScrollPane revenueScrollPane = new JScrollPane();
		revenueScrollPane.setBounds(0, labelHeight, scrollPaneWidth, scrollPaneHeight);
		
		
		JLabel paymentLabel = new JLabel("付款单：");
		paymentLabel.setBounds(0,labelHeight+scrollPaneHeight+interval,labelWidth,labelHeight);
		paymentPanel.setLocation(0, labelHeight+scrollPaneHeight+interval+labelHeight);
		
		JLabel profitLabel = new JLabel("总利润：");
		profitLabel.setBounds(0,labelHeight+scrollPaneHeight+interval+labelHeight+scrollPaneHeight+20,labelWidth,labelHeight);
	
		JLabel profitLabel2 = new JLabel( String.format("%.2f", -((PaymentPanel)paymentPanel).getTotalExpenditure()));
		profitLabel2.setBounds(labelWidth,labelHeight+scrollPaneHeight+interval+labelHeight+scrollPaneHeight+20,labelWidth*2,labelHeight);
//		profitField.setEditable(false);
		JButton excelButton = new JButton("生成到Excel");
		excelButton.setBounds(420, labelHeight+scrollPaneHeight+interval+labelHeight+scrollPaneHeight+10, 140, 30);
		
		this.setLayout(null);
		this.add(revenueLabel);
		this.add(revenueScrollPane);
		this.add(paymentLabel);
		this.add(paymentPanel);
		this.add(profitLabel);
		this.add(profitLabel2);
		this.add(excelButton);
		
		panel.setLayout(null);
		panel.add(this);
		panel.setVisible(true);
		panel.repaint();
	}
}
