package presentation.managerui.approvalui.storeinui;

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

import presentation.util.PresentationUtil;
import presentation.util.ScreenMessage;


/**
 * 这是总经理审批入库单时显示在界面上的面板
 * @author lc
 * @version 1.3
 *
 */
public class StoreinPendingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1042686549521102708L;

	private JScrollPane storeinPendingScrollPane;

	private JTable storeinPendingTable;
	private StoreinPendingTableModel tableModel;
	private TableRowSorter<TableModel> tableSorter;

	private JButton pendingButton;
	private JButton modifyButton;
	private JButton queryButton;
	
	private JToggleButton toggleButton;
    ArrayList<Integer> indexes = new ArrayList<Integer>();

	public StoreinPendingPanel() {

		tableModel = new StoreinPendingTableModel();
		tableSorter = new TableRowSorter<TableModel>(tableModel);
		storeinPendingTable = new JTable(tableModel);
		storeinPendingTable.setSize(800, 500);
		storeinPendingTable.setRowSorter(tableSorter);

		storeinPendingScrollPane = new JScrollPane(storeinPendingTable);
		storeinPendingScrollPane.setBounds(0, 0, 650, 390);
		PresentationUtil.fitTableColumns(storeinPendingTable);

		toggleButton = new JToggleButton("批量审批");
		pendingButton = new JButton("审批");
		modifyButton = new JButton("修改");
		queryButton = new JButton("详情");

		
		toggleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                indexes.clear();
                storeinPendingTable.clearSelection();
            }
        });
		
		pendingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = storeinPendingTable.getSelectedRow();
				if (row == -1){
					ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
					return;
				}
				int indexesNum = storeinPendingTable.getSelectedRowCount();
				int[] selectedRows = storeinPendingTable.getSelectedRows();
				for(int i=0;i<indexesNum;i++){
				    for(int j=i+1;j<indexesNum;j++){
				        selectedRows[j] -= 1;
				    }
				    int firstSelectedRow = selectedRows[i];
                    int modelRow = storeinPendingTable.convertRowIndexToModel(firstSelectedRow);
    				tableModel.approve(modelRow);
				}
				indexes.clear();
				storeinPendingTable.clearSelection();
			}
		});

		modifyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = storeinPendingTable.getSelectedRow();
				if (row == -1){
					ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
					return;
				}
				int modelRow = storeinPendingTable.convertRowIndexToModel(row);
				new StoreinPendingDialog(tableModel, modelRow, true);
			}
		});
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = storeinPendingTable.getSelectedRow();
				if (row == -1){
					ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
					return;
				}
				int modelRow = storeinPendingTable.convertRowIndexToModel(row);
				new StoreinPendingDialog(tableModel, modelRow, false);
			}
		});
		
		storeinPendingTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(!toggleButton.isSelected())
                    return;
                int clicked = storeinPendingTable.getSelectedRow();
                System.out.println("click:"+clicked);
                if(indexes.contains(clicked)){
                    indexes.remove(new Integer(clicked));
                    System.out.println("remove it");
                }else{
                    indexes.add(clicked);
                    System.out.println("add it");
                }
                storeinPendingTable.clearSelection();

                for(int i:indexes){
                    storeinPendingTable.addRowSelectionInterval(i, i);
                }
                System.out.println("Num:"+indexes.size());
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
		
		toggleButton.setBounds(230+90, 400, 70, 30);	
		pendingButton.setBounds(315+90, 400, 70, 30);
		modifyButton.setBounds(400+90, 400, 70, 30);
		queryButton.setBounds(485+90, 400, 70, 30);
		// set panel
		this.setBounds(0, 0, 650, 470);
		this.setLayout(null);
		this.add(storeinPendingScrollPane);
		this.add(pendingButton);
		this.add(modifyButton);
		this.add(queryButton);
	}
}
