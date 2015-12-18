 package presentation.transitcenterui.transferui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
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

import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DialogLayoutManager;
import presentation.util.OrganizationComboBox;
import presentation.util.RecentDatePickPanel;
import systemenum.ShipForm;
import vo.TransferVO;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.Name;
import businesslogic.checkbl.transferinfo.OrderChecker;
import businesslogic.checkbl.transferinfo.TransferNumber;
import businesslogic.userbl.LoginController;
import businesslogicservice.IdblService;
import businesslogicservice.TransferblService;

/**
 * 创建中转单界面
 * @author 刘航伸
 * @see TransferblService 
 * @version 1.4
 */
public class TransferDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3513694959788276702L;
	 
	private JTextField expensesField;
	private JComboBox< String> departBox;
	private JComboBox<String> destinationBox;
	private JRadioButton flightButton ;
	private JRadioButton trainButton;
	private JRadioButton truckButton;
	private ButtonGroup way;
	private OrderTableModel tableModel;
	private TransferblService transferblService;
	private Checker containerNumberChecker;
	private Checker flightNumberChecker ;
	private Checker orderCheck;
	private Checker nameChecker;
	
	public TransferDialog(){
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
		
		//默认货运方式为航空
		flightButton.setSelected(true);		
		
		JTextField idField = new JTextField();
		idField.setBounds(105, 10, 180, 20);
		JLabel idLabel = new JLabel("中转单编号");
		idLabel.setBounds(20, 10, 80, 20);
		JLabel dateLabel = new JLabel("装车日期");
		dateLabel.setBounds(20, 90, 80, 20);
		
		RecentDatePickPanel datePickPanel = new RecentDatePickPanel();
        datePickPanel.setBounds(100, 90, 200, 25);
      
		 
		JLabel flightNumLabel = new JLabel("航班号");
		flightNumLabel.setBounds(20, 130, 80, 20);
		JTextField flightNumField = new JTextField();
		flightNumField.setBounds(105, 130, 180, 20);
		
		flightNumField.addKeyListener(new KeyAdapter() {
			  public void keyTyped(KeyEvent e) {  
	                int keyChar = e.getKeyChar();                 
	                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {  
	 
	                }else{  
	                     e.consume();
	                     
	                }  
	            }        
		});
		
		JLabel departLabel = new JLabel("出发地");
		departLabel.setBounds(20, 170, 80, 20);	
		
		//出发地为当前登录用户 的机构
		departBox = new OrganizationComboBox();
		departBox.setLocation(105, 170);
		departBox.setSelectedItem(LoginController.getOrganizationName());
		departBox.setEnabled(false);
		JLabel destinationLabel = new JLabel("目的地");
		destinationLabel.setBounds(20, 210, 80, 20);
		
		destinationBox = new OrganizationComboBox("中转中心");
		destinationBox.setLocation(105, 210);		
		
		
		JLabel containerIdLabel = new JLabel("货柜号");
		containerIdLabel.setBounds(20, 250, 80, 20);
		JTextField containerIdField = new JTextField();
		containerIdField.setBounds(105, 250, 60, 20);
		containerIdField.addKeyListener(new KeyAdapter() {
			  public void keyTyped(KeyEvent e) {  
	                int keyChar = e.getKeyChar();                 
	                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {  
	 
	                }else{  
	                     e.consume();
	                     
	                }  
	            }        
		});

		JLabel loanManLabel = new JLabel("监装员");
		loanManLabel.setBounds(175, 250, 80, 20);
		JTextField loanManField = new JTextField();
		loanManField.setBounds(245, 250, 60, 20);
		JLabel orderIdLabel = new JLabel("订单");
		orderIdLabel.setBounds(20, 290, 80, 20);
		JLabel expensesLabel = new JLabel("运费");
		expensesLabel.setBounds(20, 430, 80, 20);
		expensesField = new JTextField();
		expensesField.setBounds(105, 430, 60, 20);
		idField.setEnabled(false);
		
		IdblService idblService = transferblService.getIdblService();
		idField.setText(idblService.createNewId());		
		
		tableModel = new OrderTableModel(transferblService);  
		TableRowSorter<TableModel>  tableSorter = new TableRowSorter<TableModel>(tableModel);
		JTable orderTable = new JTable(tableModel);
	    orderTable.setSize(250, 100);
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
	               setExpensesField();
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
				TransferDialog.this.dispose();
			}
		});
		
		sureButton.addActionListener(new ActionListener() {			 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean isRight = containerNumberChecker.check() && flightNumberChecker.check();
				if(!isRight){
					return;
				}
									  
				
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
				
				ShipForm shipForm = null;
				if(trainButton.isSelected())
					shipForm = ShipForm.TRAIN;
				else if(flightButton.isSelected())
					shipForm = ShipForm.PLANE;
				else 
					shipForm = ShipForm.CAR;
				
				TransferVO vo = new TransferVO(id, loadDate, flightNum, depart, destination,
						containerId, loadMan, orderId, expenses,shipForm);
				transferblService.createTransferPO(vo);
				TransferDialog.this.dispose();
			}
		});
		
		 
		this.add(idLabel);
		this.add(idField);		
		this.add(wayLabel);
		this.add(trainButton);
		this.add(flightButton);
		this.add(truckButton);
		DialogLayoutManager.fix(flightButton, trainButton, truckButton);
		
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
		this.add(orderScrollPane);
		this.add(addOrderButton);
		this.add(deleteOrderButton);
		DialogLayoutManager.fix(orderScrollPane, deleteOrderButton, addOrderButton);
		
		this.add(expensesLabel);
		this.add(expensesField);	
		this.setBounds(400, 120, 400, 550);	
		this.add(sureButton);
		this.add(cancleButton);	
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
		
		//界面置顶
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		
	}

	//显示运费
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
			private static final long serialVersionUID = -5436641251910399740L;
		 
		
	//添加订单的界面
		public AddOrderDialog( ){
			 
			 
			JLabel orderLabel = new JLabel("订单号");
			orderLabel.setBounds(35, 15, 100, 24);
			JTextField orderField = new JTextField();
			orderField.setBounds(145, 15, 180, 20);
			JButton cancelButton = new JButton("取消");
			cancelButton.setBounds(190, 50, 70, 30);
			JButton confirmButton = new JButton("确定");
			confirmButton.setBounds(275, 50, 70, 30);
			
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
					if(orderCheck.check()){
					tableModel.add(orderField.getText());
					setExpensesField();
					AddOrderDialog.this.dispose();
					}
					else {
						return;
					}

										
				}
			});
			
			this.setTitle("订单");
			this.add(orderLabel);
			this.add(orderField);
			this.add(cancelButton);
			this.add(confirmButton);
			this.setLayout(null);
			this.setBounds(400, 250, 380, 140);
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
