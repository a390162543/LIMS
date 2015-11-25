package presentation.storeoutpendingui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import businesslogic.storeoutbl.Storeout;


public class StoreoutPendingPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2807223502785855006L;

	private JScrollPane storeoutPendingScrollPane;

	private JTable storeoutPendingTable;
	private StoreoutPendingTableModel tableModel;
	private TableRowSorter<TableModel> tableSorter;

	private JButton pendingButton;
	private JButton modifyButton;
	private JButton queryButton;

	public StoreoutPendingPanel() {

		tableModel = new StoreoutPendingTableModel();
		tableSorter = new TableRowSorter<TableModel>(tableModel);
		storeoutPendingTable = new JTable(tableModel);
		storeoutPendingTable.setSize(800, 500);
		storeoutPendingTable.setRowSorter(tableSorter);

		storeoutPendingScrollPane = new JScrollPane(storeoutPendingTable);
		storeoutPendingScrollPane.setBounds(0, 40, 560, 370);

		pendingButton = new JButton("ÉóÅú");
		modifyButton = new JButton("ÐÞ¸Ä");
		queryButton = new JButton("ÏêÇé");

		pendingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = storeoutPendingTable.getSelectedRow();
				if (row == -1)
					return;
				tableModel.approve(row);
			}
		});

		modifyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = storeoutPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = storeoutPendingTable.convertRowIndexToModel(row);
				new StoreoutPendingDialog(tableModel, modelRow, true);
			}
		});
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = storeoutPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = storeoutPendingTable.convertRowIndexToModel(row);
				new StoreoutPendingDialog(tableModel, modelRow, false);
			}
		});
		pendingButton.setBounds(315, 420, 70, 30);
		modifyButton.setBounds(400, 420, 70, 30);
		queryButton.setBounds(485, 420, 70, 30);
		// set panel
		this.setBounds(0, 0, 560, 470);
		this.setLayout(null);
		this.add(storeoutPendingScrollPane);
		this.add(pendingButton);
		this.add(modifyButton);
		this.add(queryButton);
	}
}
