package presentation.managerui.approvalui.arrivalui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * ����ʱ���ﵥ��{@code Jpanel}���ṩ���ﵥ�Ĳ鿴���޸ġ���������
 * @author ���滪
 * @version 1.4
 *
 */
public class ArrivalPendingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1042686549521102708L;

	private JScrollPane arrivalPendingScrollPane;

	private JTable arrivalPendingTable;
	private ArrivalPendingTableModel tableModel;
	private TableRowSorter<TableModel> tableSorter;

	private JButton approveButton;
	private JButton modifyButton;
	private JButton queryButton;
	

	public ArrivalPendingPanel() {

		tableModel = new ArrivalPendingTableModel();
		tableSorter = new TableRowSorter<TableModel>(tableModel);
		arrivalPendingTable = new JTable(tableModel);
		arrivalPendingTable.setSize(800, 500);
		arrivalPendingTable.setRowSorter(tableSorter);

		arrivalPendingScrollPane = new JScrollPane(arrivalPendingTable);
		arrivalPendingScrollPane.setBounds(0, 0, 560, 370);

		approveButton = new JButton("����");
		modifyButton = new JButton("�޸�");
		queryButton = new JButton("����");

		approveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = arrivalPendingTable.getSelectedRow();
				if (row == -1)
					return;
                int modelRow = arrivalPendingTable.convertRowIndexToModel(row);
				tableModel.approve(modelRow);
			}
		});

		modifyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = arrivalPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = arrivalPendingTable.convertRowIndexToModel(row);
				new ArrivalPendingDialog(tableModel, modelRow, true);
			}
		});
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = arrivalPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = arrivalPendingTable.convertRowIndexToModel(row);
				new ArrivalPendingDialog(tableModel, modelRow, false);
			}
		});
        approveButton.setBounds(315, 390, 70, 30);
        modifyButton.setBounds(400, 390, 70, 30);
        queryButton.setBounds(485, 390, 70, 30);
		// set panel
		this.setBounds(0, 0, 560, 470);
		this.setLayout(null);
		this.add(arrivalPendingScrollPane);
		this.add(approveButton);
		this.add(modifyButton);
		this.add(queryButton);
	}
}
