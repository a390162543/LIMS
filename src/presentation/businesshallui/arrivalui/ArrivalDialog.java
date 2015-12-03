package presentation.businesshallui.arrivalui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import presentation.util.CheckInfoGetter;
import presentation.util.Checker;
import presentation.util.OrganizationComboBox;
import presentation.util.RecentDatePickPanel;
import businesslogic.BusinessLogicService;
import businesslogic.checkbl.CheckInfo;
import businesslogic.checkbl.arrivalinfo.ArrivalTransferId;
import businesslogic.userbl.LoginController;
import businesslogicservice.ArrivalblService;
import businesslogicservice.IdblService;
import systemenum.GoodsState;
import vo.ArrivalVO;

public class ArrivalDialog extends JDialog{

    /**
     * 
     */
    private static final long serialVersionUID = 6468749815012470915L;
    private static final String[] LABEL_NAMES = {"到达单编号","中转单编号","出发地","到达地","到达日期","到达状况"};
    
    private ArrivalblService arrivalblService;
    private JTextField[] textFields;
    
    public ArrivalDialog(){
        
        arrivalblService = BusinessLogicService.getArrivalblService();
        
        JLabel[] labels = new JLabel[6];
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
        IdblService idblService = arrivalblService.getIdblService();
        textFields[0].setText(idblService.createNewId());
        textFields[0].setEnabled(false);
        
        Checker transferIdChecker = new Checker(textFields[1], new CheckInfoGetter() {
            
            @Override
            public CheckInfo getCheckInfo() {
                return new ArrivalTransferId(textFields[1].getText());
            }
        });
        
        textFields[1].addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                transferIdChecker.check();
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
       
        
        OrganizationComboBox departComboBox = new OrganizationComboBox();
        departComboBox.setBounds(100, 10+35*2, 180, 25);
        this.add(departComboBox);
        
        OrganizationComboBox destinationComboBox = new OrganizationComboBox();
        destinationComboBox.setSelectedItem(LoginController.getOrganizationName());
        destinationComboBox.setEnabled(false);
        destinationComboBox.setBounds(100, 10+35*3, 180, 25);
        this.add(destinationComboBox);
        
        RecentDatePickPanel datePickPanel = new RecentDatePickPanel();
        datePickPanel.setBounds(100, 10+35*4, 200, 25);
        this.add(datePickPanel);
        
        //set arrival state
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton[] jRadioButtons = new JRadioButton[3];
        String[] radioButtonNames = {"完好","破损","丢失"};
        for(int i=0;i<jRadioButtons.length;i++){
            jRadioButtons[i] = new JRadioButton(radioButtonNames[i]);
            jRadioButtons[i].setBounds(90+60*i, 10+35*5, 60, 25);
            buttonGroup.add(jRadioButtons[i]);
            this.add(jRadioButtons[i]);
        }
        jRadioButtons[0].setSelected(true);


        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBounds(230, 240, 80, 30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String id = textFields[0].getText();
                String transferId = textFields[1].getText();
                Date arrivalDate = datePickPanel.getTime();
                String depart = (String)departComboBox.getSelectedItem();
                String destination = (String)destinationComboBox.getSelectedItem();
                GoodsState goodsState = GoodsState.COMPLETE;
                if(jRadioButtons[0].isSelected())
                    goodsState = GoodsState.COMPLETE;
                else if(jRadioButtons[1].isSelected())
                    goodsState = GoodsState.BROKEN;
                else if(jRadioButtons[2].isSelected())
                    goodsState = GoodsState.LOST;
                
                ArrivalVO vo = new ArrivalVO(id, arrivalDate, transferId, depart, destination, goodsState);
                arrivalblService.createArrivalPO(vo);
                ArrivalDialog.this.dispose();
            }
        });
        JButton cancleButton = new JButton("取消");
        cancleButton.setBounds(140, 240, 80, 30);
        cancleButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrivalDialog.this.dispose();
            }
        });
        
        this.add(confirmButton);
        this.add(cancleButton);
        
        this.setTitle("到达单");
        this.setSize(340, 320);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
}
