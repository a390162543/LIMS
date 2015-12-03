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

import businesslogic.statisticsbl.Statistics;
import businesslogicservice.StatisticsblService;
import vo.PaymentVO;

public class PaymentPanel extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4715941556745053343L;
	
	private JScrollPane paymentScrollPane;
	
	private JTable paymentTable;
    private PaymentTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;
    private List<PaymentVO> paymentVOs;
    public PaymentPanel(List<PaymentVO> vos){
    	paymentVOs = vos;
    	tableModel = new PaymentTableModel(vos);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        paymentTable = new JTable(tableModel);
        paymentTable.setSize(930, 160);
        TableColumn column = paymentTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(140);
        column.setMaxWidth(140);
        column.setMinWidth(140);
        column = paymentTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(70);
        column.setMaxWidth(70);
        column.setMinWidth(70);
        column = paymentTable.getColumnModel().getColumn(2);
        column.setPreferredWidth(90);
        column.setMaxWidth(90);
        column.setMinWidth(90);
        column = paymentTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(70);
        column.setMaxWidth(70);
        column.setMinWidth(70);
        column = paymentTable.getColumnModel().getColumn(4);
        column.setPreferredWidth(140);
        column.setMaxWidth(140);
        column.setMinWidth(140);
        column = paymentTable.getColumnModel().getColumn(5);
        column.setPreferredWidth(140);
        column.setMaxWidth(140);
        column.setMinWidth(140);
        column = paymentTable.getColumnModel().getColumn(6);
        column.setPreferredWidth(60);
        column.setMaxWidth(60);
        column.setMinWidth(60);
        column = paymentTable.getColumnModel().getColumn(7);
        column.setPreferredWidth(250);
        column.setMaxWidth(250);
        column.setMinWidth(250);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        paymentTable.setDefaultRenderer(Object.class, tcr);
        paymentTable.setRowSorter(tableSorter);    
        paymentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        paymentScrollPane = new JScrollPane(paymentTable);
        paymentScrollPane.setBounds(0,0,560,160);
        
        this.setBounds(0, 0, 560 , 160 );
        this.setLayout(null);
        this.add(paymentScrollPane);    
    }
    
    public Double getTotalExpenditure(){
    	StatisticsblService sbs = new Statistics(); 	
    	return sbs.getTotalExpenditure(paymentVOs);
    }
    
    public JTable getTable(){
    	return paymentTable;
    }
}
