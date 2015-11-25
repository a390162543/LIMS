package presentation.managerui.approvalui.revenueui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class RevenuePendingPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = -6568647082099294729L;

    private JScrollPane revenuePendingScrollPane;

	private JTable revenuePendingTable;
	private RevenuePendingTableModel tableModel;
	private TableRowSorter<TableModel> tableSorter;

	private JButton approveButton;
	private JButton modifyButton;
	private JButton queryButton;
	

	public RevenuePendingPanel() {

		tableModel = new RevenuePendingTableModel();
		tableSorter = new TableRowSorter<TableModel>(tableModel);
		revenuePendingTable = new JTable(tableModel);
		revenuePendingTable.setSize(800, 500);
		revenuePendingTable.setRowSorter(tableSorter);

		revenuePendingScrollPane = new JScrollPane(revenuePendingTable);
		revenuePendingScrollPane.setBounds(0, 0, 560, 370);

		approveButton = new JButton("ÉóÅú");
		modifyButton = new JButton("ÐÞ¸Ä");
		queryButton = new JButton("ÏêÇé");

		approveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = revenuePendingTable.getSelectedRow();
				if (row == -1)
					return;
                int modelRow = revenuePendingTable.convertRowIndexToModel(row);
				tableModel.approve(modelRow);
			}
		});

		modifyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = revenuePendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = revenuePendingTable.convertRowIndexToModel(row);
				new RevenuePendingDialog(tableModel, modelRow, true);
			}
		});
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = revenuePendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = revenuePendingTable.convertRowIndexToModel(row);
				new RevenuePendingDialog(tableModel, modelRow, false);
			}
		});
		approveButton.setBounds(315, 420, 70, 30);
		modifyButton.setBounds(400, 420, 70, 30);
		queryButton.setBounds(485, 420, 70, 30);
		// set panel
		this.setBounds(0, 0, 560, 470);
		this.setLayout(null);
		this.add(revenuePendingScrollPane);
		this.add(approveButton);
		this.add(modifyButton);
		this.add(queryButton);
	}
}
