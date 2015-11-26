package presentation.mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.businesshallui.BusinessHallPanel;
import presentation.courierui.OrderUI;
import presentation.financeui.FinancePanel;
import presentation.financeui.FinanceUI;
import presentation.managerui.ManagerPanel;
import presentation.storageui.StorageUI;
import presentation.systemmanagerui.SystemManagerPanel;
import presentation.transitcenterui.TransitcenterPanel;
import businesslogic.userbl.LoginController;

public class LoginPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4647764855902038670L;
	private LoginController loginController;
	public LoginPanel(){
		loginController = new LoginController();
		JLabel infoLabel = new JLabel("物流信息管理系统");
		infoLabel.setBounds(320, 110, 161, 24);
		JLabel idLabel = new JLabel("用户名");
		idLabel.setBounds(202, 214, 79, 16);
		JTextField idField = new JTextField();
		idField.setBounds(285, 210, 275, 25);
		JLabel passwordLabel = new JLabel("密码");
		passwordLabel.setBounds(201, 284, 79, 16);
		JTextField passwordField = new JTextField();
		passwordField.setBounds(285, 280, 275, 25);
		JButton loginButton = new JButton("登录");
		loginButton.setBounds(472, 340, 88, 30);
		
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = idField.getText();
				String password = passwordField.getText();
				if(loginController.checkUser(id, password)){
					 switch(LoginController.getPosition()){
					 case MANAGER : 
						 MainFrame.getMainFrame().getContentPane().removeAll();
						  MainFrame.getMainFrame().getContentPane().add(new ManagerPanel());
						  MainFrame.getMainFrame().repaint();
						  break;
					case COURIER:
						MainFrame.getMainFrame().getContentPane().removeAll();
						 MainFrame.getMainFrame().getContentPane().add(new OrderUI());
						 MainFrame.getMainFrame().repaint();
						break;
					case DRIVER:
						break;
					case FINANCIALSTAFF: 
						System.out.println("cai wu ren yuan");
						 MainFrame.getMainFrame().getContentPane().removeAll();
						 MainFrame.getMainFrame().getContentPane().add( new FinancePanel());
						
						 MainFrame.getMainFrame().repaint();
						break;
					case SELLINGBUSINESSMAN:
						MainFrame.getMainFrame().getContentPane().removeAll();
						 MainFrame.getMainFrame().getContentPane().add(new BusinessHallPanel());
						 MainFrame.getMainFrame().repaint();
						break;
					case SENIORFINANCIALSTAFF:
						break;
					case STORAGEMANAGER:
						MainFrame.getMainFrame().getContentPane().removeAll();
						 MainFrame.getMainFrame().getContentPane().add(new StorageUI());
						 MainFrame.getMainFrame().repaint();
						break;
					case SYSTEMMANAGER:
						MainFrame.getMainFrame().getContentPane().removeAll();
						 MainFrame.getMainFrame().getContentPane().add(new SystemManagerPanel());
						 MainFrame.getMainFrame().repaint();
						 break;
					case TRANSFERCENTREBUSINESSMAN:
						MainFrame.getMainFrame().getContentPane().removeAll();
						 MainFrame.getMainFrame().getContentPane().add(new TransitcenterPanel());
						 MainFrame.getMainFrame().repaint();
						break;
					default:
						break;
						 
					 }
				}				 
			}
		});
		
		JButton queryOrderButton = new JButton("订单查询");
		queryOrderButton.setBounds(20, 490, 98, 30);
		
		queryOrderButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.add(infoLabel);
		this.add(idField);
		this.add(idLabel);
		this.add(passwordLabel);
		this.add(passwordField);
		this.add(loginButton);
		this.add(queryOrderButton);
		this.setBounds(100, 100, 800, 540);
		this.setLayout(null);
		this.setVisible(true);
		
	}
}
