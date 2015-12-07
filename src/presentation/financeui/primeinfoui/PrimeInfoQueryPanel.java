package presentation.financeui.primeinfoui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import presentation.financeui.primeinfoui.accountui.PrimeInfoAccountPanel;
import presentation.financeui.primeinfoui.employeeui.PrimeInfoEmployeePanel;
import presentation.financeui.primeinfoui.orderui.PrimeInfoOrderPanel;
import presentation.financeui.primeinfoui.organizationui.PrimeInfoOrganizationPanel;
import presentation.financeui.primeinfoui.storeinui.PrimeInfoStoreinPanel;
import presentation.financeui.primeinfoui.truckui.PrimeInfoTruckPanel;
import vo.PrimeInfoVO;

public class PrimeInfoQueryPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1644129520094516933L;
	private PrimeInfoTableModel tableModel;
	
	public PrimeInfoQueryPanel(JPanel panel ,PrimeInfoTableModel tm ,int modelRow){
		tableModel = tm;
		PrimeInfoVO primeInfoVO = tableModel.getPrimeInfoVO(modelRow);

		panel.removeAll();

		
		PrimeInfoAccountPanel primeInfoAccountPanel = new PrimeInfoAccountPanel(primeInfoVO.getAccount());
		primeInfoAccountPanel.setLocation(0, 0);
		PrimeInfoTruckPanel primeInfoTruckPanel = new PrimeInfoTruckPanel(primeInfoVO.getTruck());
		primeInfoTruckPanel.setLocation(0, 0); 
		PrimeInfoOrganizationPanel primeInfoOrganizationPanel = new PrimeInfoOrganizationPanel(primeInfoVO.getOrganization());
		primeInfoOrganizationPanel.setLocation(0, 0);
		PrimeInfoEmployeePanel primeInfoEmployeePanel = new PrimeInfoEmployeePanel(primeInfoVO.getEmployee());
		primeInfoEmployeePanel.setLocation(0, 0);
		PrimeInfoStoreinPanel primeInfoStoreinPanel = new PrimeInfoStoreinPanel(primeInfoVO.getStorage());
		primeInfoStoreinPanel.setLocation(0, 0);
		PrimeInfoOrderPanel primeInfoOrderPanel = new PrimeInfoOrderPanel(primeInfoVO.getOrder());
		primeInfoOrderPanel.setLocation(0, 0);
	
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("机构", primeInfoOrganizationPanel);
		pane.addTab("人员", primeInfoEmployeePanel);
		pane.addTab("车辆", primeInfoTruckPanel);
		pane.addTab("库存", primeInfoStoreinPanel);
		pane.addTab("订单", primeInfoOrderPanel);
		pane.addTab("账户", primeInfoAccountPanel );
		pane.setBounds(0, 0, 560, 500);


		this.add(pane);
		this.setBounds(0, 0, 560, 540);
		
		panel.setLayout(null);
		panel.add(this);
		panel.setVisible(true);
		panel.repaint();
	}
}
