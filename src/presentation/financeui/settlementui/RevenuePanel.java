package presentation.financeui.settlementui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import businesslogic.BusinessLogicService;
import businesslogicservice.SettlementblService;
import presentation.financeui.settlementui.RevenueTableModel;
import presentation.util.PresentationUtil;
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
	public RevenuePanel(){

		SettlementblService settlementblService = BusinessLogicService.getSettlementblService();
		List<RevenueVO> vos = settlementblService.getUncommittedRevenueVO();
		tableModel = new RevenueTableModel(vos);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        revenueTable = new JTable(tableModel);       
        revenueTable.setSize(650, 390);
        scrollPane = new JScrollPane(revenueTable);
        scrollPane.setBounds(0, 40, 650, 390);
        revenueTable.setRowSorter(tableSorter);
		PresentationUtil.fitTableColumns(revenueTable);
		
        JButton setAccountButton  =  new JButton("设置收款账户");
		setAccountButton.setBounds(650-120, 440, 120, 30);
		setAccountButton.addActionListener(new SetAccountButtonActionListener());
		
		this.setLayout(null);
		this.add(scrollPane);
		this.add(setAccountButton);
		this.setBounds(0, 0,650, 430);
		this.setVisible(true);
		
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
