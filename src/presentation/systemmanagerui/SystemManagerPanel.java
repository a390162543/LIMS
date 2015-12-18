package presentation.systemmanagerui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 管理员的业务界面
 * @author 刘航伸
 * @version 1.3
 */
public class SystemManagerPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1851486112316513054L;
	
	public SystemManagerPanel(){
		this.setBounds(0, 0, 800, 540);
		this.setLayout(null);
		JButton powerBuuon = new JButton("员工权限");
		powerBuuon.setBounds(30, 380, 150, 40);
		powerBuuon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new PowerDialog();
			}
		});
		
		JButton passWordButton = new JButton("初始化密码");
		passWordButton.setBounds(30, 440, 150, 40);
		passWordButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InitPasswordDialog();
			}
		});
		this.add(new PersonInfoPanel());
		this.add(powerBuuon);
		this.add(passWordButton);
		this.setVisible(true);
		
	}

}
