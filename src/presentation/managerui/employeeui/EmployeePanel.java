package presentation.managerui.employeeui;


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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import presentation.util.ConfirmDialog;
import presentation.util.PresentationUtil;
import presentation.util.ScreenMessage;


/**
 * 员工管理界面
 * @author 刘航伸
 * @see presentation.employeeui.EmployeeDialog 
 * @version 1.2
 */
public class EmployeePanel extends JPanel{
    
    /**
     * 
     */
    private static final long serialVersionUID = -7230933721561303362L;
    
    private JScrollPane employeeScrollPane;
    
    private JTable employeeTable;
    private EmployeeTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;
    
    private JTextField filterTextField;
    private JButton createButton;
    private JButton deleteButton;
    private JButton modifyButton;
    private JButton queryButton;
    
    public EmployeePanel(){
        //build up Employee table 
    	 
        tableModel = new EmployeeTableModel();  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        employeeTable = new JTable(tableModel);
        employeeTable.setSize( 650, 390);
        employeeTable.setRowSorter(tableSorter); 
 
        //set scroll pane
        employeeScrollPane = new JScrollPane(employeeTable);
        employeeScrollPane.setBounds(0, 40, 650, 390);
        
 
        
        
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
        

//        EmployeeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        PresentationUtil.fitTableColumns(employeeTable);
        
        filterTextField.setBounds(320 + 90, 0, 235, 25);
        
        createButton = new JButton("创建");
        deleteButton = new JButton("删除");
        modifyButton = new JButton("修改");
        queryButton = new JButton("详情");
        createButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeDialog(tableModel);
                
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
                	new EmployeeDialog(tableModel, modelRow, true);
                }

            }
        });
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = employeeTable.getSelectedRow();
                if(row == -1)
                	ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
                else{
                	int modelRow = employeeTable.convertRowIndexToModel(row);
                	new EmployeeDialog(tableModel, modelRow, false);	
                }
               
            }
        });
        
       
        createButton.setBounds(230 +90 , 440, 70, 30 );
        deleteButton.setBounds(315+ 90, 440, 70, 30);
        modifyButton.setBounds(400+ 90, 440, 70, 30);
        queryButton.setBounds(485+ 90, 440, 70, 30);
        
        
        
        //set panel
        this.setBounds(0, 0, 560, 450);
        this.setLayout(null);
        this.add(employeeScrollPane);
        this.add(filterTextField);
        this.add(createButton);
        this.add(deleteButton);
        this.add(modifyButton);
        this.add(queryButton);

    }

  
    
}
