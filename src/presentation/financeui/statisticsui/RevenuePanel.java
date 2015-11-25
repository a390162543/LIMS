package presentation.financeui.statisticsui;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import vo.RevenueVO;
import businesslogic.statisticsbl.Statistics;
import businesslogicservice.StatisticsblService;

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
        revenueScrollPane = new JScrollPane(revenueTable);
        revenueScrollPane.setBounds(0,0,560,160);
        
        this.setBounds(0, 0, 560 , 160 );
        this.setLayout(null);
        this.add(revenueScrollPane);    
    }
    
    public Double getTotalIncome(){
    	StatisticsblService sbs = new Statistics(); 	
    	return sbs.getTotalIncome(revenueVOs);
    }
}
