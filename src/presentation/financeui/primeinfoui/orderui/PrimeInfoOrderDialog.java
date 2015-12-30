package presentation.financeui.primeinfoui.orderui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
import presentation.util.ScreenMessage;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.Name;
import businesslogic.checkbl.PhoneNumber;
import businesslogic.checkbl.orderinfo.OrderAddress;
import businesslogic.checkbl.orderinfo.OrderCost;
import businesslogic.checkbl.orderinfo.OrderTelNum;
import businesslogic.checkbl.orderinfo.OrderTime;
import businesslogic.checkbl.orderinfo.OrderVolumn;
import businesslogic.checkbl.orderinfo.OrderWeight;
import businesslogic.orderbl.Order;
import businesslogicservice.IdblService;
import businesslogicservice.OrderblService;
import systemenum.DeliveryWay;
import systemenum.GoodsState;
import systemenum.WrapWay;
import vo.OrderCreateVO;


/**
 * 这是期初建账添加订单的界面
 * @author lc
 * @version 1.5
 *
 */
public class PrimeInfoOrderDialog extends JDialog{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8288036146935771766L;
	

	private PrimeInfoOrderTableModel primeInfoOrderTableModel;
	
	private static final String[] LABEL_NAMES = {"订单信息","订单号","重量","体积","物品信息","包装方式","运送方式",
		"寄件人信息","姓名","电话","手机","地址","收件人信息","姓名","电话","手机","地址"};
	
	private JTextField[] orderInfoTextFields;
	private JTextField[] senderInfoTextFields;
	private JTextField[] receiverInfoTextFields;
	
	
	private JPanel orderinfoPanel;

	private JLabel weightUnitLabel;

	private JLabel volumnUnitLabel;

	
	private JRadioButton woodenWrapButton;
	private JRadioButton cartonWrapButton;
	private JRadioButton bagWrapButton;
	private ButtonGroup wrapWayButtonGroup;
	
	private JRadioButton economicDeliveryButton;
	private JRadioButton standardDeliveryButton;
	private JRadioButton fastDeliveryButton;
	private ButtonGroup deliveryWayButtonGroup;
	private JLabel totalExpenseLabel;
	private JTextField totalExpenseTextField;
	

	private JPanel recipientInfoPanel;
	private JPanel senderInfoPanel;
	
	private JLabel totalTimeLabel;
	private JTextField totalTimeTextField;
	
	private JButton confirmButton;
	private JButton cancleButton;

	
	public PrimeInfoOrderDialog(PrimeInfoOrderTableModel tm){
		this.primeInfoOrderTableModel = tm;

		
		
		JLabel[] labels = new JLabel[17];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
			if (i<7) {				
				labels[i].setText(LABEL_NAMES[i]);
				labels[i].setBounds(40, 80 + 35 * i, 100, 25);				
			}
			
			if (i>=7&&i<=10) {								
				labels[i].setText(LABEL_NAMES[i]);
				labels[i].setBounds(40, 110 + 35 * i, 100, 25);	
			}
			if (i>10) {
				labels[i].setText(LABEL_NAMES[i]);
				labels[i].setBounds(40, 175 + 35 * i, 100, 25);
			}
			this.add(labels[i]);
		}

		orderinfoPanel = new JPanel();
		orderinfoPanel.setBounds(20, 100, 30, 25);
		this.add(orderinfoPanel);
		
		orderInfoTextFields = new JTextField[4];
		for (int i = 0; i < orderInfoTextFields.length; i++) {
			orderInfoTextFields[i] = new JTextField();
			if (i == 0 || i ==3)
				orderInfoTextFields[i].setBounds(120, 80 + 35 * i, 180, 25);
			else
				orderInfoTextFields[i].setBounds(120, 80 + 35 * i, 90, 25);
			this.add(orderInfoTextFields[i]);
		}
		
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
		this.add(bagWrapButton);
		this.add(cartonWrapButton);
		this.add(woodenWrapButton);
		DialogLayoutManager.fix(woodenWrapButton, cartonWrapButton,bagWrapButton);
		
		
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
		this.add(fastDeliveryButton);
		this.add(standardDeliveryButton);
		this.add(economicDeliveryButton);
		DialogLayoutManager.fix(economicDeliveryButton, standardDeliveryButton,fastDeliveryButton);
			
		OrderblService orderblService = new Order();
		IdblService idblService = orderblService.getIdblService();
		orderInfoTextFields[0].setText(idblService.createNewId());
		orderInfoTextFields[0].setEditable(false);
		
		senderInfoPanel = new JPanel();
		senderInfoPanel.setBounds(20, 10, 30, 25);
		this.add(senderInfoPanel);
		
		senderInfoTextFields = new JTextField[4];
		for (int i = 0; i < senderInfoTextFields.length; i++) {
			senderInfoTextFields[i] = new JTextField();
			if (i == 0)
				senderInfoTextFields[i].setBounds(90, 530 + 30 * i, 90, 25);
			else
				senderInfoTextFields[i].setBounds(90, 530 + 30 * i, 180, 25);
			
			this.add(senderInfoTextFields[i]);
		}

		recipientInfoPanel = new JPanel();
		recipientInfoPanel.setBounds(10, 20, 30, 25);
		this.add(recipientInfoPanel);
		receiverInfoTextFields = new JTextField[4];
		for (int i = 0; i < receiverInfoTextFields.length; i++) {
			receiverInfoTextFields[i] = new JTextField();
			if (i == 0)
				receiverInfoTextFields[i].setBounds(90, 330 + 30 * i, 90, 25);
			else
				receiverInfoTextFields[i].setBounds(90, 330 + 30 * i, 180, 25);
			
			this.add(receiverInfoTextFields[i]);
		}
		
		
		confirmButton = new JButton("确定");
		cancleButton = new JButton("取消");
		confirmButton.setBounds(300, 725, 70, 30);
		cancleButton.setBounds(220, 725, 70, 30);
		this.add(confirmButton);
		this.add(cancleButton);	
       		
		
	
		totalExpenseLabel = new JLabel("总费用(元)");
		totalExpenseLabel.setBounds(235, 675, 60, 22);
		totalExpenseTextField = new JTextField();
		totalExpenseTextField.setBounds(300, 675, 60, 22);
		totalTimeLabel = new JLabel("预估时间(天)");
		totalTimeLabel.setBounds(85, 675, 80, 22);
		totalTimeTextField = new JTextField();
		totalTimeTextField.setBounds(170, 675, 60, 22);
		
		this.add(totalTimeLabel);
		this.add(totalTimeTextField);
		this.add(totalExpenseTextField);
		this.add(totalExpenseLabel);

		
		Checker senderNameChecker = new Checker(senderInfoTextFields[0], new CheckInfoGetter() {		
			@Override
			public CheckInfo getCheckInfo() {				
				return new Name(senderInfoTextFields[0].getText());
			}
		});	
		
		Checker receiverNameChecker = new Checker(receiverInfoTextFields[0], new CheckInfoGetter() {			
			@Override
			public CheckInfo getCheckInfo() {
				
				return new Name(receiverInfoTextFields[0].getText());
			}
		});
		
		Checker senderAddressChecker = new Checker(senderInfoTextFields[3], new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				return new OrderAddress(senderInfoTextFields[3].getText());
			}
		});
		
		Checker receiverAddressChecker = new Checker(receiverInfoTextFields[3], new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				return new OrderAddress(receiverInfoTextFields[3].getText());
			}
		});
		
		Checker orderWeightChecker = new Checker( orderInfoTextFields[1], new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				if (!orderInfoTextFields[1].getText().equals("")&&!orderInfoTextFields[1].getText().contains("-")) {
					return new OrderWeight(Double.valueOf(orderInfoTextFields[1].getText()));
				}
				return new OrderWeight(-1);
			}
		});
		
		Checker senderCellChecker = new Checker(senderInfoTextFields[2], new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				if (senderInfoTextFields[2].getText()==null) {
					return new PhoneNumber("");
				}
				return new PhoneNumber(senderInfoTextFields[2].getText());
			}
		});
		
		Checker receiverCellChecker = new Checker(receiverInfoTextFields[2], new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				if (receiverInfoTextFields[2].getText()==null) {
					return new PhoneNumber("");
				}
				return new PhoneNumber(receiverInfoTextFields[2].getText());
			}
		});
		
		Checker orderVolumnChecker = new Checker(orderInfoTextFields[2], new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				if (!orderInfoTextFields[2].getText().equals("")&&!orderInfoTextFields[2].getText().contains("-")) {
					return new OrderVolumn(Double.valueOf(orderInfoTextFields[2].getText()));
				}
				return new OrderVolumn(-1);
			}
		});
		
		Checker senderTelChecker = new Checker(senderInfoTextFields[1], new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				if (senderInfoTextFields[1].getText()=="") {
					return new OrderTelNum("");
				}
				return new OrderTelNum(senderInfoTextFields[1].getText());
			}
		});
		
		Checker receiverTelChecker = new Checker(receiverInfoTextFields[1], new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				if (receiverInfoTextFields[1].getText()==null) {
					return new OrderTelNum("");
				}
				return new OrderTelNum(receiverInfoTextFields[1].getText());
			}
		});
		
		
		
		senderInfoTextFields[0].addKeyListener(new KeyListener() {
			
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
		
		
		receiverInfoTextFields[0].addKeyListener(new KeyListener() {
			
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
				
		
		senderInfoTextFields[3].addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				senderAddressChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
			
		
		receiverInfoTextFields[3].addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				receiverAddressChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		orderInfoTextFields[1].addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				orderWeightChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
		orderInfoTextFields[2].addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				orderVolumnChecker.check();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		senderInfoTextFields[2].addKeyListener(new KeyListener() {
			
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
		
		
		
		receiverInfoTextFields[2].addKeyListener(new KeyListener() {
			
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
		
		
		
		senderInfoTextFields[1].addKeyListener(new KeyListener() {
			
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
		
		
		
		receiverInfoTextFields[1].addKeyListener(new KeyListener() {
			
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
		
		Checker dayChecker = new Checker(totalTimeTextField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				
				return new OrderTime(totalTimeTextField.getText());
			}
		});
		
		totalTimeTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				dayChecker.check();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
			
		Checker costChecker = new Checker(totalExpenseTextField, new CheckInfoGetter() {
			
			@Override
			public CheckInfo getCheckInfo() {
				// TODO Auto-generated method stub
				return new OrderCost(totalExpenseTextField.getText());
			}
		});
		
		totalExpenseTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
				costChecker.check();
				
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
				if (dayChecker.isCorrect()&&costChecker.isCorrect()&&orderVolumnChecker.isCorrect()&&orderWeightChecker.isCorrect()
						&&senderAddressChecker.isCorrect()&&senderNameChecker.isCorrect()&&senderCellChecker.isCorrect()&&
						senderTelChecker.isCorrect()&&receiverAddressChecker.isCorrect()&&receiverCellChecker.isCorrect()
						&&receiverTelChecker.isCorrect()&&receiverNameChecker.isCorrect()) {
					double tempcost = Double.parseDouble(totalExpenseTextField.getText());
					int temptme = Integer.parseInt(totalTimeTextField.getText());
					
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
					
					OrderCreateVO orderCreateVO = new OrderCreateVO(new String(orderInfoTextFields[0].getText()),
							senderInfoTextFields[0].getText(),senderInfoTextFields[3].getText(), 
							senderInfoTextFields[1].getText(), senderInfoTextFields[2].getText(), 
							receiverInfoTextFields[0].getText(), receiverInfoTextFields[3].getText(), 
							receiverInfoTextFields[1].getText(), receiverInfoTextFields[2].getText(), 
							orderInfoTextFields[3].getText(), Double.parseDouble(orderInfoTextFields[1].getText()),
							Double.parseDouble(orderInfoTextFields[2].getText()), tempcost, wrapWay,
							deliverWay, temptme);
					orderCreateVO.setGoodsState(GoodsState.COMPLETE);
					primeInfoOrderTableModel.create(orderCreateVO);
					PrimeInfoOrderDialog.this.dispose();
					ScreenMessage.putOnScreen(ScreenMessage.SAVE_SUCCESS);
				}
				else {
					ScreenMessage.putOnScreen(ScreenMessage.SAVE_FAILURE);
				}
				
			}
		});
		
		
		
		cancleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PrimeInfoOrderDialog.this.dispose();
			}
		});
		
		 this.setTitle("新建订单");
		 this.setSize(380, 800);
		 this.setLayout(new DialogLayoutManager());
	     this.setResizable(false);
	     this.setVisible(true);
	     this.repaint();
	}
	
	
	
	public PrimeInfoOrderDialog(PrimeInfoOrderTableModel tm  , int modelRow ,boolean isEditable){
      	this.primeInfoOrderTableModel = tm;

      	JLabel[] labels = new JLabel[17];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
			if (i<7) {				
				labels[i].setText(LABEL_NAMES[i]);
				labels[i].setBounds(40, 80 + 35 * i, 100, 25);		
				
			}
			
			if (i>=7&&i<=10) {								
				labels[i].setText(LABEL_NAMES[i]);
				labels[i].setBounds(40, 110 + 35 * i, 100, 25);	
			}
			if (i>10) {
				labels[i].setText(LABEL_NAMES[i]);
				labels[i].setBounds(40, 175 + 35 * i, 100, 25);
			}
			this.add(labels[i]);
		}

		orderinfoPanel = new JPanel();
		orderinfoPanel.setBounds(20, 100, 30, 25);
		this.add(orderinfoPanel);
		
		orderInfoTextFields = new JTextField[6];
		for (int i = 0; i < orderInfoTextFields.length; i++) {
			orderInfoTextFields[i] = new JTextField();
			orderInfoTextFields[i].setEnabled(false);
			if (i == 0 || i ==3){
				orderInfoTextFields[i].setBounds(120, 80 + 35 * i, 180, 25);
				
			}
			else{
				orderInfoTextFields[i].setBounds(120, 80 + 35 * i, 90, 25);
			
			}
			this.add(orderInfoTextFields[i]);
		}
		
		
		OrderblService orderblService = new Order();
		IdblService idblService = orderblService.getIdblService();
		orderInfoTextFields[0].setText(idblService.createNewId());
		orderInfoTextFields[0].setEditable(false);
		
		senderInfoPanel = new JPanel();
		senderInfoPanel.setBounds(20, 10, 30, 25);
		this.add(senderInfoPanel);
		
		senderInfoTextFields = new JTextField[4];
		for (int i = 0; i < senderInfoTextFields.length; i++) {
			senderInfoTextFields[i] = new JTextField();
			senderInfoTextFields[i].setEnabled(false);
			if (i == 0)
				senderInfoTextFields[i].setBounds(90, 530 + 30 * i, 90, 25);
			else
				senderInfoTextFields[i].setBounds(90, 530 + 30 * i, 180, 25);
			this.add(senderInfoTextFields[i]);
		}

		recipientInfoPanel = new JPanel();
		recipientInfoPanel.setBounds(10, 20, 30, 25);
		this.add(recipientInfoPanel);
		receiverInfoTextFields = new JTextField[4];
		for (int i = 0; i < receiverInfoTextFields.length; i++) {
			receiverInfoTextFields[i] = new JTextField();
			receiverInfoTextFields[i].setEnabled(false);
			if (i == 0)
				receiverInfoTextFields[i].setBounds(90, 330 + 30 * i, 90, 25);
			else
				receiverInfoTextFields[i].setBounds(90, 330 + 30 * i, 180, 25);
			this.add(receiverInfoTextFields[i]);
		}
		
		
		confirmButton = new JButton("确定");
		cancleButton = new JButton("取消");
		confirmButton.setBounds(300, 725, 70, 22);
		cancleButton.setBounds(220, 725, 70, 22);
		this.add(confirmButton);
		this.add(cancleButton);	
       		
		
		//暂时不使用	
		weightUnitLabel = new JLabel("Kg");
		weightUnitLabel.setBounds(170, 118, 30, 22);		
		volumnUnitLabel = new JLabel("m^3");
		volumnUnitLabel.setBounds(165, 153, 30, 22);
		
			
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
        
       

    	OrderCreateVO vo = primeInfoOrderTableModel.getOrderVO(modelRow);
    	orderInfoTextFields[0].setText(vo.getId());
    	orderInfoTextFields[1].setText(String.valueOf(vo.getWeight()));
    	orderInfoTextFields[2].setText(String.valueOf(vo.getSize()));
    	orderInfoTextFields[3].setText(vo.getGoodsInfo());
    	receiverInfoTextFields[0].setText(vo.getReceiverName());
    	receiverInfoTextFields[1].setText(vo.getReceiverTel());
    	receiverInfoTextFields[2].setText(vo.getReceiverCell());
    	receiverInfoTextFields[3].setText(vo.getReceiverAddress());
    	senderInfoTextFields[0].setText(vo.getSenderName());
    	senderInfoTextFields[1].setText(vo.getSenderTel());
    	senderInfoTextFields[2].setText(vo.getSenderCell());
    	senderInfoTextFields[3].setText(vo.getSenderAddress());
    	totalExpenseTextField.setText(String.valueOf(vo.getCost()));
    	totalTimeTextField.setText(String.valueOf(vo.getTotalTime()));
    	orderInfoTextFields[4].setText(vo.getWrapWay().getName());
    	orderInfoTextFields[5].setText(vo.getDeliverWay().getName());
    	
        JButton backButton = new JButton("返回");
        backButton.setBounds(160, 720, 70, 30);
        backButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	PrimeInfoOrderDialog.this.dispose();
            }
        });
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(250, 720, 70, 30);
        this.add(confirmButton);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                if(!isEditable){
                	PrimeInfoOrderDialog.this.dispose();
                	return;
                }
                double tempcost = Double.parseDouble(totalExpenseTextField.getText());
				int temptme = Integer.parseInt(totalTimeTextField.getText());
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
				

				OrderCreateVO orderCreateVO = new OrderCreateVO(new String(orderInfoTextFields[0].getText()),
						senderInfoTextFields[0].getText(),senderInfoTextFields[3].getText(), 
						senderInfoTextFields[1].getText(), senderInfoTextFields[2].getText(), 
						receiverInfoTextFields[0].getText(), receiverInfoTextFields[3].getText(), 
						receiverInfoTextFields[1].getText(), receiverInfoTextFields[2].getText(), 
						orderInfoTextFields[3].getText(), Double.parseDouble(orderInfoTextFields[1].getText()),
						Double.parseDouble(orderInfoTextFields[2].getText()), tempcost, wrapWay,
						deliverWay, temptme);
                primeInfoOrderTableModel.modify(modelRow, orderCreateVO);
                PrimeInfoOrderDialog.this.dispose();
                
            }
        });
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(160, 720, 70, 30);
            cancleButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                	PrimeInfoOrderDialog.this.dispose();
                }
            });
            this.add(cancleButton);
        }
       
        this.setTitle("订单信息");
		this.setSize(380, 800);
		this.setLayout(new DialogLayoutManager());
		this.setModalityType(ModalityType.APPLICATION_MODAL);
	    this.setResizable(false);
	    this.setVisible(true);
	    this.repaint();
  
    
}

}
