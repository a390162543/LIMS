package presentation.util;

 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import presentation.mainui.MainFrame;

public class ConfirmDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3853650239174813370L;
	
	private ConfirmDialog(JButton button, ActionListener actionListener){
		
		JLabel infoLabel = new JLabel("你确认删除选中的项目吗？", JLabel.CENTER);
		infoLabel.setBounds(0, 20, 250, 40);
		JButton cancleButton = new JButton("取消");
		cancleButton.setBounds(90, 75, 60, 25);
		JButton confirmButton = new JButton("确定");
		confirmButton.setBounds(160, 75, 60, 25);
		

		

 
		confirmButton.addActionListener(actionListener);
		
		
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConfirmDialog.this.dispose();
 
			}
		});
		
		cancleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConfirmDialog.this.dispose();
 
			}
		});
		
		this.add(infoLabel);
		this.add(cancleButton);
		this.add(confirmButton);
		this.setLayout(null);
		this.setSize(250, 150);
		ConfirmDialog.this.setVisible(true);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setLocationRelativeTo(MainFrame.getMainFrame());
		 
	}
	 public static void createConfirmDialog(JButton button, ActionListener actionListener){
		 new ConfirmDialog(button, actionListener);
	 }
}
