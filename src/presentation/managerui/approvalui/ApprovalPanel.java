 package presentation.managerui.approvalui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import presentation.transitcenterui.transferui.TransferPendingPanel;

public class ApprovalPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5845404174989335354L;
	private JTextField filterTextField;
	
	public ApprovalPanel(){
		JTabbedPane approvalPane = new JTabbedPane();
		JPanel orderPanel = new JPanel();
		orderPanel.setBounds(0, 25, 560, 370);
		JPanel deliverPanel = new JPanel();
		deliverPanel.setBounds(0, 25, 560, 370);		
		JPanel revenuePanel = new JPanel();
		revenuePanel.setBounds(0, 25, 560, 370);
		//JPanel transferPanel = new JPanel();
		//transferPanel.setBounds(0, 25, 560, 370);
		JPanel loadPanel = new JPanel();
		loadPanel.setBounds(0, 25, 560, 370);
		JPanel storeinPanel = new JPanel();
		storeinPanel.setBounds(0, 25, 560, 370);
		JPanel storeoutPanel = new JPanel();
		storeoutPanel.setBounds(0, 25, 560, 370);
		JPanel paymentPanel = new JPanel();
		paymentPanel.setBounds(0, 25, 560, 370);
		JPanel arrivalPanel = new JPanel();
		arrivalPanel.setBounds(0, 25, 560, 370);
		
		approvalPane.addTab("订单", orderPanel);
		approvalPane.addTab("派件单", deliverPanel);
		approvalPane.addTab("收款单", revenuePanel);
		approvalPane.addTab("中转单", new TransferPendingPanel());
		approvalPane.addTab("装车单", loadPanel);
		approvalPane.addTab("出库单", storeoutPanel);
		approvalPane.addTab("入库单", storeinPanel);
		approvalPane.addTab("付款单", paymentPanel);
		approvalPane.addTab("到达单", arrivalPanel);		
		approvalPane.setBounds(0, 0,560, 500);
		
		this.add(approvalPane);
		this.setBounds(0, 0, 560, 470);
		this.setLayout(null);
		this.setVisible(true);
	}

}
