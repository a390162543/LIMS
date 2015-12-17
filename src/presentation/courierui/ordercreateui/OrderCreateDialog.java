package presentation.courierui.ordercreateui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DialogLayoutManager;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.Name;
import businesslogic.checkbl.PhoneNumber;
import businesslogic.checkbl.orderinfo.OrderAddress;
import businesslogic.checkbl.orderinfo.OrderTelNum;
import businesslogic.checkbl.orderinfo.OrderVolumn;
import businesslogic.checkbl.orderinfo.OrderWeight;
import businesslogic.orderbl.Order;
import businesslogic.userbl.LoginController;
import businesslogicservice.IdblService;
import businesslogicservice.OrderblService;
import systemenum.DeliveryWay;
import systemenum.GoodsState;
import systemenum.WrapWay;
import vo.OrderCreateVO;



/**
 * 这是订单创建的界面
 * @author lc
 * @version 1.5
 *
 */
public class OrderCreateDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6318650343755451715L;

	
	private JLabel orderinfoLabel;
	private JPanel orderinfoPanel;
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
	private JPanel recipientInfoPanel;
	private JLabel recipientNameLabel;
	private JTextField recipientNameTextField;
	private JLabel recipientTelLabel;
	private JTextField recipientTeltTextField;
	private JLabel recipientCellLabel;
	private JTextField recipientCellTextField;
	private JLabel recipientAddressLabel;
	private JTextField recipientAdressTextField;
	
	private JLabel senderInfoLabel;
	private JPanel senderInfoPanel;
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
		
		this.setTitle("新建订单");
		this.setSize(380, 800);
		
		confirmButton = new JButton("确定");
		cancleButton = new JButton("取消");
		confirmButton.setBounds(300, 725, 70, 22);
		cancleButton.setBounds(220, 725, 70, 22);
		this.add(confirmButton);
		this.add(cancleButton);
		
   

		orderinfoLabel = new JLabel("订单信息");
		orderinfoLabel.setBounds(10,52,80,22);
		orderinfoPanel = new JPanel();
		orderinfoPanel.setBounds(100, 52, 80, 25);
		
		
		orderIdLabel = new JLabel("订单号");
		orderIdLabel.setBounds(50, 86, 60, 22);	
		orderIdTextField = new JTextField();
		orderIdTextField.setBounds(105, 82, 180, 22);
		OrderblService orderblService = new Order();
		IdblService idblService = orderblService.getIdblService();
		orderIdTextField.setText(idblService.createNewId());
		orderIdTextField.setEditable(false);
		
		weightLabel = new JLabel("重量(kg)");
		weightLabel.setBounds(54, 121, 40, 22);
		weighTextField = new JTextField();
		weighTextField.setBounds(105, 118, 60, 22);
		weighTextField.setText("0");
		weightUnitLabel = new JLabel("Kg");
		weightUnitLabel.setBounds(170, 118, 30, 22);
		volumeLabel = new JLabel("体积(m^3)");
		volumeLabel.setBounds(54, 152, 40, 22);
		volumeTextField = new JTextField();
		volumeTextField.setBounds(105, 152, 60, 22);
		volumeTextField.setText("0");
		volumnUnitLabel = new JLabel("m^3");
		volumnUnitLabel.setBounds(165, 153, 30, 22);
		goodsInfoLabel = new JLabel("物品信息");
		goodsInfoLabel.setBounds(35, 184, 80, 22);
		goodsInfoTextField = new JTextField();
		goodsInfoTextField.setBounds(105, 184, 180, 22);
		goodsInfoTextField.setText("");
		wrapWayLabel = new JLabel("包装方式");
		wrapWayLabel.setBounds(35, 218, 80, 22);
		woodenWrapButton = new JRadioButton("木箱");
		woodenWrapButton.setBounds(265, 218, 75, 22);
		cartonWrapButton = new JRadioButton("纸箱");
		cartonWrapButton.setBounds(190, 218, 75, 22);
		bagWrapButton = new JRadioButton("快递袋");
		bagWrapButton.setBounds(105, 218, 90, 22);
		wrapWayButtonGroup = new ButtonGroup();
		wrapWayButtonGroup.add(bagWrapButton);
		wrapWayButtonGroup.add(cartonWrapButton);
		wrapWayButtonGroup.add(woodenWrapButton);
		deliveryWayLabel = new JLabel("运送方式");
		deliveryWayLabel.setBounds(35, 247, 80, 22);
		economicDeliveryButton = new JRadioButton("经济");
		economicDeliveryButton.setBounds(105, 247, 75, 22);
		standardDeliveryButton = new JRadioButton("标准");
		standardDeliveryButton.setBounds(190, 247, 75, 22);
		fastDeliveryButton = new JRadioButton("特快");
		fastDeliveryButton.setBounds(265, 247, 75, 22);
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
			
		this.add(orderinfoLabel);
		this.add(orderinfoPanel);
		//DialogLayoutManager.fix(orderinfoLabel);
		this.add(orderIdLabel);
		this.add(orderIdTextField);
		this.add(weightLabel);
		this.add(weighTextField);
//		this.add(weightUnitLabel);
		this.add(volumeLabel);
		this.add(volumeTextField);
//		this.add(volumnUnitLabel);
		this.add(goodsInfoLabel);
		this.add(goodsInfoTextField);
		this.add(wrapWayLabel);
		this.add(bagWrapButton);
		this.add(cartonWrapButton);
		this.add(woodenWrapButton);
		
		
		this.add(deliveryWayLabel);
		this.add(economicDeliveryButton);	
		this.add(standardDeliveryButton);
		this.add(fastDeliveryButton);
		DialogLayoutManager.fix(bagWrapButton,cartonWrapButton,woodenWrapButton);
		DialogLayoutManager.fix(economicDeliveryButton,standardDeliveryButton,fastDeliveryButton);
		
				
		recipientInfoLabel = new JLabel("收件人信息");
		recipientInfoLabel.setBounds(10, 293, 100, 22);
		recipientInfoPanel = new JPanel();
		recipientInfoPanel.setBounds(120,293,20,25);
		recipientNameLabel = new JLabel("姓名");
		recipientNameLabel.setBounds(39, 333, 40, 22);
		recipientNameTextField = new JTextField();
		recipientNameTextField.setBounds(89, 330, 60, 22);
		recipientNameTextField.setText("");
		recipientTelLabel = new JLabel("电话");
		recipientTelLabel.setBounds(39, 364, 40, 22);
		recipientTeltTextField = new JTextField();
		recipientTeltTextField.setBounds(89, 362, 180, 22);
		recipientTeltTextField.setText("");
		recipientCellLabel = new JLabel("手机");
		recipientCellLabel.setBounds(39, 396, 40, 22);
		recipientCellTextField = new JTextField();
		recipientCellTextField.setBounds(89, 396, 180, 22);
		recipientCellTextField.setText("");
		recipientAddressLabel = new JLabel("地址");
		recipientAddressLabel.setBounds(39, 439, 40, 22);
		recipientAdressTextField = new JTextField();
		recipientAdressTextField.setBounds(89, 439, 180, 22);
		recipientAdressTextField.setText("");
				
		this.add(recipientInfoLabel);
		this.add(recipientInfoPanel);
		this.add(recipientNameLabel);
		this.add(recipientNameTextField);
		this.add(recipientTelLabel);
		this.add(recipientTeltTextField);
		this.add(recipientCellLabel);
		this.add(recipientCellTextField);
		this.add(recipientAddressLabel);
		this.add(recipientAdressTextField);
	
		senderInfoLabel = new JLabel("寄件人信息");
		senderInfoLabel.setBounds(10, 488, 100, 22);
		senderInfoPanel = new JPanel();
		senderInfoPanel.setBounds(120,488,20,25);
		senderNameLabel = new JLabel("姓名");
		senderNameLabel.setBounds(39, 531, 40, 22);
		senderNameTextField = new JTextField();
		senderNameTextField.setBounds(89, 531, 60, 22);
		senderNameTextField.setText("");
		senderTelLabel = new JLabel("电话");
		senderTelLabel.setBounds(39, 566, 40, 22);
		senderTeltTextField = new JTextField();
		senderTeltTextField.setBounds(89, 566, 180, 22);
		senderTeltTextField.setText("");
		senderCellLabel = new JLabel("手机");
		senderCellLabel.setBounds(39, 600, 40, 22);
		senderCellTextField = new JTextField();
		senderCellTextField.setBounds(89, 600, 180, 22);
		senderCellTextField.setText("");
		senderAddressLabel = new JLabel("地址");
		senderAddressLabel.setBounds(39, 631, 40, 22);
		senderAdressTextField = new JTextField();
		senderAdressTextField.setBounds(89, 631, 180, 22);
		senderAdressTextField.setText("");
				
		this.add(senderInfoLabel);
		this.add(senderInfoPanel);
		//DialogLayoutManager.fix(senderInfoLabel);
		this.add(senderNameLabel);
		this.add(senderNameTextField);
		this.add(senderTelLabel);
		this.add(senderTeltTextField);
		this.add(senderCellLabel);
		this.add(senderCellTextField); 
		this.add(senderAddressLabel);
		this.add(senderAdressTextField);
		
		
		this.add(totalTimeLabel);
		this.add(totalTimeTextField);
		this.add(totalExpenseLabel);
		this.add(totalExpenseTextField);
			
		
				
		this.setLayout(new DialogLayoutManager());
		this.setResizable(false);
	    this.setVisible(true);
		
	    bagWrapButton.setSelected(true);
	    economicDeliveryButton.setSelected(true);
		
	    
	    
		Checker senderNameChecker = new Checker(senderNameTextField, new CheckInfoGetter() {		
			@Override
			public CheckInfo getCheckInfo() {				
				return new Name(senderNameTextField.getText());
			}
		});	
		
		Checker receiverNameChecker = new Checker(recipientNameTextField, new CheckInfoGetter() {			
			@Override
			public CheckInfo getCheckInfo() {
				
				return new Name(recipientNameTextField.getText());
			}
		});
		
		Checker senderAddressChecker = new Checker(senderAdressTextField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				return new OrderAddress(senderAdressTextField.getText());
			}
		});
		
		Checker receiverAddressChecker = new Checker(recipientAdressTextField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				return new OrderAddress(recipientAdressTextField.getText());
			}
		});
		
		
	Checker orderWeightChecker = new Checker( weighTextField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				if (!weighTextField.getText().equals("")&&!weighTextField.getText().contains("-")) {
					return new OrderWeight(Double.valueOf(weighTextField.getText()));
				}
				return new OrderWeight(-1);
			}
		});
	
	Checker orderVolumnChecker = new Checker(volumeTextField, new CheckInfoGetter() {
		
		@Override
		public CheckInfo getCheckInfo() {
			if (!volumeTextField.getText().equals("")&&!volumeTextField.getText().contains("-")) {
				return new OrderVolumn(Double.valueOf(volumeTextField.getText()));
			}
			return new OrderVolumn(-1);
		}
	});
	
	Checker senderTelChecker = new Checker(senderTeltTextField, new CheckInfoGetter() {
		
		@Override
		public CheckInfo getCheckInfo() {
			if (senderTeltTextField.getText()=="") {
				return new OrderTelNum("");
			}
			return new OrderTelNum(senderTeltTextField.getText());
		}
	});
	
	Checker senderCellChecker = new Checker(senderCellTextField, new CheckInfoGetter() {
		
		@Override
		public CheckInfo getCheckInfo() {
			if (senderCellTextField.getText()==null) {
				return new PhoneNumber("");
			}
			return new PhoneNumber(senderCellTextField.getText());
		}
	});
	
	Checker receiverCellChecker = new Checker(recipientCellTextField, new CheckInfoGetter() {
		
		@Override
		public CheckInfo getCheckInfo() {
			if (recipientCellTextField.getText()==null) {
				return new PhoneNumber("");
			}
			return new PhoneNumber(recipientCellTextField.getText());
		}
	});
	
	
	Checker receiverTelChecker = new Checker(recipientTeltTextField, new CheckInfoGetter() {
		
		@Override
		public CheckInfo getCheckInfo() {
			if (recipientTeltTextField.getText()==null) {
				return new OrderTelNum("");
			}
			return new OrderTelNum(recipientTeltTextField.getText());
		}
	});
	
		senderNameTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				senderNameChecker.check();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		recipientNameTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				receiverNameChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
				
		senderAdressTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				senderAddressChecker.check();
				if (senderAddressChecker.isCorrect()&&receiverAddressChecker.isCorrect()) {
					totalTimeTextField.setText(String.valueOf(orderblService.getEximatedTime(senderAdressTextField.getText(), recipientAdressTextField.getText())));
				}
				if (senderAddressChecker.isCorrect()&&receiverAddressChecker.isCorrect()&&(cartonWrapButton.isSelected()||woodenWrapButton.isSelected()
						||bagWrapButton.isSelected())&&(economicDeliveryButton.isSelected()||standardDeliveryButton.isSelected()||fastDeliveryButton.isSelected())
						&&orderWeightChecker.isCorrect()&&orderVolumnChecker.isCorrect()) {
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
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		recipientAdressTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				receiverAddressChecker.check();
				if (senderAddressChecker.isCorrect()&&receiverAddressChecker.isCorrect()) {
					totalTimeTextField.setText(String.valueOf(orderblService.getEximatedTime(senderAdressTextField.getText(), recipientAdressTextField.getText())));
				}
				if (senderAddressChecker.isCorrect()&&receiverAddressChecker.isCorrect()&&(cartonWrapButton.isSelected()||woodenWrapButton.isSelected()
						||bagWrapButton.isSelected())&&(economicDeliveryButton.isSelected()||standardDeliveryButton.isSelected()||fastDeliveryButton.isSelected())
						&&orderWeightChecker.isCorrect()&&orderVolumnChecker.isCorrect()) {
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
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	
		
		weighTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				orderWeightChecker.check();
				if (senderAddressChecker.isCorrect()&&receiverAddressChecker.isCorrect()&&(cartonWrapButton.isSelected()||woodenWrapButton.isSelected()
						||bagWrapButton.isSelected())&&(economicDeliveryButton.isSelected()||standardDeliveryButton.isSelected()||fastDeliveryButton.isSelected())
						&&orderWeightChecker.isCorrect()&&orderVolumnChecker.isCorrect()) {
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
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
	
		
		volumeTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				orderVolumnChecker.check();
				if (senderAddressChecker.isCorrect()&&receiverAddressChecker.isCorrect()&&(cartonWrapButton.isSelected()||woodenWrapButton.isSelected()
						||bagWrapButton.isSelected())&&(economicDeliveryButton.isSelected()||standardDeliveryButton.isSelected()||fastDeliveryButton.isSelected())
						&&orderWeightChecker.isCorrect()&&orderVolumnChecker.isCorrect()) {
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
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		senderCellTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				senderCellChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		recipientCellTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				receiverCellChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		bagWrapButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (senderAddressChecker.isCorrect()&&receiverAddressChecker.isCorrect()&&(cartonWrapButton.isSelected()||woodenWrapButton.isSelected()
						||bagWrapButton.isSelected())&&(economicDeliveryButton.isSelected()||standardDeliveryButton.isSelected()||fastDeliveryButton.isSelected())
						&&orderWeightChecker.isCorrect()&&orderVolumnChecker.isCorrect()) {
					WrapWay wrapWay = WrapWay.BAG;								
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
		});

		woodenWrapButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (senderAddressChecker.isCorrect()&&receiverAddressChecker.isCorrect()&&(cartonWrapButton.isSelected()||woodenWrapButton.isSelected()
						||bagWrapButton.isSelected())&&(economicDeliveryButton.isSelected()||standardDeliveryButton.isSelected()||fastDeliveryButton.isSelected())
						&&orderWeightChecker.isCorrect()&&orderVolumnChecker.isCorrect()) {
					WrapWay wrapWay = WrapWay.WOODEN;				
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
		});

		cartonWrapButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (senderAddressChecker.isCorrect()&&receiverAddressChecker.isCorrect()&&(cartonWrapButton.isSelected()||woodenWrapButton.isSelected()
						||bagWrapButton.isSelected())&&(economicDeliveryButton.isSelected()||standardDeliveryButton.isSelected()||fastDeliveryButton.isSelected())
						&&orderWeightChecker.isCorrect()&&orderVolumnChecker.isCorrect()) {
					WrapWay wrapWay = WrapWay.CARTON;	
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
		});
		
		economicDeliveryButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (senderAddressChecker.isCorrect()&&receiverAddressChecker.isCorrect()&&(cartonWrapButton.isSelected()||woodenWrapButton.isSelected()
						||bagWrapButton.isSelected())&&(economicDeliveryButton.isSelected()||standardDeliveryButton.isSelected()||fastDeliveryButton.isSelected())
						&&orderWeightChecker.isCorrect()&&orderVolumnChecker.isCorrect()) {
					WrapWay wrapWay;
					if(woodenWrapButton.isSelected())
						wrapWay = WrapWay.WOODEN;
					else if(cartonWrapButton.isSelected())
						wrapWay = WrapWay.CARTON;
					else 
						wrapWay = WrapWay.BAG;
					
					DeliveryWay deliverWay = DeliveryWay.ECONOMIC;
					OrderCreateVO vo = new OrderCreateVO(senderAdressTextField.getText(), recipientAdressTextField.getText(), 
							wrapWay, deliverWay, Double.parseDouble(weighTextField.getText()));	
					totalExpenseTextField.setText(String.valueOf(orderblService.getTotal(vo)));
				}
				
			}
		});
		
		standardDeliveryButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (senderAddressChecker.isCorrect()&&receiverAddressChecker.isCorrect()&&(cartonWrapButton.isSelected()||woodenWrapButton.isSelected()
						||bagWrapButton.isSelected())&&(economicDeliveryButton.isSelected()||standardDeliveryButton.isSelected()||fastDeliveryButton.isSelected())
						&&orderWeightChecker.isCorrect()&&orderVolumnChecker.isCorrect()) {
					WrapWay wrapWay;
					if(woodenWrapButton.isSelected())
						wrapWay = WrapWay.WOODEN;
					else if(cartonWrapButton.isSelected())
						wrapWay = WrapWay.CARTON;
					else 
						wrapWay = WrapWay.BAG;
					
					DeliveryWay deliverWay = DeliveryWay.STANDARD;		
					OrderCreateVO vo = new OrderCreateVO(senderAdressTextField.getText(), recipientAdressTextField.getText(), 
							wrapWay, deliverWay, Double.parseDouble(weighTextField.getText()));	
					totalExpenseTextField.setText(String.valueOf(orderblService.getTotal(vo)));
				}
				
			}
		});
		
		
		fastDeliveryButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (senderAddressChecker.isCorrect()&&receiverAddressChecker.isCorrect()&&(cartonWrapButton.isSelected()||woodenWrapButton.isSelected()
						||bagWrapButton.isSelected())&&(economicDeliveryButton.isSelected()||standardDeliveryButton.isSelected()||fastDeliveryButton.isSelected())
						&&orderWeightChecker.isCorrect()&&orderVolumnChecker.isCorrect()) {
					WrapWay wrapWay;
					if(woodenWrapButton.isSelected())
						wrapWay = WrapWay.WOODEN;
					else if(cartonWrapButton.isSelected())
						wrapWay = WrapWay.CARTON;
					else 
						wrapWay = WrapWay.BAG;
					
					DeliveryWay deliverWay = DeliveryWay.FAST;
									
					OrderCreateVO vo = new OrderCreateVO(senderAdressTextField.getText(), recipientAdressTextField.getText(), 
							wrapWay, deliverWay, Double.parseDouble(weighTextField.getText()));	
					totalExpenseTextField.setText(String.valueOf(orderblService.getTotal(vo)));
				}
				
			}
		});
		
		senderTeltTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				senderTelChecker.check();			
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		recipientTeltTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				receiverTelChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
			
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
				
				OrderCreateVO orderCreateVO = new OrderCreateVO(orderIdTextField.getText(),
						senderNameTextField.getText(),senderAdressTextField.getText(), 
						senderTeltTextField.getText(), senderCellTextField.getText(), 
						recipientNameTextField.getText(), recipientAdressTextField.getText(), 
						recipientTeltTextField.getText(), recipientCellTextField.getText(), 
						goodsInfoTextField.getText(), Double.parseDouble(weighTextField.getText()),
						Double.parseDouble(volumeTextField.getText()), tempcost, wrapWay,
						deliverWay,  Integer.parseInt(totalTimeTextField.getText()));
				orderCreateVO.setGoodsState(GoodsState.COMPLETE);
				orderCreateVO.setNowLocation(LoginController.getOrganizationName());
			
				OrderblService orderblService = BusinessLogicService.getOrderblService();
				orderblService.createOrderPO(orderCreateVO);
				OrderCreateDialog.this.dispose();
				
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
