package presentation.mainui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * ×´Ì¬Ãæ°å
 * @author Áõº½Éì
 *
 */
public class StatePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1862337458325424892L;
	
	private JLabel backgroundLanel;
	private static JLabel infoLanel;
	private static final ImageIcon backgroundImg = 
			new ImageIcon(StatePanel.class.getResource("image/label.png"));
	public StatePanel() {
		// TODO Auto-generated constructor stub
		infoLanel = new JLabel();
		infoLanel.setBounds(5, 0, 100, 25);
		infoLanel.setOpaque(false);
		infoLanel.setText("±£´æ³É¹¦");
		
		backgroundLanel = new JLabel(backgroundImg );
		backgroundLanel.setBounds(0, 0, 800, 26);
		backgroundLanel.add(infoLanel);
		backgroundLanel.setLayout(null);
		
		

		
		this.add(backgroundLanel);
		
		this.setBounds(-5, 515, 800, 25);
		this.setLayout(null);
		this.setVisible(true);
	 
		 
	
	}
	
	public static void setInfo(String s){
		infoLanel.setText(s);
	}

}
