package presentation.managerui.approvalui.transferui;

 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import presentation.util.PresentationUtil;
import presentation.util.ScreenMessage;

/**
 * ������ת������
 * @author ������
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
		transferPendingScrollPane.setBounds(0, 0, 650, 390);

		toggleButton = new JToggleButton("��������");
		approveButton = new JButton("����");
		modifyButton = new JButton("�޸�");
		queryButton = new JButton("����");
		
        tableModel.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				PresentationUtil.fitTableColumns(transferPendingTable);
			}
		});
        
		PresentationUtil.fitTableColumns(transferPendingTable);
		
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
		
		toggleButton.setBounds(320, 400, 70, 30);
		approveButton.setBounds(405, 400, 70, 30);
		modifyButton.setBounds(400+90, 400, 70, 30);
		queryButton.setBounds(485+90, 400, 70, 30);
		// set panel
		this.setBounds(0, 0, 650, 470);		
		this.add(transferPendingScrollPane);
		this.add(toggleButton);
		this.add(approveButton);
		this.add(modifyButton);
		this.add(queryButton);
		this.setLayout(null);
	}
}
