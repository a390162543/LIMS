package presentation.financeui.primeinfoui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class PrimeInfoDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8284713439380769197L;
	private JPanel parent;
	private JScrollPane primeInfoScrollPane;
	    
	private JTable primeInfoTable;
	private PrimeInfoTableModel tableModel;
	private TableRowSorter<TableModel> tableSorter;
	private JLabel promptLabel;
	private JButton confirmButton;
	private JButton createButton;
	
	public PrimeInfoDialog(JPanel panel){
		parent = panel;
		int dialogx = 380;
		int dialogy = 300;
		promptLabel = new JLabel("您可以选择账单进行期初账单查询:");
		promptLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		promptLabel.setSize(343,22);
		promptLabel.setLocation((dialogx-240)/2, dialogy/10);
		promptLabel.setVisible(true);
	        //build up account table
	        tableModel = new PrimeInfoTableModel();  
	        tableSorter = new TableRowSorter<TableModel>(tableModel);
	        primeInfoTable = new JTable(tableModel);
	        primeInfoTable.setSize(200, 500);
	        primeInfoTable.setRowSorter(tableSorter);        
	        //set scroll pane
	        primeInfoScrollPane = new JScrollPane(primeInfoTable);
	        primeInfoScrollPane.setBounds((dialogx-200)/2, 70, 200, 130);
	
	        
	        confirmButton = new JButton("查看");
	        createButton = new JButton("新建账单");
	        createButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new PrimeInfoPanel(parent);
	                PrimeInfoDialog.this.dispose();
	            }
	        });
	
	        confirmButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	int row = primeInfoTable.getSelectedRow();
	                if(row == -1)
	                    return;
	                int modelRow = primeInfoTable.convertRowIndexToModel(row);
	                
	            	new PrimeInfoQueryPanel(parent ,tableModel,modelRow);
	            	PrimeInfoDialog.this.dispose();
	            }
	        });
	        confirmButton.setBounds(180, 210, 70, 30);
	        createButton.setBounds(270, 210, 70, 30);
	      

	        //set panel
	        this.setModalityType(ModalityType.APPLICATION_MODAL);
	        this.setSize(dialogx, dialogy);
	        this.setLayout(null);
	        this.add(promptLabel);
	        this.add(primeInfoScrollPane);
	        this.add(createButton);
	        this.add(confirmButton);
	        this.setVisible(true);
	    }
}
