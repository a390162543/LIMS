package presentation.managerui;

 
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

 

import presentation.financeui.statisticsui.StatisticsDialog;
import presentation.managerui.approvalui.ApprovalPanel;
import presentation.managerui.cityui.CreateCityDialog;
import presentation.managerui.cityui.QueryDistanceDialog;
import presentation.managerui.constantui.PriceDialog;
import presentation.managerui.employeeui.EmployeePanel;
import presentation.managerui.organizationui.OrganizationPanel;
 

 
/**
 * 总经理的业务界面
 * @author 刘航伸
 * @version 1.2
 */
public class ManagerPanel  extends JPanel{
	
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 9202445863891069079L;
	 
 
//	private JButton querypriceButotn;
//	private JButton queryDistanceButton;
//	private JButton approvalButton;
//	private JButton employeeButton;
//	private JButton organizationButton;
//	private JButton paymentButton;
// 
	
	
	public ManagerPanel() {
		
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        
        tabbedPane.addTab(" 成本管理  ", null);
        tabbedPane.addTab("新增城市 ", null);
        tabbedPane.addTab("查询距离", null);
        tabbedPane.addTab("查询价格", null);
        tabbedPane.addTab("审批单据", null);
        tabbedPane.addTab("机构管理", null );
        tabbedPane.addTab("员工管理", null);
        tabbedPane.setBounds(0, 30, 800, 480);
        this.add(tabbedPane);
        tabbedPane.setSelectedIndex(-1);
        tabbedPane.addChangeListener(new ChangeListener() {
            
            @Override
            public void stateChanged(ChangeEvent e) {
                int index = tabbedPane.getSelectedIndex();
                if(index<=3 && index >= 1)
                    tabbedPane.setSelectedIndex(-1);
                switch (index) {
                case 0:
                	new StatisticsDialog(tabbedPane, 0);
                    break;
                case 1:
                	new CreateCityDialog();
                    break;
                case 2:
                	new QueryDistanceDialog();
                    break;
                case 3:
                   new PriceDialog();
                    break;
                case 4:
                	tabbedPane.setComponentAt(index, new ApprovalPanel());
                	break;
                case 5:
                	tabbedPane.setComponentAt(index, new OrganizationPanel());
                	break;
                case 6:
                	tabbedPane.setComponentAt(index, new EmployeePanel());
                default:
                    break;
                }
            }
        });
        
        this.setSize(800, 540);
        this.setLayout(null);
		// TODO Auto-generated constructor stub
//		JPanel mainPanel = new JPanel();
//		mainPanel.setBounds(200, 50, 560, 450);
//		mainPanel.setLayout(null);
//		this.setSize(800, 540);
//		int buttonWidth = 150;
//		int buttonHeight = 40;	
//		
//		paymentButton = new JButton("成本管理");
//		paymentButton.setBounds(30, 70, buttonWidth, buttonHeight);
//		paymentButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				new StatisticsDialog(mainPanel);
//				 ManagerPanel.this.repaint();
//			}
//		});
//		 
//		
//		JButton addCityButton = new JButton("新增城市");
//		addCityButton.setBounds(30, 130, buttonWidth, buttonHeight);
//		addCityButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				new CreateCityDialog();
//				 ManagerPanel.this.repaint();
//			}
//		});
//		
//		querypriceButotn = new JButton("查询价格");
//		querypriceButotn.setBounds(30, 250, buttonWidth, buttonHeight);
//		querypriceButotn.addActionListener(new ActionListener(){
//
//			
//			  @Override
//			  public void actionPerformed(ActionEvent e){
//				  new PriceDialog();
//				  ManagerPanel.this.repaint();
//			  }
//		});
//		
//		queryDistanceButton = new JButton("查询距离");
//		queryDistanceButton.setBounds(30,190,buttonWidth,buttonHeight);
//		queryDistanceButton.addActionListener(new ActionListener(){
//
//
//			
//			  @Override
//			  public void actionPerformed(ActionEvent e){
//				   
//				  new QueryDistanceDialog();
//				  ManagerPanel.this.repaint();
//			  }
//		});
//		
//		approvalButton = new JButton("审批单据");
//		approvalButton.setBounds(30, 310, buttonWidth, buttonHeight);
//		approvalButton.addActionListener(new ActionListener(){
//
//			
//			  @Override
//			  public void actionPerformed(ActionEvent e){
//				 mainPanel.removeAll();
//				 mainPanel.add(new ApprovalPanel());
//				 mainPanel.repaint();
//			  }
//		});
//		
//		
//		employeeButton = new JButton("员工管理");
//		employeeButton.setBounds(30, 430, buttonWidth, buttonHeight);
//		employeeButton.addActionListener(new ActionListener(){
//
//			
//			  @Override
//			  public void actionPerformed(ActionEvent e){
//				 mainPanel.removeAll();
//				 mainPanel.add(new EmployeePanel());
//				 mainPanel.repaint();
//			  }
//		});
//		
//			
//		organizationButton = new JButton("机构管理");
//		organizationButton.setBounds(30, 370, buttonWidth, buttonHeight);
//		organizationButton.addActionListener(new ActionListener(){		
//			  @Override
//			  public void actionPerformed(ActionEvent e){
//				 mainPanel.removeAll();
//				 mainPanel.add(new OrganizationPanel());
//				 mainPanel.repaint();
//			  }
//		});
//		
//		this.setLayout(null);
//		this.add(addCityButton);
//		this.add(querypriceButotn);
//		this.add(queryDistanceButton);
//		this.add(approvalButton);
//		this.add(employeeButton);
//		this.add(organizationButton);	 
//		this.add(paymentButton);
//		this.add(mainPanel);
		

    }

	 
	 
	 
	 
	 
}
