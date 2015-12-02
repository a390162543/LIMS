package presentation.financeui.primeinfoui.employeeui;

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
	 private JButton createButton;
	 private JButton deleteButton;
	 private JButton confirmButton; 	
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
	        
	        createButton = new JButton("添加");
	        deleteButton = new JButton("删除");
	        confirmButton = new JButton("新建员工");
	       
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
	        confirmButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                
	            }
	        });
	       
	        createButton.setBounds(230, 420, 70, 30);
	        deleteButton.setBounds(315, 420, 70, 30);
	        confirmButton.setBounds(400, 420, 70, 30);
	        
	        //set panel
	        this.setBounds(0, 0, 560, 470);
	        this.setLayout(null);
	        this.add(EmployeeScrollPane);
	        this.add(filterTextField);
	        this.add(createButton);
	        this.add(deleteButton);
	        this.add(confirmButton);
	     

		
	}
}
