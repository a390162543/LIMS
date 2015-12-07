package presentation.financeui.settlementui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import businesslogic.BusinessLogicService;
import businesslogicservice.SettlementblService;
import presentation.financeui.settlementui.RevenueTableModel;
import vo.RevenueVO;
/**
 * {@code RevenuePanel}继承{@code JPanel}，是未设置收款账户的收款单的界面层面板展示
 * @author 刘德宽
 *
 */
public class RevenuePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6891629283767178138L;
	private JScrollPane scrollPane ;
	private JTable revenueTable;
    private RevenueTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;
	public RevenuePanel(JPanel panel){
		panel.removeAll();

		SettlementblService settlementblService = BusinessLogicService.getSettlementblService();
		List<RevenueVO> vos = settlementblService.getUncommittedRevenueVO();
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
		
        JButton setAccountButton  =  new JButton("设置收款账户");
		setAccountButton.setBounds(560-120, 370+10, 120, 30);
		setAccountButton.addActionListener(new SetAccountButtonActionListener());
		
		this.setLayout(null);
		this.add(scrollPane);
		this.add(setAccountButton);
		this.setBounds(0, 40,560,370+10+30);
		this.setVisible(true);
		
		panel.setLayout(null);
		panel.add(this);
		panel.setVisible(true);
		panel.repaint();
	}
	
	class SetAccountButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
            int row = revenueTable.getSelectedRow();
            if(row == -1)
                return;
            int modelRow = revenueTable.convertRowIndexToModel(row);
			@SuppressWarnings("unused")
			SetAccountDialog setAccountDialog = new SetAccountDialog(tableModel,modelRow);
		}
		
	}
}
