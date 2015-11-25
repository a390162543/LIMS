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

import presentation.courierui.ordercreateui.OrderCreateDialog;
import vo.TransferVO;
import businesslogic.organizationbl.Organization;
import businesslogic.transferbl.Transfer;
import businesslogicservice.OrganizationblService;
import businesslogicservice.TransferblService;

public class TransferDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3513694959788276702L;
	 
	private OrganizationblService organizationblService;
	private JTextField expensesField;
	private JComboBox< String> departBox;
	private JComboBox<String> destinationBox;
	private OrderTableModel tableModel;
	private TransferblService transferblService;
	
	public TransferDialog(){
		transferblService = new Transfer();
		organizationblService = new Organization();
		Integer[] yearArray = new Integer[]{2015,2016};
		Integer[] monthArray = new Integer[]{1,2};
		Integer[] dayArray = new Integer[]{1,2};
//		List<String> nameLise = organizationblService.getAllOrganizationName();
//		String[] departStr  =    nameLise.toArray(new String[nameLise.size()]);		 
//		String[] destinationStr = departStr;
		 
		JLabel infoLabel = new JLabel("��ת��");
		infoLabel.setBounds(105, 5, 170, 35);
		JTextField idField = new JTextField();
		idField.setBounds(105, 50, 180, 20);
		JLabel idLabel = new JLabel("��ת�����");
		idLabel.setBounds(20, 50, 80, 20);
		JLabel dateLabel = new JLabel("װ������");
		dateLabel.setBounds(20, 90, 80, 20);
		JComboBox<Integer> yearBox = new JComboBox<Integer>(yearArray);
		yearBox.setBounds(105,90, 60, 20);
		JComboBox<Integer> monthBox = new JComboBox<Integer>(monthArray);
		monthBox.setBounds(185, 90, 60, 20);
		JComboBox<Integer> dayBox = new JComboBox<Integer>(dayArray);
		dayBox.setBounds(265, 90, 60, 20);
		JLabel yearLabel = new JLabel("��");
		yearLabel.setBounds(165, 90, 20, 20);
		JLabel monthLabel = new JLabel("��");
		monthLabel.setBounds(245, 90, 20, 20);
		JLabel dayLabel = new JLabel("��");
		dateLabel.setBounds(325, 90, 20, 20);
		JLabel flightNumLabel = new JLabel("�����");
		flightNumLabel.setBounds(20, 130, 80, 20);
		JTextField flightNumField = new JTextField();
		flightNumField.setBounds(105, 130, 180, 20);
		JLabel departLabel = new JLabel("������");
		departLabel.setBounds(20, 170, 80, 20);
		departBox = new JComboBox<String>( );
		departBox.setBounds(105, 170, 180, 20);
		JLabel destinationLabel = new JLabel("Ŀ�ĵ�");
		destinationLabel.setBounds(20, 210, 80, 20);
		destinationBox = new JComboBox<String>();
		destinationBox.setBounds(105, 210, 180, 20);
		JLabel containerIdLabel = new JLabel("�����");
		containerIdLabel.setBounds(20, 250, 80, 20);
		JTextField containerIdField = new JTextField();
		containerIdField.setBounds(105, 250, 60, 20);
		JLabel loanManLabel = new JLabel("��װԱ");
		loanManLabel.setBounds(175, 250, 80, 20);
		JTextField loanManField = new JTextField();
		loanManField.setBounds(245, 250, 60, 20);
		JLabel orderIdLabel = new JLabel("����");
		orderIdLabel.setBounds(20, 290, 80, 20);
		JLabel expensesLabel = new JLabel("�˷�");
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
	    JButton addOrderButton = new JButton("���Ӷ���");
	    addOrderButton.setBounds(300, 290, 70, 20);
		JButton deleteOrderButton = new JButton("ɾ������");
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
		
		JButton cancleButton = new JButton("ȡ��");
		cancleButton.setBounds(190, 410, 70, 30);
		JButton sureButton = new JButton("ȷ��");
		sureButton.setBounds(280, 410, 70, 30);
		 
		cancleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TransferDialog.this.dispose();
			}
		});
		
		sureButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = idField.getText();
				Date loadDate = new Date((Integer)yearBox.getSelectedItem(), 
						(Integer)monthBox.getSelectedItem(),(Integer)monthBox.getSelectedItem());
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
		this.add(yearBox);
		this.add(yearLabel);
		this.add(monthBox);
		this.add(monthLabel);
		this.add(dayBox);
		this.add(dayLabel);
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
			 
			JLabel infoLanel = new JLabel("����");
			infoLanel.setBounds(105, 10, 170, 35);
			JLabel orderLabel = new JLabel("������");
			orderLabel.setBounds(35, 85, 100, 24);
			JTextField orderField = new JTextField();
			orderField.setBounds(145, 85, 180, 20);
			JButton cancelButton = new JButton("ȡ��");
			cancelButton.setBounds(190, 150, 70, 30);
			JButton confirmButton = new JButton("ȷ��");
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