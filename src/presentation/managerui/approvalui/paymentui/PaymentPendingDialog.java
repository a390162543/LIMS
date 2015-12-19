package presentation.managerui.approvalui.paymentui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentation.mainui.MainFrame;
import presentation.util.DialogLayoutManager;
import presentation.util.RecentDatePickPanel;
import systemenum.Entry;
import vo.PaymentVO;
/**
 * {@code PaymentPendingDialog}继承{@code JDialog}，是待审批付款单增删改查的界面层对话框展示
 * @author 刘德宽
 *
 */
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
        
        JTextField idField = new JTextField();
        PaymentVO vo = tableModel.getPaymentVO(modelRow);
        idField.setText(vo.getId());
        idField.setSize(150, 25);
        this.add(idField);
        
        RecentDatePickPanel datePickPanel = new RecentDatePickPanel();
        datePickPanel.setSize( 200, 25);
        datePickPanel.setEnabled(false);
        this.add(datePickPanel);
       
        JTextField[] textFields = new JTextField[6];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setSize(150, 25);
            textFields[i].setEditable(isEditable);
            this.add(textFields[i]);
        }
        textFields[0].setText(String.format( "%.2f",vo.getMoney()));
        textFields[1].setText(vo.getName());
        textFields[2].setText(vo.getPayeeAccountId());
        textFields[3].setText(vo.getAccountId());
        textFields[4].setText(vo.getEntry().getName());
        textFields[5].setText(vo.getRemarks());
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 280, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                	PaymentPendingDialog.this.dispose();
                }
                else{
	                PaymentVO vo = new PaymentVO(idField.getText(),datePickPanel.getDate() , 
	                		Double.parseDouble(textFields[0].getText()), textFields[1].getText(), textFields[2].getText(), 
	                		textFields[3].getText(), Entry.valueOf(textFields[4].getText()),textFields[5].getText());
	                tableModel.modify(modelRow, vo);
	                PaymentPendingDialog.this.dispose();
                }
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
        this.setLayout(new DialogLayoutManager());
        this.setLocationRelativeTo(MainFrame.getMainFrame());
        this.setTitle("付款单");
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
}
