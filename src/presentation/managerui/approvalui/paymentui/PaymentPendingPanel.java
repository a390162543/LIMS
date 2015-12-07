package presentation.managerui.approvalui.paymentui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 * {@code PaymentPendingPanel}继承{@code JPanel}，是显示待审批付款单和对待审批付款单操作的界面层面板展示
 * @author 刘德宽
 *
 */
public class PaymentPendingPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7484946635994357212L;
	private JScrollPane paymentPendingScrollPane;

	private JTable paymentPendingTable;
	private PaymentPendingTableModel tableModel;
	private TableRowSorter<TableModel> tableSorter;

	private JButton pendingButton;
	private JButton modifyButton;
	private JButton queryButton;

	public PaymentPendingPanel() {

		tableModel = new PaymentPendingTableModel();
		tableSorter = new TableRowSorter<TableModel>(tableModel);
		paymentPendingTable = new JTable(tableModel);
		paymentPendingTable.setSize(800, 500);
		paymentPendingTable.setRowSorter(tableSorter);

		paymentPendingScrollPane = new JScrollPane(paymentPendingTable);
		paymentPendingScrollPane.setBounds(0, 40, 560, 370);

		pendingButton = new JButton("审批");
		modifyButton = new JButton("修改");
		queryButton = new JButton("详情");

		pendingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = paymentPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = paymentPendingTable.convertRowIndexToModel(row);
				tableModel.approve(modelRow);
			}
		});

		modifyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = paymentPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = paymentPendingTable.convertRowIndexToModel(row);
				new PaymentPendingDialog(tableModel, modelRow, true);
			}
		});
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = paymentPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = paymentPendingTable.convertRowIndexToModel(row);
				new PaymentPendingDialog(tableModel, modelRow, false);
			}
		});
		pendingButton.setBounds(315, 420, 70, 30);
		modifyButton.setBounds(400, 420, 70, 30);
		queryButton.setBounds(485, 420, 70, 30);
		// set panel
		this.setBounds(0, 0, 560, 470);
		this.setLayout(null);
		this.add(paymentPendingScrollPane);
		this.add(pendingButton);
		this.add(modifyButton);
		this.add(queryButton);
	}
}
