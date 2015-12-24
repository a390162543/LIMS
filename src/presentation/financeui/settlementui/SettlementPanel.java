package presentation.financeui.settlementui;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import presentation.financeui.statisticsui.RevenueTableModel;
import presentation.util.PresentationUtil;
import vo.RevenueVO;
/**
 * {@code SettlementPanel}继承{@code JPanel}，是已通过审批的收款单的界面层面板展示
 * @author 刘德宽
 *
 */
public class SettlementPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3527282890826795425L;
	private JScrollPane scrollPane ;
	private JTable revenueTable;
    private RevenueTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;

	public SettlementPanel(JTabbedPane tabbedPane,List<RevenueVO> vos){
		this.setBounds(0, 0, 560, 370);

    	tableModel = new RevenueTableModel(vos);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        revenueTable = new JTable(tableModel);
        revenueTable.setSize(930, 160);
        scrollPane = new JScrollPane(revenueTable);	
		scrollPane.setBounds(0, 0, 560, 370);
        revenueTable.setRowSorter(tableSorter);
		PresentationUtil.fitTableColumns(revenueTable);
		this.add(scrollPane);

		tabbedPane.setComponentAt(2, this);
	}
}
