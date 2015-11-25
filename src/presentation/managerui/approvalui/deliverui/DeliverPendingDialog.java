package presentation.managerui.approvalui.deliverui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vo.DeliverVO;

public class DeliverPendingDialog extends JDialog {
	


    /**
     * 
     */
    private static final long serialVersionUID = -4818837948185252148L;

    private static final String[] LABEL_NAMES = {"派件单编号","订单编号","快递员编号","派件日期"};
    
    private DeliverPendingTableModel tableModel;
    
      
    @SuppressWarnings("deprecation")
    public DeliverPendingDialog(DeliverPendingTableModel tm, int modelRow, boolean isEditable) {
        
        this.tableModel = tm;

        JLabel[] labels = new JLabel[4];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
        JTextField textFields[];
        textFields = new JTextField[3];
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
            textFields[i].setBounds(100, 10+35*i, 150, 25);
            this.add(textFields[i]);
        }
        //set birth chooser
//        JLabel[] birthLabels = new JLabel[3];
//        String[] birthLabelNames = {"年","月","日"};
//        for(int i=0;i<birthLabels.length;i++){
//            birthLabels[i] = new JLabel();
//            birthLabels[i].setText(birthLabelNames[i]);
//            birthLabels[i].setBounds(145+50*i, 8+35*3, 20, 25);
//            this.add(birthLabels[i]);
//        }
        JComboBox<Integer> yearComboBox = new JComboBox<Integer>();
        JComboBox<Integer> monthComboBox = new JComboBox<Integer>();
        JComboBox<Integer> dayComboBox = new JComboBox<Integer>();
        for(int i=1960;i<=2015;i++)  yearComboBox.addItem(i);
        for(int i=1;i<=12;i++)  monthComboBox.addItem(i);
        for(int i=1;i<=31;i++)  dayComboBox.addItem(i);
        yearComboBox.setBounds(100, 10+35*3, 70, 25);
        monthComboBox.setBounds(170, 10+35*3, 60, 25);
        dayComboBox.setBounds(230, 10+35*3, 60, 25);
        this.add(yearComboBox);
        this.add(monthComboBox);
        this.add(dayComboBox);
        
        DeliverVO vo = tableModel.getDeliverVO(modelRow);
        textFields[0].setText(vo.getId());
        textFields[1].setText(vo.getOrderId());
        textFields[2].setText(vo.getCourierId());
        yearComboBox.setSelectedItem(vo.getDeliverDate().getYear());
        monthComboBox.setSelectedItem(vo.getDeliverDate().getMonth());
        dayComboBox.setSelectedItem(vo.getDeliverDate().getDate());

        
        // 如果textfield的编号和表格列号一一对应，上述代码也可以用for循环 
        // textFields[i].setText((String) tableModel.getValueAt(modelRow, i));
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 240, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEditable){
                    DeliverPendingDialog.this.dispose();
                    return;
                }
                DeliverVO vo = new DeliverVO(textFields[0].getText(), new Date(), textFields[1].getText(), textFields[2].getText());
                tableModel.modify(modelRow, vo);
                System.out.println("you've clicked confirm button..");
                DeliverPendingDialog.this.dispose();
                
            }
        });
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
        this.add(confirmButton);

        this.setSize(340, 320);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }

}
