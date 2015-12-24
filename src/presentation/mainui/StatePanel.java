package presentation.mainui;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
/**
 * 状态面板
 * @author 刘航伸
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
	private JLabel timeLabel;
	public StatePanel() {
		// TODO Auto-generated constructor stub
		infoLanel = new JLabel();
		infoLanel.setBounds(5, 0, 100, 25);
		infoLanel.setOpaque(false);
		 
		timeLabel = new JLabel();
		timeLabel.setBounds(620, 0, 200, 25);
		timeLabel.setText("2015年12月21日    12:58");
		Thread timeThread = new Thread(){
			
			@Override
			public void run(){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日    HH:mm");
				timeLabel.setText(sdf.format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		timeThread.start();
		
		backgroundLanel = new JLabel(backgroundImg );
		backgroundLanel.setBounds(0, 0, 800, 26);
		backgroundLanel.add(infoLanel);
		backgroundLanel.add(timeLabel);
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
