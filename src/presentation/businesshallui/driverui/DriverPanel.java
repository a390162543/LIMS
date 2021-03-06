package presentation.businesshallui.driverui;


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
import presentation.util.PresentationUtil;
import presentation.util.ScreenMessage;


/**
 * 司机信息的{@code JPanel}，提供了一个{@code Jtable}用以表格显示信息
 * <p>提供了司机信息增删改查的功能
 * @author 林祖华
 * @version 1.6
 * @see businesslogicservice.EmployeeblService
 */
public class DriverPanel extends JPanel{
    
    /**
     * 
     */
    private static final long serialVersionUID = -7230933721561303362L;
    
    private JScrollPane EmployeeScrollPane;
    
    private JTable EmployeeTable;
    private DriverTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;
    
    private JTextField filterTextField;
    private JButton createButton;
    private JButton deleteButton;
    private JButton modifyButton;
    private JButton queryButton;
    
    public DriverPanel(){
        //build up Employee table
        tableModel = new DriverTableModel();  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        EmployeeTable = new JTable(tableModel);
        EmployeeTable.setSize(650, 390);
        EmployeeTable.setRowSorter(tableSorter);

        //set scroll pane
        EmployeeScrollPane = new JScrollPane(EmployeeTable);
        EmployeeScrollPane.setBounds(0, 40, 650, 390);
        PresentationUtil.fitTableColumns(EmployeeTable);
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
        filterTextField.setBounds(410, 0, 235, 25);
        
        createButton = new JButton("创建");
        deleteButton = new JButton("删除");
        modifyButton = new JButton("修改");
        queryButton = new JButton("详情");
        createButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new DriverDialog(tableModel);
                
            }
        });
        
        deleteButton.addActionListener(new ActionListener () {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = EmployeeTable.getSelectedRow();
                if(row == -1){
                    ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);                
                }else{
                    ConfirmDialog.createConfirmDialog(deleteButton, new ActionListener() {                  
                        @Override
                        public void actionPerformed(ActionEvent e) {                         
                             int modelRow = EmployeeTable.convertRowIndexToModel(row);
                             tableModel.delete(modelRow);
                             ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
                        }
                    });
                }
            }
        });
        
        modifyButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = EmployeeTable.getSelectedRow();
                if(row == -1){
                    ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
                    return;
                }
                int modelRow = EmployeeTable.convertRowIndexToModel(row);
                new DriverDialog(tableModel, modelRow, true);
            }
        });
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = EmployeeTable.getSelectedRow();
                if(row == -1){
                    ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
                    return;
                }
                int modelRow = EmployeeTable.convertRowIndexToModel(row);
                new DriverDialog(tableModel, modelRow, false);
            }
        });
        createButton.setBounds(320, 440, 70, 30);
        deleteButton.setBounds(405, 440, 70, 30);
        modifyButton.setBounds(490, 440, 70, 30);
        queryButton.setBounds(575, 440, 70, 30);
        //set panel
        this.setBounds(0, 0, 560, 450);
        this.setLayout(null);
        this.add(EmployeeScrollPane);
        this.add(filterTextField);
        this.add(createButton);
        this.add(deleteButton);
        this.add(modifyButton);
        this.add(queryButton);
    }


    
}
