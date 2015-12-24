package presentation.financeui.primeinfoui.organizationui;
 
 
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import presentation.util.ConfirmDialog;
import presentation.util.PresentationUtil;
import presentation.util.ScreenMessage;
import vo.OrganizationVO;
import businesslogicservice.PrimeInfoblService;

public class PrimeInfoOrganizationPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5055537811206619490L;		
	
	private JScrollPane OrganizationScrollPane;   
    private JTable organizationTable;
    private PrimeInfoOrganizationTableModel tableModel;
    private TableRowSorter<TableModel> tableSorter;   
    private PrimeInfoblService primeInfoblService;
    
    public PrimeInfoOrganizationPanel(List<OrganizationVO> vos){
    	 //build up account table
        tableModel = new PrimeInfoOrganizationTableModel(vos);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        organizationTable = new JTable(tableModel);
        organizationTable.setSize(650, 390);
        organizationTable.setRowSorter(tableSorter);        
        //set scroll pane
        OrganizationScrollPane = new JScrollPane(organizationTable);
        OrganizationScrollPane.setBounds(0, 0, 650, 390);
        
        tableModel.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
			       PresentationUtil.fitTableColumns(organizationTable);
			}
		});
        
        PresentationUtil.fitTableColumns(organizationTable);
        
        JButton queryButton = new JButton("详情");
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = organizationTable.getSelectedRow();
                if(row == -1)
                	ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
                else{
                	int modelRow = organizationTable.convertRowIndexToModel(row);
                	new PrimeInfoOrganizationDialog(tableModel, modelRow, false);
                }          
            }
        });

        queryButton.setBounds(485+90, 400, 70, 30);
        //set panel
        this.setBounds(0, 15, 650, 470);
        this.setLayout(null);
        this.add(OrganizationScrollPane);
        this.add(queryButton);   	
    }
    
    
    public PrimeInfoOrganizationPanel(PrimeInfoblService pibs){
    	 //build up Organization table
    	primeInfoblService = pibs;
        tableModel = new  PrimeInfoOrganizationTableModel(primeInfoblService);
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        organizationTable = new JTable(tableModel);
        organizationTable.setSize(650, 390);
        organizationTable.setRowSorter(tableSorter);        
        //set scroll pane
        OrganizationScrollPane = new JScrollPane(organizationTable);
        OrganizationScrollPane.setBounds(0, 0, 650, 390);
        
        PresentationUtil.fitTableColumns(organizationTable);
        
        JButton createButton = new JButton("添加");
        JButton deleteButton = new JButton("删除");
        JButton modifyButton = new JButton("修改");
        JButton queryButton = new JButton("查询");
        JButton confirmButton = new JButton("完成建账");
        createButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrimeInfoOrganizationDialog(tableModel);
                
            }
        });
        
        ActionListener actionListener = new ActionListener () {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = organizationTable.getSelectedRow();
                if(row == -1){
                	ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);             	
                }                
                else{
                	ConfirmDialog.createConfirmDialog(deleteButton, new ActionListener() {					
						@Override
						public void actionPerformed(ActionEvent e) {						 
							 int modelRow = organizationTable.convertRowIndexToModel(row);
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
            	 int row = organizationTable.getSelectedRow();
                 if(row == -1)
                	 ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
                 else{
                	 int modelRow = organizationTable.convertRowIndexToModel(row);
                	 new PrimeInfoOrganizationDialog(tableModel, modelRow, true); 
                 }
	 
            }
        });
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = organizationTable.getSelectedRow();
                if(row == -1)
                	ScreenMessage.putOnScreen(ScreenMessage.NO_CHOOSE_IN_TABLE);
                else{
                	int modelRow = organizationTable.convertRowIndexToModel(row);
                	new PrimeInfoOrganizationDialog(tableModel, modelRow, false);
                }
  
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
       
        createButton.setBounds(60+90, 400, 70, 30);
        deleteButton.setBounds(145+90, 400, 70, 30);
        modifyButton.setBounds(230+90, 400, 70, 30);
        queryButton.setBounds(315+90, 400, 70, 30);          
        confirmButton.setBounds(425+90, 400, 130, 30);
        //set panel
        //改成470高的话 jtabbedpane 就不显示选项卡了 不知为什么！！！！
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
