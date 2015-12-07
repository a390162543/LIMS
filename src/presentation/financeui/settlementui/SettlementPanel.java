package presentation.financeui.settlementui;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import presentation.financeui.statisticsui.RevenueTableModel;
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

	public SettlementPanel(JPanel panel,List<RevenueVO> vos){
		panel.removeAll();
		this.setBounds(0, 40, 560, 370);

    	tableModel = new RevenueTableModel(vos);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        revenueTable = new JTable(tableModel);
        revenueTable.setSize(930, 160);
        TableColumn column = revenueTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(140);
        column.setMaxWidth(140);
        column.setMinWidth(140);
        column = revenueTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(70);
        column.setMaxWidth(70);
        column.setMinWidth(70);
        column = revenueTable.getColumnModel().getColumn(2);
        column.setPreferredWidth(140);
        column.setMaxWidth(140);
        column.setMinWidth(140);
        column = revenueTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(90);
        column.setMaxWidth(90);
        column.setMinWidth(90);
        column = revenueTable.getColumnModel().getColumn(4);
        column.setPreferredWidth(60);
        column.setMaxWidth(60);
        column.setMinWidth(60);
        column = revenueTable.getColumnModel().getColumn(5);
        column.setPreferredWidth(140);
        column.setMaxWidth(140);
        column.setMinWidth(140);
        column = revenueTable.getColumnModel().getColumn(6);
        column.setPreferredWidth(140);
        column.setMaxWidth(140);
        column.setMinWidth(140);
 
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        revenueTable.setDefaultRenderer(Object.class, tcr);
        revenueTable.setRowSorter(tableSorter);    
        revenueTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        scrollPane = new JScrollPane(revenueTable);
		
		scrollPane.setBounds(0, 0, 560, 370);
		this.add(scrollPane);

		panel.setLayout(null);
		panel.add(this);
		panel.setVisible(true);
		panel.repaint();
	}
}
