package presentation.transitcenterui.transferui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

 


import presentation.util.OrganizationComboBox;
import presentation.util.RecentDatePickPanel;
import vo.TransferVO;
 
import businesslogic.transferbl.Transfer;
 
import businesslogic.userbl.LoginController;
import businesslogicservice.TransferblService;

public class TransferDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3513694959788276702L;
	 
	private JTextField expensesField;
	private JComboBox< String> departBox;
	private JComboBox<String> destinationBox;
	private OrderTableModel tableModel;
	private TransferblService transferblService;
	
	public TransferDialog(){
		transferblService = new Transfer();		 
		JLabel infoLabel = new JLabel("中转单");
		infoLabel.setBounds(105, 5, 170, 35);
		JTextField idField = new JTextField();
		idField.setBounds(105, 50, 180, 20);
		JLabel idLabel = new JLabel("中转单编号");
		idLabel.setBounds(20, 50, 80, 20);
		JLabel dateLabel = new JLabel("装车日期");
		dateLabel.setBounds(20, 90, 80, 20);
		
		RecentDatePickPanel datePickPanel = new RecentDatePickPanel();
        datePickPanel.setBounds(100, 90, 200, 25);
        this.add(datePickPanel);
		 
		JLabel flightNumLabel = new JLabel("航班号");
		flightNumLabel.setBounds(20, 130, 80, 20);
		JTextField flightNumField = new JTextField();
		flightNumField.setBounds(105, 130, 180, 20);
		
		JLabel departLabel = new JLabel("出发地");
		departLabel.setBounds(20, 170, 80, 20);		
		departBox = new OrganizationComboBox();
		departBox.setLocation(105, 170);
		JLabel destinationLabel = new JLabel("目的地");
		destinationLabel.setBounds(20, 210, 80, 20);
		
		destinationBox = new OrganizationComboBox();
		destinationBox.setLocation(105, 210);
		destinationBox.setSelectedItem(LoginController.getOrganizationName());
		destinationBox.setEnabled(false);
		
		JLabel containerIdLabel = new JLabel("货柜号");
		containerIdLabel.setBounds(20, 250, 80, 20);
		JTextField containerIdField = new JTextField();
		containerIdField.setBounds(105, 250, 60, 20);
		JLabel loanManLabel = new JLabel("监装员");
		loanManLabel.setBounds(175, 250, 80, 20);
		JTextField loanManField = new JTextField();
		loanManField.setBounds(245, 250, 60, 20);
		JLabel orderIdLabel = new JLabel("订单");
		orderIdLabel.setBounds(20, 290, 80, 20);
		JLabel expensesLabel = new JLabel("运费");
		expensesLabel.setBounds(20, 370, 80, 20);
		expensesField = new JTextField();
		expensesField.setBounds(105, 370, 60, 20);
		
		tableModel = new OrderTableModel(transferblService);  
		TableRowSorter<TableModel>  tableSorter = new TableRowSorter<TableModel>(tableModel);
		JTable orderTable = new JTable(tableModel);
	    orderTable.setSize(180, 60);
	    orderTable.setRowSorter(tableSorter);        
	    JScrollPane OrderScrollPane = new JScrollPane(orderTable);
	    OrderScrollPane.setBounds(105, 290, 180, 60);	        
	    JButton addOrderButton = new JButton("添加订单");
	    addOrderButton.setBounds(300, 290, 70, 20);
		JButton deleteOrderButton = new JButton("删除订单");
		deleteOrderButton.setBounds(300, 320, 70, 20);
		addOrderButton.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// new AddOrderDialog(tableModel, dialog);
					 new AddOrderDialog();
			}
		});
			
		deleteOrderButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = orderTable.getSelectedRow();
	               if(row == -1)
	                   return;
	               int modelRow = orderTable.convertRowIndexToModel(row);
	               tableModel.delete(modelRow);
			}
		});
		
		JButton cancleButton = new JButton("取消");
		cancleButton.setBounds(190, 410, 70, 30);
		JButton sureButton = new JButton("确定");
		sureButton.setBounds(280, 410, 70, 30);
		 
		cancleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TransferDialog.this.dispose();
			}
		});
		
		sureButton.addActionListener(new ActionListener() {
			
			 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = idField.getText();
				Date loadDate = datePickPanel.getTime();
				String flightNum = flightNumField.getText();
				String depart = (String) departBox.getSelectedItem();
				String destination = (String) destinationBox.getSelectedItem();
				String containerId = containerIdField.getText();
				String loadMan = loanManField.getText();
				List<String> orderId = new ArrayList<String>();
				for(int i = 0; i < orderTable.getRowCount(); i ++)
					orderId.add((String)orderTable.getValueAt(i, 0));
				double expenses = new Double(expensesField.getText());
				TransferVO vo = new TransferVO(id, loadDate, flightNum, depart, destination,
						containerId, loadMan, orderId, expenses);
				transferblService.createTransferPO(vo);
			}
		});
		
		 
		
		this.add(infoLabel);
		this.add(idLabel);
		this.add(idField);
		this.add(dateLabel);
		this.add(dateLabel);	 
		this.add(flightNumLabel);
		this.add(flightNumField);
		this.add(departLabel);
		this.add(departBox);
		this.add(destinationLabel);
		this.add(destinationBox);
		this.add(containerIdLabel);
		this.add(containerIdField);
		this.add(loanManLabel);
		this.add(loanManField);
		this.add(orderIdLabel);
		this.add(expensesLabel);
		this.add(expensesField);
		this.add(cancleButton);
		this.add(sureButton);	 
		this.add(OrderScrollPane);
		this.add(addOrderButton);
		this.add(deleteOrderButton);
		this.setBounds(0, 0, 380, 470);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public void setExpensesField(){
		expensesField.setText("" + transferblService.getCost
				((String)departBox.getSelectedItem(),(String) destinationBox.getSelectedItem() ));
	}
	
	    class AddOrderDialog extends JDialog{

		 
		/**
			 * 
			 */
			private static final long serialVersionUID = -5436641251910399740L;
		 
		
		
		public AddOrderDialog( ){
			 
			JLabel infoLanel = new JLabel("订单");
			infoLanel.setBounds(105, 10, 170, 35);
			JLabel orderLabel = new JLabel("订单号");
			orderLabel.setBounds(35, 85, 100, 24);
			JTextField orderField = new JTextField();
			orderField.setBounds(145, 85, 180, 20);
			JButton cancelButton = new JButton("取消");
			cancelButton.setBounds(190, 150, 70, 30);
			JButton confirmButton = new JButton("确定");
			confirmButton.setBounds(275, 150, 70, 30);
			
			cancelButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					AddOrderDialog.this.dispose();
				}
			});
			
			confirmButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					tableModel.add(orderField.getText());
					setExpensesField();
										
				}
			});
			
			this.add(infoLanel);
			this.add(orderLabel);
			this.add(orderField);
			this.add(cancelButton);
			this.add(confirmButton);
			this.setLayout(null);
			this.setBounds(100, 100, 380, 240);
			this.setVisible(true);		
		}

	}
	  
	 
	
}
