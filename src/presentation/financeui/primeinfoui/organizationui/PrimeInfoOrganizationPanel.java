package presentation.financeui.primeinfoui.organizationui;
 
 
import java.awt.Container;
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
import vo.OrganizationVO;
import businesslogicservice.PrimeInfoblService;

public class PrimeInfoOrganizationPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5055537811206619490L;		
	private JScrollPane OrganizationScrollPane;   
    private JTable OrganizationTable;
    private PrimeInfoOrganizationTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;   
    private PrimeInfoblService primeInfoblService;
    
    public PrimeInfoOrganizationPanel(List<OrganizationVO> vos){
    	 //build up account table
        tableModel = new PrimeInfoOrganizationTableModel(vos);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        OrganizationTable = new JTable(tableModel);
        OrganizationTable.setSize(800, 500);
        OrganizationTable.setRowSorter(tableSorter);        
        //set scroll pane
        OrganizationScrollPane = new JScrollPane(OrganizationTable);
        OrganizationScrollPane.setBounds(0, 10, 560, 370);
        
        JButton queryButton = new JButton("����");
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = OrganizationTable.getSelectedRow();
                if(row == -1)
                    return;
                int modelRow = OrganizationTable.convertRowIndexToModel(row);
                new PrimeInfoOrganizationDialog().showQueryDialog(tableModel, modelRow, false);
                
            }
        });
  
        queryButton.setBounds(485, 390, 70, 30);
        //set panel
        this.setBounds(0, 15, 560, 370);
        this.setLayout(null);
        this.add(OrganizationScrollPane);
        this.add(queryButton);
    	
    }
    public PrimeInfoOrganizationPanel(PrimeInfoblService pibs){
    	 //build up Organization table
    	primeInfoblService = pibs;
        tableModel = new  PrimeInfoOrganizationTableModel(primeInfoblService);
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        OrganizationTable = new JTable(tableModel);
        OrganizationTable.setSize(800, 500);
        OrganizationTable.setRowSorter(tableSorter);        
        //set scroll pane
        OrganizationScrollPane = new JScrollPane(OrganizationTable);
        OrganizationScrollPane.setBounds(0, 10, 560, 370);
        
        JButton createButton = new JButton("���");
        JButton deleteButton = new JButton("ɾ��");
        JButton modifyButton = new JButton("�޸�");
        JButton queryButton = new JButton("��ѯ");
        JButton confirmButton = new JButton("��ɽ���");
        createButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrimeInfoOrganizationDialog().showCreateDialog(tableModel);
                
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = OrganizationTable.getSelectedRow();
                if(row == -1)
                    return;
                int modelRow = OrganizationTable.convertRowIndexToModel(row);
                tableModel.delete(modelRow);

            }
        });
        modifyButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	 int row = OrganizationTable.getSelectedRow();
                 if(row == -1)
                     return;
                 int modelRow = OrganizationTable.convertRowIndexToModel(row);
                 new PrimeInfoOrganizationDialog().showQueryDialog(tableModel, modelRow, false);	 
            }
        });
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = OrganizationTable.getSelectedRow();
                if(row == -1)
                    return;
                int modelRow = OrganizationTable.convertRowIndexToModel(row);
                new PrimeInfoOrganizationDialog().showQueryDialog(tableModel, modelRow, false);
            }
        });
        confirmButton.addActionListener(new ActionListener() {
			
    		@Override
    		public void actionPerformed(ActionEvent e) {
    		// TODO Auto-generated method stub
    			primeInfoblService.createPrimeInfoPO();
    			primeInfoblService.execute();   
    	        Container container = PrimeInfoOrganizationPanel.this.getParent().getParent();
    	        container.removeAll();
    	        container.repaint();
    		}
    	});
       
        createButton.setBounds(60, 390, 70, 30);
        deleteButton.setBounds(145, 390, 70, 30);
        modifyButton.setBounds(230, 390, 70, 30);
        queryButton.setBounds(315, 390, 70, 30);          
        confirmButton.setBounds(425, 390, 130, 30);
        //set panel
        //�ĳ�470�ߵĻ� jtabbedpane �Ͳ���ʾѡ��� ��֪Ϊʲô��������
        this.setBounds(0, 15, 560, 370);
        this.setLayout(null);
        this.add(OrganizationScrollPane);
        this.add(createButton);
        this.add(deleteButton);
        this.add(modifyButton);
        this.add(queryButton);
        this.add(confirmButton);  

    }

}
