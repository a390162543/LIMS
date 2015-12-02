package presentation.financeui.primeinfoui.truckui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import businesslogicservice.PrimeInfoblService;



public class PrimeInfoTruckPanel extends JPanel{
    
    /**
     * 
     */
    private static final long serialVersionUID = -7230933721561303362L;
    
    private JScrollPane truckScrollPane;
    
    private JTable truckTable;
    private PrimeInfoTruckTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;
    
    private JTextField filterTextField;
    private JButton addButton;
    private JButton deleteButton;
    private JButton createButton;
    
    public PrimeInfoTruckPanel(PrimeInfoblService primeInfoblService){
        //build up truck table
        tableModel = new PrimeInfoTruckTableModel(primeInfoblService);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        truckTable = new JTable(tableModel);
        truckTable.setSize(800, 500);
        truckTable.setRowSorter(tableSorter);        
        //set scroll pane
        truckScrollPane = new JScrollPane(truckTable);
        truckScrollPane.setBounds(0, 10, 560, 370);
        //set other components on panel
        
        addButton = new JButton("添加");
        deleteButton = new JButton("删除");
        createButton = new JButton("新建账单");
        addButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrimeInfoTruckDialog(tableModel);
                
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = truckTable.getSelectedRow();
                if(row == -1)
                    return;
                int modelRow = truckTable.convertRowIndexToModel(row);
                tableModel.delete(modelRow);

            }
        });
        createButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                primeInfoblService.createPrimeInfoPO();
                primeInfoblService.execute();
 
                Container container = PrimeInfoTruckPanel.this.getParent().getParent();
                container.removeAll();
                container.repaint();
            }
        });
        addButton.setBounds(230, 390, 70, 30);
        deleteButton.setBounds(315, 390, 70, 30);
        createButton.setBounds(425, 390, 130, 30);
        //set panel
        this.setBounds(0, 0, 560, 470);
        this.setLayout(null);
        this.add(truckScrollPane);
        this.add(filterTextField);
        this.add(addButton);
        this.add(deleteButton);
        this.add(createButton);

    }


    
}
