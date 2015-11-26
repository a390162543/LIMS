package presentation.storageui.storagequeryui;

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

import vo.StorageQueryResultVO;


public class StorageQueryPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4312274032428622531L;
	
	
	private JScrollPane storageQueryScrollPane;
    private JTable storageQueryTable;
    private StorageQueryTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;
    
    private JTextField filterTextField;
    
    private JButton getExcelButton;
    
    public StorageQueryPanel(List<StorageQueryResultVO> dataList){
        //build up truck table
    	getExcelButton = new JButton("导出Excel表格");
    	getExcelButton.setBounds(360, 360, 160, 25);
        tableModel = new StorageQueryTableModel(dataList);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        storageQueryTable = new JTable(tableModel);
        storageQueryTable.setSize(800, 500);
        storageQueryTable.setRowSorter(tableSorter);        
        //set scroll pane
        storageQueryScrollPane = new JScrollPane(storageQueryTable);
        storageQueryScrollPane.setBounds(0, 40, 540, 300);
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
        filterTextField.setBounds(300, 0, 235, 25);
        
        getExcelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
        
        //set panel
        this.setBounds(0, 0, 540, 430);
        this.setLayout(null);
        this.add(getExcelButton);
        this.add(storageQueryScrollPane);
        this.add(filterTextField);
        
    }

}
