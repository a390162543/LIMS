package presentation.managerui.approvalui.transferui;

 
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel; 
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import presentation.transitcenterui.transferui.OrderTableModel;
import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DialogLayoutManager;
import presentation.util.OrganizationComboBox;
import presentation.util.RecentDatePickPanel;
import systemenum.ShipForm;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.Name;
import businesslogic.checkbl.transferinfo.OrderChecker;
import businesslogic.checkbl.transferinfo.TransferNumber;
import businesslogicservice.TransferblService;
 
import vo.TransferVO;

/**
 * 查看，修改中转单界面
 * @author 刘航伸
 * @see TransferblService 
 * @version 1.4
 */
public class TransferPendingDialog extends JDialog {
	
	 

    /**
	 * 
	 */
	private static final long serialVersionUID = -2401054928878228625L;

	 
    
    private TransferPendingTableModel transferPendingTableModel;
	private JTextField expensesField;
	private JComboBox< String> departBox;
	private JComboBox<String> destinationBox;
	private JRadioButton flightButton ;
	private JRadioButton trainButton;
	private JRadioButton truckButton;
	private ButtonGroup way;
	private OrderTableModel orderTableModel;
	private TransferblService transferblService;
	private Checker containerNumberChecker;
	private Checker flightNumberChecker ;
	private Checker orderCheck;
	private Checker nameChecker; 
 
    public TransferPendingDialog(TransferPendingTableModel tm, int modelRow, boolean isEditable) {
    	transferPendingTableModel = tm;
    	transferblService = BusinessLogicService.getTransferblService();
		 
	 //设置组件
		JLabel wayLabel = new JLabel("货运方式");
		wayLabel.setBounds(20, 50, 80, 20);
		flightButton = new JRadioButton("航空");
		flightButton.setBounds(110, 50, 80, 20);
		trainButton = new JRadioButton("铁路");
		trainButton.setBounds(190, 50, 80, 20);
		truckButton = new JRadioButton("汽运");
		truckButton.setBounds(270, 50, 80, 20);
		way = new ButtonGroup();
		way.add(flightButton);
		way.add(trainButton);
		way.add(truckButton);
		 		
		JTextField idField = new JTextField();
		idField.setBounds(105, 10, 180, 20);
		JLabel idLabel = new JLabel("中转单编号");
		idLabel.setBounds(20, 10, 80, 20);
		JLabel dateLabel = new JLabel("装车日期");
		dateLabel.setBounds(20, 90, 80, 20);
		 RecentDatePickPanel datePickPanel = new RecentDatePickPanel();
		 datePickPanel.setBounds(105, 90, 200, 25);
		 
		JLabel flightNumLabel = new JLabel("航班号");
		flightNumLabel.setBounds(20, 130, 80, 20);
		JTextField flightNumField = new JTextField();
		flightNumField.setBounds(105, 130, 180, 20);
		JLabel departLabel = new JLabel("出发地");
		departLabel.setBounds(20, 170, 80, 20);
		departBox = new OrganizationComboBox();
		departBox.setBounds(105, 170, 180, 20);
		JLabel destinationLabel = new JLabel("目的地");
		destinationLabel.setBounds(20, 210, 80, 20);
		destinationBox = new OrganizationComboBox();
		destinationBox.setBounds(105, 210, 180, 20);
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
		
		// 显示中转单信息
		TransferVO vo = transferPendingTableModel.getTransferVO(modelRow);
		idField.setText(vo.getId());
		switch (vo.getShipForm()) {
		case TRAIN:
			trainButton.setSelected(true); break;
		case PLANE: 
			flightButton.setSelected(true); break;
		case CAR:
			truckButton.setSelected(true); break;
		default:
			break;
		}
		flightNumField.setText(vo.getFlightNumbe());
		departBox.setSelectedItem(vo.getDepart());
		destinationBox.setSelectedItem(vo.getDestination());
		datePickPanel.setDate(vo.getLoadDate());
		containerIdField.setText(vo.getContainerId());
		loanManField.setText(vo.getLoadMan());
		expensesField.setText(""+vo.getExpenses());		
		orderTableModel = new OrderTableModel(transferblService);  
		TableRowSorter<TableModel>  tableSorter = new TableRowSorter<TableModel>(orderTableModel);
		JTable orderTable = new JTable(orderTableModel);
	    orderTable.setSize(180, 60);
	    orderTable.setRowSorter(tableSorter);        
	    orderTable.getTableHeader().setPreferredSize(new Dimension(180, 25));
	    JScrollPane orderScrollPane = new JScrollPane(orderTable);
	    orderScrollPane.setBounds(105, 290,250, 100);	        
	    JButton addOrderButton = new JButton("添加订单");
	    addOrderButton.setBounds(280, 400, 70, 20);
		JButton deleteOrderButton = new JButton("删除订单");
		deleteOrderButton.setBounds(200, 400, 70, 20);
		addOrderButton.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// new AddOrderDialog(OrderTableModel, dialog);
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
	               orderTableModel.delete(modelRow);
			}
		});
		
		JButton cancleButton = new JButton("取消");
		cancleButton.setBounds(190, 470, 70, 30);
		JButton sureButton = new JButton("确定");
		sureButton.setBounds(280, 470, 70, 30);		
		 
		cancleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TransferPendingDialog.this.dispose();
			}
		});
		
		
		sureButton.addActionListener(new ActionListener() {
				 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(isEditable){
					String id = idField.getText();
					Date loadDate = datePickPanel.getTime();
					String flightNum = flightNumField.getText();
					String depart = (String) departBox.getSelectedItem();
					String destination = (String) destinationBox.getSelectedItem();
					String containerId = containerIdField.getText();
					String loadMan = loanManField.getText();
					List<String> orderId = new ArrayList<String>();
					for(int i = 0; i < orderTable.getRowCount(); i ++){
						orderId.add((String)orderTable.getValueAt(i, 0));
					}
						
					double expenses = new Double(expensesField.getText());
					ShipForm shipForm = null;
					if(trainButton.isSelected())
						shipForm = ShipForm.TRAIN;
					else if(flightButton.isSelected())
						shipForm = ShipForm.PLANE;
					else 
						shipForm = ShipForm.CAR;
					TransferVO vo = new TransferVO(id, loadDate, flightNum, depart, destination,
							containerId, loadMan, orderId, expenses,shipForm);
					transferblService.modifyTransferPO(vo);	
				}
				else {
					TransferPendingDialog.this.dispose();
					return;
				}
				
			}
		});
		
		if(!isEditable){
			 
			flightNumField.setEnabled(true);
			departBox.setEnabled(true);
			destinationBox.setEnabled(true);
			containerIdField.setEnabled(true);
			loanManField.setEnabled(true);
			addOrderButton.setEnabled(true);
			deleteOrderButton.setEnabled(true);
			expensesField.setEnabled(true);
		}
		
		 
		
 
		this.add(idLabel);
		this.add(idField);
		
		this.add(wayLabel);
		this.add(trainButton);
		this.add(flightButton);
		this.add(truckButton);
		DialogLayoutManager.fix(trainButton, flightButton, truckButton);
		
		this.add(dateLabel);		 	
		this.add(datePickPanel);
		
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
				
		this.add(orderScrollPane);
		this.add(addOrderButton);
		this.add(deleteOrderButton);
		DialogLayoutManager.fix(orderScrollPane, deleteOrderButton, addOrderButton);
		
		this.add(sureButton);
		this.add(cancleButton);
		
		this.setBounds(0, 0, 380, 550);
		this.setLayout(new DialogLayoutManager());
		this.setVisible(true);
		
		//添加检查
		  flightNumberChecker = new Checker(flightNumField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(flightNumField.getText() == null){
					return null;
				}
				else{
					return new TransferNumber(flightNumField.getText());
				}
				 
			}
		});
		flightNumField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				flightNumberChecker.check();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		 
		
		containerNumberChecker = new Checker(containerIdField, new CheckInfoGetter() {			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(containerIdField.getText() == null){
					return null;
				}
				else{
					return new TransferNumber(containerIdField.getText());
				}
				 
			}
		});
		containerIdField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				containerNumberChecker.check();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		nameChecker = new Checker(loanManField,new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				if(loanManField.getText() == null){
					return null;
				}
				else{
					return new Name(loanManField.getText());
				}
			}
		});
		loanManField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				nameChecker.check();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		

    }
    
    public void setExpensesField(){
    	double distance = 0.0;
		String wayStr = "";
		if(flightButton.isSelected())
			wayStr = "航空";
		else if(trainButton.isSelected())
			wayStr = "铁路";
		else {
			wayStr = "汽运";
		}
		distance = transferblService.getCost
				((String)departBox.getSelectedItem(),(String) destinationBox.getSelectedItem(), wayStr);
		
		expensesField.setText("" +  distance);
	}
	
	    class AddOrderDialog extends JDialog{	
		/**
			 * 
			 */
			private static final long serialVersionUID = 1339326680556538387L;
		 
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
					orderTableModel.add(orderField.getText());
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
			
			//添加订单检查
			orderCheck = new Checker(orderField,new CheckInfoGetter() {
				
				@Override
				public CheckInfo getCheckInfo() {
					// TODO Auto-generated method stub
					if(orderField.getText() == null){
						return null;
					}
					else {
						ShipForm shipForm = null;
						if(trainButton.isSelected())
							shipForm = ShipForm.TRAIN;
						else if(flightButton.isSelected())
							shipForm = ShipForm.PLANE;
						else 
							shipForm = ShipForm.CAR;
						return new OrderChecker(shipForm,(String) destinationBox.getSelectedItem(),
								orderField.getText());
					}
					 
				}
			});	
			
			orderField.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					orderCheck.check();
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
	}

}

