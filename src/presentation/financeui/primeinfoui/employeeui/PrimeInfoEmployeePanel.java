package presentation.financeui.primeinfoui.employeeui;


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

public class PrimeInfoEmployeePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5658697284093794781L;
	
	 private JScrollPane EmployeeScrollPane;	    
	 private JTable EmployeeTable;
	 private PrimeInfoEmployeeTableModel tableModel;
	 private TableRowSorter<TableModel> tableSorter;    
	 private JTextField filterTextField;
 	
	 private PrimeInfoblService primeInfoblService;
	
	public PrimeInfoEmployeePanel(PrimeInfoblService pibs){
		primeInfoblService = pibs;	 
		tableModel = new PrimeInfoEmployeeTableModel(primeInfoblService);
	    EmployeeTable = new JTable(tableModel);
	    EmployeeTable.setSize(800, 500);
	    EmployeeTable.setRowSorter(tableSorter);        
	     //set scroll pane
	    EmployeeScrollPane = new JScrollPane(EmployeeTable);
	    EmployeeScrollPane.setBounds(0, 40, 560, 370);
	     //set other components on panel
	      filterTextField = new JTextField();
	     filterTextField.setToolTipText("请输入模糊查找字段");
	        filterTextField.getDocument().addDocumentListener(new DocumentListener() {
	            
	            @Override
	            public void removeUpdate(DocumentEvent e) {
	                changedUpdate(e);
	                
	            }
	            
	            @Override
	            public void insertUpdate(DocumentEvent e) {
	                changedUpdate(e);
	                
	            }
	            
	            @Override
	            public void changedUpdate(DocumentEvent e) {
	                String filterText = filterTextField.getText();
	                if(filterText.isEmpty()){
	                    tableSorter.setRowFilter(null);
	                }else{
	                    tableSorter.setRowFilter(RowFilter.regexFilter(filterText));
	                }
	                
	            }
	        });
	        filterTextField.setBounds(320, 0, 235, 25);
	        
	       JButton createButton = new JButton("添加");
	       JButton deleteButton = new JButton("删除");
	       JButton modifyButton = new JButton("修改");
	       JButton queryButton = new JButton("详情");
	       JButton confirmButton = new JButton("确认");
	        createButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new PrimeInfoEmployeeDialog().showCreateDialog(tableModel);
	                
	            }
	        });
	        deleteButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int row = EmployeeTable.getSelectedRow();
	                if(row == -1)
	                    return;
	                int modelRow = EmployeeTable.convertRowIndexToModel(row);
	                tableModel.delete(modelRow);

	            }
	        });
	        modifyButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	 int row = EmployeeTable.getSelectedRow();
		             if(row == -1)
		                return;
		             int modelRow = EmployeeTable.convertRowIndexToModel(row);
		             new PrimeInfoEmployeeDialog().showQueryDialog(tableModel, modelRow, true);

	            }
	        });
	        
	        queryButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int row = EmployeeTable.getSelectedRow();
		            if(row == -1)
		               return;
		            int modelRow = EmployeeTable.convertRowIndexToModel(row);
		            new PrimeInfoEmployeeDialog().showQueryDialog(tableModel, modelRow, false);

				}
			});
	        
	        confirmButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					primeInfoblService.createPrimeInfoPO();
	            	Container container = PrimeInfoEmployeePanel.this.getParent().getParent();
	            	container.removeAll();
	            	container.repaint();
				}
			});
	       
	        createButton.setBounds(230, 420, 70, 30);
	        deleteButton.setBounds(315, 420, 70, 30);
	        modifyButton.setBounds(400, 420, 70, 30);
	        queryButton.setBounds(485, 420, 70, 30);
	        confirmButton.setBounds(145, 420, 70, 40);
	        //set panel
	        this.setBounds(0, 0, 560, 470);
	        this.setLayout(null);
	        this.add(EmployeeScrollPane);
	        this.add(filterTextField);
	        this.add(createButton);
	        this.add(deleteButton);
	        this.add(modifyButton);
	        this.add(queryButton);
	        this.add(confirmButton);

		
	}
}
