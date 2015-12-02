package presentation.financeui.primeinfoui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import presentation.financeui.primeinfoui.primeinfoaccount.PrimeInfoAccountPanel;
import businesslogic.primeinfobl.PrimeInfo;
import businesslogicservice.PrimeInfoblService;


public class PrimeInfoPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5816655519200291427L;
	
	public PrimeInfoPanel(JPanel panel){
		panel.removeAll();
		
		int srollPaneWidth = 560;
		int scrollPaneHeight = 370;

		JScrollPane organizationScrollPane = new JScrollPane();
		organizationScrollPane.setBounds(0, 25, srollPaneWidth, scrollPaneHeight);
		JScrollPane employeeScrollPane = new JScrollPane();
		employeeScrollPane.setBounds(0, 25, srollPaneWidth, scrollPaneHeight);
		JScrollPane truckScrollPane = new JScrollPane();
		truckScrollPane.setBounds(0, 25, srollPaneWidth, scrollPaneHeight);
		JScrollPane storageScrollPane = new JScrollPane();
		storageScrollPane.setBounds(0, 25, srollPaneWidth, scrollPaneHeight);
		
		PrimeInfoblService primeInfoblService = new PrimeInfo(); 
		PrimeInfoAccountPanel primeInfoAccountPanel = new PrimeInfoAccountPanel(primeInfoblService);
		primeInfoAccountPanel.setLocation(0, 0);
//		PrimeInfoTruckPanel primeInfoTruckPanel = new PrimeInfoTruckPanel(primeInfoblService);
//		primeInfoTruckPanel.setLocation(0, 0); 
//		PrimeInfoOrganizationPanel primeInfoOrganizationPanel = new PrimeInfoOrganizationPanel(primeInfoblService);
//		primeInfoOrganizationPanel.setLocation(0, 0);
//		PrimeInfoEmpolyeePanel primeInfoEmpolyeePanel = new PrimeInfoEmpolyeePanel(primeInfoblService);
//		primeInfoEmpolyeePanel.setLocation(0, 0);
//		PrimeInfoStoreinPanel primeInfoStoreinPanel = new PrimeInfoStoreinPanel(primeInfoblService);
//		primeInfoStoreinPanel.setLocation(0, 0);
	
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("机构", organizationScrollPane);
		pane.addTab("人员", employeeScrollPane);
		pane.addTab("车辆", truckScrollPane);
		pane.addTab("库存", storageScrollPane);
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
