package presentation.managerui.approvalui.loadui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class LoadPendingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1042686549521102708L;

	private JScrollPane loadPendingScrollPane;

	private JTable loadPendingTable;
	private LoadPendingTableModel tableModel;
	private TableRowSorter<TableModel> tableSorter;

	private JButton approveButton;
	private JButton modifyButton;
	private JButton queryButton;
	

	public LoadPendingPanel() {

		tableModel = new LoadPendingTableModel();
		tableSorter = new TableRowSorter<TableModel>(tableModel);
		loadPendingTable = new JTable(tableModel);
		loadPendingTable.setSize(800, 500);
		loadPendingTable.setRowSorter(tableSorter);

		loadPendingScrollPane = new JScrollPane(loadPendingTable);
		loadPendingScrollPane.setBounds(0, 0, 560, 370);

		approveButton = new JButton("ÉóÅú");
		modifyButton = new JButton("ÐÞ¸Ä");
		queryButton = new JButton("ÏêÇé");

		approveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = loadPendingTable.getSelectedRow();
				if (row == -1)
					return;
                int modelRow = loadPendingTable.convertRowIndexToModel(row);
				tableModel.approve(modelRow);
			}
		});

		modifyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = loadPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = loadPendingTable.convertRowIndexToModel(row);
				new LoadPendingDialog(tableModel, modelRow, true);
			}
		});
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = loadPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = loadPendingTable.convertRowIndexToModel(row);
				new LoadPendingDialog(tableModel, modelRow, false);
			}
		});
		approveButton.setBounds(315, 420, 70, 30);
		modifyButton.setBounds(400, 420, 70, 30);
		queryButton.setBounds(485, 420, 70, 30);
		// set panel
		this.setBounds(0, 0, 560, 470);
		this.setLayout(null);
		this.add(loadPendingScrollPane);
		this.add(approveButton);
		this.add(modifyButton);
		this.add(queryButton);
	}
}
