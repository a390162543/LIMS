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

import businesslogic.storeoutbl.Storeout;
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
	
	
	private JLabel storeoutDateLabel;
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;
	private JComboBox<String> yearComboBox;
	private JComboBox<String> monthComboBox;
	private JComboBox<String> dayComboBox;
	
	private JLabel destinationLabel;
	private JComboBox<String> destinationComboBox;
	
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
	
	private String[] year = {"2015","2016","2017","2018","2019","2010"};
    private String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    private String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
    		"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private String[] totalDestination = {"鼓楼营业厅","仙林营业厅","南京中转中心"};
    private String[] column = {"订单号"};
    private DefaultTableModel tableModel = new DefaultTableModel(null, column);
    
	public StoreoutDialogUI(){
		init();
		buttonFunction();
	}
	
	public void init(){
		this.setTitle("出库单");	
		this.setSize(380, 460);
		this.setLayout(null);
		
		storeoutDateLabel = new JLabel("出库日期");
		storeoutDateLabel.setBounds(20, 44, 80, 22);
		       
        yearComboBox = new JComboBox<String>(year);
        yearComboBox.setBounds(110, 42, 70, 25);
        yearComboBox.setEditable(false);
        monthComboBox = new JComboBox<String>(month);
        monthComboBox.setBounds(200, 40, 50, 25);
        monthComboBox.setEditable(false);
        dayComboBox = new JComboBox<String>(day);
        dayComboBox.setBounds(270, 40, 50, 25);
        dayComboBox.setEditable(false);
        yearLabel = new JLabel("年");
        yearLabel.setBounds(180, 42, 20, 22);
        monthLabel = new JLabel("月");
        monthLabel.setBounds(250, 42, 20, 22);
        dayLabel = new JLabel("日");
        dayLabel.setBounds(320, 40, 20, 22);
        destinationLabel = new JLabel("目的地");
        destinationLabel.setBounds(28, 70, 60, 22);
        destinationComboBox = new JComboBox<String>(totalDestination);
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
        this.add(yearLabel);
        this.add(monthLabel);
        this.add(dayLabel);
        this.add(dayComboBox);
        this.add(monthComboBox);
        this.add(yearComboBox);
        this.add(dayComboBox);
        this.add(monthComboBox);
        this.add(yearComboBox);
		this.add(storeoutDateLabel);
		
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
	}

	public void buttonFunction(){
		
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
				
				String id = new String("2015111700000005");
				int totalRow = goodsInfoTable.getRowCount();
				ArrayList<String> orderId = new ArrayList<String>();
				for(int i=0;i<totalRow;i++){
					orderId.add(new String((String)tableModel.getValueAt(i, 0)));
				}
				int yearDate = Integer.parseInt(year[yearComboBox.getSelectedIndex()]);
				int monthDate = Integer.parseInt(month[monthComboBox.getSelectedIndex()]);
				int dayDate = Integer.parseInt(day[dayComboBox.getSelectedIndex()]);
				@SuppressWarnings("deprecation")
				Date date = new Date(yearDate-1900, monthDate-1, dayDate);
				String destination = totalDestination[destinationComboBox.getSelectedIndex()];
				
				ShipForm shipForm;
				if(airWayButton.isSelected())
					shipForm = ShipForm.PLANE;
				else if(carWayButton.isSelected())
					shipForm = ShipForm.CAR;
				else
					shipForm = ShipForm.TRAIN;
				
				String transferId = new String(transferIdTextField.getText());
				String organization = "南京中转中心";
				StoreoutCreateVO vo = new StoreoutCreateVO(id, orderId, date, destination, shipForm, transferId,organization);
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
