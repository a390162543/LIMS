package presentation.financeui.statisticsui;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import presentation.util.PresentationUtil;
import vo.RevenueVO;
import businesslogic.BusinessLogicService;
import businesslogicservice.StatisticsblService;
/**
 * {@code RevenuePanel}继承{@code JPanel}，是已通过审批的收款单的界面层面板展示
 * @author 刘德宽
 *
 */
public class RevenuePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2759549654404930030L;
private JScrollPane revenueScrollPane;
	
	private JTable revenueTable;
    private RevenueTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;
    private List<RevenueVO> revenueVOs;
    public RevenuePanel(List<RevenueVO> vos){
    	revenueVOs = vos;
    	tableModel = new RevenueTableModel(vos);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        revenueTable = new JTable(tableModel);
        revenueTable.setSize(930, 160);
      
        revenueScrollPane = new JScrollPane(revenueTable);
        revenueScrollPane.setBounds(0,0,560,160);
        revenueTable.setRowSorter(tableSorter);
		PresentationUtil.fitTableColumns(revenueTable);
        
        this.setBounds(0, 0, 560 , 160 );
        this.setLayout(null);
        this.add(revenueScrollPane);    
    }
    
    public Double getTotalIncome(){
    	StatisticsblService sbs = BusinessLogicService.getStatisticsblService(); 	
    	return sbs.getTotalIncome(revenueVOs);
    }
    
    public JTable getTable(){
    	return revenueTable;
    }
}
