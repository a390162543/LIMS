 package presentation.managerui.approvalui;

import javax.swing.JPanel;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import presentation.managerui.approvalui.arrivalui.ArrivalPendingPanel;
import presentation.managerui.approvalui.deliverui.DeliverPendingPanel;
import presentation.managerui.approvalui.loadui.LoadPendingPanel;
import presentation.managerui.approvalui.orderui.OrderPendingPanel;
import presentation.managerui.approvalui.paymentui.PaymentPendingPanel;
import presentation.managerui.approvalui.revenueui.RevenuePendingPanel;
import presentation.managerui.approvalui.storeinui.StoreinPendingPanel;
import presentation.managerui.approvalui.storeoutui.StoreoutPendingPanel;
import presentation.managerui.approvalui.transferui.TransferPendingPanel;
 
public class ApprovalPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5845404174989335354L;
	private JTextField filterTextField;
	
	public ApprovalPanel(){
		JTabbedPane approvalPane = new JTabbedPane(JTabbedPane.TOP);
		approvalPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		 

		approvalPane.addTab("����", new OrderPendingPanel());
		approvalPane.addTab("�ɼ���", new DeliverPendingPanel());
		approvalPane.addTab("�տ", new RevenuePendingPanel());
		approvalPane.addTab("��ת��", new TransferPendingPanel());
		approvalPane.addTab("װ����",new LoadPendingPanel());
		approvalPane.addTab("���ⵥ",new StoreoutPendingPanel());
		approvalPane.addTab("��ⵥ",new StoreinPendingPanel());
		approvalPane.addTab("���", new PaymentPendingPanel());
		approvalPane.addTab("���ﵥ", new ArrivalPendingPanel());		
		approvalPane.setBounds(0, 0,560, 500);
		
		this.add(approvalPane);
		this.setBounds(0, 0, 560, 470);
		this.setLayout(null);
		this.setVisible(true);
	}

}
