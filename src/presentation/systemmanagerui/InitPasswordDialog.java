package presentation.systemmanagerui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
 
import javax.swing.JTextField;

import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.userinfo.UserId;
import businesslogic.userbl.User;
import businesslogicservice.UserblService;

public class InitPasswordDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6998132242135722023L;
	
	private UserblService userblService;
	private Checker idChecker;
	
	public InitPasswordDialog(){
		userblService = new User();
	 
		
		JLabel idLabel = new JLabel("用户帐号");
		idLabel.setBounds(20, 20, 70, 30);
		JTextField idField = new JTextField();
		idField.setBounds(100, 20, 180, 20);
		
		JButton canceldButton = new JButton("取消");
		canceldButton.setBounds(195, 60, 70, 30);
		canceldButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InitPasswordDialog.this.dispose();
			}
		});
		
		JButton sureButton = new JButton("确认");
		sureButton.setBounds(280, 60, 70, 30);
		sureButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(idChecker.check())	{
					userblService.initialize(idField.getText());
					InitPasswordDialog.this.dispose();
				}
					
			}
		});
		
		 
		this.add(idLabel);
		this.add(idField);
		this.add(canceldButton);
		this.add(sureButton);
		this.setBounds(400, 300, 380, 150);
		this.setLayout(null);
		this.setVisible(true);
		
		//添加检查项
		idChecker = new Checker(idField,new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(idField.getText() == null){
					return null;
				}
				else{
					return new UserId(idField.getText());
				}
				 
			}
		});
	}
}
