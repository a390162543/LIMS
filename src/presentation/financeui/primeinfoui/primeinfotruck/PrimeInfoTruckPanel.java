package presentation.financeui.primeinfoui.primeinfotruck;

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

import vo.TruckVO;
import businesslogicservice.PrimeInfoblService;

public class PrimeInfoTruckPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -11825426146558197L;
	private PrimeInfoblService primeInfoblService;
	private JScrollPane truckScrollPane;
    private JTable truckTable;
    private PrimeInfoTruckTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;

    private JButton queryButton;
    private JButton modifyButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton createButton;
    
    public PrimeInfoTruckPanel(List<TruckVO> vos ){	
        //build up account table
        tableModel = new PrimeInfoTruckTableModel(vos);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        truckTable = new JTable(tableModel);
        truckTable.setSize(800, 500);
        truckTable.setRowSorter(tableSorter);        
        //set scroll pane
        truckScrollPane = new JScrollPane(truckTable);
        truckScrollPane.setBounds(0, 10, 560, 370);
        
        queryButton = new JButton("详情");
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = truckTable.getSelectedRow();
                if(row == -1)
                    return;
                int modelRow = truckTable.convertRowIndexToModel(row);
                new PrimeInfoTruckDialog(tableModel ,modelRow , false);
                
            }
        });
  
        queryButton.setBounds(485, 390, 70, 30);
        //set panel
        this.setBounds(0, 15, 560, 470);
        this.setLayout(null);
        this.add(truckScrollPane);
        this.add(queryButton);

    }
    
    public PrimeInfoTruckPanel(PrimeInfoblService primeInfoblService2){
    	
        	this.primeInfoblService = primeInfoblService2;
            //build up account table
            tableModel = new PrimeInfoTruckTableModel(primeInfoblService);  
            tableSorter = new TableRowSorter<TableModel>(tableModel);
            truckTable = new JTable(tableModel);
            truckTable.setSize(800, 500);
            truckTable.setRowSorter(tableSorter);        
            //set scroll pane
            truckScrollPane = new JScrollPane(truckTable);
            truckScrollPane.setBounds(0, 10, 560, 370);
            
            addButton = new JButton("添加");
            deleteButton = new JButton("删除");
            modifyButton = new JButton("修改");
            queryButton = new JButton("查询");
            createButton = new JButton("完成建账");
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
            modifyButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = truckTable.getSelectedRow();
                    if(row == -1)
                        return;
                    int modelRow = truckTable.convertRowIndexToModel(row);
                    new PrimeInfoTruckDialog(tableModel ,modelRow ,true);
                }
            });
            queryButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = truckTable.getSelectedRow();
                    if(row == -1)
                        return;
                    int modelRow = truckTable.convertRowIndexToModel(row);
                    new PrimeInfoTruckDialog(tableModel ,modelRow ,false);
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
            addButton.setBounds(60, 390, 70, 30);
            deleteButton.setBounds(145, 390, 70, 30);
            modifyButton.setBounds(230, 390, 70, 30);
            queryButton.setBounds(315, 390, 70, 30);          
            createButton.setBounds(425, 390, 130, 30);
            //set panel
            this.setBounds(0, 15, 560, 470);
            this.setLayout(null);
            this.add(truckScrollPane);
            this.add(addButton);
            this.add(deleteButton);
            this.add(modifyButton);
            this.add(queryButton);
            this.add(createButton);
    }
}

