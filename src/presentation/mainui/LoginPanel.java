package presentation.mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import presentation.businesshallui.BusinessHallPanel;
import presentation.courierui.OrderUI;
import presentation.courierui.orderqueryui.OrderInfoQueryDialog;
import presentation.financeui.FinancePanel;
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
	private JTextField idField;
	private JPasswordField passwordField;
	private JLabel warnLabel;
	
	public LoginPanel(){
		loginController = new LoginController();
		JLabel infoLabel = new JLabel("物流信息管理系统");
		warnLabel = new JLabel();
		warnLabel.setBounds(235, 90, 150, 25);;
		infoLabel.setBounds(220, 10, 161, 24);
		JLabel idLabel = new JLabel("用户名");
		idLabel.setBounds(100, 114, 79, 16);
		idField = new JTextField();
		idField.setBounds(235, 114, 275, 25);
		JLabel passwordLabel = new JLabel("密码");
		passwordLabel.setBounds(100, 184, 79, 16);
		passwordField = new JPasswordField(16);
		passwordField.setBounds(235, 180, 275, 25);
		passwordField.setEchoChar('*');
		JButton loginButton = new JButton("登录");
		loginButton.setBounds(400, 240, 88, 30);
		
		
		loginButton.addActionListener(new ActionListener() {		
		 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				log();
			}
		});
		
		JButton queryOrderButton = new JButton("订单查询");
		queryOrderButton.setBounds(0,350, 98, 30);
		
		queryOrderButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OrderInfoQueryDialog();
				
			}
		});
		
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getKeyCode());
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					
					log();
				}
			}
		});
		
		this.add(infoLabel);
		this.add(idField);
		this.add(warnLabel);
		this.add(idLabel);
		this.add(passwordLabel);
		this.add(passwordField);
		this.add(loginButton);
		this.add(queryOrderButton);
		this.setBounds(100, 100, 800, 540);
		this.setLayout(null);
		this.setVisible(true);		
	}
	
	void log(){
		if(idField.getText().equals("") || passwordField.getPassword().toString().equals("")){
			warnLabel.setText("请输入用户名和密码");
			return;
		}
		String id = idField.getText();
		String password = new String(passwordField.getPassword());
	 
		if(loginController.checkUser(id, password)){
			 switch(LoginController.getPosition().getPower()){
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
		else
			warnLabel.setText("您填写的用户名或密码不正确");
	 
	}
}
