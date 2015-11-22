package presentation.financeui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class FinanceUI extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = 8711406243212445031L;

	public FinanceUI() {
		this.setSize(800+10, 540+40);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
        
        this.setContentPane(new FinancePanel());
        this.setVisible(true);

    }
}
