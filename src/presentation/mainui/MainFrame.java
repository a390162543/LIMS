package presentation.mainui;

 
import javax.swing.JFrame;
 

 

public class MainFrame  {

	 private static JFrame mainFrame;
 
	
	public MainFrame(){
		mainFrame = new JFrame();
		mainFrame.getContentPane().add(new LoginPanel());
		mainFrame.setBounds(100, 100, 800, 540);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);		
	}
	
	public static JFrame getMainFrame(){
		return mainFrame;
	}
	
	
}
