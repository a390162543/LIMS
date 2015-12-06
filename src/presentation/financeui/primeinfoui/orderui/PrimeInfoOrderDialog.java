package presentation.financeui.primeinfoui.orderui;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



import businesslogic.orderbl.Order;
import businesslogicservice.IdblService;
import businesslogicservice.OrderblService;
import systemenum.DeliveryWay;
import systemenum.GoodsState;
import systemenum.WrapWay;
import vo.OrderCreateVO;


public class PrimeInfoOrderDialog extends JDialog{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8288036146935771766L;
	

	private PrimeInfoOrderTableModel primeInfoOrderTableModel;
	
	private static final String[] LABEL_NAMES = {"订单号","重量","体积","物品信息","包装方式","运送方式",
		"姓名","电话","手机","地址","姓名","电话","手机","地址"};
	
	private JTextField[] orderInfoTextFields;
	private JTextField[] senderInfoTextFields;
	private JTextField[] receiverInfoTextFields;
	
	
	private JLabel orderinfoLabel;

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
	
	private JLabel recipientInfoLabel;
	private JLabel senderInfoLabel;
	
	
	private JLabel totalTimeLabel;
	private JTextField totalTimeTextField;
	
	private JButton confirmButton;
	private JButton cancleButton;
	
	public PrimeInfoOrderDialog(PrimeInfoOrderTableModel tm){
		this.primeInfoOrderTableModel = tm;

		JLabel[] labels = new JLabel[14];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
			if (i<6) {				
				labels[i].setText(LABEL_NAMES[i]);
				labels[i].setBounds(40, 80 + 35 * i, 100, 25);			
			}
			if (i>=6&&i<=9) {
				labels[i].setText(LABEL_NAMES[i]);
				labels[i].setBounds(40, 110 + 35 * i, 100, 25);	
			}
			if (i>9) {
				labels[i].setText(LABEL_NAMES[i]);
				labels[i].setBounds(40, 175 + 35 * i, 100, 25);
			}
			this.add(labels[i]);
		}

		orderInfoTextFields = new JTextField[4];
		for (int i = 0; i < orderInfoTextFields.length; i++) {
			orderInfoTextFields[i] = new JTextField();
			if (i == 0 || i ==3)
				orderInfoTextFields[i].setBounds(120, 80 + 35 * i, 180, 25);
			else
				orderInfoTextFields[i].setBounds(120, 80 + 35 * i, 90, 25);
			this.add(orderInfoTextFields[i]);
		}
		
		
		OrderblService orderblService = new Order();
		IdblService idblService = orderblService.getIdblService();
		orderInfoTextFields[0].setText(idblService.createNewId());
		orderInfoTextFields[0].setEditable(false);
		
		senderInfoTextFields = new JTextField[4];
		for (int i = 0; i < senderInfoTextFields.length; i++) {
			senderInfoTextFields[i] = new JTextField();
			if (i == 0)
				senderInfoTextFields[i].setBounds(90, 530 + 30 * i, 90, 25);
			else
				senderInfoTextFields[i].setBounds(90, 530 + 30 * i, 180, 25);
			this.add(senderInfoTextFields[i]);
		}

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
		confirmButton.setBounds(300, 725, 70, 22);
		cancleButton.setBounds(220, 725, 70, 22);
		this.add(confirmButton);
		this.add(cancleButton);	
       		
		orderinfoLabel = new JLabel("订单信息");
		orderinfoLabel.setBounds(10,52,80,22);	
			
		weightUnitLabel = new JLabel("Kg");
		weightUnitLabel.setBounds(170, 118, 30, 22);		
		volumnUnitLabel = new JLabel("m^3");
		volumnUnitLabel.setBounds(165, 153, 30, 22);
		
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
		this.add(bagWrapButton);
		this.add(cartonWrapButton);
		this.add(woodenWrapButton);			
		this.add(volumnUnitLabel);	
		this.add(weightUnitLabel);
		this.add(orderinfoLabel);
		
		recipientInfoLabel = new JLabel("收件人信息");
		recipientInfoLabel.setBounds(10, 293, 100, 22);		
		
		this.add(recipientInfoLabel);	
	
		senderInfoLabel = new JLabel("寄件人信息");
		senderInfoLabel.setBounds(10, 488, 100, 22);
		
		this.add(senderInfoLabel);
		
		
			
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
		 this.setLayout(null);
		 this.setLocationRelativeTo(null);
	     this.setResizable(false);
	     this.setVisible(true);
	     this.repaint();
	}
	
	
	
	public PrimeInfoOrderDialog(PrimeInfoOrderTableModel tm  , int modelRow ,boolean isEditable){
      	this.primeInfoOrderTableModel = tm;

        JLabel[] labels = new JLabel[14];
        for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
			if (i<6) {				
				labels[i].setText(LABEL_NAMES[i]);
				labels[i].setBounds(40, 80 + 35 * i, 100, 25);			
			}
			if (i>=6&&i<=9) {
				labels[i].setText(LABEL_NAMES[i]);
				labels[i].setBounds(40, 110 + 35 * i, 100, 25);	
			}
			if (i>9) {
				labels[i].setText(LABEL_NAMES[i]);
				labels[i].setBounds(40, 175 + 35 * i, 100, 25);
			}
			this.add(labels[i]);
		}

		orderInfoTextFields = new JTextField[4];
		for (int i = 0; i < orderInfoTextFields.length; i++) {
			orderInfoTextFields[i] = new JTextField();
			if (i == 0 || i ==3)
				orderInfoTextFields[i].setBounds(120, 80 + 35 * i, 180, 25);
			else
				orderInfoTextFields[i].setBounds(120, 80 + 35 * i, 90, 25);
			orderInfoTextFields[i].setEditable(isEditable);
			this.add(orderInfoTextFields[i]);
		}
		
		senderInfoTextFields = new JTextField[4];
		for (int i = 0; i < senderInfoTextFields.length; i++) {
			senderInfoTextFields[i] = new JTextField();
			if (i == 0)
				senderInfoTextFields[i].setBounds(90, 530 + 30 * i, 90, 25);
			else
				senderInfoTextFields[i].setBounds(90, 530 + 30 * i, 180, 25);
			senderInfoTextFields[i].setEditable(isEditable);
			this.add(senderInfoTextFields[i]);
		}

		receiverInfoTextFields = new JTextField[4];
		for (int i = 0; i < receiverInfoTextFields.length; i++) {
			receiverInfoTextFields[i] = new JTextField();
			if (i == 0)
				receiverInfoTextFields[i].setBounds(90, 330 + 30 * i, 90, 25);
			else
				receiverInfoTextFields[i].setBounds(90, 330 + 30 * i, 180, 25);
			receiverInfoTextFields[i].setEditable(isEditable);
			this.add(receiverInfoTextFields[i]);
		}
		
		
		JTextField wrapWayTextField = new JTextField();
		wrapWayTextField.setBounds(120, 245, 90, 25);
       	JTextField deliverWayTextField = new JTextField();
       	deliverWayTextField.setBounds(120, 280, 90, 25);
		orderinfoLabel = new JLabel("订单信息");
		orderinfoLabel.setBounds(10,52,80,22);	
			
		weightUnitLabel = new JLabel("Kg");
		weightUnitLabel.setBounds(170, 118, 30, 22);		
		volumnUnitLabel = new JLabel("m^3");
		volumnUnitLabel.setBounds(165, 153, 30, 22);
		
		
		
		totalExpenseLabel = new JLabel("总费用");
		totalExpenseLabel.setBounds(235, 675, 60, 22);
		totalExpenseTextField = new JTextField();
		totalExpenseTextField.setBounds(300, 675, 60, 22);
		totalExpenseTextField.setEditable(isEditable);
		totalTimeLabel = new JLabel("预估时间");
		totalTimeLabel.setBounds(85, 675, 80, 22);
		totalTimeTextField = new JTextField();
		totalTimeTextField.setBounds(170, 675, 60, 22);
		totalTimeTextField.setEditable(isEditable);
		
		this.add(wrapWayTextField);
		this.add(deliverWayTextField);
		this.add(totalTimeLabel);
		this.add(totalTimeTextField);
		this.add(totalExpenseTextField);
		this.add(totalExpenseLabel);		
		this.add(volumnUnitLabel);	
		this.add(weightUnitLabel);
		this.add(orderinfoLabel);
		
		recipientInfoLabel = new JLabel("收件人信息");
		recipientInfoLabel.setBounds(10, 293, 100, 22);		
		
		this.add(recipientInfoLabel);	
	
		senderInfoLabel = new JLabel("寄件人信息");
		senderInfoLabel.setBounds(10, 488, 100, 22);
		
		this.add(senderInfoLabel);
        
       

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
    	wrapWayTextField.setText(vo.getWrapWay().getName());
    	deliverWayTextField.setText(vo.getDeliverWay().getName());
    	
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
                primeInfoOrderTableModel.modify(modelRow, vo);
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
        this.add(confirmButton);
        this.setTitle("订单信息");
		this.setSize(380, 800);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setVisible(true);
	    this.repaint();
  
    
}

}
