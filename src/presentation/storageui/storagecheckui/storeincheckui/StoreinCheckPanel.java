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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import presentation.util.PresentationUtil;
import vo.InOrderCheckResultVO;


/**
 * 这是库存查看时符合条件的入库单的显示的面板
 * @author lc
 * @version 1.3
 *
 */
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
    	storeinTotalLabel.setBounds(440, 200, 120, 25);
    	storeinTotalTextField = new JTextField();
    	storeinTotalTextField.setBounds(550, 200, 60, 25);
        tableModel = new StoreinCheckTableModel(dataList);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        storeinTable = new JTable(tableModel);
        storeinTable.setSize(800, 200);
        storeinTable.setRowSorter(tableSorter);        
        //set scroll pane
        storeinScrollPane = new JScrollPane(storeinTable);
        storeinScrollPane.setBounds(0, 40, 650, 150);
       
        tableModel.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				PresentationUtil.fitTableColumns(storeinTable);
			}
		});
        
        PresentationUtil.fitTableColumns(storeinTable);
        
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
        
        filterTextField.setBounds(360, 0, 235, 25);            
        storeinTotalTextField.setText(dataList.size()+"");
        //set panel
        this.setBounds(0, 0, 650, 300);
        this.setLayout(null);
        this.add(storeinScrollPane);
        this.add(filterTextField);
        this.add(storeinTotalLabel);
        this.add(storeinTotalTextField);
    }

}
