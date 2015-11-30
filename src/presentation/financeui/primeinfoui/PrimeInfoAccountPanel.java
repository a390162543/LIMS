package presentation.financeui.primeinfoui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import po.AccountPO;
import po.PrimeInfoPO;
import data.PrimeInfoData;
import dataservice.PrimeInfoDataService;
import vo.AccountVO;
import vo.EmployeeVO;
import vo.OrganizationVO;
import vo.PrimeInfoVO;
import vo.StorageCheckVO;
import vo.TruckVO;
import businesslogic.primeinfobl.PrimeInfo;
import businesslogicservice.PrimeInfoblService;


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

    private JButton addButton;
    private JButton deleteButton;
    private JButton createButton;
    
    public PrimeInfoAccountPanel(){
    	List<OrganizationVO>  organization = new ArrayList<OrganizationVO>();
    	List<EmployeeVO>  employee = new ArrayList<EmployeeVO>();
    	List<TruckVO>  truck = new ArrayList<TruckVO>();
    	List<StorageCheckVO>  storage = new ArrayList<StorageCheckVO>();
    	List<AccountVO>  account = new ArrayList<AccountVO>();
    	Date date = new Date();
    	primeInfoblService = new PrimeInfo(new PrimeInfoVO(organization, employee, truck, storage,  account, date));
        //build up account table
        tableModel = new PrimeInfoAccountTableModel(primeInfoblService);  
        tableSorter = new TableRowSorter<TableModel>(tableModel);
        accountTable = new JTable(tableModel);
        accountTable.setSize(800, 500);
        accountTable.setRowSorter(tableSorter);        
        //set scroll pane
        accountScrollPane = new JScrollPane(accountTable);
        accountScrollPane.setBounds(0, 10, 560, 370);
        
        addButton = new JButton("添加");
        deleteButton = new JButton("删除");
        createButton = new JButton("新建账单");
        addButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrimeInfoAccountDialog(tableModel);
                
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
        addButton.setBounds(230, 390, 70, 30);
        deleteButton.setBounds(315, 390, 70, 30);
        createButton.setBounds(425, 390, 130, 30);
        //set panel
        this.setBounds(0, 15, 560, 470);
        this.setLayout(null);
        this.add(accountScrollPane);
        this.add(addButton);
        this.add(deleteButton);
        this.add(createButton);

    }

}
