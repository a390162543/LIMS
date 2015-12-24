package presentation.systemmanagerui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
 

import presentation.mainui.LoginFrame;
import presentation.mainui.MainFrame;
import businesslogic.userbl.LoginController;

public class PersonInfoPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7563688584126519496L;
	
	public PersonInfoPanel(){
		String id = LoginController.getEmployeeId();
		String position = LoginController.getPosition().getName();
		String name = LoginController.getEmployeeName();
		JLabel infoLabel = new JLabel();
		
		infoLabel.setBounds(400  - 20 * position.length(), 0, 180 + 20 * position.length(), 20);
		
		
		
		infoLabel.setText(name+"("+"ID: "+id+")"+"   "+position);
		
		infoLabel.setHorizontalAlignment(JLabel.RIGHT);
		JLabel modifyPasswordLabel = new JLabel("ÐÞ¸ÄÃÜÂë");
		modifyPasswordLabel.setBounds(630, 0, 50, 20);
		modifyPasswordLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				modifyPasswordLabel.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				modifyPasswordLabel.setForeground(Color .green);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new ModifyPasswordDialog();
			}
		});
		
		JLabel logoutLabel = new JLabel("×¢ÏúµÇÂ¼");		
		logoutLabel.setBounds(700, 0, 50, 20);
		logoutLabel.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				logoutLabel.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				logoutLabel.setForeground(Color.green);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				MainFrame.getMainFrame().dispose();
				new LoginFrame();
			}
		});
		
		this.add(infoLabel);
		this.add(modifyPasswordLabel);
		this.add(logoutLabel);
		this.setBounds(0, 0, 800, 30);
		this.setLayout(null);
	}

}
