package presentation.storageui.storeoutui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DialogLayoutManager;
import presentation.util.OrganizationComboBox;
import presentation.util.RecentDatePickPanel;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.arrivalinfo.ArrivalTransferId;
import businesslogic.storeoutbl.Storeout;
import businesslogic.userbl.LoginController;
import businesslogicservice.IdblService;
import businesslogicservice.StoreoutblService;
import systemenum.ShipForm;
import vo.StoreoutCreateVO;

/**
 * 这是创建出库单的界面
 * @author lc
 * @version 1.4
 *
 */
public class StoreoutDialogUI extends JDialog{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1002157076212463439L;
	/**
	 * 
	 */
	
	private JLabel storeoutIdLabel;
	private JTextField storeoutIdTextField;
	
	private JLabel storeoutDateLabel;
	private RecentDatePickPanel datePickPanel;
	
	private JLabel destinationLabel;
	private OrganizationComboBox destinationComboBox;
	
	private JLabel shipFormLabel;
	private JRadioButton airWayButton;
	private JRadioButton carWayButton;
	private JRadioButton trainsWayButton;
	private ButtonGroup shipFormButtonGroup;
	
	private JLabel transferIdLabel;
	private JTextField transferIdTextField;

	private JLabel storeoutGoodsInfoLabel;
	private JTable goodsInfoTable;
	
	
	private JButton confirmButton;
	private JButton cancleButton;
	
	private List<String> orders;
	
    private String[] column = {"订单号"};
    private DefaultTableModel tableModel = new DefaultTableModel(null, column);
    
	public StoreoutDialogUI(){
		
	

		this.setTitle("出库单");	
		this.setSize(380, 460);
		this.setLayout(null);
		
		
		storeoutIdLabel = new JLabel("出库单号");
		storeoutIdLabel.setBounds(20, 12, 80, 22);
		storeoutIdTextField = new JTextField();
		storeoutIdTextField.setBounds(110, 12, 180, 22);
		StoreoutblService storeoutblService = new Storeout();
		IdblService idblService = storeoutblService.getIdblService();
		storeoutIdTextField.setText(idblService.createNewId());
		storeoutIdTextField.setEditable(false);
		
		storeoutDateLabel = new JLabel("出库日期");
		storeoutDateLabel.setBounds(20, 44, 80, 22);
		datePickPanel = new RecentDatePickPanel();       
        datePickPanel.setBounds(110, 44, 200, 22);
        destinationLabel = new JLabel("目的地");
        destinationLabel.setBounds(28, 70, 60, 22);
        destinationComboBox = new OrganizationComboBox();
        destinationComboBox.setBounds(110, 72, 180, 22);
        
        shipFormLabel = new JLabel("装运形式");
        shipFormLabel.setBounds(28, 105, 80, 22);
        airWayButton = new JRadioButton("空运");
        airWayButton.setBounds(270, 105, 80, 22);
        carWayButton = new JRadioButton("汽运");
        carWayButton.setBounds(110, 105, 80, 22);
        trainsWayButton = new JRadioButton("铁运");
        trainsWayButton.setBounds(190, 105, 80, 22);
        shipFormButtonGroup = new ButtonGroup();
        shipFormButtonGroup.add(airWayButton);
        shipFormButtonGroup.add(carWayButton);
        shipFormButtonGroup.add(trainsWayButton);
        
        transferIdLabel = new JLabel("中转单");
        transferIdLabel.setBounds(28, 137, 60, 22);
        transferIdTextField = new JTextField();
        transferIdTextField.setBounds(110, 137, 180, 22);
        
        storeoutGoodsInfoLabel = new JLabel("出库货物");
        storeoutGoodsInfoLabel.setBounds(28, 170, 80, 22);
        
        goodsInfoTable = new JTable(tableModel);
        goodsInfoTable.setSize(180, 120);
        JScrollPane scrollpane = new JScrollPane(goodsInfoTable);
        scrollpane.setBounds(110, 170, 180, 120);
        

        confirmButton = new JButton("确定");
        confirmButton.setBounds(295, 360, 70, 30);
        cancleButton = new JButton("取消");
        cancleButton.setBounds(210, 360, 70, 30);
        
        
        this.add(storeoutIdLabel);
        this.add(storeoutIdTextField);
        this.add(storeoutDateLabel);
        this.add(datePickPanel);
        this.add(destinationLabel);
        this.add(destinationComboBox);
        this.add(transferIdLabel);
        this.add(transferIdTextField);
        this.add(shipFormLabel); 
        this.add(carWayButton);
        this.add(trainsWayButton);
        this.add(airWayButton);
        DialogLayoutManager.fix(carWayButton,trainsWayButton,airWayButton);      
        this.add(storeoutGoodsInfoLabel);        
        this.add(scrollpane); 
       
       
        
        
		this.add(confirmButton);
		this.add(cancleButton);
       
		this.setLayout(new DialogLayoutManager());
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
	
		Checker transferIdChecker = new Checker(transferIdTextField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				if (transferIdTextField.getText()!=null) {
					return new ArrivalTransferId(transferIdTextField.getText());
				}
				return new ArrivalTransferId("");
			}
		});
		
		transferIdTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				transferIdChecker.check();
				if (transferIdChecker.check()) {
					String transId = transferIdTextField.getText();
					
					StoreoutblService storeoutblService = BusinessLogicService.getStoreoutblService();
					
					
					if (transId.length()==19) {
						orders = storeoutblService.getTransferVO(transId);
					}
					else {
						orders = storeoutblService.getLoadVO(transId);
					}
					
					String[] data = new String[orders.size()];
					for (int i = 0; i < orders.size(); i++) {
						data[i] = orders.get(i);
						storeoutblService.changeLocationState(orders.get(i));
					}
					tableModel.addRow(data);
				}
				else {
					
					if (tableModel.getRowCount()!=0) {						
						String orderId = (String) tableModel.getValueAt(0, 0);
						storeoutblService.restoreLcationState(orderId);
						tableModel.removeRow(0);
					}
					
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
		
		
		
		
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int totalRow = goodsInfoTable.getRowCount();
				ArrayList<String> orderId = new ArrayList<String>();
				for(int i=0;i<totalRow;i++){
					orderId.add(new String((String)tableModel.getValueAt(i, 0)));
				}
				

				Date date = datePickPanel.getDate();
				String destination = destinationComboBox.getItemAt(destinationComboBox.getSelectedIndex());
				
				ShipForm shipForm;
				if(airWayButton.isSelected())
					shipForm = ShipForm.PLANE;
				else if(carWayButton.isSelected())
					shipForm = ShipForm.CAR;
				else
					shipForm = ShipForm.TRAIN;
				
				String transferId = transferIdTextField.getText();
				StoreoutCreateVO vo = new StoreoutCreateVO(storeoutIdTextField.getText(), orderId, date, destination, shipForm, transferId,LoginController.getOrganizationName());
				StoreoutblService storeoutblService = BusinessLogicService.getStoreoutblService();
				storeoutblService.createStoreoutPO(vo);
			}
		});
		
		cancleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StoreoutblService storeoutblService = BusinessLogicService.getStoreoutblService();
				int totalRow = goodsInfoTable.getRowCount();
				for (int i = 0; i < totalRow; i++) {
					String orderId = (String) tableModel.getValueAt(i, 0);
					storeoutblService.restoreLcationState(orderId);
				}
				
			}
		});
	}
}
