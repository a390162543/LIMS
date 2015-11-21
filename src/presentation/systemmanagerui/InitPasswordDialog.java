package presentation.systemmanagerui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
 
import javax.swing.JTextField;

import businesslogic.userbl.User;
import businesslogicservice.UserblService;

public class InitPasswordDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6998132242135722023L;
	
	private UserblService userblService;
	
	public InitPasswordDialog(){
		userblService = new User();
		JLabel infoLabel = new JLabel("初始化密码");
		infoLabel.setBounds(110, 10, 170, 35);
		JLabel idLabel = new JLabel("用户帐号");
		idLabel.setBounds(195, 125, 70, 30);
		JTextField idField = new JTextField();
		idField.setBounds(160, 65, 180, 20);
		
		JButton canceldButton = new JButton("取消");
		canceldButton.setBounds(195, 125, 70, 30);
		canceldButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InitPasswordDialog.this.dispose();
			}
		});
		
		JButton sureButton = new JButton();
		sureButton.setBounds(280, 175, 70, 30);
		sureButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(userblService.find(idField.getText()) != null)					
					userblService.initialize(idField.getText());
			}
		});
		
		this.add(infoLabel);
		this.add(idLabel);
		this.add(idField);
		this.add(canceldButton);
		this.add(sureButton);
		this.setBounds(0, 0, 380, 180);
		this.setLayout(null);
		this.setVisible(true);
	}
}
