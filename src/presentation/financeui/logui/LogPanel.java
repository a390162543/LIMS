package presentation.financeui.logui;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import businesslogic.BusinessLogicService;
import businesslogicservice.LogblService;
import vo.LogVO;
/**
 * {@code LogPanel}继承{@code JPanel}，是日志记录的界面层面板展示
 * @author 刘德宽
 *
 */
public class LogPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2071902369087985351L;

	public LogPanel(JTabbedPane tabbedPane, List<LogVO> vos){
		this.setBounds(0, 0, 560, 360);

		String contents="";
		LogblService logblService = BusinessLogicService.getLogblService();
		for( LogVO vo : vos)
			 contents += logblService.getLogInfo(vo);
        
		JTextArea operationArea = new JTextArea(contents);
		operationArea.setEditable(false);
		operationArea.setLocation(0, 0);
		operationArea.setSize(560, 100);
		operationArea.setLineWrap(true);
		operationArea.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(operationArea);
		scrollPane.setBounds(0,40, 650, 390);	
		this.setLayout(null);
		this.add(scrollPane);
	
		tabbedPane.setComponentAt(5, this);
		
	}
}
