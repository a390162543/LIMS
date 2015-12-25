package presentation.financeui.primeinfoui.orderui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;






import presentation.util.ConfirmDialog;
import presentation.util.PresentationUtil;
import presentation.util.ScreenMessage;
import vo.OrderCreateVO;
import businesslogicservice.PrimeInfoblService;


/**
 * 该类是期初建账时用于显示已经建立的订单的面板
 * @author lc
 * @version 1.3
 *
 */
public class PrimeInfoOrderPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4991664100422134832L;
	
	private PrimeInfoblService primeInfoblService;
	private JScrollPane orderScrollPane;
    private JTable orderTable;
    private PrimeInfoOrderTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;

    private JButton addButton;
    private JButton deleteButton;
    private JButton createButton;
    private JButton queryButton;
    private JButton modifyButton;
    

    public PrimeInfoOrderPanel(List<OrderCreateVO> vos ){	
        //build up account table
        tableModel = new PrimeInfoOrderTableModel(vos);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        orderTable = new JTable(tableModel);
        orderTable.setSize(650, 390);
        orderTable.setRowSorter(tableSorter);        
        //set scroll pane
        orderScrollPane = new JScrollPane(orderTable);
        orderScrollPane.setBounds(0, 10, 650, 390);
        PresentationUtil.fitTableColumns(orderTable);
        queryButton = new JButton("详情");
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = orderTable.getSelectedRow();
                if(row == -1){
                	ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
                    return;
                }
                int modelRow = orderTable.convertRowIndexToModel(row);
                new PrimeInfoOrderDialog(tableModel ,modelRow , false);
                
            }
        });
  
        queryButton.setBounds(485+90, 400, 70, 30);
        //set panel
        this.setBounds(0, 15, 650, 470);
        this.setLayout(null);
        this.add(orderScrollPane);
        this.add(queryButton);

    }
    
    
    
    public PrimeInfoOrderPanel(PrimeInfoblService primeInfoblService2){	
    	this.primeInfoblService = primeInfoblService2;
        //build up account table
        tableModel = new PrimeInfoOrderTableModel(primeInfoblService);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        orderTable = new JTable(tableModel);
        orderTable.setSize(650, 390);
        orderTable.setRowSorter(tableSorter);        
        //set scroll pane
        orderScrollPane = new JScrollPane(orderTable);
        orderScrollPane.setBounds(0, 0, 650, 390);
        
        addButton = new JButton("添加");
        deleteButton = new JButton("删除");
        createButton = new JButton("完成建账");
        queryButton = new JButton("查询");
        modifyButton = new JButton("修改");
        addButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrimeInfoOrderDialog(tableModel);
                
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = orderTable.getSelectedRow();
                if(row == -1){
                	ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
                    return;
                }
                else {
                	ConfirmDialog.createConfirmDialog(deleteButton, new ActionListener() {					
						@Override
						public void actionPerformed(ActionEvent e) {						 
							 int modelRow = orderTable.convertRowIndexToModel(row);
			                 tableModel.delete(modelRow);
							 ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
						}
                	  });
                }
				       
            }
        });
        modifyButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = orderTable.getSelectedRow();
                if(row == -1){
                	ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
                    return;
                }
                int modelRow = orderTable.convertRowIndexToModel(row);
                new PrimeInfoOrderDialog(tableModel ,modelRow ,true);
            }
        });
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = orderTable.getSelectedRow();
                if(row == -1)
                    return;
                int modelRow = orderTable.convertRowIndexToModel(row);
                new PrimeInfoOrderDialog(tableModel ,modelRow ,false);
            }
        });
        createButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	primeInfoblService.createPrimeInfoPO();
            	primeInfoblService.execute();
 
            	Container container = PrimeInfoOrderPanel.this.getParent().getParent();
            	container.removeAll();
            	container.repaint();
            }
        });
        addButton.setBounds(60+90, 400, 70, 30);
        deleteButton.setBounds(145+90, 400, 70, 30);
        modifyButton.setBounds(230+90, 400, 70, 30);
        queryButton.setBounds(315+90, 400, 70, 30);          
        createButton.setBounds(425+90, 400, 130, 30);
        //set panel
        this.setBounds(0, 15, 560, 470);
        this.setLayout(null);
        this.add(orderScrollPane);
        this.add(addButton);
        this.add(deleteButton);
        this.add(createButton);
        this.add(queryButton);
        this.add(modifyButton);

    }

}
