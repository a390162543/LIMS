package presentation.businesshallui.deliverui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vo.DeliverVO;
import businesslogic.deliverbl.Deliver;
import businesslogicservice.DeliverblService;

public class DeliverDialog extends JDialog{

    /**
     * 
     */
    private static final long serialVersionUID = 6468749815012470915L;
    private static final String[] LABEL_NAMES = {"派件单编号","订单编号","快递员编号","派件日期"};
    
    private DeliverblService deliverblService;
    private JTextField[] textFields;
    
    public DeliverDialog(){
        
        deliverblService = new Deliver();
        
        JLabel[] labels = new JLabel[4];
        for(int i=0;i<labels.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(LABEL_NAMES[i]);
            labels[i].setBounds(20, 10+35*i, 100, 25);
            this.add(labels[i]);
        }
        
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
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 160, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                DeliverVO vo = new DeliverVO(textFields[0].getText(), new Date(), textFields[1].getText(), textFields[2].getText());
                deliverblService.createDeliverPO(vo);
                DeliverDialog.this.dispose();
            }
        });
        JButton cancleButton = new JButton("取消");
        cancleButton.setBounds(140, 160, 80, 30);
        cancleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                DeliverDialog.this.dispose();
            }
        });
        
        this.add(confirmButton);
        this.add(cancleButton);
        
        this.setTitle("派件单");
        this.setSize(340, 240);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
}
