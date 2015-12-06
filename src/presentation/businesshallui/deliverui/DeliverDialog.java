package presentation.businesshallui.deliverui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.DialogLayoutManager;
import presentation.util.RecentDatePickPanel;
import vo.DeliverVO;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.deliverinfo.DeliverOrderId;
import businesslogicservice.DeliverblService;
import businesslogicservice.IdblService;

public class DeliverDialog extends JDialog{

    /**
     * 
     */
    private static final long serialVersionUID = 6468749815012470915L;
    private static final String[] LABEL_NAMES = {"派件单编号","订单编号","快递员编号","派件日期"};
    
    private DeliverblService deliverblService;
    private JTextField[] textFields;
    
    public DeliverDialog(){
        
        deliverblService = BusinessLogicService.getDeliverblService();
        
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
            this.add(textFields[i]);
        }
        IdblService idblService = deliverblService.getIdblService();
        textFields[0].setText(idblService.createNewId());
        textFields[0].setEnabled(false);
        
        CourierComboBox courierComboBox = new CourierComboBox();
        courierComboBox.setBounds(100, 10+35*2, 150, 25);
        this.add(courierComboBox);
        
        RecentDatePickPanel datePickPanel = new RecentDatePickPanel();
        datePickPanel.setBounds(100, 10+35*3, 200, 25);
        this.add(datePickPanel);
        
        Checker orderIdChecker = new Checker(textFields[1], new CheckInfoGetter() {
            
            @Override
            public CheckInfo getCheckInfo() {
                return new DeliverOrderId(textFields[1].getText());
            }
        });
        textFields[1].addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                orderIdChecker.check();
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 160, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String id = textFields[0].getText();
                Date deliverDate = datePickPanel.getTime();
                String orderId = textFields[1].getText();
                String courierId = courierComboBox.getSelectedCourier();
                
                DeliverVO vo = new DeliverVO(id, deliverDate, orderId, courierId);
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
        this.setLayout(new DialogLayoutManager());
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
}
