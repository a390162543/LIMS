package presentation.financeui.logui;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



import vo.LogVO;

public class LogPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2071902369087985351L;

	public LogPanel(JPanel panel, List<LogVO> vos){
		panel.removeAll();
		this.setBounds(0, 110, 560, 360);

		String contents="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS"); 
		for( LogVO vo : vos)
			 contents += sdf.format( vo.getDate())+"   :   "+vo.getOpration()+"\n";
        
		JTextArea operationArea = new JTextArea(contents);
		operationArea.setEditable(true);
		operationArea.setLocation(0, 0);
		operationArea.setSize(560, 100);
		operationArea.setLineWrap(true);
		operationArea.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(operationArea);
		scrollPane.setBounds(0,0, 560, 360);	
		this.setLayout(null);
		this.add(scrollPane);
	
		panel.setLayout(null);
		panel.add(this);
		panel.repaint();
		
	}
}
