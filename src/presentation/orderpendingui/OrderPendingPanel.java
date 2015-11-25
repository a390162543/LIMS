package presentation.orderpendingui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import businesslogic.orderbl.Order;

public class OrderPendingPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -557553077145656777L;

	private JScrollPane orderPendingScrollPane;

	private JTable orderPendingTable;
	private OrderPendingTableModel tableModel;
	private TableRowSorter<TableModel> tableSorter;

	private JButton pendingButton;
	private JButton modifyButton;
	private JButton queryButton;

	public OrderPendingPanel() {

		tableModel = new OrderPendingTableModel();
		tableSorter = new TableRowSorter<TableModel>(tableModel);
		orderPendingTable = new JTable(tableModel);
		orderPendingTable.setSize(800, 500);
		orderPendingTable.setRowSorter(tableSorter);

		orderPendingScrollPane = new JScrollPane(orderPendingTable);
		orderPendingScrollPane.setBounds(0, 40, 560, 370);

		pendingButton = new JButton("ÉóÅú");
		modifyButton = new JButton("ÐÞ¸Ä");
		queryButton = new JButton("ÏêÇé");

		pendingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = orderPendingTable.getSelectedRow();
				if (row == -1)
					return;
				tableModel.approve(row);
			}
		});

		modifyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = orderPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = orderPendingTable.convertRowIndexToModel(row);
				new OrderPendingDialog(tableModel, modelRow, true);
			}
		});
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = orderPendingTable.getSelectedRow();
				if (row == -1)
					return;
				int modelRow = orderPendingTable.convertRowIndexToModel(row);
				new OrderPendingDialog(tableModel, modelRow, false);
			}
		});
		pendingButton.setBounds(315, 420, 70, 30);
		modifyButton.setBounds(400, 420, 70, 30);
		queryButton.setBounds(485, 420, 70, 30);
		// set panel
		this.setBounds(0, 0, 560, 470);
		this.setLayout(null);
		this.add(orderPendingScrollPane);
		this.add(pendingButton);
		this.add(modifyButton);
		this.add(queryButton);

	}
	

}
