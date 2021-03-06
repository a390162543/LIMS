package presentation.storageui.storagecheckui.storeoutcheckui;

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
import vo.OutOrderCheckResultVO;

/**
 * 这是库存查看时符合条件的出库单的显示的面板
 * @author lc
 * @version 1.3
 *
 */
public class StoreoutCheckPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8806896108344483250L;
	
	private JScrollPane storeoutScrollPane;
    private JTable storeoutTable;
    private StoreoutCheckTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;
    
    private JTextField filterTextField;
    private JLabel storeoutTotalLabel;
    private JTextField storeoutTotalTextField;
   
    
    public StoreoutCheckPanel(List<OutOrderCheckResultVO> dataList){
        //build up truck table
    	storeoutTotalLabel = new JLabel("总出库数量");
    	storeoutTotalLabel.setBounds(440, 195, 120, 25);
    	storeoutTotalTextField = new JTextField();
    	storeoutTotalTextField.setBounds(550, 195, 60, 25);
        tableModel = new StoreoutCheckTableModel(dataList);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        storeoutTable = new JTable(tableModel);
        storeoutTable.setSize(800, 500);
        storeoutTable.setRowSorter(tableSorter);        

        storeoutScrollPane = new JScrollPane(storeoutTable);
        storeoutScrollPane.setBounds(0, 40, 650, 150);
        
        tableModel.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				PresentationUtil.fitTableColumns(storeoutTable);
			}
		});
        
        PresentationUtil.fitTableColumns(storeoutTable);
        
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
        
        filterTextField.setBounds(360, 0, 235, 25);
        storeoutTotalTextField.setText(dataList.size()+"");
        
        //set panel
        this.setBounds(0, 0, 650, 470);
        this.setLayout(null);
        this.add(storeoutScrollPane);
        this.add(filterTextField);
        this.add(storeoutTotalLabel);
        this.add(storeoutTotalTextField);
    }

}
