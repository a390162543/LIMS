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
import presentation.util.PresentationUtil;
import presentation.util.ScreenMessage;
import vo.CityVO;
import businesslogicservice.PrimeInfoblService;

public class PrimeInfoCityPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4300686911538244505L;
	private JScrollPane CityScrollPane;   
    private JTable cityTable;
    private PrimeInfoCityTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;   
    private PrimeInfoblService primeInfoblService;
    
    public PrimeInfoCityPanel(List<CityVO> vos){
    	 //build up account table
        tableModel = new PrimeInfoCityTableModel(vos);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        cityTable = new JTable(tableModel);
        cityTable.setSize(650, 390);
        cityTable.setRowSorter(tableSorter);        
        //set scroll pane
        CityScrollPane = new JScrollPane(cityTable);
        CityScrollPane.setBounds(0, 0, 650,390);
        
        
        PresentationUtil.fitTableColumns(cityTable);
        
        
        JButton queryButton = new JButton("详情");
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = cityTable.getSelectedRow();
                if(row == -1)
                    return;
                int modelRow = cityTable.convertRowIndexToModel(row);
                new PrimeInfoCityDialog(tableModel, modelRow, false);
                
            }
        });
  
        queryButton.setBounds(485 +90, 400, 70, 30);
        //set panel
        this.setBounds(0, 15, 650, 470);
        this.setLayout(null);
        this.add(CityScrollPane);
        this.add(queryButton);
    	
    }
    public PrimeInfoCityPanel(PrimeInfoblService pibs){
    	 //build up City table
    	primeInfoblService = pibs;
        tableModel = new  PrimeInfoCityTableModel(primeInfoblService);
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        cityTable = new JTable(tableModel);
        cityTable.setSize(650,390);
        cityTable.setRowSorter(tableSorter);        
        //set scroll pane
        CityScrollPane = new JScrollPane(cityTable);
        CityScrollPane.setBounds(0, 0, 650,390);
        
        PresentationUtil.fitTableColumns(cityTable);
        
        
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
                int row = cityTable.getSelectedRow();
                if(row == -1)
                   	ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);         
                else{
                	  ConfirmDialog.createConfirmDialog(deleteButton, new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							 int modelRow = cityTable.convertRowIndexToModel(row);
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
            	 int row = cityTable.getSelectedRow();
                 if(row == -1)
                		ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);  
                 else{
                	 int modelRow = cityTable.convertRowIndexToModel(row);
                	 new PrimeInfoCityDialog(tableModel, modelRow, true);	
                 }
            }
        });
        
        
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = cityTable.getSelectedRow();
                if(row == -1)
                	ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);  
                else{
                	int modelRow = cityTable.convertRowIndexToModel(row);
                	new PrimeInfoCityDialog(tableModel, modelRow, false);
                }
            }
        });
        confirmButton.addActionListener(new ActionListener() {
			
    		@Override
    		public void actionPerformed(ActionEvent e) {
    		// TODO Auto-generated method stub
    			ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
    			primeInfoblService.createPrimeInfoPO();
    			primeInfoblService.execute();   
    	        Container container = PrimeInfoCityPanel.this.getParent().getParent();
    	        container.removeAll();
    	        container.repaint();
    		}
    	});
       
        createButton.setBounds(60+90, 400, 70, 30);
        deleteButton.setBounds(145+90, 400, 70, 30);
        modifyButton.setBounds(230+90, 400, 70, 30);
        queryButton.setBounds(315+90, 400, 70, 30);          
        confirmButton.setBounds(425+90, 400, 130, 30);

        this.setBounds(0, 15, 650, 470);
        this.setLayout(null);
        this.add(CityScrollPane);
        this.add(createButton);
        this.add(deleteButton);
        this.add(modifyButton);
        this.add(queryButton);
        this.add(confirmButton);  

    }

}
