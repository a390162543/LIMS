//package presentation.transitcenterui.transferui;
//
// 
//
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.TableModel;
//import javax.swing.table.TableRowSorter;
//
//import businesslogicservice.TransferblService;
//
//
//
//public class OrderPanel extends JPanel{
//    
//     
//    
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = -5891671935536664654L;
//
//	private JScrollPane OrderScrollPane;
//    
//    private JTable orderTable;
//    private OrderTableModel tableModel;
//    private TableRowSorter<TableModel> tableSorter;
//    
//   
//    
//    public OrderPanel( TransferblService tbs, TransferDialog dialog){
//        //build up Order table
//    	 
//        tableModel = new OrderTableModel(tbs);  
//        tableSorter = new TableRowSorter<TableModel>(tableModel);
//        orderTable = new JTable(tableModel);
//        orderTable.setSize(180, 60);
//        orderTable.setRowSorter(tableSorter);        
//        //set scroll pane
//        
//        OrderScrollPane = new JScrollPane(orderTable);
//        OrderScrollPane.setBounds(0, 10, 180, 60);
//        //set other components on panel
//            
//        
//        JButton addOrderButton = new JButton("Ìí¼Ó¶©µ¥");
//		addOrderButton.setBounds(190, 10, 70, 20);
//		JButton deleteOrderButton = new JButton("É¾³ý¶©µ¥");
//		deleteOrderButton.setBounds(190, 40, 70, 20);
//		addOrderButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				 new AddOrderDialog(tableModel, dialog);
//				 
//			}
//		});
//		
//		deleteOrderButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				int row = orderTable.getSelectedRow();
//                if(row == -1)
//                    return;
//                int modelRow = orderTable.convertRowIndexToModel(row);
//                tableModel.delete(modelRow);
//			}
//		});
//        
//         
//        //set panel
//        this.setBounds(100, 280, 270, 80);
//        this.setLayout(null);
//        this.add(OrderScrollPane);
//        this.add(addOrderButton);
//        this.add(deleteOrderButton);
//        
//
//    }
//
//
//    
//}
//
