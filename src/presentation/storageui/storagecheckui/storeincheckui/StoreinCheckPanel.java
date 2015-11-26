package presentation.storageui.storagecheckui.storeincheckui;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import vo.InOrderCheckResultVO;

public class StoreinCheckPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3607545462714570777L;
	
	
	private JScrollPane storeinScrollPane;
    private JTable storeinTable;
    private StoreinCheckTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;
    
    private JTextField filterTextField;
    private JLabel storeinTotalLabel;
    private JTextField storeinTotalTextField;
   
    
    public StoreinCheckPanel(List<InOrderCheckResultVO> dataList){
        //build up truck table
    	storeinTotalLabel = new JLabel("总入库数量");
    	storeinTotalLabel.setBounds(300, 200, 150, 25);
    	storeinTotalTextField = new JTextField();
    	storeinTotalTextField.setBounds(460, 200, 60, 25);
        tableModel = new StoreinCheckTableModel(dataList);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        storeinTable = new JTable(tableModel);
        storeinTable.setSize(800, 500);
        storeinTable.setRowSorter(tableSorter);        
        //set scroll pane
        storeinScrollPane = new JScrollPane(storeinTable);
        storeinScrollPane.setBounds(0, 40, 560, 130);
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
        
        //set panel
        this.setBounds(0, 0, 560, 300);
        this.setLayout(null);
        this.add(storeinScrollPane);
        this.add(filterTextField);
        this.add(storeinTotalLabel);
        this.add(storeinTotalTextField);
    }

}
