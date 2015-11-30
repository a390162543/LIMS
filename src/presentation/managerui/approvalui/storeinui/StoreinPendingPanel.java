package presentation.managerui.approvalui.storeinui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import vo.StoreinCreateVO;
import businesslogic.orderbl.Order;
import businesslogic.storeinbl.Storein;

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
		storeinPendingScrollPane.setBounds(0, 40, 560, 370);

		pendingButton = new JButton("ÉóÅú");
		modifyButton = new JButton("ÐÞ¸Ä");
		queryButton = new JButton("ÏêÇé");

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
		pendingButton.setBounds(315, 420, 70, 30);
		modifyButton.setBounds(400, 420, 70, 30);
		queryButton.setBounds(485, 420, 70, 30);
		// set panel
		this.setBounds(0, 0, 560, 470);
		this.setLayout(null);
		this.add(storeinPendingScrollPane);
		this.add(pendingButton);
		this.add(modifyButton);
		this.add(queryButton);
	}
}
