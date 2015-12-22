package presentation.financeui.primeinfoui.cityui;

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
import presentation.util.ScreenMessage;
import vo.CityVO;
import businesslogicservice.PrimeInfoblService;

public class PrimeInfoCityPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4300686911538244505L;
	private JScrollPane CityScrollPane;   
    private JTable CityTable;
    private PrimeInfoCityTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;   
    private PrimeInfoblService primeInfoblService;
    
    public PrimeInfoCityPanel(List<CityVO> vos){
    	 //build up account table
        tableModel = new PrimeInfoCityTableModel(vos);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        CityTable = new JTable(tableModel);
        CityTable.setSize(800, 500);
        CityTable.setRowSorter(tableSorter);        
        //set scroll pane
        CityScrollPane = new JScrollPane(CityTable);
        CityScrollPane.setBounds(0, 10, 560, 370);
        
        JButton queryButton = new JButton("详情");
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = CityTable.getSelectedRow();
                if(row == -1)
                    return;
                int modelRow = CityTable.convertRowIndexToModel(row);
                new PrimeInfoCityDialog(tableModel, modelRow, false);
                
            }
        });
  
        queryButton.setBounds(485, 390, 70, 30);
        //set panel
        this.setBounds(0, 15, 560, 370);
        this.setLayout(null);
        this.add(CityScrollPane);
        this.add(queryButton);
    	
    }
    public PrimeInfoCityPanel(PrimeInfoblService pibs){
    	 //build up City table
    	primeInfoblService = pibs;
        tableModel = new  PrimeInfoCityTableModel(primeInfoblService);
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        CityTable = new JTable(tableModel);
        CityTable.setSize(800, 500);
        CityTable.setRowSorter(tableSorter);        
        //set scroll pane
        CityScrollPane = new JScrollPane(CityTable);
        CityScrollPane.setBounds(0, 10, 560, 370);
        
        JButton createButton = new JButton("添加");
        JButton deleteButton = new JButton("删除");
        JButton modifyButton = new JButton("修改");
        JButton queryButton = new JButton("查询");
        JButton confirmButton = new JButton("完成建账");
        createButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrimeInfoCityDialog(tableModel);
                
            }
        });
       ActionListener actionListener = new ActionListener () {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = CityTable.getSelectedRow();
                if(row == -1)
                   	ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);         
                else{
                	  ConfirmDialog.createConfirmDialog(deleteButton, new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							 int modelRow = CityTable.convertRowIndexToModel(row);
							 tableModel.delete(modelRow);	
							 ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
						}
					});
                }
            }
        };  
        deleteButton.addActionListener(actionListener);
        
        modifyButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	 int row = CityTable.getSelectedRow();
                 if(row == -1)
                		ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);  
                 else{
                	 int modelRow = CityTable.convertRowIndexToModel(row);
                	 new PrimeInfoCityDialog(tableModel, modelRow, true);	
                 }
            }
        });
        
        
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = CityTable.getSelectedRow();
                if(row == -1)
                	ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);  
                else{
                	int modelRow = CityTable.convertRowIndexToModel(row);
                	new PrimeInfoCityDialog(tableModel, modelRow, false);
                }
            }
        });
        confirmButton.addActionListener(new ActionListener() {
			
    		@Override
    		public void actionPerformed(ActionEvent e) {
    		// TODO Auto-generated method stub
    			primeInfoblService.createPrimeInfoPO();
    			primeInfoblService.execute();   
    	        Container container = PrimeInfoCityPanel.this.getParent().getParent();
    	        container.removeAll();
    	        container.repaint();
    		}
    	});
       
        createButton.setBounds(60, 390, 70, 30);
        deleteButton.setBounds(145, 390, 70, 30);
        modifyButton.setBounds(230, 390, 70, 30);
        queryButton.setBounds(315, 390, 70, 30);          
        confirmButton.setBounds(425, 390, 130, 30);

        this.setBounds(0, 15, 560, 370);
        this.setLayout(null);
        this.add(CityScrollPane);
        this.add(createButton);
        this.add(deleteButton);
        this.add(modifyButton);
        this.add(queryButton);
        this.add(confirmButton);  

    }

}
