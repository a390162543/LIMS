package presentation.storageui.storeoutui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import presentation.util.OrganizationComboBox;
import presentation.util.RecentDatePickPanel;
import businesslogic.storeoutbl.Storeout;
import businesslogic.userbl.LoginController;
import businesslogicservice.IdblService;
import businesslogicservice.StoreoutblService;
import systemenum.ShipForm;
import vo.StoreoutCreateVO;

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
	
	private JButton addButton;
	private JButton deleteButton;
	private JButton confirmButton;
	private JButton cancleButton;
	
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
        airWayButton.setBounds(110, 105, 80, 22);
        carWayButton = new JRadioButton("汽运");
        carWayButton.setBounds(190, 105, 80, 22);
        trainsWayButton = new JRadioButton("铁运");
        trainsWayButton.setBounds(270, 105, 80, 22);
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
        
        addButton = new JButton("新增");
        addButton.setBounds(210, 310, 70, 30);
        deleteButton = new JButton("删除");
        deleteButton.setBounds(295, 310, 70, 30);
        confirmButton = new JButton("确定");
        confirmButton.setBounds(295, 360, 70, 30);
        cancleButton = new JButton("取消");
        cancleButton.setBounds(210, 360, 70, 30);
        
        
        this.add(storeoutIdLabel);
        this.add(storeoutIdTextField);
        
        this.add(cancleButton);
        this.add(confirmButton);
        this.add(deleteButton);
        this.add(addButton);
        this.add(scrollpane);
        this.add(storeoutGoodsInfoLabel);
        this.add(transferIdTextField);
        this.add(transferIdLabel);
        this.add(trainsWayButton);
        this.add(carWayButton);
        this.add(airWayButton);
        this.add(shipFormLabel);
        this.add(destinationComboBox);
        this.add(destinationLabel);
        this.add(datePickPanel);
		this.add(storeoutDateLabel);
		
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
	
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StoreoutGoodsDialog(tableModel);
				
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = goodsInfoTable.getSelectedRow();
	              if(row == -1)
	            	  return;
	              tableModel.removeRow(row);		
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
				StoreoutblService storeoutblService = new Storeout();
				storeoutblService.createStoreoutPO(vo);
			}
		});
		
		cancleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StoreoutblService storeoutblService = new Storeout();
				int totalRow = goodsInfoTable.getRowCount();
				for (int i = 0; i < totalRow; i++) {
					String orderId = (String) tableModel.getValueAt(i, 0);
					storeoutblService.restoreLcationState(orderId);
				}
				
			}
		});
	}
}
