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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import presentation.util.ConfirmDialog;


/**
 * Ա���������
 * @author ������
 * @see presentation.employeeui.EmployeeDialog 
 * @version 1.2
 */
public class EmployeePanel extends JPanel{
    
    /**
     * 
     */
    private static final long serialVersionUID = -7230933721561303362L;
    
    private JScrollPane EmployeeScrollPane;
    
    private JTable EmployeeTable;
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
        EmployeeTable = new JTable(tableModel);
        EmployeeTable.setSize(800, 500);
        EmployeeTable.setRowSorter(tableSorter);        
        //set scroll pane
        EmployeeScrollPane = new JScrollPane(EmployeeTable);
        EmployeeScrollPane.setBounds(0, 40, 560, 370);
        //set other components on panel
        filterTextField = new JTextField();
        filterTextField.setToolTipText("������ģ�������ֶ�");
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
        
        createButton = new JButton("����");
        deleteButton = new JButton("ɾ��");
        modifyButton = new JButton("�޸�");
        queryButton = new JButton("����");
        createButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeDialog(tableModel);
                
            }
        });
      
         ActionListener actionListener = new ActionListener () {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = EmployeeTable.getSelectedRow();
                if(row == -1)
                    return;
                int modelRow = EmployeeTable.convertRowIndexToModel(row);
                tableModel.delete(modelRow);

            }
        };  
        
        new ConfirmDialog(deleteButton, actionListener);
        
        modifyButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = EmployeeTable.getSelectedRow();
                if(row == -1)
                    return;
                int modelRow = EmployeeTable.convertRowIndexToModel(row);
                new EmployeeDialog(tableModel, modelRow, true);
            }
        });
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = EmployeeTable.getSelectedRow();
                if(row == -1)
                    return;
                int modelRow = EmployeeTable.convertRowIndexToModel(row);
                new EmployeeDialog(tableModel, modelRow, false);
            }
        });
        createButton.setBounds(230, 420, 70, 30);
        deleteButton.setBounds(315, 420, 70, 30);
        modifyButton.setBounds(400, 420, 70, 30);
        queryButton.setBounds(485, 420, 70, 30);
        //set panel
        this.setBounds(0, 0, 560, 470);
        this.setLayout(null);
        this.add(EmployeeScrollPane);
        this.add(filterTextField);
        this.add(createButton);
        this.add(deleteButton);
        this.add(modifyButton);
        this.add(queryButton);

    }


    
}
