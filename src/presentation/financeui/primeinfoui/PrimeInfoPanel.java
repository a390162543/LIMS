package presentation.financeui.primeinfoui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import presentation.financeui.primeinfoui.accountui.PrimeInfoAccountPanel;
import presentation.financeui.primeinfoui.cityui.PrimeInfoCityPanel;
import presentation.financeui.primeinfoui.employeeui.PrimeInfoEmployeePanel;
import presentation.financeui.primeinfoui.orderui.PrimeInfoOrderPanel;
import presentation.financeui.primeinfoui.organizationui.PrimeInfoOrganizationPanel;
import presentation.financeui.primeinfoui.storeinui.PrimeInfoStoreinPanel;
import presentation.financeui.primeinfoui.truckui.PrimeInfoTruckPanel;
import businesslogic.BusinessLogicService;
import businesslogicservice.PrimeInfoblService;


public class PrimeInfoPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5816655519200291427L;
	
	public PrimeInfoPanel(JPanel panel){
		panel.removeAll();
		
		PrimeInfoblService primeInfoblService = BusinessLogicService.getPrimeInfoblService(); 

		PrimeInfoAccountPanel primeInfoAccountPanel = new PrimeInfoAccountPanel(primeInfoblService);
		primeInfoAccountPanel.setLocation(0, 0);
		PrimeInfoTruckPanel primeInfoTruckPanel = new PrimeInfoTruckPanel(primeInfoblService);
		primeInfoTruckPanel.setLocation(0, 0);
		PrimeInfoOrganizationPanel primeInfoOrganizationPanel = new PrimeInfoOrganizationPanel(primeInfoblService);
		primeInfoOrganizationPanel.setLocation(0, 0);
		PrimeInfoEmployeePanel primeInfoEmployeePanel = new PrimeInfoEmployeePanel(primeInfoblService);
		primeInfoEmployeePanel.setLocation(0, 0);
		PrimeInfoCityPanel primeInfoCityPanel = new PrimeInfoCityPanel(primeInfoblService);
		primeInfoCityPanel.setLocation(0, 0);
		PrimeInfoStoreinPanel primeInfoStoreinPanel = new PrimeInfoStoreinPanel(primeInfoblService);
		primeInfoStoreinPanel.setLocation(0, 0);
		PrimeInfoOrderPanel primeInfoOrderPanel = new PrimeInfoOrderPanel(primeInfoblService);
		primeInfoOrderPanel.setLocation(0, 0);
	
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("机构", primeInfoOrganizationPanel);
		pane.addTab("人员", primeInfoEmployeePanel);
		pane.addTab("城市", primeInfoCityPanel );
		pane.addTab("车辆", primeInfoTruckPanel);
		pane.addTab("库存", primeInfoStoreinPanel);
		pane.addTab("订单", primeInfoOrderPanel);
		pane.addTab("账户", primeInfoAccountPanel );
	
		pane.setBounds(0, 0, 560, 500);
		
		this.setLayout(null);
		this.add(pane);
		this.setBounds(0, 0, 560, 540);
		
		panel.setLayout(null);
		panel.add(this);
		panel.setVisible(true);
		panel.repaint();
		
	}
}
