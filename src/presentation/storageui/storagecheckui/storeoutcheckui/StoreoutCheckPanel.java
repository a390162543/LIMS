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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import vo.OutOrderCheckResultVO;

/**
 * ���ǿ��鿴ʱ���������ĳ��ⵥ����ʾ�����
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
    	storeoutTotalLabel = new JLabel("�ܳ�������");
    	storeoutTotalLabel.setBounds(350, 200, 120, 25);
    	storeoutTotalTextField = new JTextField();
    	storeoutTotalTextField.setBounds(460, 200, 60, 25);
        tableModel = new StoreoutCheckTableModel(dataList);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        storeoutTable = new JTable(tableModel);
        storeoutTable.setSize(800, 500);
        storeoutTable.setRowSorter(tableSorter);        
        //set scroll pane
        storeoutScrollPane = new JScrollPane(storeoutTable);
        storeoutScrollPane.setBounds(0, 40, 560, 150);
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
        storeoutTotalTextField.setText(dataList.size()+"");
        
        //set panel
        this.setBounds(0, 0, 560, 470);
        this.setLayout(null);
        this.add(storeoutScrollPane);
        this.add(filterTextField);
        this.add(storeoutTotalLabel);
        this.add(storeoutTotalTextField);
    }

}
