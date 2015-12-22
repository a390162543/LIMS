package presentation.mainui;

 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
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

public class LoginFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 495477735756978175L;
	
	private static final ImageIcon backgroundImg = 
						new ImageIcon(LoginFrame.class.getResource("image/background.png"));
	 
	public LoginFrame() {
		// TODO Auto-generated constructor stub
		
		 
		JLabel backgroundLabel = new JLabel(backgroundImg);
		backgroundLabel.setBounds(0, 0, 450, 300);
		backgroundLabel.add(new LoginPanel());
		backgroundLabel.setLayout(null);
		
		this.setBounds(300, 100, 400, 300);
		this.getContentPane().add(backgroundLabel);
		this.setUndecorated(true);
 
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

		this.setLayout(null);
		this.setVisible(true);
		
	}
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
			int i = 40;
			loginController = new LoginController();
		 
			warnLabel = new JLabel();
			warnLabel.setBounds(235, 90, 150, 25);;
		 
			JLabel idLabel = new JLabel("用户名");
			idLabel.setBounds(80, 170 - i, 80, 25);
			idField = new JTextField();
			idField.setBounds(170, 170 - i, 170, 25);
			JLabel passwordLabel = new JLabel("密码");
			passwordLabel.setBounds(80, 210 - i,80, 25);
			passwordField = new JPasswordField(16);
			passwordField.setBounds(170, 210 - i, 170, 25);
			passwordField.setEchoChar('*');
			JButton loginButton = new JButton("登录");
			loginButton.setBounds(250, 240 - 20, 90, 30);
			
			
			loginButton.addActionListener(new ActionListener() {		
			 
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					log();
				}
			});
			
			JButton queryOrderButton = new JButton("订单查询");
			queryOrderButton.setBounds(10,240 , 90, 30);
			
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
			
		 
			this.add(idField);
			this.add(warnLabel);
			this.add(idLabel);
			this.add(passwordLabel);
			this.add(passwordField);
			this.add(loginButton);
			this.add(queryOrderButton);
			this.setBounds(0, 0, 450, 300);
			this.setOpaque(false);
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
		 
			//登陆成功
			if(loginController.checkUser(id, password)){
				new MainFrame();
				LoginFrame.this.dispose();
				 switch(LoginController.getPosition().getPower()){
				 case MANAGER : 
					  
					 MainFrame.getMainFrame().getContentPane().add(new ManagerPanel());
					 MainFrame.getMainFrame().repaint();
					 break;
				case COURIER:
					 
					 MainFrame.getMainFrame().getContentPane().add(new OrderUI());
					 MainFrame.getMainFrame().repaint();
					break;
				case DRIVER:
					break;
				case FINANCIALSTAFF: 				 
					 MainFrame.getMainFrame().getContentPane().add( new FinancePanel());					
					 MainFrame.getMainFrame().repaint();
					break;
				case SELLINGBUSINESSMAN:
					 
					 MainFrame.getMainFrame().getContentPane().add(new BusinessHallPanel());
					 MainFrame.getMainFrame().repaint();
					break;
				case SENIORFINANCIALSTAFF:
					MainFrame.getMainFrame().getContentPane().add( new FinancePanel());					
					MainFrame.getMainFrame().repaint();
					break;
				case STORAGEMANAGER:
				 
					 MainFrame.getMainFrame().getContentPane().add(new StorageUI());
					 MainFrame.getMainFrame().repaint();
					break;
				case SYSTEMMANAGER:
					 
					 MainFrame.getMainFrame().getContentPane().add(new SystemManagerPanel());
					 MainFrame.getMainFrame().repaint();
					 break;
				case TRANSFERCENTREBUSINESSMAN:
				 
					 MainFrame.getMainFrame().getContentPane().add(new TransitcenterPanel());
					 MainFrame.getMainFrame().repaint();
					break;
				default:
					break;
					 
				 }
			}	
			else
				new ErrorDialog();
		 
		}
	}
	public class ErrorDialog extends JDialog{

		/**
		 * 
		 */
		private static final long serialVersionUID = -7502171616980517945L;
		
		public ErrorDialog() {
			// TODO Auto-generated constructor stub
			JLabel infoLabel = new JLabel("您输入的用户名或密码错误，请重新输入");
			infoLabel.setBounds(20, 20, 250, 40);
			JButton confirmButton = new JButton("确定");
			confirmButton.setBounds(200, 70, 70, 30);
			confirmButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ErrorDialog.this.dispose();
				}
			});
			
			this.setBounds(100, 200, 300, 150);
			this.add(infoLabel);
			this.add(confirmButton);
			this.setLayout(null);
			this.setModalityType(ModalityType.APPLICATION_MODAL);
			this.setLocationRelativeTo(LoginFrame.this);
			this.setVisible(true);
		}
		
	}

}
