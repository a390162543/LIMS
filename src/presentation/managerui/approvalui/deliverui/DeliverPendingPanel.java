package presentation.managerui.approvalui.deliverui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class DeliverPendingPanel extends JPanel {



	/**
     * 
     */
    private static final long serialVersionUID = 4846680007628719065L;

    private JScrollPane deliverPendingScrollPane;

	private JTable deliverPendingTable;
	private DeliverPendingTableModel tableModel;
	private TableRowSorter<TableModel> tableSorter;

	private JButton approveButton;
	private JButton modifyButton;
	private JButton queryButton;
	

	public DeliverPendingPanel() {

		tableModel = new DeliverPendingTableModel();
		tableSorter = new TableRowSorter<TableModel>(tableModel);
		deliverPendingTable = new JTable(tableModel);
		deliverPendingTable.setSize(800, 500);
		deliverPendingTable.setRowSorter(tableSorter);

		deliverPendingScrollPane = new JScrollPane(deliverPendingTable);
		deliverPendingScrollPane.setBounds(0, 0, 560, 370);

		approveButton = new JButton("ÉóÅú");
		modifyButton = new JButton("ÐÞ¸Ä");
		queryButton = new JButton("ÏêÇé");

		approveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = deliverPendingTable.getSelectedRow();
				if (row == -1)
					return;
                int modelRow = deliverPendingTable.convertRowIndexToModel(row);
				tableModel.approve(modelRow);
			}
		});

		modifyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = deliverPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = deliverPendingTable.convertRowIndexToModel(row);
				new DeliverPendingDialog(tableModel, modelRow, true);
			}
		});
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = deliverPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = deliverPendingTable.convertRowIndexToModel(row);
				new DeliverPendingDialog(tableModel, modelRow, false);
			}
		});
		approveButton.setBounds(315, 420, 70, 30);
		modifyButton.setBounds(400, 420, 70, 30);
		queryButton.setBounds(485, 420, 70, 30);
		// set panel
		this.setBounds(0, 0, 560, 470);
		this.setLayout(null);
		this.add(deliverPendingScrollPane);
		this.add(approveButton);
		this.add(modifyButton);
		this.add(queryButton);
	}
}
