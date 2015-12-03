package presentation.transitcenterui.transferui;

 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TransferPendingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1042686549521102708L;

	private JScrollPane transferPendingScrollPane;

	private JTable transferPendingTable;
	private TransferPendingTableModel tableModel;
	private TableRowSorter<TableModel> tableSorter;

	private JButton approveButton;
	private JButton modifyButton;
	private JButton queryButton;
	

	public TransferPendingPanel() {

		tableModel = new TransferPendingTableModel();
		tableSorter = new TableRowSorter<TableModel>(tableModel);
		transferPendingTable = new JTable(tableModel);
		transferPendingTable.setSize(800, 500);
		transferPendingTable.setRowSorter(tableSorter);

		transferPendingScrollPane = new JScrollPane(transferPendingTable);
		transferPendingScrollPane.setBounds(0, 0, 560, 370);

		approveButton = new JButton("ÉóÅú");
		modifyButton = new JButton("ÐÞ¸Ä");
		queryButton = new JButton("ÏêÇé");

		approveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = transferPendingTable.getSelectedRow();
				if (row == -1)
					return;
                int modelRow = transferPendingTable.convertRowIndexToModel(row);
				tableModel.approve(modelRow);
			}
		});

		modifyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = transferPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = transferPendingTable.convertRowIndexToModel(row);
				new TransferPendingDialog(tableModel, modelRow, true);
			}
		});
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = transferPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = transferPendingTable.convertRowIndexToModel(row);
				new TransferPendingDialog(tableModel, modelRow, false);
			}
		});
		approveButton.setBounds(315, 390, 70, 30);
		modifyButton.setBounds(400, 390, 70, 30);
		queryButton.setBounds(485, 390, 70, 30);
		// set panel
		this.setBounds(0, 0, 560, 470);
		this.setLayout(null);
		this.add(transferPendingScrollPane);
		this.add(approveButton);
		this.add(modifyButton);
		this.add(queryButton);
	}
}
