package presentation.financeui.primeinfoui.storeinui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import businesslogicservice.PrimeInfoblService;

public class PrimeInfoStoreinPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5707582086736967054L;
	
	
	private PrimeInfoblService primeInfoblService;
	private JScrollPane storeinScrollPane;
    private JTable accountTable;
    private PrimeInfoStoreinTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;

    private JButton addButton;
    private JButton deleteButton;
    private JButton createButton;
    
    public PrimeInfoStoreinPanel(PrimeInfoblService primeInfoblService2){	
    	this.primeInfoblService = primeInfoblService2;
        //build up account table
        tableModel = new PrimeInfoStoreinTableModel(primeInfoblService);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        accountTable = new JTable(tableModel);
        accountTable.setSize(800, 500);
        accountTable.setRowSorter(tableSorter);        
        //set scroll pane
        storeinScrollPane = new JScrollPane(accountTable);
        storeinScrollPane.setBounds(0, 10, 560, 370);
        
        addButton = new JButton("添加");
        deleteButton = new JButton("删除");
        createButton = new JButton("新建账单");
        addButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrimeInfoStoreinDialog(tableModel);
                
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = accountTable.getSelectedRow();
                if(row == -1)
                    return;
                int modelRow = accountTable.convertRowIndexToModel(row);
                tableModel.delete(modelRow);

            }
        });
        createButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	primeInfoblService.createPrimeInfoPO();
            	primeInfoblService.executeAccountPO();
 
            	Container container = PrimeInfoStoreinPanel.this.getParent().getParent();
            	container.removeAll();
            	container.repaint();
            }
        });
        addButton.setBounds(230, 390, 70, 30);
        deleteButton.setBounds(315, 390, 70, 30);
        createButton.setBounds(425, 390, 130, 30);
        //set panel
        this.setBounds(0, 15, 560, 470);
        this.setLayout(null);
        this.add(storeinScrollPane);
        this.add(addButton);
        this.add(deleteButton);
        this.add(createButton);

    }
	

}
