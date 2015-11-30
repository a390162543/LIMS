package presentation.financeui.accountui;

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

public class AccountPanel extends JPanel{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 7177618034393345294L;

	private JScrollPane accountScrollPane;
	    
	    private JTable accountTable;
	    private AccountTableModel tableModel;
	    private TableRowSorter<TableModel> tableSorter;
	    
	    private JTextField filterTextField;
	    private JButton createButton;
	    private JButton deleteButton;
	    private JButton modifyButton;
	    private JButton queryButton;
	    
	    public AccountPanel(JPanel panel){
	    	panel.removeAll();
	        //build up account table
	        tableModel = new AccountTableModel();  
	        tableSorter = new TableRowSorter<TableModel>(tableModel);
	        accountTable = new JTable(tableModel);
	        accountTable.setSize(800, 500);
	        accountTable.setRowSorter(tableSorter);        
	        //set scroll pane
	        accountScrollPane = new JScrollPane(accountTable);
	        accountScrollPane.setBounds(0, 40, 560, 370);
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
	        
	        createButton = new JButton("创建");
	        deleteButton = new JButton("删除");
	        modifyButton = new JButton("修改");
	        queryButton = new JButton("详情");
	        createButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new AccountDialog(tableModel);
	                
	            }
	        });
	        deleteButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int row = accountTable.getSelectedRow();
	                if(row == -1)
	                    return;
	                int modelRow = accountTable.convertRowIndexToModel(row);
	                tableModel.delete(modelRow);

	            }
	        });
	        modifyButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int row = accountTable.getSelectedRow();
	                if(row == -1)
	                    return;
	                int modelRow = accountTable.convertRowIndexToModel(row);
	                new AccountDialog(tableModel, modelRow, true);
	            }
	        });
	        queryButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int row = accountTable.getSelectedRow();
	                if(row == -1)
	                    return;
	                int modelRow = accountTable.convertRowIndexToModel(row);
	                new AccountDialog(tableModel, modelRow, false);
	            }
	        });
	        createButton.setBounds(230, 420, 70, 30);
	        deleteButton.setBounds(315, 420, 70, 30);
	        modifyButton.setBounds(400, 420, 70, 30);
	        queryButton.setBounds(485, 420, 70, 30);
	        //set panel
	        this.setBounds(0, 0, 560, 470);
	        this.setLayout(null);
	        this.add(accountScrollPane);
	        this.add(filterTextField);
	        this.add(createButton);
	        this.add(deleteButton);
	        this.add(modifyButton);
	        this.add(queryButton);
	        
	        panel.setLayout(null);
	        panel.add(this);
			panel.setVisible(true);
			panel.repaint();
	    }


}
