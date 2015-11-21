package presentation.managerui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 




import javax.swing.JButton;
 
import javax.swing.JPanel;

import presentation.managerui.cityui.QueryDistanceDialog;
import presentation.managerui.employeeui.EmployeePanel;
import presentation.managerui.organizationui.OrganizationPanel;

 

public class ManagerPanel  extends JPanel{
	
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 9202445863891069079L;
	 
 
	private JButton querypriceButotn;
	private JButton queryDistanceButton;
	private JButton approvalButton;
	private JButton employeeButton;
	private JButton organizationButton;
	 
	
	
	public ManagerPanel() {
		// TODO Auto-generated constructor stub
		 
		this.setSize(800, 600);
		int buttonWidth = 150;
		int buttonHeight = 40;	
		querypriceButotn = new JButton("查询价格");
		querypriceButotn.setBounds(30, 250, buttonWidth, buttonHeight);
		querypriceButotn.addActionListener(new ActionListener(){

			
			  @Override
			  public void actionPerformed(ActionEvent e){
				  
			  }
		});
		
		queryDistanceButton = new JButton("查询距离");
		queryDistanceButton.setBounds(30,190,buttonWidth,buttonHeight);
		queryDistanceButton.addActionListener(new ActionListener(){


			
			  @Override
			  public void actionPerformed(ActionEvent e){
				  new QueryDistanceDialog();
			  }
		});
		
		approvalButton = new JButton("审批单据");
		approvalButton.setBounds(30, 310, buttonWidth, buttonHeight);
		approvalButton.addActionListener(new ActionListener(){

			
			  @Override
			  public void actionPerformed(ActionEvent e){
				  
			  }
		});
		
		
		employeeButton = new JButton("员工管理");
		employeeButton.setBounds(30, 430, buttonWidth, buttonHeight);
		employeeButton.addActionListener(new ActionListener(){

			
			  @Override
			  public void actionPerformed(ActionEvent e){
				 ManagerPanel.this.add(new EmployeePanel());
			  }
		});
		
			
		organizationButton = new JButton("机构管理");
		organizationButton.setBounds(30, 370, buttonWidth, buttonHeight);
		organizationButton.addActionListener(new ActionListener(){		
			  @Override
			  public void actionPerformed(ActionEvent e){
				 ManagerPanel.this.add(new OrganizationPanel());
			  }
		});
		
		
		this.add(querypriceButotn);
		this.add(queryDistanceButton);
		this.add(approvalButton);
		this.add(employeeButton);
		this.add(organizationButton);
	}
	 
	 
	 
}
