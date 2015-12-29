package presentation.systemmanagerui;

 

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DialogLayoutManager;
import presentation.util.ScreenMessage;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.userinfo.ConfirmPassword;
import businesslogic.checkbl.userinfo.NewPassword;
import businesslogic.checkbl.userinfo.UserPassword;
import businesslogic.userbl.LoginController;
import businesslogicservice.UserblService;

public class ModifyPasswordDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 78062928285466070L;
	
	private UserblService userblService;
	private Checker passwordCheck;
	private Checker newPasswordCheck;
	private Checker confirmPassword;
	
	public ModifyPasswordDialog() {
		// TODO Auto-generated constructor stub
		userblService = BusinessLogicService.getUserblService();
		JLabel[] labels = new JLabel[3];
		JPasswordField[] fields = new JPasswordField[3];
		String[] strs  = {"原密码", "新密码", "确认新密码"};
		
		for(int i = 0; i < 3; i ++){
			labels[i] = new JLabel();
			fields[i] = new JPasswordField();
			labels[i].setBounds(20, 40 * (i+1), 70, 25);
			labels[i].setText(strs[i]);
			fields[i].setBounds(120, 40 * (i+1), 150, 25);
			fields[i].setEchoChar('*');
			this.add(labels[i]);
			this.add(fields[i]);
		}
		JButton cancelButton = new JButton("取消");
		cancelButton.setBounds(100, 190, 60, 20);
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ModifyPasswordDialog.this.dispose();
			}
		});
		
		JButton confirmButton = new JButton("确认");
		confirmButton.setBounds(180, 190, 60, 20);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean isCorrect = passwordCheck.check() & newPasswordCheck.check()
									& confirmPassword.check();
				if(isCorrect){
				 
					userblService.modifyPassword(LoginController.getEmployeeId(),
							new String(fields[1].getPassword()));
					ModifyPasswordDialog.this.dispose();
					ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
				}
			}
		});
		
		//添加检查项
		passwordCheck = new Checker(fields[0],new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(fields[0] == null){
					return null;
				}
				return new UserPassword(new String(fields[0].getPassword()), LoginController.getEmployeeId());
			}
		});
		fields[0].addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				passwordCheck.check();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		newPasswordCheck = new Checker(fields[1],new  CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(fields[1] == null){
					return null;
				}
				return new NewPassword(new String(fields[1].getPassword()));
			}
		});
		
		fields[1].addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				newPasswordCheck.check();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		confirmPassword = new Checker(fields[2],new  CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(fields[2] == null){
					return null;
				}
				return new ConfirmPassword(new String(fields[1].getPassword()), 
						new String(fields[2].getPassword()));
			}
		});
		
		fields[2].addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				confirmPassword.check();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		for(int i = 0; i < 3; i ++){
			this.add(labels[i]);
			this.add(fields[i]);
		}
		this.add(confirmButton);
		this.add(cancelButton);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
//		this.setLocationRelativeTo(MainFrame.getMainFrame());
		this.setLayout(new DialogLayoutManager());
		this.setBounds(100, 200, 350, 270);
		this.setVisible(true);
		this.setTitle("修改密码");
		this.setResizable(false);
	}

}
