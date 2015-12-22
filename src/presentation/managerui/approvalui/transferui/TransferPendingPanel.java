package presentation.managerui.approvalui.transferui;

 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import presentation.util.ScreenMessage;

/**
 * 审批中转单界面
 * @author 刘航伸
 * @see TransferPendingTableModel
 * @version 1.2
 */
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
	private JToggleButton toggleButton;
	ArrayList<Integer> indexes = new ArrayList<Integer>();

	public TransferPendingPanel() {

		tableModel = new TransferPendingTableModel();
		tableSorter = new TableRowSorter<TableModel>(tableModel);
		transferPendingTable = new JTable(tableModel);
		transferPendingTable.setSize(800, 500);
		transferPendingTable.setRowSorter(tableSorter);

		transferPendingScrollPane = new JScrollPane(transferPendingTable);
		transferPendingScrollPane.setBounds(0, 0, 560, 370);

		toggleButton = new JToggleButton("批量审批");
		approveButton = new JButton("审批");
		modifyButton = new JButton("修改");
		queryButton = new JButton("详情");

		
		toggleButton.addActionListener(new ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
                indexes.clear();
                transferPendingTable.clearSelection();
            }
        });
		
		approveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = transferPendingTable.getSelectedRow();
				if (row == -1)
					ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
				else{
					int indexesNum = transferPendingTable.getSelectedRowCount();
					int[] selectedRows = transferPendingTable.getSelectedRows();
					for(int i=0;i<indexesNum;i++){
						for(int j=i+1;j<indexesNum;j++){
							selectedRows[j] -= 1;
						}
						int firstSelectedRow = selectedRows[i];
						int modelRow = transferPendingTable.convertRowIndexToModel(firstSelectedRow);
						tableModel.approve(modelRow);
					}
					indexes.clear();
					transferPendingTable.clearSelection();
				 
				}
         
			}
		});

		modifyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = transferPendingTable.getSelectedRow();
				if (row == -1)
					ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
				else{
					int modelRow = transferPendingTable.convertRowIndexToModel(row);
					new TransferPendingDialog(tableModel, modelRow, true);
					 
				}
	
			}
		});
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = transferPendingTable.getSelectedRow();
				if (row == -1)
					ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
				else{
					int modelRow = transferPendingTable.convertRowIndexToModel(row);
					new TransferPendingDialog(tableModel, modelRow, false);
				}

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
