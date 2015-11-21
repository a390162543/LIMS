package presentation.financeui.settlementui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RevenuePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6891629283767178138L;

	public RevenuePanel(JPanel panel){
		panel.removeAll();
		int scrollPaneWidth = 560;
		int scrollPaneHeight = 370;
		JScrollPane revenueScrollPane = new JScrollPane();
		revenueScrollPane.setBounds(0, 0, scrollPaneWidth, scrollPaneHeight);
		
		JButton setAccountButton  =  new JButton("设置收款账户");
		setAccountButton.setBounds(scrollPaneWidth-120, scrollPaneHeight+10, 120, 30);
		setAccountButton.addActionListener(new SetAccountButtonActionListener());
		
		this.setLayout(null);
		this.add(revenueScrollPane);
		this.add(setAccountButton);
		this.setBounds(0, 100,scrollPaneWidth,scrollPaneHeight+10+30);
		this.setVisible(true);
		
		panel.setLayout(null);
		panel.add(this);
		panel.setVisible(true);
		panel.repaint();
	}
	
	class SetAccountButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			@SuppressWarnings("unused")
			SetAccountDialog setAccountDialog = new SetAccountDialog();
		}
		
	}
}
