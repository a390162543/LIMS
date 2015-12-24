package presentation.managerui.approvalui.loadui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
 * 审批时装车单的{@code Jpanel}，提供装车单的查看、修改、审批功能
 * @author 林祖华
 * @version 1.4
 *
 */
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
    private JToggleButton toggleButton;
    ArrayList<Integer> indexes = new ArrayList<Integer>();
	

	public LoadPendingPanel() {

		tableModel = new LoadPendingTableModel();
		tableSorter = new TableRowSorter<TableModel>(tableModel);
		loadPendingTable = new JTable(tableModel);
		loadPendingTable.setSize(800, 500);
		loadPendingTable.setRowSorter(tableSorter);

		loadPendingScrollPane = new JScrollPane(loadPendingTable);
		loadPendingScrollPane.setBounds(0, 0, 650, 390);

	    toggleButton = new JToggleButton("批量审批");
		approveButton = new JButton("审批");
		modifyButton = new JButton("修改");
		queryButton = new JButton("详情");

        toggleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                indexes.clear();
                loadPendingTable.clearSelection();
            }
        });
        approveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = loadPendingTable.getSelectedRow();
                if(row == -1){
                    ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
                    return;
                }
                int indexesNum = loadPendingTable.getSelectedRowCount();
                int[] selectedRows = loadPendingTable.getSelectedRows();
                for(int i=0;i<indexesNum;i++){
                    for(int j=i+1;j<indexesNum;j++){
                        selectedRows[j] -= 1;
                    }
                    int firstSelectedRow = selectedRows[i];
                    int modelRow = loadPendingTable.convertRowIndexToModel(firstSelectedRow);
                    tableModel.approve(modelRow);
                }
                ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
                indexes.clear();
                loadPendingTable.clearSelection();
            }
        });

		modifyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = loadPendingTable.getSelectedRow();
                if(row == -1){
                    ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
                    return;
                }
				int modelRow = loadPendingTable.convertRowIndexToModel(row);
				new LoadPendingDialog(tableModel, modelRow, true);
			}
		});
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = loadPendingTable.getSelectedRow();
                if(row == -1){
                    ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
                    return;
                }
				int modelRow = loadPendingTable.convertRowIndexToModel(row);
				new LoadPendingDialog(tableModel, modelRow, false);
			}
		});
	      loadPendingTable.addMouseListener(new MouseListener() {
	            @Override
	            public void mouseReleased(MouseEvent e) {
	                if(!toggleButton.isSelected())
	                    return;
	                int clicked = loadPendingTable.getSelectedRow();
	                if(indexes.contains(clicked)){
	                    indexes.remove(new Integer(clicked));
	                }else{
	                    indexes.add(clicked);
	                }
	                loadPendingTable.clearSelection();

	                for(int i:indexes){
	                    loadPendingTable.addRowSelectionInterval(i, i);
	                }
	            }
	            
	            @Override
	            public void mousePressed(MouseEvent e) {
	                // TODO Auto-generated method stub
	                
	            }
	            
	            @Override
	            public void mouseExited(MouseEvent e) {
	                // TODO Auto-generated method stub
	                
	            }
	            
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                // TODO Auto-generated method stub
	                
	            }
	            
	            @Override
	            public void mouseClicked(MouseEvent e) {

	            }
	        });
	        
	        
	      toggleButton.setBounds(325, 400, 70, 30);       
	      approveButton.setBounds(405, 400, 70, 30);
	      modifyButton.setBounds(490, 400, 70, 30);
	      queryButton.setBounds(575, 400, 70, 30);
		// set panel
		this.setBounds(0, 0, 650, 470);
		this.setLayout(null);
		this.add(loadPendingScrollPane);
	    this.add(toggleButton);
		this.add(approveButton);
		this.add(modifyButton);
		this.add(queryButton);
	}
}
