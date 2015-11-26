package presentation.managerui.approvalui.paymentui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import systemenum.Entry;
import vo.PaymentVO;

public class PaymentPendingDialog extends JDialog{

/**
	 * 
	 */
	private static final long serialVersionUID = 8218976799824804456L;



	private static final String[] LABEL_NAMES = {"付款单编号","付款日期","付款金额","收款人姓名","收款方账户","付款方账户","条目","备注"};
    
    private PaymentPendingTableModel tableModel;
    
      
    public PaymentPendingDialog(PaymentPendingTableModel tm, int modelRow, boolean isEditable) {
        
        this.tableModel = tm;

        JLabel[] labels = new JLabel[8];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        JTextField[] textFields = new JTextField[8];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);

            textFields[i].setEditable(isEditable);
            this.add(textFields[i]);
        }
        PaymentVO vo = tableModel.getPaymentVO(modelRow);
        textFields[0].setText(vo.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        textFields[1].setText(sdf.format(vo.getDate()));
        textFields[2].setText(String.format( "%.2f",vo.getMoney()));
        textFields[3].setText(vo.getName());
        textFields[4].setText(vo.getPayeeAccountId());
        textFields[5].setText(vo.getAccountId());
        textFields[6].setText(vo.getEntry().getName());
        textFields[7].setText(vo.getRemarks());
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 280, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                	PaymentPendingDialog.this.dispose();
                }
                @SuppressWarnings("deprecation")
				PaymentVO vo = new PaymentVO(textFields[0].getText(), new Date(Integer.parseInt(textFields[1].getText().substring(0, 4)),Integer.parseInt(textFields[1].getText().substring(5, 7)),Integer.parseInt(textFields[1].getText().substring(8, 10))), 
                		Double.parseDouble(textFields[2].getText()), textFields[3].getText(), textFields[4].getText(), 
                		textFields[5].getText(), Entry.valueOf(textFields[6].getText()),textFields[7].getText());
                tableModel.modify(modelRow, vo);
                System.out.println("you've clicked confirm button..");
                PaymentPendingDialog.this.dispose();
                return;
            }
        });
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(140, 280, 80, 30);
            cancleButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                	PaymentPendingDialog.this.dispose();
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
