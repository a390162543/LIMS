package presentation.financeui.primeinfoui.employeeui;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

import presentation.financeui.primeinfoui.primeinfoaccount.PrimeInfoAccountDialog;
import presentation.financeui.primeinfoui.primeinfoaccount.PrimeInfoAccountPanel;
import presentation.financeui.primeinfoui.primeinfoaccount.PrimeInfoAccountTableModel;
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
	 private JTextField filterTextField;	
	 private PrimeInfoblService primeInfoblService;	 
	 public PrimeInfoEmployeePanel(List<EmployeeVO> vos){
		 	tableModel = new PrimeInfoEmployeeTableModel(vos);  
	        tableSorter = new TableRowSorter<TableModel>(tableModel);
	        employeeTable = new JTable(tableModel);
	        employeeTable.setSize(800, 500);
	        employeeTable.setRowSorter(tableSorter);        
	        //set scroll pane
	        employeeScrollPane = new JScrollPane(employeeTable);
	        employeeScrollPane.setBounds(0, 10, 560, 370);
	        
	       JButton  queryButton = new JButton("详情");
	        queryButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int row = employeeTable.getSelectedRow();
	                if(row == -1)
	                    return;
	                int modelRow = employeeTable.convertRowIndexToModel(row);
	                new PrimeInfoEmployeeDialog().showQueryDialog(tableModel, modelRow, false); 	                
	            }
	        });
	  
	        queryButton.setBounds(485, 390, 70, 30);
	        //set panel
	        this.setBounds(0, 15, 560, 470);
	        this.setLayout(null);
	        this.add(employeeScrollPane);
	        this.add(queryButton);
	 }
	
	public PrimeInfoEmployeePanel(PrimeInfoblService pibs){
		primeInfoblService = pibs;	 
		tableModel = new PrimeInfoEmployeeTableModel(primeInfoblService);
	    employeeTable = new JTable(tableModel);
	    employeeTable.setSize(800, 500);
	    employeeTable.setRowSorter(tableSorter);        
	     //set scroll pane
	    employeeScrollPane = new JScrollPane(employeeTable);
	    employeeScrollPane.setBounds(0, 40, 560, 370);
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
	       JButton confirmButton = new JButton("完成初期建账");
	        createButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new PrimeInfoEmployeeDialog().showCreateDialog(tableModel);
	                
	            }
	        });
	        deleteButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int row = employeeTable.getSelectedRow();
	                if(row == -1)
	                    return;
	                int modelRow = employeeTable.convertRowIndexToModel(row);
	                tableModel.delete(modelRow);

	            }
	        });
	        modifyButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	 int row = employeeTable.getSelectedRow();
		             if(row == -1)
		                return;
		             int modelRow = employeeTable.convertRowIndexToModel(row);
		             new PrimeInfoEmployeeDialog().showQueryDialog(tableModel, modelRow, true);

	            }
	        });
	        
	        queryButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int row = employeeTable.getSelectedRow();
		            if(row == -1)
		               return;
		            int modelRow = employeeTable.convertRowIndexToModel(row);
		            new PrimeInfoEmployeeDialog().showQueryDialog(tableModel, modelRow, false);

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
	       
	        createButton.setBounds(60, 420, 70, 30);
	        deleteButton.setBounds(145, 420, 70, 30);
	        modifyButton.setBounds(230, 420, 70, 30);
	        queryButton.setBounds(315, 420, 70, 30);
	        confirmButton.setBounds(425, 420, 70, 40);
	        //set panel
	        this.setBounds(0, 0, 560, 470);
	        this.setLayout(null);
	        this.add(employeeScrollPane);
	        this.add(filterTextField);
	        this.add(createButton);
	        this.add(deleteButton);
	        this.add(modifyButton);
	        this.add(queryButton);
	        this.add(confirmButton);

		
	}
}
