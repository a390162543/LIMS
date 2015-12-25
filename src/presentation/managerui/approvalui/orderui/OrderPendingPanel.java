package presentation.managerui.approvalui.orderui;

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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import presentation.util.PresentationUtil;
import presentation.util.ScreenMessage;



/**
 * 这是总经理审批订单显示在界面上的面板
 * @author lc
 * @version 1.3
 *
 */
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
	
	private JToggleButton toggleButton;
    ArrayList<Integer> indexes = new ArrayList<Integer>();

	public OrderPendingPanel() {

		tableModel = new OrderPendingTableModel();
		tableSorter = new TableRowSorter<TableModel>(tableModel);
		orderPendingTable = new JTable(tableModel);
		orderPendingTable.setSize(800, 500);
		orderPendingTable.setRowSorter(tableSorter);

		orderPendingScrollPane = new JScrollPane(orderPendingTable);
		orderPendingScrollPane.setBounds(0, 0, 660, 390);
		
		tableModel.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				PresentationUtil.fitTableColumns(orderPendingTable);
			}
		});
		
		PresentationUtil.fitTableColumns(orderPendingTable);

		toggleButton = new JToggleButton("批量审批");
		pendingButton = new JButton("审批");
		modifyButton = new JButton("修改");
		queryButton = new JButton("详情");

		toggleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                indexes.clear();
                orderPendingTable.clearSelection();
            }
        });
		
		pendingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = orderPendingTable.getSelectedRow();
				if (row == -1){
					ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
					return;
				}
				int indexesNum = orderPendingTable.getSelectedRowCount();
				int[] selectedRows = orderPendingTable.getSelectedRows();
				for(int i=0;i<indexesNum;i++){
				    for(int j=i+1;j<indexesNum;j++){
				        selectedRows[j] -= 1;
				    }
				    int firstSelectedRow = selectedRows[i];
                    int modelRow = orderPendingTable.convertRowIndexToModel(firstSelectedRow);
    				tableModel.approve(modelRow);
				}
				indexes.clear();
				orderPendingTable.clearSelection();
			}
		});

		modifyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = orderPendingTable.getSelectedRow();
				if (row == -1){
					ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
					return;
				}
				int modelRow = orderPendingTable.convertRowIndexToModel(row);
				new OrderPendingDialog(tableModel, modelRow, true);
			}
		});
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = orderPendingTable.getSelectedRow();
				if (row == -1){
					ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
					return;
				}
				int modelRow = orderPendingTable.convertRowIndexToModel(row);
				new OrderPendingDialog(tableModel, modelRow, false);
			}
		});
		
		orderPendingTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(!toggleButton.isSelected())
                    return;
                int clicked = orderPendingTable.getSelectedRow();
                System.out.println("click:"+clicked);
                if(indexes.contains(clicked)){
                    indexes.remove(new Integer(clicked));
                    System.out.println("remove it");
                }else{
                    indexes.add(clicked);
                    System.out.println("add it");
                }
                orderPendingTable.clearSelection();

                for(int i:indexes){
                    orderPendingTable.addRowSelectionInterval(i, i);
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
		this.add(orderPendingScrollPane);
		this.add(toggleButton);
		this.add(pendingButton);
		this.add(modifyButton);
		this.add(queryButton);

	}
	

}
