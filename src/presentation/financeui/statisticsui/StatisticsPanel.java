package presentation.financeui.statisticsui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogic.ExcelExporter;
import businesslogicservice.ExcelExporterService;


/**
 * {@code StatisticsPanel}�̳�{@code JPanel}����ͳ�Ʊ���Ľ�������չʾ
 * @author ���¿�
 *
 */
public class StatisticsPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8910285590324569708L;

	public StatisticsPanel(JPanel panel, JPanel paymentPanel ,JPanel revenuePanel){
		panel.removeAll();
		this.setBounds(0, 0, 560, 430);
		
		int labelWidth = 65;
		int labelHeight = 20;
		int interval=10;
		int scrollPaneWidth = 560;
		int scrollPaneHeight = 160;
		JLabel revenueLabel = new JLabel("�տ��");
		revenueLabel.setBounds(0,20,labelWidth,labelHeight);
		revenuePanel.setLocation(0,20+labelHeight);
		JButton excelButton = new JButton("���ɵ�Excel");
		excelButton.setBounds(418, 10, 140, 30);
		excelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ExcelExporterService excelExporterService = new ExcelExporter();
				File file = new File("c:/LIMS/database/"+"StatisticsExcel"+".xls");
				try {
					excelExporterService.export(((RevenuePanel)revenuePanel).getTable(),((PaymentPanel)paymentPanel).getTable(),file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
	
		JLabel paymentLabel = new JLabel("�����");
		paymentLabel.setBounds(0,20+labelHeight+scrollPaneHeight+interval,labelWidth,labelHeight);
		paymentPanel.setLocation(0, 20+labelHeight+scrollPaneHeight+interval+labelHeight);
		
		JLabel incomeLabel = new JLabel("�����룺");
		incomeLabel.setBounds(0,20+labelHeight+scrollPaneHeight+interval+labelHeight+scrollPaneHeight+20,labelWidth,labelHeight);	
		JLabel incomeLabel2 = new JLabel( String.format("%.2f", ((RevenuePanel)revenuePanel).getTotalIncome()));
		incomeLabel2.setBounds(labelWidth,20+labelHeight+scrollPaneHeight+interval+labelHeight+scrollPaneHeight+20,labelWidth*2,labelHeight);
		JLabel expenditureLabel = new JLabel("��֧����");
		expenditureLabel.setBounds(scrollPaneWidth/3+15,20+labelHeight+scrollPaneHeight+interval+labelHeight+scrollPaneHeight+20,labelWidth,labelHeight);	
		JLabel expenditureLabel2 = new JLabel( String.format("%.2f", ((PaymentPanel)paymentPanel).getTotalExpenditure()));
		expenditureLabel2.setBounds(scrollPaneWidth/3+15+labelWidth,20+labelHeight+scrollPaneHeight+interval+labelHeight+scrollPaneHeight+20,labelWidth*2,labelHeight);
		
		JLabel profitLabel = new JLabel("������");
		profitLabel.setBounds((scrollPaneWidth/3)*2+30,20+labelHeight+scrollPaneHeight+interval+labelHeight+scrollPaneHeight+20,labelWidth,labelHeight);	
		JLabel profitLabel2 = new JLabel( String.format("%.2f", ((RevenuePanel)revenuePanel).getTotalIncome()-((PaymentPanel)paymentPanel).getTotalExpenditure()));
		profitLabel2.setBounds((scrollPaneWidth/3)*2+labelWidth+30,20+labelHeight+scrollPaneHeight+interval+labelHeight+scrollPaneHeight+20,labelWidth*2,labelHeight);


		
		this.setLayout(null);
		this.add(revenueLabel);
		this.add(revenuePanel);
		this.add(paymentLabel);
		this.add(paymentPanel);
		this.add(incomeLabel);
		this.add(incomeLabel2);
		this.add(expenditureLabel);
		this.add(expenditureLabel2);
		this.add(profitLabel);
		this.add(profitLabel2);
		this.add(excelButton);
		
		panel.setLayout(null);
		panel.add(this);
		panel.setVisible(true);
		panel.repaint();
	}
}
