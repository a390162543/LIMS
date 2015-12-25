package presentation.financeui.primeinfoui.employeeui;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import presentation.util.ConfirmDialog;
import presentation.util.PresentationUtil;
import presentation.util.ScreenMessage;
import vo.EmployeeVO;
import businesslogicservice.PrimeInfoblService;

public class PrimeInfoEmployeePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5658697284093794781L;
	
	 private JScrollPane employeeScrollPane;	    
	 private JTable employeeTable;
	 private PrimeInfoEmployeeTableModel tableModel;
	 private TableRowSorter<TableModel> tableSorter;    
	 private PrimeInfoblService primeInfoblService;	 
	 
	 
	 public PrimeInfoEmployeePanel(List<EmployeeVO> vos){
		 	tableModel = new PrimeInfoEmployeeTableModel(vos);  
	        tableSorter = new TableRowSorter<TableModel>(tableModel);
	        employeeTable = new JTable(tableModel);
	        employeeTable.setSize(650,390);
	        employeeTable.setRowSorter(tableSorter);        
	        //set scroll pane
	        employeeScrollPane = new JScrollPane(employeeTable);
	        employeeScrollPane.setBounds(0, 0, 650, 390);
	        
	        
	        tableModel.addTableModelListener(new TableModelListener() {
				
				@Override
				public void tableChanged(TableModelEvent e) {
					// TODO Auto-generated method stub
				       PresentationUtil.fitTableColumns(employeeTable);
				}
			});
	        
	        PresentationUtil.fitTableColumns(employeeTable);
	        
	       JButton  queryButton = new JButton("详情");
	        queryButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int row = employeeTable.getSelectedRow();
	                if(row == -1)
	                	ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);  
	                else{
	                	int modelRow = employeeTable.convertRowIndexToModel(row);
	                	new PrimeInfoEmployeeDialog(tableModel, modelRow, false); 
	                }                
	            }
	        });
	  
	        queryButton.setBounds(485+90, 400, 70, 30);
	        //set panel
	        this.setBounds(0, 15, 650, 470);
	        this.setLayout(null);
	        this.add(employeeScrollPane);
	        this.add(queryButton);
	 }
	
	public PrimeInfoEmployeePanel(PrimeInfoblService pibs){
		primeInfoblService = pibs;	 
		tableModel = new PrimeInfoEmployeeTableModel(primeInfoblService);
	    employeeTable = new JTable(tableModel);
	    employeeTable.setSize(650, 390);
	    employeeTable.setRowSorter(tableSorter);        
	     //set scroll pane
	    employeeScrollPane = new JScrollPane(employeeTable);
	    employeeScrollPane.setBounds(0, 0, 650, 390);
	
        PresentationUtil.fitTableColumns(employeeTable);
        
        
	       JButton createButton = new JButton("添加");
	       JButton deleteButton = new JButton("删除");
	       JButton modifyButton = new JButton("修改");
	       JButton queryButton = new JButton("查询");
	       JButton confirmButton = new JButton("完成建账");
	       
	       createButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new PrimeInfoEmployeeDialog (tableModel);
	                
	            }
	        });
	        
	        
	         ActionListener actionListener = new ActionListener () {
	             
	             @Override
	             public void actionPerformed(ActionEvent e) {
	                 int row = employeeTable.getSelectedRow();
	                 if(row == -1){
	                 	ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);             	
	                 }                
	                 else{
	                 	ConfirmDialog.createConfirmDialog(deleteButton, new ActionListener() {					
	 						@Override
	 						public void actionPerformed(ActionEvent e) {						 
	 							 int modelRow = employeeTable.convertRowIndexToModel(row);
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
	            	 int row = employeeTable.getSelectedRow();
		             if(row == -1)
		            	 ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
		             else{
		            	 int modelRow = employeeTable.convertRowIndexToModel(row);
		            	 new PrimeInfoEmployeeDialog(tableModel, modelRow, true);
		             }
	            }
	        });
	        
	        queryButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int row = employeeTable.getSelectedRow();
		            if(row == -1)
		            	ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
		            else{
		            	int modelRow = employeeTable.convertRowIndexToModel(row);
		            	new PrimeInfoEmployeeDialog(tableModel, modelRow, false);
		            }


				}
			});
	        
	        confirmButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					primeInfoblService.createPrimeInfoPO();
                	primeInfoblService.execute();    
                	Container container = PrimeInfoEmployeePanel.this.getParent().getParent();
                	container.removeAll();
                	container.repaint();
				}
			});
	       
	        createButton.setBounds(60+90, 400, 70, 30);
	        deleteButton.setBounds(145+90, 400, 70, 30);
	        modifyButton.setBounds(230+90, 400, 70, 30);
	        queryButton.setBounds(315+90, 400, 70, 30);          
	        confirmButton.setBounds(425+90, 400, 130, 30);

	        //set panel
	        this.setBounds(0, 15, 650, 470);
	        this.setLayout(null);
	        this.add(employeeScrollPane);     
	        this.add(createButton);
	        this.add(deleteButton);
	        this.add(modifyButton);
	        this.add(queryButton);
	        this.add(confirmButton);

		
	}
}
