package presentation.mainui;

 
import javax.swing.JFrame;

import presentation.systemmanagerui.PersonInfoPanel;
 

 

public class MainFrame  {

	 private static JFrame mainFrame;
 
	
	public MainFrame(){
		mainFrame = new JFrame();
		mainFrame.getContentPane().add(new StatePanel());
		mainFrame.getContentPane().add(new PersonInfoPanel());
	
		mainFrame.setBounds(100, 100, 780, 540 + 35 );
		mainFrame.getContentPane().setLayout(null);
		mainFrame.repaint();
		mainFrame.setVisible(true);	
		mainFrame.setLocationRelativeTo(null);
	}
	
	public static JFrame getMainFrame(){
		return mainFrame;
	}
	
	
}
