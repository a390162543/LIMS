package presentation.managerui;

import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;

import javax.swing.JButton; 
import javax.swing.JPanel;

import presentation.financeui.statisticsui.StatisticsDialog;
import presentation.managerui.approvalui.ApprovalPanel;
import presentation.managerui.cityui.CreateCityDialog;
import presentation.managerui.cityui.QueryDistanceDialog;
import presentation.managerui.constantui.PriceDialog;
import presentation.managerui.employeeui.EmployeePanel;
import presentation.managerui.organizationui.OrganizationPanel;
 

 
/**
 * �ܾ����ҵ�����
 * @author ������
 * @version 1.2
 */
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
	private JButton paymentButton;
 
	
	
	public ManagerPanel() {
		// TODO Auto-generated constructor stub
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(200, 50, 560, 450);
		mainPanel.setLayout(null);
		this.setSize(800, 540);
		int buttonWidth = 150;
		int buttonHeight = 40;	
		
		paymentButton = new JButton("�ɱ�����");
		paymentButton.setBounds(30, 70, buttonWidth, buttonHeight);
		paymentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new StatisticsDialog(mainPanel);
				 ManagerPanel.this.repaint();
			}
		});
		 
		
		JButton addCityButton = new JButton("��������");
		addCityButton.setBounds(30, 130, buttonWidth, buttonHeight);
		addCityButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreateCityDialog();
				 ManagerPanel.this.repaint();
			}
		});
		
		querypriceButotn = new JButton("��ѯ�۸�");
		querypriceButotn.setBounds(30, 250, buttonWidth, buttonHeight);
		querypriceButotn.addActionListener(new ActionListener(){

			
			  @Override
			  public void actionPerformed(ActionEvent e){
				  new PriceDialog();
				  ManagerPanel.this.repaint();
			  }
		});
		
		queryDistanceButton = new JButton("��ѯ����");
		queryDistanceButton.setBounds(30,190,buttonWidth,buttonHeight);
		queryDistanceButton.addActionListener(new ActionListener(){


			
			  @Override
			  public void actionPerformed(ActionEvent e){
				   
				  new QueryDistanceDialog();
				  ManagerPanel.this.repaint();
			  }
		});
		
		approvalButton = new JButton("��������");
		approvalButton.setBounds(30, 310, buttonWidth, buttonHeight);
		approvalButton.addActionListener(new ActionListener(){

			
			  @Override
			  public void actionPerformed(ActionEvent e){
				 mainPanel.removeAll();
				 mainPanel.add(new ApprovalPanel());
				 mainPanel.repaint();
			  }
		});
		
		
		employeeButton = new JButton("Ա������");
		employeeButton.setBounds(30, 430, buttonWidth, buttonHeight);
		employeeButton.addActionListener(new ActionListener(){

			
			  @Override
			  public void actionPerformed(ActionEvent e){
				 mainPanel.removeAll();
				 mainPanel.add(new EmployeePanel());
				 mainPanel.repaint();
			  }
		});
		
			
		organizationButton = new JButton("��������");
		organizationButton.setBounds(30, 370, buttonWidth, buttonHeight);
		organizationButton.addActionListener(new ActionListener(){		
			  @Override
			  public void actionPerformed(ActionEvent e){
				 mainPanel.removeAll();
				 mainPanel.add(new OrganizationPanel());
				 mainPanel.repaint();
			  }
		});
		
		this.setLayout(null);
		this.add(addCityButton);
		this.add(querypriceButotn);
		this.add(queryDistanceButton);
		this.add(approvalButton);
		this.add(employeeButton);
		this.add(organizationButton);	 
		this.add(paymentButton);
		this.add(mainPanel);
	 
	}
	 
	 
	 
}
