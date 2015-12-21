package presentation.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ConfirmDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3853650239174813370L;
	
	public ConfirmDialog(JButton button, ActionListener actionListener){
		JLabel infoLabel = new JLabel("确认删除");
		infoLabel.setBounds(100, 50, 60, 40);
		JButton cancleButton = new JButton("取消");
		cancleButton.setBounds(50, 120, 70, 30);
		JButton confirmButton = new JButton("确定");
		confirmButton.setBounds(130, 120, 70, 30);
		
		cancleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConfirmDialog.this.dispose();
			}
		});
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConfirmDialog.this.setVisible(true);
			}
		});
		confirmButton.addActionListener(actionListener);
		
		this.add(infoLabel);
		this.add(cancleButton);
		this.add(confirmButton);
		this.setLayout(null);
		this.setSize(200, 200);
		
	}

}
