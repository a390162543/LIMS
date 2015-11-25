package presentation.orderpendingui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import systemenum.GoodsState;
import vo.OrderCreateVO;


public class OrderPendingDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2253851643242569020L;
	
	private static final String[] LABEL_NAMES = {"订单号","寄件地址","收件地址","物品信息","重量","体积","包装方式","运送方式","总费用"};
    
    private OrderPendingTableModel tableModel;
    
    
    
    public OrderPendingDialog(OrderPendingTableModel tm, int modelRow, boolean isEditable) {
        
        this.tableModel = tm;

        JLabel[] labels = new JLabel[9];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        JTextField[] textFields = new JTextField[9];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);

            textFields[i].setEditable(isEditable);
            this.add(textFields[i]);
        }
        OrderCreateVO vo = tableModel.getOrderPendingVO(modelRow);
        textFields[0].setText(vo.getId());
        textFields[1].setText(vo.getSenderAddress());
        textFields[2].setText(vo.getReceiverAddress());
        textFields[3].setText(vo.getGoodsInfo());
        textFields[4].setText(String.valueOf(vo.getWeight()));
        textFields[5].setText(String.valueOf(vo.getSize()));
        textFields[6].setText(vo.getWrapWay().toString());
        textFields[7].setText(vo.getDeliverWay().toString());
        textFields[8].setText(String.valueOf(vo.getCost()));
        
        
        // 如果textfield的编号和表格列号一一对应，上述代码也可以用for循环 
        // textFields[i].setText((String) tableModel.getValueAt(modelRow, i));
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 280, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    OrderPendingDialog.this.dispose(); 
                    return;
                }
                OrderCreateVO orderCreateVO = new OrderCreateVO(textFields[0].getText(),vo.getSenderName(),textFields[1].getText(),vo.getSenderTel(),vo.getSenderCell(), 
                		vo.getReceiverName(),textFields[2].getText(),vo.getReceiverTel(),vo.getReceiverCell(), textFields[3].getText(), Double.parseDouble(textFields[4].getText()), 
                		Double.parseDouble(textFields[5].getText()), Double.parseDouble(textFields[6].getText()),vo.getWrapWay(),vo.getDeliverWay(),vo.getTotalTime());
                tableModel.modify(modelRow, orderCreateVO);
                System.out.println("you've clicked confirm button..");
                OrderPendingDialog.this.dispose();
               
            }
        });
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(140, 280, 80, 30);
            
            cancleButton.addActionListener(new ActionListener() {   
                @Override
                public void actionPerformed(ActionEvent e) {
                    OrderPendingDialog.this.dispose();
                }
            });
            this.add(cancleButton);
        }

        this.add(confirmButton);
        this.setSize(340, 360);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }

}
