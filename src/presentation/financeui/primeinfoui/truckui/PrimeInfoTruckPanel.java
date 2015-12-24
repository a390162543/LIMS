package presentation.financeui.primeinfoui.truckui;

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

/**
 * 期初建账维护车辆信息列表的{@code JPanel}，提供了车辆信息的增删改查服务
 * @author 林祖华
 * @version 1.2
 * @see businesslogicservice.PrimeInfoblService
 */
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
        truckTable.setSize(650, 390);
        truckTable.setRowSorter(tableSorter);        
        //set scroll pane
        truckScrollPane = new JScrollPane(truckTable);
        truckScrollPane.setBounds(0, 0, 650, 390);
        
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
  
        queryButton.setBounds(575, 400, 70, 30);
        //set panel
        this.setBounds(0, 15, 650, 470);
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
            truckTable.setSize(650, 390);
            truckTable.setRowSorter(tableSorter);        
            //set scroll pane
            truckScrollPane = new JScrollPane(truckTable);
            truckScrollPane.setBounds(0, 0, 650, 390);
            
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
            addButton.setBounds(150, 400, 70, 30);
            deleteButton.setBounds(235, 400, 70, 30);
            modifyButton.setBounds(320, 400, 70, 30);
            queryButton.setBounds(405, 400, 70, 30);          
            createButton.setBounds(515, 400, 130, 30);
            //set panel
            this.setBounds(0, 15, 650, 470);
            this.setLayout(null);
            this.add(truckScrollPane);
            this.add(addButton);
            this.add(deleteButton);
            this.add(modifyButton);
            this.add(queryButton);
            this.add(createButton);
    }
}

