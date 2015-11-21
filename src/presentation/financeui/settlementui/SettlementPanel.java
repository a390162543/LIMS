package presentation.financeui.settlementui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SettlementPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3527282890826795425L;

	public SettlementPanel(JPanel panel){
		panel.removeAll();
		this.setBounds(0, 100, 560, 370);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 560, 370);
		this.add(scrollPane);

		panel.setLayout(null);
		panel.add(this);
		panel.setVisible(true);
		panel.repaint();
	}
}
