package presentation.financeui.primeinfoui.accountui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import presentation.util.ConfirmDialog;
import presentation.util.ScreenMessage;
import vo.AccountVO;
import businesslogicservice.PrimeInfoblService;

/**
 * {@code AccountPanel}�̳�{@code JPanel}�����ڳ�������ʾ�˻���Ϣ�Ͷ��˻������Ľ�������չʾ
 * @author ���¿�
 *
 */
public class PrimeInfoAccountPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2604706309395668342L;
	
	private PrimeInfoblService primeInfoblService;
	private JScrollPane accountScrollPane;
    private JTable accountTable;
    private PrimeInfoAccountTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;

    private JButton queryButton;
    private JButton modifyButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton createButton;
    
    public PrimeInfoAccountPanel(List<AccountVO> vos ){	
        //build up account table
        tableModel = new PrimeInfoAccountTableModel(vos);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        accountTable = new JTable(tableModel);
        accountTable.setSize(650,390);
        accountTable.setRowSorter(tableSorter);        
        //set scroll pane
        accountScrollPane = new JScrollPane(accountTable);
        accountScrollPane.setBounds(0, 0, 650,390);
        
        queryButton = new JButton("����");
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = accountTable.getSelectedRow();
                if(row == -1)
                    return;
                int modelRow = accountTable.convertRowIndexToModel(row);
                new PrimeInfoAccountDialog(tableModel ,modelRow , false);
                
            }
        });
  
        queryButton.setBounds(485 +90, 400, 70, 30);
        //set panel
        this.setBounds(0, 15, 650, 470);
        this.setLayout(null);
        this.add(accountScrollPane);
        this.add(queryButton);

    }
    
    public PrimeInfoAccountPanel(PrimeInfoblService primeInfoblService2){
    	
        	this.primeInfoblService = primeInfoblService2;
            //build up account table
            tableModel = new PrimeInfoAccountTableModel(primeInfoblService);  
            tableSorter = new TableRowSorter<TableModel>(tableModel);
            accountTable = new JTable(tableModel);
            accountTable.setSize(650,390);
            accountTable.setRowSorter(tableSorter);        
            //set scroll pane
            accountScrollPane = new JScrollPane(accountTable);
            accountScrollPane.setBounds(0, 0, 650,390);
            
            addButton = new JButton("���");
            deleteButton = new JButton("ɾ��");
            modifyButton = new JButton("�޸�");
            queryButton = new JButton("��ѯ");
            createButton = new JButton("��ɽ���");
            addButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    new PrimeInfoAccountDialog(tableModel);
                    
                }
            });
            ActionListener actionListener = new ActionListener () {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = accountTable.getSelectedRow();
                    if(row == -1){
                    	ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);             	
                    }                
                    else{
                    	ConfirmDialog.createConfirmDialog(deleteButton, new ActionListener() {					
    						@Override
    						public void actionPerformed(ActionEvent e) {						 
    							 int modelRow = accountTable.convertRowIndexToModel(row);
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
                    int row = accountTable.getSelectedRow();
                    if(row == -1)
                        return;
                    int modelRow = accountTable.convertRowIndexToModel(row);
                    new PrimeInfoAccountDialog(tableModel ,modelRow ,true);
                }
            });
            queryButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = accountTable.getSelectedRow();
                    if(row == -1)
                        return;
                    int modelRow = accountTable.convertRowIndexToModel(row);
                    new PrimeInfoAccountDialog(tableModel ,modelRow ,false);
                }
            });
            createButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                	primeInfoblService.createPrimeInfoPO();
                	primeInfoblService.execute();
     
                	Container container = PrimeInfoAccountPanel.this.getParent().getParent();
                	container.removeAll();
                	container.repaint();
                }
            });
            addButton.setBounds(60 + 90 , 400, 70, 30);
            deleteButton.setBounds(145+ 90 , 400, 70, 30);
            modifyButton.setBounds(230+ 90 , 400, 70, 30);
            queryButton.setBounds(315+ 90, 400, 70, 30);          
            createButton.setBounds(425 + 90, 400, 130, 30);
            //set panel
            this.setBounds(0, 15, 650, 470);
            this.setLayout(null);
            this.add(accountScrollPane);
            this.add(addButton);
            this.add(deleteButton);
            this.add(modifyButton);
            this.add(queryButton);
            this.add(createButton);
    }
}
