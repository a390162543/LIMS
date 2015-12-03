package presentation.courierui.ordercreateui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import businesslogic.orderbl.Order;
import businesslogicservice.OrderblService;
import systemenum.DeliveryWay;
import systemenum.GoodsState;
import systemenum.WrapWay;
import vo.OrderCreateVO;

public class OrderCreateDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6318650343755451715L;
	/**
	 * 
	 */
	
	
	private JLabel orderinfoLabel;
	private JLabel orderIdLabel;
	private JTextField orderIdTextField;
	private JLabel weightLabel;
	private JTextField weighTextField;
	private JLabel weightUnitLabel;
	private JLabel volumeLabel;
	private JTextField volumeTextField;
	private JLabel volumnUnitLabel;
	private JLabel goodsInfoLabel;
	private JTextField goodsInfoTextField;
	private JLabel wrapWayLabel;
	private JRadioButton woodenWrapButton;
	private JRadioButton cartonWrapButton;
	private JRadioButton bagWrapButton;
	private ButtonGroup wrapWayButtonGroup;
	private JLabel deliveryWayLabel;
	private JRadioButton economicDeliveryButton;
	private JRadioButton standardDeliveryButton;
	private JRadioButton fastDeliveryButton;
	private ButtonGroup deliveryWayButtonGroup;
	private JLabel totalExpenseLabel;
	private JTextField totalExpenseTextField;
	
	private JLabel recipientInfoLabel;
	private JLabel recipientNameLabel;
	private JTextField recipientNameTextField;
	private JLabel recipientTelLabel;
	private JTextField recipientTeltTextField;
	private JLabel recipientCellLabel;
	private JTextField recipientCellTextField;
	private JLabel recipientAddressLabel;
	private JTextField recipientAdressTextField;
	
	private JLabel senderInfoLabel;
	private JLabel senderNameLabel;
	private JTextField senderNameTextField;
	private JLabel senderTelLabel;
	private JTextField senderTeltTextField;
	private JLabel senderCellLabel;
	private JTextField senderCellTextField;
	private JLabel senderAddressLabel;
	private JTextField senderAdressTextField;
	
	private JLabel totalTimeLabel;
	private JTextField totalTimeTextField;
	
	private JButton confirmButton;
	private JButton cancleButton;
	
	public OrderCreateDialog(){
		init();	
		buttonFunction();
		
	}
	
	
	public void init(){
		this.setTitle("新建订单");
		this.setSize(380, 800);
		this.setLayout(null);
		
		orderInfoInit();
		recipientInfoInit();
		senderInfoinit();
		
		confirmButton = new JButton("确定");
		cancleButton = new JButton("取消");
		confirmButton.setBounds(300, 725, 70, 22);
		cancleButton.setBounds(220, 725, 70, 22);
		this.add(confirmButton);
		this.add(cancleButton);
		
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.repaint();
	}
	
	public void orderInfoInit(){
		orderinfoLabel = new JLabel("订单信息");
		orderinfoLabel.setBounds(10,52,80,22);
		orderIdLabel = new JLabel("订单号");
		orderIdLabel.setBounds(50, 86, 60, 22);
		orderIdTextField = new JTextField();
		orderIdTextField.setBounds(105, 82, 180, 22);
		weightLabel = new JLabel("重量");
		weightLabel.setBounds(54, 121, 40, 22);
		weighTextField = new JTextField();
		weighTextField.setBounds(105, 118, 60, 22);
		weightUnitLabel = new JLabel("Kg");
		weightUnitLabel.setBounds(170, 118, 30, 22);
		volumeLabel = new JLabel("体积");
		volumeLabel.setBounds(54, 152, 40, 22);
		volumeTextField = new JTextField();
		volumeTextField.setBounds(105, 152, 60, 22);
		volumnUnitLabel = new JLabel("m^3");
		volumnUnitLabel.setBounds(165, 153, 30, 22);
		goodsInfoLabel = new JLabel("物品信息");
		goodsInfoLabel.setBounds(35, 184, 80, 22);
		goodsInfoTextField = new JTextField();
		goodsInfoTextField.setBounds(105, 184, 180, 22);
		wrapWayLabel = new JLabel("包装方式");
		wrapWayLabel.setBounds(35, 218, 80, 22);
		woodenWrapButton = new JRadioButton("木箱");
		woodenWrapButton.setBounds(105, 218, 75, 22);
		cartonWrapButton = new JRadioButton("纸箱");
		cartonWrapButton.setBounds(180, 218, 75, 22);
		bagWrapButton = new JRadioButton("快递袋");
		bagWrapButton.setBounds(255, 218, 90, 22);
		wrapWayButtonGroup = new ButtonGroup();
		wrapWayButtonGroup.add(bagWrapButton);
		wrapWayButtonGroup.add(cartonWrapButton);
		wrapWayButtonGroup.add(woodenWrapButton);
		deliveryWayLabel = new JLabel("运送方式");
		deliveryWayLabel.setBounds(35, 247, 80, 22);
		economicDeliveryButton = new JRadioButton("经济");
		economicDeliveryButton.setBounds(105, 247, 75, 22);
		standardDeliveryButton = new JRadioButton("标准");
		standardDeliveryButton.setBounds(180, 247, 75, 22);
		fastDeliveryButton = new JRadioButton("特快");
		fastDeliveryButton.setBounds(255, 247, 75, 22);
		deliveryWayButtonGroup = new ButtonGroup();
		deliveryWayButtonGroup.add(economicDeliveryButton);
		deliveryWayButtonGroup.add(standardDeliveryButton);
		deliveryWayButtonGroup.add(fastDeliveryButton);
		totalExpenseLabel = new JLabel("总费用");
		totalExpenseLabel.setBounds(235, 675, 60, 22);
		totalExpenseTextField = new JTextField();
		totalExpenseTextField.setBounds(300, 675, 60, 22);
		totalTimeLabel = new JLabel("预估时间");
		totalTimeLabel.setBounds(85, 675, 80, 22);
		totalTimeTextField = new JTextField();
		totalTimeTextField.setBounds(170, 675, 60, 22);
		this.add(totalTimeLabel);
		this.add(totalTimeTextField);
		this.add(totalExpenseTextField);
		this.add(totalExpenseLabel);
		this.add(fastDeliveryButton);
		this.add(standardDeliveryButton);
		this.add(economicDeliveryButton);	
		this.add(deliveryWayLabel);
		this.add(bagWrapButton);
		this.add(cartonWrapButton);
		this.add(woodenWrapButton);
		this.add(wrapWayLabel);
		this.add(goodsInfoTextField);
		this.add(goodsInfoLabel);
		this.add(volumnUnitLabel);
		this.add(volumeTextField);
		this.add(volumeLabel);
		this.add(weightUnitLabel);
		this.add(weighTextField);
		this.add(weightLabel);
		this.add(orderIdTextField);
		this.add(orderIdLabel);
		this.add(orderinfoLabel);
	}

	
	public void recipientInfoInit(){
		recipientInfoLabel = new JLabel("收件人信息");
		recipientInfoLabel.setBounds(10, 293, 100, 22);
		recipientNameLabel = new JLabel("姓名");
		recipientNameLabel.setBounds(39, 333, 40, 22);
		recipientNameTextField = new JTextField();
		recipientNameTextField.setBounds(89, 330, 60, 22);
		recipientTelLabel = new JLabel("电话");
		recipientTelLabel.setBounds(39, 364, 40, 22);
		recipientTeltTextField = new JTextField();
		recipientTeltTextField.setBounds(89, 362, 180, 22);
		recipientCellLabel = new JLabel("手机");
		recipientCellLabel.setBounds(39, 396, 40, 22);
		recipientCellTextField = new JTextField();
		recipientCellTextField.setBounds(89, 396, 180, 22);
		recipientAddressLabel = new JLabel("地址");
		recipientAddressLabel.setBounds(39, 439, 40, 22);
		recipientAdressTextField = new JTextField();
		recipientAdressTextField.setBounds(89, 439, 180, 22);
		this.add(recipientAdressTextField);
		this.add(recipientAddressLabel);
		this.add(recipientCellTextField); 
		this.add(recipientCellLabel);
		this.add(recipientTelLabel);
		this.add(recipientTeltTextField);
		this.add(recipientNameTextField);
		this.add(recipientNameLabel);
		this.add(recipientInfoLabel);	
	}
	
	
	public void senderInfoinit(){
		senderInfoLabel = new JLabel("寄件人信息");
		senderInfoLabel.setBounds(10, 488, 100, 22);
		senderNameLabel = new JLabel("姓名");
		senderNameLabel.setBounds(39, 531, 40, 22);
		senderNameTextField = new JTextField();
		senderNameTextField.setBounds(89, 531, 60, 22);
		senderTelLabel = new JLabel("电话");
		senderTelLabel.setBounds(39, 566, 40, 22);
		senderTeltTextField = new JTextField();
		senderTeltTextField.setBounds(89, 566, 180, 22);
		senderCellLabel = new JLabel("手机");
		senderCellLabel.setBounds(39, 600, 40, 22);
		senderCellTextField = new JTextField();
		senderCellTextField.setBounds(89, 600, 180, 22);
		senderAddressLabel = new JLabel("地址");
		senderAddressLabel.setBounds(39, 631, 40, 22);
		senderAdressTextField = new JTextField();
		senderAdressTextField.setBounds(89, 631, 180, 22);
		
		senderAdressTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				OrderblService orderblService = new Order();
				if (recipientAdressTextField.getText()!=null) {
					totalTimeTextField.setText(String.valueOf(orderblService.getEximatedTime(senderAdressTextField.getText(), recipientAdressTextField.getText())));
				}
				if (recipientAdressTextField.getText()!=null&&weighTextField.getText()!=null&&(cartonWrapButton.isSelected()||woodenWrapButton.isSelected()
						||bagWrapButton.isSelected())&&(economicDeliveryButton.isSelected()||standardDeliveryButton.isSelected()||fastDeliveryButton.isSelected())) {
					WrapWay wrapWay;
					if(woodenWrapButton.isSelected())
						wrapWay = WrapWay.WOODEN;
					else if(cartonWrapButton.isSelected())
						wrapWay = WrapWay.CARTON;
					else 
						wrapWay = WrapWay.BAG;
					
					DeliveryWay deliverWay;
					if(economicDeliveryButton.isSelected())
						deliverWay = DeliveryWay.ECONOMIC;
					else if(standardDeliveryButton.isSelected())
						deliverWay = DeliveryWay.STANDARD;
					else
						deliverWay = DeliveryWay.FAST;
					
					OrderCreateVO vo = new OrderCreateVO(senderAdressTextField.getText(), recipientAdressTextField.getText(), 
							wrapWay, deliverWay, Double.parseDouble(weighTextField.getText()));	
					totalExpenseTextField.setText(String.valueOf(orderblService.getTotal(vo)));
				}
				
			}
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(senderAdressTextField);
		this.add(senderAddressLabel);
		this.add(senderCellTextField); 
		this.add(senderCellLabel);
		this.add(senderTelLabel);
		this.add(senderTeltTextField);
		this.add(senderNameTextField);
		this.add(senderNameLabel);
		this.add(senderInfoLabel);
	}
	
	
	public void buttonFunction(){
		
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double tempcost = Double.parseDouble(totalExpenseTextField.getText());
				
				WrapWay wrapWay;
				if(woodenWrapButton.isSelected())
					wrapWay = WrapWay.WOODEN;
				else if(cartonWrapButton.isSelected())
					wrapWay = WrapWay.CARTON;
				else 
					wrapWay = WrapWay.BAG;
				
				DeliveryWay deliverWay;
				if(economicDeliveryButton.isSelected())
					deliverWay = DeliveryWay.ECONOMIC;
				else if(standardDeliveryButton.isSelected())
					deliverWay = DeliveryWay.STANDARD;
				else
					deliverWay = DeliveryWay.FAST;
				
				OrderCreateVO orderCreateVO = new OrderCreateVO(new String(orderIdTextField.getText()),
						senderNameTextField.getText(),senderAdressTextField.getText(), 
						senderTeltTextField.getText(), senderCellTextField.getText(), 
						recipientNameTextField.getText(), recipientAdressTextField.getText(), 
						recipientTeltTextField.getText(), recipientCellTextField.getText(), 
						goodsInfoTextField.getText(), Double.parseDouble(weighTextField.getText()),
						Double.parseDouble(volumeTextField.getText()), tempcost, wrapWay,
						deliverWay,  Integer.parseInt(totalTimeTextField.getText()));
				orderCreateVO.setGoodsState(GoodsState.COMPLETE);
				OrderblService orderblService = new Order();
				orderblService.createOrderPO(orderCreateVO);
			}
		});
		
		cancleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
