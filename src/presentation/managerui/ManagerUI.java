package presentation.managerui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ManagerUI implements MouseListener {
	JButton querypriceButotn = new JButton("≤È—Øº€∏Ò");
	JFrame managerFrame = new JFrame();
	public static void main(String[] arg){
		ManagerUI managerui = new ManagerUI();
		managerui.start();
	}
	public void start(){
		int buttonWidth = 150;
		int buttonHeight = 40;
		
		
		managerFrame.setBounds(100, 50, 800, 540);
		managerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		managerFrame.setVisible(true);
		managerFrame.setLayout(null);
		
		
		querypriceButotn.setBounds(30, 190, buttonWidth, buttonHeight);
		querypriceButotn.addMouseListener(this );
		
		managerFrame.add(querypriceButotn);
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent() == querypriceButotn){
			QueryPriceDialog q =new QueryPriceDialog();
			q.show();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	 
	 
}
