package presentation.managerui.approvalui.deliverui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentation.util.DialogLayoutManager;
import presentation.util.RecentDatePickPanel;
import vo.DeliverVO;

/**
 * 审批时派件单的{@code Jdialog}
 * @author 林祖华
 * @version 1.3
 * @see businesslogicservice.ApprovalblService
 */
public class DeliverPendingDialog extends JDialog {
	


    /**
     * 
     */
    private static final long serialVersionUID = -4818837948185252148L;

    private static final String[] LABEL_NAMES = {"派件单编号","订单编号","快递员编号","派件日期"};
    
    private DeliverPendingTableModel tableModel;
    private JTextField[] textFields;
      
    public DeliverPendingDialog(DeliverPendingTableModel tm, int modelRow, boolean isEditable) {
        
        this.tableModel = tm;

        JLabel[] labels = new JLabel[4];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        textFields = new JTextField[2];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            textFields[i].setEnabled(false);
            this.add(textFields[i]);
        }
        
        JTextField courierIdTextField = new JTextField();
        courierIdTextField.setBounds(100, 10+35*2, 150, 25);
        courierIdTextField.setEnabled(false);
        this.add(courierIdTextField);
        
        RecentDatePickPanel datePickPanel = new RecentDatePickPanel();
        datePickPanel.setBounds(100, 10+35*3, 200, 25);
        datePickPanel.setEnabled(false);
        this.add(datePickPanel);
        
        DeliverVO vo = tableModel.getDeliverVO(modelRow);
        textFields[0].setText(vo.getId());
        textFields[1].setText(vo.getOrderId());
        courierIdTextField.setText(vo.getCourierId());
        datePickPanel.setTime(vo.getDeliverDate());

        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 240, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    DeliverPendingDialog.this.dispose();
                    return;
                }
                tableModel.modify(modelRow, vo);
                System.out.println("you've clicked confirm button..");
                DeliverPendingDialog.this.dispose();
                
            }
        });
        this.add(confirmButton);
        if(isEditable){
            JButton cancleButton = new JButton("取消");
            cancleButton.setBounds(140, 240, 80, 30);
            cancleButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    DeliverPendingDialog.this.dispose();
                }
            });
            this.add(cancleButton);
        }


        this.setSize(340, 320);
        this.setLayout(new DialogLayoutManager());
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }

}
