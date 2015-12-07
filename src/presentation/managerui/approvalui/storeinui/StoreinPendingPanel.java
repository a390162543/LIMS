package presentation.managerui.approvalui.storeinui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 * 这是总经理审批入库单时显示在界面上的面板
 * @author lc
 * @version 1.3
 *
 */
public class StoreinPendingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1042686549521102708L;

	private JScrollPane storeinPendingScrollPane;

	private JTable storeinPendingTable;
	private StoreinPendingTableModel tableModel;
	private TableRowSorter<TableModel> tableSorter;

	private JButton pendingButton;
	private JButton modifyButton;
	private JButton queryButton;

	public StoreinPendingPanel() {

		tableModel = new StoreinPendingTableModel();
		tableSorter = new TableRowSorter<TableModel>(tableModel);
		storeinPendingTable = new JTable(tableModel);
		storeinPendingTable.setSize(800, 500);
		storeinPendingTable.setRowSorter(tableSorter);

		storeinPendingScrollPane = new JScrollPane(storeinPendingTable);
		storeinPendingScrollPane.setBounds(0, 0, 560, 370);

		pendingButton = new JButton("审批");
		modifyButton = new JButton("修改");
		queryButton = new JButton("详情");

		pendingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = storeinPendingTable.getSelectedRow();
				if (row == -1)
					return;
				tableModel.approve(row);
			}
		});

		modifyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = storeinPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = storeinPendingTable.convertRowIndexToModel(row);
				new StoreinPendingDialog(tableModel, modelRow, true);
			}
		});
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = storeinPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = storeinPendingTable.convertRowIndexToModel(row);
				new StoreinPendingDialog(tableModel, modelRow, false);
			}
		});
		pendingButton.setBounds(315, 390, 70, 30);
		modifyButton.setBounds(400, 390, 70, 30);
		queryButton.setBounds(485, 390, 70, 30);
		// set panel
		this.setBounds(0, 0, 560, 470);
		this.setLayout(null);
		this.add(storeinPendingScrollPane);
		this.add(pendingButton);
		this.add(modifyButton);
		this.add(queryButton);
	}
}
