package presentation.managerui.approvalui.arrivalui;

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
 * 审批时到达单的{@code Jpanel}，提供到达单的查看、修改、审批功能
 * @author 林祖华
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
    private JToggleButton toggleButton;
    ArrayList<Integer> indexes = new ArrayList<Integer>();
	
	public ArrivalPendingPanel() {

		tableModel = new ArrivalPendingTableModel();
		tableSorter = new TableRowSorter<TableModel>(tableModel);
		arrivalPendingTable = new JTable(tableModel);
		arrivalPendingTable.setSize(800, 500);
		arrivalPendingTable.setRowSorter(tableSorter);

		arrivalPendingScrollPane = new JScrollPane(arrivalPendingTable);
		arrivalPendingScrollPane.setBounds(0, 0, 560, 370);

		toggleButton = new JToggleButton("批量审批");
		approveButton = new JButton("审批");
		modifyButton = new JButton("修改");
		queryButton = new JButton("详情");

		toggleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                indexes.clear();
                arrivalPendingTable.clearSelection();
            }
        });
		approveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = arrivalPendingTable.getSelectedRow();
                if(row == -1){
                    ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
                    return;
                }
				int indexesNum = arrivalPendingTable.getSelectedRowCount();
				int[] selectedRows = arrivalPendingTable.getSelectedRows();
				for(int i=0;i<indexesNum;i++){
				    for(int j=i+1;j<indexesNum;j++){
				        selectedRows[j] -= 1;
				    }
				    int firstSelectedRow = selectedRows[i];
                    int modelRow = arrivalPendingTable.convertRowIndexToModel(firstSelectedRow);
    				tableModel.approve(modelRow);
				}
				ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
				indexes.clear();
				arrivalPendingTable.clearSelection();
			}
		});

		modifyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = arrivalPendingTable.getSelectedRow();
                if(row == -1){
                    ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
                    return;
                }
				int modelRow = arrivalPendingTable.convertRowIndexToModel(row);
				new ArrivalPendingDialog(tableModel, modelRow, true);
			}
		});
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = arrivalPendingTable.getSelectedRow();
                if(row == -1){
                    ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
                    return;
                }
				int modelRow = arrivalPendingTable.convertRowIndexToModel(row);
				new ArrivalPendingDialog(tableModel, modelRow, false);
			}
		});
		
		arrivalPendingTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(!toggleButton.isSelected())
                    return;
                int clicked = arrivalPendingTable.getSelectedRow();
                if(indexes.contains(clicked)){
                    indexes.remove(new Integer(clicked));
                }else{
                    indexes.add(clicked);
                }
                arrivalPendingTable.clearSelection();
                for(int i:indexes){
                    arrivalPendingTable.addRowSelectionInterval(i, i);
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
		
		
        toggleButton.setBounds(230, 390, 70, 30);		
        approveButton.setBounds(315, 390, 70, 30);
        modifyButton.setBounds(400, 390, 70, 30);
        queryButton.setBounds(485, 390, 70, 30);

		// set panel
		this.setBounds(0, 0, 560, 470);
		this.setLayout(null);
		this.add(arrivalPendingScrollPane);
		this.add(toggleButton);
		this.add(approveButton);
		this.add(modifyButton);
		this.add(queryButton);
	}
}
